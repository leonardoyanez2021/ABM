package cl.metlife.abm.business.execution;

import cl.metlife.abm.business.execution.exception.FileTypeException;
import cl.metlife.abm.business.managers.*;
import cl.metlife.abm.business.managers.pipesponsor.PipeSponsorManager;
import cl.metlife.abm.business.managers.pipesponsor.exception.PipeSponsorException;
import cl.metlife.abm.business.managers.preingreso.PreIngresoManager;
import cl.metlife.abm.business.managers.preingreso.exception.PreIngresoException;
import cl.metlife.abm.domain.Process;
import cl.metlife.abm.domain.*;
import cl.metlife.abm.persistence.dao.*;
import cl.metlife.abm.persistence.dao.exception.PipeSponsorDBException;
import cl.metlife.abm.ws.domain.FileErrorDetail;
import cl.metlife.abm.ws.domain.InfoResult;
import cl.metlife.abm.ws.domain.ProcessResult;
import cl.metlife.ws.clients.preingreso.bulk.ArrayOfSet;
import cl.metlife.ws.clients.preingreso.bulk.WsInfoMovimientosResponseBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by BluePrints Developer on 25-01-2017.
 */
@Stateless
public class WebServiceExecutionManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceExecutionManager.class);
    private static final DateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy_HH-mm");
    private static final String PREINGRESO_USER = "preingreso.service.username";
    public static final String RESPONSE_S = "Preingreso FlowResponse: %s";

    @EJB
    ProcessExecutionManager normalExecutionManager;

    @EJB
    AltaTitularDAO altaTitularDAO;

    @EJB
    AltaCargaDAO altaCargaDAO;

    @EJB
    ExclusionTitularDAO exclusionTitularDAO;

    @EJB
    ExclusionCargaDAO exclusionCargaDAO;

    @EJB
    TraspasoTitularDAO traspasoTitularDAO;
    @EJB
    DesignacionBeneficiarioDAO designacionBeneficiarioDAO;

    @EJB
    private LogbookManager logbookManager;
    @EJB
    private ABMConfigurationManager configurationManager;

    @EJB
    private PreIngresoManager preIngresoManager;

    @EJB
    private PipeSponsorManager pipeSponsorManager;

    @EJB
    private LotManager lotManager;

    @EJB
    private DetailManager detailManager;

    @EJB
    private FileTypeManager fileTypeManager;

    @EJB
    private ProcessManager processManager;

    @EJB
    private InfoResultDTO infoResultDTO;


    public InfoResult askForResults(Long solicitud, int lote, List<Integer> sets){
        // Validaciones

        return infoResultDTO.getInfoResult(solicitud,lote,sets);
    }



    public ProcessResult execute(String brokerRut, String lotNumber, Date date, String movementType, byte[] fileBytes, String user) {

        System.out.println("\n===== [WSEXEC_MGR] INICIO execute() =====");
        System.out.println("[WSEXEC_MGR] brokerRut: " + brokerRut + ", lotNumber: " + lotNumber + ", movementType: " + movementType);

        Process process = processManager.getByMultiBrokerRut(brokerRut);
        ProccesRowResponse f=new ProccesRowResponse(false);

        if(process == null){
            System.out.println("[WSEXEC_MGR] ERROR: Proceso no encontrado para RUT: " + brokerRut);
            ArrayList<String> availableRuts = new ArrayList<>(processManager.getAllRegisteredRuts());
            return new ProcessResult(ProcessResult.STATUS_ERROR,"El rut " + brokerRut + " no corresponde a un Corredor válido. Rut disponibles: "
                    + availableRuts.toString(),0);
        }
        System.out.println("[WSEXEC_MGR] Proceso encontrado: " + process.getBrokerName() + " (ID: " + process.getId() + ")");

        //inicio proceso
        logbookManager.info(process, Log.LOG_STEP_EJECUCION_GENERAL ,"Iniciando Proceso por Servicio Web " +
                (process.getProcessTypeId().equals(ProcessType.PROCESS_TYPE_NORMAL) ? "Corredor ": " Multicorredor")
                + " " + process.getBrokerName() + " (" + process.getBrokerRut() + ")" , null);

        Lot persistedLot = null;
        String errorDetail = "Hubo un error al procesar el archivo. Consulte con su Admin.";
        try{

            System.out.println("[WSEXEC_MGR] Obteniendo FileTypeId por WsId: " + movementType);
            Long fileTypeId = getFileTypeIdByWsId(movementType);
            System.out.println("[WSEXEC_MGR] FileTypeId obtenido: " + fileTypeId);

            Long pipeSponsorId = normalExecutionManager.getPipeSponsorId(process, fileTypeId);
            System.out.println("[WSEXEC_MGR] PipeSponsorId: " + pipeSponsorId);

            String fileName = "ws_lot_" + FORMAT.format(new Date()) + ".csv";
            System.out.println("[WSEXEC_MGR] Creando lote con fileName: " + fileName + ", lotNumber: " + lotNumber);

            persistedLot = lotManager.create(new Lot(new Date(), fileTypeId, process.getId(), fileName, lotNumber, LotStatus.FINALIZED));
            System.out.println("[WSEXEC_MGR] Lote creado - ID: " + persistedLot.getId() + ", Number: " + persistedLot.getNumber());

            logbookManager.wsLog(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_EJECUCION_GENERAL, "Iniciando Proceso ",null,persistedLot, null,brokerRut);
            LOGGER.info("Persisted LOT Web Service Execution Manager");
            LOGGER.info(persistedLot.toString());
            //Formateo el archivo para enviarlo a pipeSponsor
            String FileString= new String(fileBytes, StandardCharsets.UTF_8);

            LOGGER.info("Formato de archivo");
            LOGGER.info(FileString);
            System.out.println("[WSEXEC_MGR] Formateando archivo para PipeSponsor...");
            byte[] fileBytesFormatted = normalExecutionManager.fixFile(FileString, Long.parseLong(persistedLot.getNumber()), fileTypeId,true);

            // Uploading file into Pipe.
            System.out.println("[WSEXEC_MGR] Subiendo archivo a PipeSponsor...");
            boolean pipeResponse = callToPipeSponsor(brokerRut, process, fileName, pipeSponsorId, persistedLot, fileBytesFormatted);
            System.out.println("[WSEXEC_MGR] Respuesta de PipeSponsor: " + pipeResponse);

            // Processing data after be uploaded in Pipe.
            LOGGER.info("WebService processRowsAfterPipeLoad");
            System.out.println("[WSEXEC_MGR] Llamando a processRowsAfterPipeLoad()...");
            f=processRowsAfterPipeLoad(process, fileTypeId, persistedLot, user,brokerRut);
            System.out.println("[WSEXEC_MGR] processRowsAfterPipeLoad() completado. Respuesta: " + f.isResponse());

            logbookManager.wsLog(process, Log.LOG_LEVEL_INFO,Log.LOG_STEP_EJECUCION_GENERAL ,"Proceso Servicio Web Finalizado. " +
                    (process.getProcessTypeId().equals(ProcessType.PROCESS_TYPE_NORMAL) ? "Corredor ": " Multicorredor")
                    + " " + process.getBrokerName() + " (" + process.getBrokerRut() + ")" , null,persistedLot, null,brokerRut);

            if(f.isResponse()){
                System.out.println("[WSEXEC_MGR] EXITO - BulkId: " + f.getBulkId());
                System.out.println("===== [WSEXEC_MGR] FIN execute() - SUCCESS =====\n");
                return new ProcessResult(ProcessResult.STATUS_SUCCESS,"Se procesó correctamente el archivo. Proceso Servicio Web Finalizado.", f.getBulkId());
            }
            else {
                System.out.println("[WSEXEC_MGR] ERROR - BulkId: " + f.getBulkId());
                System.out.println("===== [WSEXEC_MGR] FIN execute() - ERROR =====\n");
                return new ProcessResult(ProcessResult.STATUS_ERROR, "Hubo un error al ejecutar el Archivo",f.getBulkId());
            }

        } catch (PipeSponsorException e) {
            System.out.println("[WSEXEC_MGR] EXCEPCION PipeSponsorException: " + e.getMessage());
            logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, "Error en la validacion del archivo en Pipe de Sponsor", e,persistedLot,null, brokerRut);
            LOGGER.error(e.getMessage(), e);
            ProcessResult processResult = new ProcessResult(ProcessResult.STATUS_ERROR, "Hubo un error al cargar el archivo a PipeSponsor ",f.getBulkId()                    );
            processResult.setFileErrorDetailList(e.getFileErrorDetails());
            processResult.setBulkId(processResult.getBulkId());
            return processResult;
        } catch (PreIngresoException | PipeSponsorDBException e) {
            logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, e.getMessage(), e,persistedLot,null, brokerRut);
            LOGGER.error(e.getMessage(), e);
            errorDetail="Error al contactar con preingreso: "+e.getMessage();



        } catch (FileTypeException e) {
            logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_EJECUCION_GENERAL, e.getMessage(), e,persistedLot,null, brokerRut);
            LOGGER.error(e.getMessage(), e);
            errorDetail=e.getMessage();
        } catch (JAXBException | SQLException e) {
            logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, e.getMessage(), e,persistedLot,null, brokerRut);
            LOGGER.error(e.getMessage(), e);
        } catch (RuntimeException e) {
            errorDetail="Error inesperado, posible rut mal formateado. "+e.getMessage();
            logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, errorDetail, e,persistedLot,null, brokerRut);
            LOGGER.error(e.getMessage(), e);
        }
        return new ProcessResult(ProcessResult.STATUS_ERROR, errorDetail,f.getBulkId());
    }

    private ProccesRowResponse processRowsAfterPipeLoad(Process process, Long fileTypeId, Lot persistedLot, String user,String brokerRut)
            throws PreIngresoException, PipeSponsorDBException, JAXBException, SQLException {
        // Registrar detalle local y enviar a preingreso.
        boolean preingresoFlowResponse = false;
        ProccesRowResponse pRR=new ProccesRowResponse(false);

        LOGGER.info(String.format( "FileType : %s", fileTypeId));
        try{
            if (fileTypeId.equals(FileType.ALTA_TITULAR)) {
                LOGGER.info("Alta titular WebService");
                List<AltaTitular> list = normalExecutionManager.synchronize(persistedLot, altaTitularDAO, false);
                pRR = process(process, persistedLot, list, user, altaTitularDAO, brokerRut);
                LOGGER.info(String.format(RESPONSE_S, preingresoFlowResponse));
            } else if (fileTypeId.equals(FileType.ALTA_CARGA)) {
                LOGGER.info("Alta Carga WebService");
                List<AltaCarga> list = normalExecutionManager.synchronize(persistedLot, altaCargaDAO, false);
                pRR = process(process, persistedLot, list, user, altaCargaDAO, brokerRut);
                LOGGER.info(String.format(RESPONSE_S, preingresoFlowResponse));
            } else if (fileTypeId.equals(FileType.BAJA_TITULAR)) {
                LOGGER.info("Baja titular WebService");
                List<ExclusionTitular> list = normalExecutionManager.synchronize(persistedLot, exclusionTitularDAO, false);
                pRR = process(process, persistedLot, list, user, exclusionTitularDAO, brokerRut);
                LOGGER.info(String.format(RESPONSE_S, preingresoFlowResponse));
            } else if (fileTypeId.equals(FileType.BAJA_CARGA)) {
                LOGGER.info("Baja Carga WebService");
                LOGGER.info(persistedLot.toString());
                List<ExclusionCarga> list = normalExecutionManager.synchronize(persistedLot, exclusionCargaDAO, false);
                LOGGER.info(String.format("%s",list.size()));
                LOGGER.info("entrando a process");
                pRR = process(process, persistedLot, list, user, exclusionCargaDAO, brokerRut);
                LOGGER.info(String.format(RESPONSE_S, preingresoFlowResponse));
            } else if (fileTypeId.equals(FileType.TRASPASO_TITULAR)) {
                LOGGER.info("Traspaso titular WebService");
                List<TraspasoTitular> list = normalExecutionManager.synchronize(persistedLot, traspasoTitularDAO, false);
                pRR = process(process, persistedLot, list, traspasoTitularDAO, brokerRut);
                LOGGER.info(String.format(RESPONSE_S, preingresoFlowResponse));
            } else if (fileTypeId.equals(FileType.DESIGNACION_BENEFICIARIO) || fileTypeId==7L) {
                LOGGER.info("DesignaciÃ³n Beneficiario WebService");
                List<DesignacionBeneficiario> list = normalExecutionManager.synchronize(persistedLot, designacionBeneficiarioDAO, false);
                pRR = process(process, persistedLot, list, designacionBeneficiarioDAO, brokerRut);
                LOGGER.info(String.format(RESPONSE_S, preingresoFlowResponse));
            } else{
                LOGGER.info("el tipo de movimiento que se ingreso no estÃ¡ disponible actualmente");


            }
            return pRR;
        }catch(Exception e)
        {
            LOGGER.info(String.format("Error en este punto desconocido %s",e.getMessage()));
            e.printStackTrace();
            return pRR;
        }

    }
    private boolean waitingToGetListAgain(List list) {
        if(list.isEmpty()){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                LOGGER.error("Errorsito GeGeWe con threads");
                Thread.currentThread().interrupt();
            }
        } else {
            return true;
        }
        return false;
    }
    private <U extends Operation, T extends OperationDAO<U>> ProccesRowResponse process(Process process, Lot persistedLot, List<U> list, T opDAO,String brokerRut) throws JAXBException, SQLException, PreIngresoException, PipeSponsorDBException {
        System.out.println("\n[WSEXEC_MGR_PROCESS] INICIO process()");
        System.out.println("[WSEXEC_MGR_PROCESS] Cantidad de registros a procesar: " + list.size());
        System.out.println("[WSEXEC_MGR_PROCESS] LotId: " + persistedLot.getId() + ", opDAO type: " + opDAO.getClass().getSimpleName());

        int index = 0;
        List<Detail> detailList = new ArrayList<>();
        for (U op : list) {
            try {
                Detail detail = detailManager.create(detailManager.map(op, persistedLot, process.isConsiderBarcodes(), ++index));
                detailList.add(detail);
                if(index <= 3) { // Log primeros 3 detalles
                    System.out.println("[WSEXEC_MGR_PROCESS] Detalle #" + index + " creado - ID: " + detail.getId());
                }
            } catch (Exception e) {
                System.out.println("[WSEXEC_MGR_PROCESS] ERROR al procesar registro #" + index + ": " + e.getMessage());
                logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_EJECUCION_GENERAL, "Hubo un error al procesar el alta " + op.toString(), null,brokerRut);
            }
        }
        System.out.println("[WSEXEC_MGR_PROCESS] Total de detalles creados: " + detailList.size());

        String user = configurationManager.getByKey(PREINGRESO_USER.toString()).getValor();
        System.out.println("[WSEXEC_MGR_PROCESS] Usuario preingreso: " + user);

        boolean response = false;
        ProccesRowResponse pRR=new ProccesRowResponse(false);
        try {
            if (opDAO instanceof AltaTitularDAO || opDAO instanceof AltaCargaDAO) {
                System.out.println("[WSEXEC_MGR_PROCESS] Llamando a preIngresoManager.createAlta()");
                pRR = preIngresoManager.createAlta(detailList, process, user, ProcessExecutionManager.ALTA_TITULAR_CARGA, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(persistedLot.getNumber()));
            } else if (opDAO instanceof ExclusionTitularDAO) {
                System.out.println("[WSEXEC_MGR_PROCESS] Llamando a preIngresoManager.createBajaTitular()");
                pRR = preIngresoManager.createBajaTitular(detailList, process, user, ProcessExecutionManager.BAJA_TITULAR, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(persistedLot.getNumber()));
            } else if (opDAO instanceof ExclusionCargaDAO) {
                System.out.println("[WSEXEC_MGR_PROCESS] Llamando a preIngresoManager.createBajaCarga()");
                pRR = preIngresoManager.createBajaCarga(detailList, process, user, ProcessExecutionManager.BAJA_CARGA, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(persistedLot.getNumber()));
            } else if (opDAO instanceof TraspasoTitularDAO) {
                System.out.println("[WSEXEC_MGR_PROCESS] Llamando a preIngresoManager.createTransaction()");
                pRR = preIngresoManager.createTransaction(detailList, process, user, ProcessExecutionManager.TRASPASO_TITULAR, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(persistedLot.getNumber()));
            } else if (opDAO instanceof DesignacionBeneficiarioDAO) {
                System.out.println("[WSEXEC_MGR_PROCESS] Llamando a preIngresoManager.DesignarBeneficiario()");
                pRR = preIngresoManager.DesignarBeneficiario(detailList, process, user, ProcessExecutionManager.DESIGNACION_BENEFICIARIO, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(persistedLot.getNumber()));
            }
            System.out.println("[WSEXEC_MGR_PROCESS] Respuesta de PreIngreso: " + pRR.isResponse() + ", BulkId: " + pRR.getBulkId());

            if (pRR.isResponse()) {
                System.out.println("[WSEXEC_MGR_PROCESS] Actualizando estado de detalles a: " + (process.isConsiderBarcodes() ? "CREATED" : "FINALIZED"));
                if (process.isConsiderBarcodes()) {
                    normalExecutionManager.updateDetailStatus(detailList, DetailsStatus.CREATED);
                } else {
                    normalExecutionManager.updateDetailStatus(detailList, DetailsStatus.FINALIZED);
                }
            } else {
                System.out.println("[WSEXEC_MGR_PROCESS] Actualizando estado de detalles a ERROR");
                normalExecutionManager.updateDetailStatus(detailList, DetailsStatus.ERROR);
            }
            normalExecutionManager.changeToProcessed(list, opDAO);
            System.out.println("[WSEXEC_MGR_PROCESS] FIN process() - SUCCESS\n");
            return pRR;
        }
        catch (Exception e){
            System.out.println("[WSEXEC_MGR_PROCESS] EXCEPCION en process(): " + e.getMessage());
            e.printStackTrace();
            normalExecutionManager.changeToProcessed(list, opDAO);
            LOGGER.info(e.getMessage());
            throw e;
        }

    }

    private <U extends Operation, T extends OperationDAO<U>> ProccesRowResponse process(Process process,Lot persistedLot, List<U> list, String user, T opDAO, String brokerRut) throws JAXBException, SQLException, PreIngresoException, PipeSponsorDBException {

        boolean response=false;
        ProccesRowResponse pRR= new ProccesRowResponse(false);

        HashMap<Long, Lot> lotsCreated = new HashMap<>();
        List<Detail> detailList = new ArrayList<>();
        int counter = 0;
        Lot lot=null;
        for (U op : list) {
            try {
                lot = null;
                // Crear un lote nuevo con el registro de lote altatitular
                if(!lotsCreated.containsKey(op.getLote())){

                    if(opDAO instanceof AltaTitularDAO) {
                        lot = lotManager.create(new Lot(new Date(), FileType.ALTA_TITULAR, process.getId(), "WS_" + FORMAT.format(new Date()), op.getLote().toString(), LotStatus.FINALIZED));
                    }
                    else if(opDAO instanceof ExclusionTitularDAO) {
                        lot = lotManager.create(new Lot(new Date(), FileType.BAJA_TITULAR, process.getId(), "WS_" + FORMAT.format(new Date()), op.getLote().toString(), LotStatus.FINALIZED));
                    }
                    else if(opDAO instanceof AltaCargaDAO) {
                        lot = lotManager.create(new Lot(new Date(), FileType.ALTA_CARGA, process.getId(), "WS_" + FORMAT.format(new Date()), op.getLote().toString(), LotStatus.FINALIZED));
                    }
                    else if(opDAO instanceof ExclusionCargaDAO) {
                        lot = lotManager.create(new Lot(new Date(), FileType.BAJA_CARGA, process.getId(), "WS_" + FORMAT.format(new Date()), op.getLote().toString(), LotStatus.FINALIZED));
                    }
                    else if(opDAO instanceof TraspasoTitularDAO) {
                        lot = lotManager.create(new Lot(new Date(), FileType.TRASPASO_TITULAR, process.getId(), "WS_" + FORMAT.format(new Date()), op.getLote().toString(), LotStatus.FINALIZED));
                    }
                    else{
                        lot = lotManager.create(new Lot(new Date(), FileType.DESIGNACION_BENEFICIARIO, process.getId(), "WS_" + FORMAT.format(new Date()), op.getLote().toString(), LotStatus.FINALIZED));
                    }
                    lotsCreated.put(op.getLote(), lot);
                } else {
                    lot = lotsCreated.get(op.getLote());
                }

                Detail objToCreate = detailManager.map(op, lot, process.isConsiderBarcodes(), ++counter);
                objToCreate.setStatusId(DetailsStatus.FINALIZED);
                Detail detail = detailManager.create(objToCreate);

                detailList.add(detail);
            } catch (Exception e){
                LOGGER.info(String.format( "Error 1 : %s",e.getMessage()));
                logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_EJECUCION_GENERAL, "Hubo un error al procesar la operacion " + op.toString(), null, op.getRutCorredor());
            }
        }
        try {
            if (opDAO instanceof AltaTitularDAO || opDAO instanceof AltaCargaDAO)
                pRR = preIngresoManager.createAlta(detailList, process, user, ProcessExecutionManager.ALTA_TITULAR_CARGA, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(lot.getNumber()));
            else if (opDAO instanceof ExclusionTitularDAO)
                pRR = preIngresoManager.createBajaTitular(detailList, process, user, ProcessExecutionManager.BAJA_TITULAR, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(lot.getNumber()));
            else if (opDAO instanceof ExclusionCargaDAO)
                pRR = preIngresoManager.createBajaCarga(detailList, process, user, ProcessExecutionManager.BAJA_CARGA, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(lot.getNumber()));
            else if (opDAO instanceof TraspasoTitularDAO)
                pRR = preIngresoManager.createTransaction(detailList, process, user, ProcessExecutionManager.TRASPASO_TITULAR, ProcessExecutionManager.WEBSERVICE_PROCESS_TYPE, Long.parseLong(lot.getNumber()));
            normalExecutionManager.changeToProcessed(list, opDAO);
            LOGGER.info(String.format("Response: %s", pRR.toString()));
            return pRR;
        }catch (Exception e){
            normalExecutionManager.changeToProcessed(list, opDAO);
            LOGGER.info(e.getMessage());
            throw e;
        }
    }
    public WsInfoMovimientosResponseBo infoCargaMovimientos(long idSolicitud, long idLote, ArrayOfSet sets){

        return preIngresoManager.infoCargaMovimiento(idSolicitud, idLote, sets);
    }

    private boolean callToPipeSponsor(String brokerRut, Process process, String fileName, Long pipeSponsorId, Lot persistedLot, byte[] fileBytesFormatted) throws JAXBException, SQLException, PipeSponsorException {
        boolean response = false;
        List<String> errorFileContent = new ArrayList<>();
        List<FileErrorDetail> fileErrorDetails = new ArrayList<>();
        response = pipeSponsorManager.sendPipeSposor(process, fileName, fileBytesFormatted, pipeSponsorId, persistedLot, null, errorFileContent, brokerRut, fileName,fileErrorDetails,true);
        if(!errorFileContent.isEmpty())
            throw  new PipeSponsorException(errorFileContent.toString(),fileErrorDetails);
        return response;
    }


    private Long getFileTypeIdByWsId(String movementType) throws FileTypeException {

        List<FileType> fileTypes = fileTypeManager.findAll();

        for (FileType fileType : fileTypes) {

            if(fileType.getWsId().equals(movementType))
                return fileType.getId();
        }

        String tiposWS = fileTypes.stream().map(fileType -> fileType.getWsId()).collect(Collectors.toList()).toString();
        throw new FileTypeException("El tipo de archivo es invÃ¡lido. Identificadores reconocidos: " + tiposWS );
    }

}
