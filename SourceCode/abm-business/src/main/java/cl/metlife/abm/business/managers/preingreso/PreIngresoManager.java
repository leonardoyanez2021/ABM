package cl.metlife.abm.business.managers.preingreso;

import cl.metlife.abm.business.execution.ProccesRowResponse;
import cl.metlife.abm.business.execution.ProcessExecutionManager;
import cl.metlife.abm.business.managers.LogbookManager;
import cl.metlife.abm.business.managers.LotManager;
import cl.metlife.abm.business.managers.ProcessManager;
import cl.metlife.abm.business.managers.preingreso.exception.PreIngresoException;
import cl.metlife.abm.domain.Process;
import cl.metlife.abm.domain.*;
import cl.metlife.abm.persistence.dao.InfoResultDAO;
import cl.metlife.abm.ws.domain.ErrorNums;
import cl.metlife.ws.clients.preingreso.Corredor;
import cl.metlife.ws.clients.preingreso.bulk.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import java.io.StringWriter;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Stateless
public class PreIngresoManager {
    public static final String LLAMADA_OK = "Llamada correcta al mÃ©todo crear() de PreIngreso. Id: ";
    public static final String ERROR_PREINGRESO = "Hubo un error al ejecutar el mÃ©todo crear() en PreIngreso. [CODE: ";
    public static final String DESCRIPTION = ", DESCRIPTION: ";
    PreingresoMapper preingresoMapper;
    @EJB
    PreIngresoServiceManager preIngresoServiceManager;
    @EJB
    LogbookManager logbookManager;
    @EJB
    LotManager lotManager;
    @EJB
    ProcessManager processManager;
    @EJB
    InfoResultDAO infoResultDAO;
    private static final Logger LOGGER = LoggerFactory.getLogger(PreIngresoManager.class);

    public PreIngresoManager(){
        preingresoMapper = new PreingresoMapper();
    }

    public boolean registerFilenet(Detail detail, String filenetCode){
        Lot lot = lotManager.getById(detail.getLotId());
        String sesionId = preIngresoServiceManager.getSesionId();
        Holder<Integer> errorNumber = new Holder<>();
        Holder<String> errorDescription = new Holder<>();
        Holder<ErrorBo> errorBo = new Holder<>();
        errorNumber.value = 1;
        if(lot.getFileTypeId().equals(FileType.ALTA_TITULAR) || lot.getFileTypeId().equals(FileType.ALTA_CARGA) || lot.getFileTypeId().equals(FileType.BAJA_TITULAR) || lot.getFileTypeId().equals(FileType.BAJA_CARGA)) {
            char dvTit = detail.getColumn6().charAt(0);
            char dvCar = detail.getColumn8().charAt(0);
            preIngresoServiceManager.getBulkService(sesionId).fileNetCodigoGrabar(sesionId, Integer.parseInt(lot.getBulkId()),
                    Integer.parseInt(detail.getColumn1()), Integer.parseInt(detail.getColumn2()), Integer.parseInt(detail.getColumn5()), Integer.parseInt(""+dvTit),
                    Integer.valueOf(detail.getColumn7()), (int)dvCar, filenetCode, errorNumber, errorDescription, errorBo);
        }
        if(errorNumber.value == 0){
            logbookManager.log(lot.getProcess(), Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Se actualizÃ³ correctamente el cÃ³digo filenet en PreIngreso", lot, detail, null, null);
            return true;
        } else
            logbookManager.log(lot.getProcess(), Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al registrar el cÃ³digo filenet en PreIngreso [DESCRIPTION: " + errorDescription.value + "].", lot, detail, null, null);

        return false;
    }
    public WsInfoMovimientosResponseBo infoCargaMovimiento(long idSolicitud, long lote,ArrayOfSet sets ){

        return preIngresoServiceManager.getBulkService().infoCargaMovimientos(idSolicitud, lote,sets);

    }


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ProccesRowResponse createAlta(List<Detail> detailList, Process process, String user, int movementType, int processType, Long lote) throws PreIngresoException {
        ProccesRowResponse pRR=new ProccesRowResponse(false);
        LOGGER.info("Create Alta Webservice");
        EInfoResult in= new EInfoResult();
        in.setErrorNum(ErrorNums.OK);
        ESolicitud so= new ESolicitud();
        Date d= java.util.Date.from(Instant.now());
        setEsolicitud(detailList, process, movementType, so, d, "Alta Titular o Carga");
        List<EMovimiento> movimientos= new ArrayList<>();
        int okMov=0;
        int errorMov=0;
        try {
            // SesiÃ³n
            String sesionId = preIngresoServiceManager.getSesionId();

            // Input crear()
            String portalRut = process.getBrokerRut().replace(".", "").replace("-", "");
            String portalNombre = process.getBrokerName();
            AgrupacionCorredor agrupacionCorredor = getAgrupacionCorredor(portalRut, portalNombre);
            XMLGregorianCalendar fechaDesde = getXmlGregorianCalendar(new Date());
            so.setFechaRecepcionCorredor(d);

            // Crear Reponse
            BulkBo crearResponse = preIngresoServiceManager.getBulkService(sesionId).crear(sesionId, movementType, null, fechaDesde, user, user, agrupacionCorredor);
            printVariables(user, movementType, sesionId, agrupacionCorredor, fechaDesde);
            so.setEstado(crearResponse.getEstadoId()!=null?""+crearResponse.getEstadoId():"");
            LOGGER.info("ID de SOLICITUD");
            LOGGER.info("An id: {}",crearResponse.getId().longValue());
            pRR.setBulkId(crearResponse.getId().longValue());
            Long maxSo=infoResultDAO.getMaxSol();
            so.setId(crearResponse.getId()!=null?crearResponse.getId().longValue():maxSo);
            in.setCantidadMovimientos(detailList.size());

            if(crearResponse.getError() != null && crearResponse.getError().getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, LLAMADA_OK + crearResponse.getId(), null, null, null, null);
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, ERROR_PREINGRESO + (crearResponse.getError().getNumero()) + DESCRIPTION + (crearResponse.getError().getDescripcion()==null? "" : crearResponse.getError().getDescripcion()) + "]", null, null, null, null);
                in.setMovimientosOk(okMov);
                in.setMovimientosError(errorMov);
                this.finalizePersistence(ErrorNums.CODE_ERROR,in,so,movimientos,crearResponse.getError().getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }

            // Crear Alta
            int altaQty =0;
            Lot detailLot = lotManager.getById(detailList.get(0).getLotId());
            detailLot = updateBulkId(detailLot, crearResponse.getId().toString());


            for (Detail detail : detailList) {
                EMovimiento eMovimiento= new EMovimiento();
                if(processType == ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE){
                    detailLot = lotManager.getById(detail.getLotId());
                    detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
                }

                System.out.println("\n========== [DATA_TRACE] INICIO PROCESAMIENTO DETALLE ==========");
                System.out.println("[DATA_TRACE] >>> DATOS ORIGINALES DEL CSV (Detail) <<<");
                System.out.println("[DATA_TRACE] Detail.toString(): " + detail.toString());
                System.out.println("[DATA_TRACE] Column5 (RUT Titular): '" + detail.getColumn5() + "'");
                System.out.println("[DATA_TRACE] Column6 (DV Titular): '" + detail.getColumn6() + "' (length: " + (detail.getColumn6() != null ? detail.getColumn6().length() : "null") + ")");
                System.out.println("[DATA_TRACE] Column7 (RUT Carga): '" + detail.getColumn7() + "'");
                System.out.println("[DATA_TRACE] Column8 (DV Carga): '" + detail.getColumn8() + "' (length: " + (detail.getColumn8() != null ? detail.getColumn8().length() : "null") + ")");

                MovtoAltaBo movtoAltaBo = preingresoMapper.makeMovtoAltoBo(detail, detailLot, user, crearResponse.getId());
                movtoAltaBo.setLote(""+lote);

                System.out.println("\n[DATA_TRACE] >>> OBJETO CONSTRUIDO (MovtoAltaBo) <<<");
                System.out.println("[DATA_TRACE] BulkId: " + movtoAltaBo.getBulkId());
                System.out.println("[DATA_TRACE] PolizaNumero: " + movtoAltaBo.getPolizaNumero());
                System.out.println("[DATA_TRACE] GrupoId: " + movtoAltaBo.getGrupoId());
                if(movtoAltaBo.getTitular() != null) {
                    System.out.println("[DATA_TRACE] Titular.Rut: " + movtoAltaBo.getTitular().getRut());
                    System.out.println("[DATA_TRACE] Titular.Dv: " + movtoAltaBo.getTitular().getDv() + " (valor int del char)");
                    System.out.println("[DATA_TRACE] Titular.Dv como char: '" + (char)movtoAltaBo.getTitular().getDv().intValue() + "'");
                }
                if(movtoAltaBo.getCarga() != null) {
                    System.out.println("[DATA_TRACE] Carga.Rut: " + movtoAltaBo.getCarga().getRut());
                    System.out.println("[DATA_TRACE] Carga.Dv: " + movtoAltaBo.getCarga().getDv() + " (valor int del char)");
                    System.out.println("[DATA_TRACE] Carga.Dv como char: '" + (char)movtoAltaBo.getCarga().getDv().intValue() + "'");
                    System.out.println("[DATA_TRACE] Carga.Nombre: '" + movtoAltaBo.getCarga().getNombre() + "'");
                }
                System.out.println("[DATA_TRACE] Lote: " + movtoAltaBo.getLote());
                System.out.println("[DATA_TRACE] Barcode: " + movtoAltaBo.getBarcode());

                System.out.println("\n[DATA_TRACE] >>> XML QUE SE ENVIARÁ AL SERVICIO SOAP <<<");
                String xmlToSend = toXml(movtoAltaBo);
                System.out.println(xmlToSend);
                System.out.println("[DATA_TRACE] >>> FIN XML <<<\n");

                printDetalle(sesionId, movtoAltaBo);
                // Crear Alta Response

                System.out.println("[DATA_TRACE] >>> LLAMANDO A crearAlta() <<<");
                ErrorBo crearAltaResponse = preIngresoServiceManager.getBulkService(sesionId).crearAlta(sesionId, movtoAltaBo);

                System.out.println("\n[DATA_TRACE] >>> RESPUESTA DE crearAlta() <<<");
                System.out.println("[DATA_TRACE] ErrorBo.numero: " + crearAltaResponse.getNumero());
                System.out.println("[DATA_TRACE] ErrorBo.descripcion: '" + crearAltaResponse.getDescripcion() + "'");
                System.out.println("========== [DATA_TRACE] FIN PROCESAMIENTO DETALLE ==========\n");

                setResponse(eMovimiento, crearAltaResponse.getNumero(), crearAltaResponse.getDescripcion());

                if(crearAltaResponse.getNumero() == 0){
                    altaQty++;
                    eMovimiento.setFila(altaQty);
                    okMov++;
                    movimientos.add(eMovimiento);
                    logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Llamada correcta al mÃ©todo crearAlta() de PreIngreso.", detailLot, detail, null, null);
                } else {
                    eMovimiento.setFila(altaQty);
                    logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar crearAlta() para el detalle. [CODE: " + crearAltaResponse.getNumero() + DESCRIPTION + crearAltaResponse.getDescripcion() + "]", detailLot, detail, null, null);
                    errorMov++;
                    in.setMovimientosError(errorMov);
                    in.setMovimientosOk(okMov);
                    movimientos.add(eMovimiento);
                }

            }
            in.setMovimientosError(errorMov);
            in.setMovimientosOk(okMov);
            // Ejecutar
            WsBulkSoap ws=preIngresoServiceManager.getBulkService(sesionId);
            WsSolicitudResponseBo ejecutarResponse = ws.ejecutar2(sesionId, crearResponse.getId());

            //errores y codigos para el set...
            ArrayOfSet sets=ejecutarResponse.getSets();
            pRR.setBulkId(ejecutarResponse.getSolicitud());
            LOGGER.info(String.format("ID de SOLICITUD: %s", ejecutarResponse.getSolicitud()));
            List<Set> listaSet= sets.getSet();

            for(int i=0;i<listaSet.size();i++){
                movimientos.get(i).setFolio(listaSet.get(i).getFolio());
            }
            LOGGER.info(String.format("Ejecutando alta con ID = %s", crearResponse.getId()));
            if(ejecutarResponse.getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Se creÃ³ el alta en preIngreso correctamente para " + altaQty + " registros.", null, null, null, null);
                finalizePersistence(ErrorNums.OK,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                pRR.setResponse(true);
                return pRR;
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar  ejecutar() en PreIngreso. [CODE: " + ejecutarResponse.getNumero() + DESCRIPTION + ejecutarResponse.getDescripcion() + "]", null, null, null, null);
                finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                pRR.setResponse(false);
                return pRR;
            }

        }
        catch (Exception e) {
            logbookManager.error(process, Log.LOG_STEP_PREINGRESO, "Hubo un error al crear el alta en preingreso"+e.getMessage(), null);
            e.printStackTrace();
            finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, e.getMessage());
            LOGGER.info("error 1: "+e.getMessage());
            if(e instanceof NumberFormatException){
                throw new PreIngresoException("Rut mal formateado: "+e.getMessage(), e);
            }else{
                throw new PreIngresoException("Hubo un error al crear el alta en preingreso", e);
            }
        }
    }

    private void printDetalle(String sesionId, MovtoAltaBo movtoAltaBo) {
        LOGGER.info(String.format("Se crea detalle de alta en pregingreso con sessionId ( %s:)", sesionId));
        LOGGER.info(toXml(movtoAltaBo));
        LOGGER.info(movtoAltaBo.toString());
    }

    private void printVariables(String user, int movementType, String sesionId, AgrupacionCorredor agrupacionCorredor, XMLGregorianCalendar fechaDesde) {
        String sb = "SessionId: " + sesionId + " " +
                "Tipo de movimiento: " + movementType +
                "Nombre adjunto: " + " " +
                "Fecha recepcion: " + fechaDesde + " " +
                "PortalRut: " + user + " " +
                "PortalNombre: " + user + " " +
                "AgrupacionCorredor: " + agrupacionCorredor + " ";
        LOGGER.info(sb);
    }

    private void setEsolicitud(List<Detail> detailList, Process process, int movementType, ESolicitud so, Date d, String movementName) {
        so.setTipoSolicitud(process.getProcessType().getName());
        so.setFechaSolicitud(d);
        so.setLote(detailList.get(0).getLotId());
        so.setPortalRut(process.getBrokerRut());
        so.setPortalUsuario(process.getBrokerName());
        so.setUsuario(process.getUser());
        so.setMovimientoId(movementType);
        so.setMovimiento(movementName);
    }

    private void  setResponse(EMovimiento eMovimiento, int numero, String descripcion) {
        eMovimiento.setIdError(numero);
        eMovimiento.setDescripcion(descripcion);
    }

    private void finalizePersistence(ErrorNums err, EInfoResult in, ESolicitud so, List<EMovimiento> movimientos, String descripcion) {
        infoResultDAO.persistSol(so);

        in.setNumero(err.getId());
        in.setDescripcion(descripcion);
        in.setIdSolicitud(so.getId());
        so.setMovimientos(movimientos);
        in.setSolicitud(so);

        infoResultDAO.persist(in);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ProccesRowResponse createBajaCarga(List<Detail> detailList, Process process, String user, int movementType, int processType,Long lote) throws  PreIngresoException {
        EInfoResult in= new EInfoResult();
        in.setErrorNum(ErrorNums.OK);
        ESolicitud so= new ESolicitud();
        Date d= java.util.Date.from(Instant.now());
        setEsolicitud(detailList, process, movementType, so, d, "Baja Carga");
        List<EMovimiento> movimientos= new ArrayList<>();
        int okMov=0;
        int totalMov=0;
        int errorMov=0;
        ProccesRowResponse pRR= new ProccesRowResponse(false);

        try {
            // SesiÃ³n
            String sesionId = preIngresoServiceManager.getSesionId();

            // Input crear()
            String portalRut = process.getBrokerRut().replace(".", "").replace("-", "");
            String portalNombre = process.getBrokerName();
            AgrupacionCorredor agrupacionCorredor = getAgrupacionCorredor(portalRut, portalNombre);
            XMLGregorianCalendar fechaDesde = getXmlGregorianCalendar(new Date());
            so.setFechaRecepcionCorredor(d);

            // crear() reponse
            BulkBo crearResponse = preIngresoServiceManager.getBulkService(sesionId).crear(sesionId, movementType, null, fechaDesde, user, user, agrupacionCorredor);
            printVariables(user,movementType,sesionId,agrupacionCorredor,fechaDesde);
            so.setEstado(crearResponse!=null?crearResponse.getEstadoId()!=null?crearResponse.getEstadoId().toString():"":"");
            Long maxSo=infoResultDAO.getMaxSol();

            so.setId(crearResponse.getId()!=null?crearResponse.getId().longValue():maxSo);
            in.setCantidadMovimientos(detailList.size());

            pRR.setBulkId(so.getId());

            if(crearResponse.getError() != null && crearResponse.getError().getNumero() == 0){
                //logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Llamada correcta al mÃ©todo crear() de PreIngreso. Id: " + crearResponse.getId(), null, null, null, null);
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, ERROR_PREINGRESO + crearResponse.getError().getNumero() + DESCRIPTION + crearResponse.getError().getDescripcion() + "]", null, null, null, null);
                in.setMovimientosError(errorMov);
                in.setMovimientosOk(okMov);
                this.finalizePersistence(ErrorNums.CODE_ERROR,in,so,movimientos,crearResponse.getError().getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }

            // crearBaja()
            int bajaQty =0;
            Lot detailLot = lotManager.getById(detailList.get(0).getLotId());
            detailLot = updateBulkId(detailLot, crearResponse.getId().toString());

            for (Detail detail : detailList) {
                EMovimiento eMovimiento= new EMovimiento();
                if(processType == ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE){
                    detailLot = lotManager.getById(detail.getLotId());
                    detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
                }

                MovtoBajaBo movtoBajaBo = preingresoMapper.makeMovtoBajaBo(detail, detailLot, user, crearResponse.getId());
                movtoBajaBo.setLote(""+lote);
                LOGGER.info(String.format("Se crea detalle de alta en pregingreso con sessionId ( %s )", sesionId ));
                LOGGER.info(toXml(movtoBajaBo));
                // Crear Alta Response
                ErrorBo crearAltaBaja = preIngresoServiceManager.getBulkService(sesionId).crearBaja(sesionId, movtoBajaBo);
                setResponse(eMovimiento, crearAltaBaja.getNumero(), crearAltaBaja.getDescripcion());

                if(crearAltaBaja.getNumero() == 0){
                    bajaQty++;
                    eMovimiento.setFila(bajaQty);
                    okMov++;
                    movimientos.add(eMovimiento);
                    logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Llamada correcta al mÃ©todo crearAltaBaja() de PreIngreso.", detailLot, detail, null, null);
                } else {
                    eMovimiento.setFila(bajaQty);
                    logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo crearAltaBaja() para el detalle. [CODE: " + crearAltaBaja.getNumero() + DESCRIPTION + crearAltaBaja.getDescripcion() + "]", detailLot, detail, null, null);
                    errorMov++;
                    in.setMovimientosError(errorMov);
                    in.setMovimientosOk(okMov);
                    movimientos.add(eMovimiento);
                    //this.finalizePersistence(ErrorNums.CODE_ERROR,in,so,movimientos,crearAltaBaja.getDescripcion());
                    //preIngresoServiceManager.logout(sesionId);
                    //return false;
                }
            }
            in.setMovimientosError(errorMov);
            in.setMovimientosOk(okMov);

            // Ejecutar
            WsSolicitudResponseBo ejecutarResponse = preIngresoServiceManager.getBulkService(sesionId).ejecutar2(sesionId, crearResponse.getId());
            LOGGER.info("Ejecutando baja con ID = " + crearResponse.getId());

            ArrayOfSet sets=ejecutarResponse.getSets();
            pRR.setBulkId(ejecutarResponse.getSolicitud());
            LOGGER.info(String.format("ID de SOLICITUD: %s", ejecutarResponse.getSolicitud()));
            List<Set> listaSet= sets.getSet();

            for(int i=0;i<listaSet.size();i++){
                movimientos.get(i).setFolio(listaSet.get(i).getFolio());

            }



            if(ejecutarResponse != null && ejecutarResponse.getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Se creÃ³ el alta en preIngreso correctamente para " + bajaQty + " registros.", null, null, null, null);
                finalizePersistence(ErrorNums.OK,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                pRR.setResponse(true);
                return pRR;
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo ejecutar() en PreIngreso. [CODE: " + ejecutarResponse.getNumero() + DESCRIPTION + ejecutarResponse.getDescripcion() + "]", null, null, null, null);
                finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }
        } catch (Exception e) {
            LOGGER.info("error 1: "+e.getMessage());
            logbookManager.error(process, Log.LOG_STEP_PREINGRESO, "Hubo un error al crear la Baja en preingreso", null);
            finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, e.getMessage());
            throw new PreIngresoException("Hubo un error al crear la baja en preingreso: "+e.getMessage(), e);
        }

    }
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ProccesRowResponse createBajaTitular(List<Detail> detailList, Process process, String user, int movementType, int processType,Long lote) throws JAXBException, SQLException, PreIngresoException {
        LOGGER.info("createBajaTitular");
        EInfoResult in= new EInfoResult();
        in.setErrorNum(ErrorNums.OK);
        ESolicitud so= new ESolicitud();
        Date d= java.util.Date.from(Instant.now());
        setEsolicitud(detailList, process, movementType, so, d, "Baja Titular");
        List<EMovimiento> movimientos= new ArrayList<>();
        int okMov=0;
        int totalMov=0;
        int errorMov=0;
        ProccesRowResponse pRR= new ProccesRowResponse(false);

        try {
            // SesiÃ³n
            String sesionId = preIngresoServiceManager.getSesionId();
            // Input crear()
            String portalRut = process.getBrokerRut().replace(".", "").replace("-", "");
            String portalNombre = process.getBrokerName();
            AgrupacionCorredor agrupacionCorredor = getAgrupacionCorredor(portalRut, portalNombre);
            XMLGregorianCalendar fechaDesde = getXmlGregorianCalendar(new Date());
            so.setFechaRecepcionCorredor(d);
            // crear() reponse

            BulkBo crearResponse = preIngresoServiceManager.getBulkService(sesionId).crear(sesionId, movementType, null, fechaDesde, user, user, agrupacionCorredor);
            printVariables(user,movementType,sesionId,agrupacionCorredor,fechaDesde);
            so.setEstado(crearResponse!=null?crearResponse.getEstadoId()!=null?crearResponse.getEstadoId().toString():"":"");
            Long maxSo=infoResultDAO.getMaxSol();
            pRR.setBulkId(crearResponse!=null?crearResponse.getId().longValue():Long.MIN_VALUE);
            assert crearResponse != null;
            so.setId(crearResponse.getId()!=null?crearResponse.getId().longValue():maxSo);
            in.setCantidadMovimientos(detailList.size());

            if(crearResponse.getError() != null && crearResponse.getError().getNumero() == 0){
                //logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Llamada correcta al mÃ©todo crear() de PreIngreso. Id: " + crearResponse.getId(), null, null, null, null);
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, ERROR_PREINGRESO + crearResponse.getError().getNumero() + DESCRIPTION + crearResponse.getError().getDescripcion() + "]", null, null, null, null);
                in.setMovimientosError(errorMov);
                in.setMovimientosOk(okMov);
                this.finalizePersistence(ErrorNums.CODE_ERROR,in,so,movimientos,crearResponse.getError().getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }

            // crearBajaTitular()
            int bajaQty =0;
            Lot detailLot = lotManager.getById(detailList.get(0).getLotId());
            detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
            int foil=0;
            for (Detail detail : detailList) {
                EMovimiento eMovimiento= new EMovimiento();
                if(processType == ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE){
                    detailLot = lotManager.getById(detail.getLotId());
                    detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
                }
                LOGGER.info("Detail Lote");
                LOGGER.info(detailLot.toString());

                System.out.println("\n========== [DATA_TRACE_BAJA] INICIO PROCESAMIENTO DETALLE BAJA ==========");
                System.out.println("[DATA_TRACE_BAJA] >>> DATOS ORIGINALES DEL CSV (Detail) <<<");
                System.out.println("[DATA_TRACE_BAJA] Detail.toString(): " + detail.toString());
                System.out.println("[DATA_TRACE_BAJA] Column3 (RUT Titular): '" + detail.getColumn3() + "'");
                System.out.println("[DATA_TRACE_BAJA] Column4 (DV Titular): '" + detail.getColumn4() + "' (length: " + (detail.getColumn4() != null ? detail.getColumn4().length() : "null") + ")");

                MovtoBajaBo movtoBajaBo = preingresoMapper.makeMovtoBajaBo(detail, detailLot, user, crearResponse.getId());

                movtoBajaBo.setLote(""+lote);

                System.out.println("\n[DATA_TRACE_BAJA] >>> OBJETO CONSTRUIDO (MovtoBajaBo) <<<");
                System.out.println("[DATA_TRACE_BAJA] BulkId: " + movtoBajaBo.getBulkId());
                System.out.println("[DATA_TRACE_BAJA] PolizaNumero: " + movtoBajaBo.getPolizaNumero());
                System.out.println("[DATA_TRACE_BAJA] GrupoId: " + movtoBajaBo.getGrupoId());
                if(movtoBajaBo.getTitular() != null) {
                    System.out.println("[DATA_TRACE_BAJA] Titular.Rut: " + movtoBajaBo.getTitular().getRut());
                    System.out.println("[DATA_TRACE_BAJA] Titular.Dv: " + movtoBajaBo.getTitular().getDv() + " (valor int del char)");
                    System.out.println("[DATA_TRACE_BAJA] Titular.Dv como char: '" + (char)movtoBajaBo.getTitular().getDv().intValue() + "'");
                }
                System.out.println("[DATA_TRACE_BAJA] Lote: " + movtoBajaBo.getLote());
                System.out.println("[DATA_TRACE_BAJA] Barcode: " + movtoBajaBo.getBarcode());

                System.out.println("\n[DATA_TRACE_BAJA] >>> XML QUE SE ENVIARÁ AL SERVICIO SOAP <<<");
                String xmlToSend = toXml(movtoBajaBo);
                System.out.println(xmlToSend);
                System.out.println("[DATA_TRACE_BAJA] >>> FIN XML <<<\n");

                LOGGER.info("Se crea detalle de Baja titular en pregingreso con sessionId (" + sesionId + ":");
                LOGGER.info(toXml(movtoBajaBo));
                // Crear Alta Response

                System.out.println("[DATA_TRACE_BAJA] >>> LLAMANDO A crearBaja() <<<");
                ErrorBo crearAltaBaja = preIngresoServiceManager.getBulkService(sesionId).crearBaja(sesionId, movtoBajaBo);

                System.out.println("\n[DATA_TRACE_BAJA] >>> RESPUESTA DE crearBaja() <<<");
                System.out.println("[DATA_TRACE_BAJA] ErrorBo.numero: " + crearAltaBaja.getNumero());
                System.out.println("[DATA_TRACE_BAJA] ErrorBo.descripcion: '" + crearAltaBaja.getDescripcion() + "'");
                System.out.println("========== [DATA_TRACE_BAJA] FIN PROCESAMIENTO DETALLE BAJA ==========\n");

                setResponse(eMovimiento, crearAltaBaja.getNumero(), crearAltaBaja.getDescripcion());

                if(crearAltaBaja != null && crearAltaBaja.getNumero() ==0 ){
                    bajaQty++;
                    eMovimiento.setFila(bajaQty);
                    okMov++;
                    movimientos.add(eMovimiento);
                    logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Llamada correcta al mÃ©todo crearAltaBaja() de PreIngreso.", detailLot, detail, null, null);
                } else {
                    logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo crearAltaBaja() para el detalle. [CODE: " + crearAltaBaja.getNumero() + DESCRIPTION + crearAltaBaja.getDescripcion() + "]", detailLot, detail, null, null);
                    errorMov++;
                    in.setMovimientosError(errorMov);
                    in.setMovimientosOk(okMov);
                    movimientos.add(eMovimiento);
                    //this.finalizePersistence(ErrorNums.CODE_ERROR,in,so,movimientos,crearAltaBaja.getDescripcion());
                    //preIngresoServiceManager.logout(sesionId);
                    //return false;
                }
                foil++;
            }

            /* Start trozo codigo refactoring*/
            in.setMovimientosError(errorMov);
            in.setMovimientosOk(okMov);

            // Ejecutar
            WsSolicitudResponseBo ejecutarResponse = preIngresoServiceManager.getBulkService(sesionId).ejecutar2(sesionId, crearResponse.getId());
            pRR.setBulkId(ejecutarResponse.getSolicitud());
            LOGGER.info(String.format("ID de SOLICITUD: %s", ejecutarResponse.getSolicitud()));
            ArrayOfSet sets=ejecutarResponse.getSets();
            List<Set> listaSet= sets.getSet();

            for(int i=0;i<listaSet.size();i++){
                movimientos.get(i).setFolio(listaSet.get(i).getFolio());
            }

            LOGGER.info("Ejecutando baja con ID = " + crearResponse.getId());
            if(ejecutarResponse != null && ejecutarResponse.getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Se creÃ³ el alta en preIngreso correctamente para " + bajaQty + " registros.", null, null, null, null);
                finalizePersistence(ErrorNums.OK,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                pRR.setResponse(true);
                return pRR;
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo ejecutar() en PreIngreso. [CODE: " + ejecutarResponse.getNumero() + DESCRIPTION + ejecutarResponse.getDescripcion() + "]", null, null, null, null);
                finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }
            /* end trozo codigo refactoring*/
        } catch (Exception e) {
            LOGGER.info("error 1: "+e.getMessage());
            logbookManager.error(process, Log.LOG_STEP_PREINGRESO, "Hubo un error al crear el alta en preingreso", null);
            finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, e.getMessage());
            throw new PreIngresoException("Hubo un error al crear la baja en preingreso", e);
        }
    }




    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ProccesRowResponse createTransaction(List<Detail> detailList, Process process, String user, int movementType, int processType, Long Lote) throws JAXBException, SQLException, PreIngresoException
    {
        boolean response = false;
        EInfoResult in= new EInfoResult();
        in.setErrorNum(ErrorNums.OK);
        ESolicitud so= new ESolicitud();
        Date d= java.util.Date.from(Instant.now());
        setEsolicitud(detailList, process, movementType, so, d, "Traspaso Titular");
        List<EMovimiento> movimientos= new ArrayList<>();
        int okMov=0;
        int totalMov=0;
        int errorMov=0;
        ProccesRowResponse pRR= new ProccesRowResponse(false);

        try {
            // SesiÃ³n
            String sesionId = preIngresoServiceManager.getSesionId();

            // Input crear()
            int tipoMovimiento = movementType; // Alta tit y Alta Car
            String portalRut = process.getBrokerRut().replace(".", "").replace("-", "");
            String portalNombre = process.getBrokerName();

            AgrupacionCorredor agrupacionCorredor = getAgrupacionCorredor(portalRut, portalNombre);
            XMLGregorianCalendar fechaDesde = getXmlGregorianCalendar(new Date());
            so.setFechaRecepcionCorredor(d);

            // Crear Reponse
            BulkBo crearResponse = preIngresoServiceManager.getBulkService(sesionId).crear(sesionId, tipoMovimiento, null, fechaDesde, user, user, agrupacionCorredor);
            printVariables(user,movementType,sesionId,agrupacionCorredor,fechaDesde);
            so.setEstado(crearResponse!=null?crearResponse.getEstadoId()!=null?crearResponse.getEstadoId().toString():"":"");
            Long maxSo=infoResultDAO.getMaxSol();
            so.setId(crearResponse.getId()!=null?crearResponse.getId().longValue():maxSo);
            in.setCantidadMovimientos(detailList.size());
            Corredor c=new Corredor();
            c.setNombre(user);
            c.setRut(portalRut);
            pRR.setBulkId(so.getId());


            if(crearResponse.getError() != null && crearResponse.getError().getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, LLAMADA_OK + crearResponse.getId(), null, null, null, null);
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, ERROR_PREINGRESO + (crearResponse.getError().getNumero()) + DESCRIPTION + (crearResponse.getError().getDescripcion()==null? "" : crearResponse.getError().getDescripcion()) + "]", null, null, null, null);
                preIngresoServiceManager.logout(sesionId);
                in.setMovimientosError(errorMov);
                in.setMovimientosOk(okMov);
                this.finalizePersistence(ErrorNums.CODE_ERROR,in,so,movimientos,crearResponse.getError().getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }

            // Crear Alta
            int altaQty =0;
            Lot detailLot = lotManager.getById(detailList.get(0).getLotId());
            detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
            int foil=0;
            for (Detail detail : detailList) {
                EMovimiento eMovimiento= new EMovimiento();
                if(processType == ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE){
                    detailLot = lotManager.getById(detail.getLotId());
                    detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
                }

                MovtoTraspasoBo movtoTraspasoBo = preingresoMapper.makeMovtoTraspasoBoTitular(detail, detailLot, user, crearResponse.getId(),c);
                LOGGER.info("Se crea detalle de Traspaso en pregingreso con sessionId (" + sesionId + ":");

                LOGGER.info(movtoTraspasoBo.toString());
                // Crear Alta Response
                ErrorBo crearTraspasoResponse = preIngresoServiceManager.getBulkService(sesionId).crearTraspaso(sesionId, movtoTraspasoBo);
                setResponse(eMovimiento, crearTraspasoResponse.getNumero(), crearTraspasoResponse.getDescripcion());

                if(crearTraspasoResponse.getNumero() == 0){
                    altaQty++;
                    eMovimiento.setFila(altaQty);
                    okMov++;
                    movimientos.add(eMovimiento);
                    logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Llamada correcta al mÃ©todo crearAlta() de PreIngreso.", detailLot, detail, null, null);
                } else {
                    logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo crearTraspaso() para el detalle. [CODE: " + crearTraspasoResponse.getNumero() + DESCRIPTION + crearTraspasoResponse.getDescripcion() + "]", detailLot, detail, null, null);
                    eMovimiento.setFila(altaQty+1);
                    errorMov++;
                    in.setMovimientosError(errorMov);
                    in.setMovimientosOk(okMov);
                    movimientos.add(eMovimiento);
                    //this.finalizePersistence(ErrorNums.CODE_ERROR,in,so,movimientos,crearTraspasoResponse.getDescripcion());
                    //preIngresoServiceManager.logout(sesionId);
                    //return false;
                }
                foil++;
            }
            in.setMovimientosError(errorMov);
            in.setMovimientosOk(okMov);

            // Ejecutar
            WsSolicitudResponseBo ejecutarResponse = preIngresoServiceManager.getBulkService(sesionId).ejecutarTraspaso2(sesionId, crearResponse.getId());
            ArrayOfSet sets=ejecutarResponse.getSets();
            List<Set> listaSet= sets.getSet();

            for(int i=0;i<listaSet.size();i++){
                movimientos.get(i).setFolio(listaSet.get(i).getFolio());

            }
            pRR.setBulkId(ejecutarResponse.getSolicitud());
            LOGGER.info(String.format("ID de SOLICITUD: %s", ejecutarResponse.getSolicitud()));
            LOGGER.info("Ejecutando Traspaso con ID = " + crearResponse.getId());
            if(ejecutarResponse!= null && ejecutarResponse.getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Se CREÃ“ el Traspaso  en preIngreso correctamente para " + altaQty + " registros.", null, null, null, null);
                finalizePersistence(ErrorNums.OK,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                pRR.setResponse(true);
                return pRR;
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo ejecutar() en PreIngreso. [CODE: " + ejecutarResponse.getNumero() + DESCRIPTION + ejecutarResponse.getDescripcion() + "]", null, null, null, null);
                finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, ejecutarResponse.getDescripcion());
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }

        } catch (Exception e) {
            LOGGER.info("error 1: "+e.getMessage());
            logbookManager.error(process, Log.LOG_STEP_PREINGRESO, "Hubo un error al crear el alta en preingreso: "+e.getMessage(), null);
            finalizePersistence(ErrorNums.CODE_ERROR,in, so, movimientos, e.getMessage());
            throw new PreIngresoException("Hubo un error al crear el Traspaso en preingreso: "+e.getMessage(), e);
        }

    }
    //DESIGNACIÃ“N BENEFICIARIO
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ProccesRowResponse DesignarBeneficiario(List<Detail> detailList, Process process, String user, int movementType, int processType, Long Lote) throws JAXBException, SQLException, PreIngresoException
    {
        boolean response = false;
        Date d= java.util.Date.from(Instant.now());

        ProccesRowResponse pRR = new ProccesRowResponse(false);
        try {
            // SesiÃ³n
            String sesionId = preIngresoServiceManager.getSesionId();

            // Input crear()
            int tipoMovimiento = movementType; // Alta tit y Alta Car
            String portalRut = process.getBrokerRut().replace(".", "").replace("-", "");
            String portalNombre = process.getBrokerName();

            AgrupacionCorredor agrupacionCorredor = getAgrupacionCorredor(portalRut, portalNombre);
            XMLGregorianCalendar fechaDesde = getXmlGregorianCalendar(new Date());


            // Crear Reponse
            BulkBo crearResponse = preIngresoServiceManager.getBulkService(sesionId).crear(sesionId, tipoMovimiento, null, fechaDesde, user, user, agrupacionCorredor);
            printVariables(user,movementType,sesionId,agrupacionCorredor,fechaDesde);
            Corredor c=new Corredor();
            c.setNombre(user);
            c.setRut(portalRut);
            Long maxSo=infoResultDAO.getMaxSol();
            pRR.setBulkId(crearResponse.getId());

            if(crearResponse.getError() != null && crearResponse.getError().getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, LLAMADA_OK + crearResponse.getId(), null, null, null, null);
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, ERROR_PREINGRESO + (crearResponse.getError().getNumero()) + DESCRIPTION + (crearResponse.getError().getDescripcion()==null? "" : crearResponse.getError().getDescripcion()) + "]", null, null, null, null);
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }

            // Crear DesignaciÃ³n
            int altaQty =0;
            Lot detailLot = lotManager.getById(detailList.get(0).getLotId());
            detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
            int foil=0;
            for (Detail detail : detailList) {
                EMovimiento eMovimiento= new EMovimiento();
                if(processType == ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE){
                    detailLot = lotManager.getById(detail.getLotId());
                    detailLot = updateBulkId(detailLot, crearResponse.getId().toString());
                }
                System.out.println("Entrando a agregar beneficiario");
                LOGGER.info("Entrando a agregar beneficiario");

                RequestBeneficiarioAddBo movtoAgregarBenef = preingresoMapper.makeMovtoBeneficiarioBo(detail, detailLot, user, crearResponse.getId(),c);
                LOGGER.info("Se crea detalle de DesignaciÃ³n beneficiario en pregingreso con sessionId (" + sesionId + ":");

                // Crear Alta Response
                ResultBeneficiarioBo BenefResponse = preIngresoServiceManager.getBulkService(sesionId).agregarBeneficiario(sesionId, movtoAgregarBenef);
                setResponse(eMovimiento, BenefResponse.getCodigo(), BenefResponse.getDescripcion());

                if(BenefResponse.getCodigo() == 0){
                    altaQty++;
                    eMovimiento.setFila(altaQty);
                    logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Llamada correcta al mÃ©todo crearDesignacion de PreIngreso.", detailLot, detail, null, null);
                } else {
                    logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo Designacion Beneficiario() para el detalle. [CODE: " + BenefResponse.getCodigo() + DESCRIPTION + BenefResponse.getDescripcion() + "]", detailLot, detail, null, null);
                    eMovimiento.setFila(altaQty);
                }
                foil++;
            }
            // Ejecutar
            WsSolicitudResponseBo ejecutarResponse = preIngresoServiceManager.getBulkService(sesionId).ejecutarDesignacionBeneficiario2(sesionId, crearResponse.getId());

            pRR.setBulkId(ejecutarResponse.getNumero());
            LOGGER.info(String.format("ID de SOLICITUD: %s", ejecutarResponse.getNumero()));
            LOGGER.info("Ejecutando Traspaso con ID = " + crearResponse.getId());
            if(ejecutarResponse!= null && ejecutarResponse.getNumero() == 0){
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_PREINGRESO, "Se CREÃ“ la DesignaciÃ³n en preIngreso correctamente para " + altaQty + " registros.", null, null, null, null);
                preIngresoServiceManager.logout(sesionId);
                pRR.setResponse(true);
                return pRR;
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, "Hubo un error al ejecutar el mÃ©todo ejecutar() en PreIngreso. [CODE: " + ejecutarResponse.getNumero() + DESCRIPTION + ejecutarResponse.getDescripcion() + "]", null, null, null, null);
                preIngresoServiceManager.logout(sesionId);
                return pRR;
            }

        } catch (Exception e) {
            LOGGER.info(String.format("error 1: %s",e.getMessage()));
            logbookManager.error(process, Log.LOG_STEP_PREINGRESO, "Hubo un error al crear el alta en preingreso", null);
            e.printStackTrace();
            throw new PreIngresoException("Hubo un error al crear el alta en preingreso : "+e.getMessage(), e);
        }

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<DetalleBo> findDataPreIngreso(Date from, Date to, String multiBrokerRut, String brokerRut, Integer status, String username) throws JAXBException, SQLException, PreIngresoException {
        List<DetalleBo> detalleBoList = new ArrayList<DetalleBo>();

        try {
            String sesionId = preIngresoServiceManager.getSesionId();

            XMLGregorianCalendar fechaDesde = getXmlGregorianCalendar(from);
            XMLGregorianCalendar fechaHasta = getXmlGregorianCalendar(to);
            Integer statusInt =  status==null?null:(status.equals(0)?null:status);
            brokerRut = brokerRut==null ? null : (brokerRut.equals("") ? null : brokerRut);
            Process process = processManager.getByMultiBrokerRut(multiBrokerRut.replace(".", ""));
            List<String> bulksId = lotManager.findBulksIdByProcessIdAndFromToDate(process.getId(), from, to);

            for (String bulkId : bulksId) {
                BulkDetalleBo crearResponse = preIngresoServiceManager.getBulkService(sesionId).bulkDetalle2(sesionId, Integer.valueOf(bulkId), multiBrokerRut.replace(".", "").replace("-", ""), null, statusInt, fechaDesde, fechaHasta, brokerRut);
                detalleBoList.addAll(crearResponse.getDetalles().getDetalleBo());
            }

            preIngresoServiceManager.logout(sesionId);

            return detalleBoList;
        } catch (Exception e) {
            LOGGER.info("error 1: "+e.getMessage());
            throw new PreIngresoException("Hubo un error al llamar al mÃ©todo de detalle preingreso.", e);
        }
    }

    private Lot updateBulkId(Lot detailLot, String bulkId) {
        detailLot.setBulkId(bulkId);
        lotManager.update(detailLot);

        return lotManager.getById(detailLot.getId());
    }

    private AgrupacionCorredor getAgrupacionCorredor(String portalRut, String portalNombre) {
        AgrupacionCorredor agrupacionCorredor = new ObjectFactory().createAgrupacionCorredor();
        agrupacionCorredor.setNombre(portalNombre);
        agrupacionCorredor.setRutDv(portalRut);
        return agrupacionCorredor;
    }

    private XMLGregorianCalendar getXmlGregorianCalendar(Date date) {
        GregorianCalendar a = new GregorianCalendar();
        a.setTime(date);
        XMLGregorianCalendar fechaDesde = null;
        try {
            fechaDesde = DatatypeFactory.newInstance().newXMLGregorianCalendar(a);
        } catch (Exception e){
            e.printStackTrace();
        }
        return fechaDesde;
    }

    private void updateLotToError(Lot lot) {
        lot.setLotStatusId(LotStatus.ERROR);
        lot.setLotStatus(null);

        lotManager.update(lot);
    }

    public String toXml(MovtoBo input) {

        try {
            JAXBContext context = JAXBContext.newInstance(MovtoBo.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            JAXBElement jx = new JAXBElement(new QName("root"), MovtoBo.class, input);
            marshaller.marshal(jx, sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }

}