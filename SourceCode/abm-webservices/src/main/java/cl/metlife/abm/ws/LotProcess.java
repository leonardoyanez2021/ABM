package cl.metlife.abm.ws;
import cl.metlife.abm.business.execution.WebServiceExecutionManager;
import cl.metlife.abm.business.managers.LogbookManager;
import cl.metlife.abm.business.managers.LotManager;
import cl.metlife.abm.domain.Lot;
import cl.metlife.abm.ws.domain.*;
import cl.metlife.ws.clients.preingreso.bulk.ArrayOfSet;
import cl.metlife.ws.clients.preingreso.bulk.WsInfoMovimientosResponseBo;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
public class LotProcess {

    public static final String MISSING_PARAMETER_BROKER_RUT = "Missing parameter: brokerRut";
    public static final String MISSING_PARAMETER_MOVEMENT_TYPE = "Missing parameter: movementType";
    public static final String MISSING_PARAMETER_FILE = "Missing parameter: file";
    @EJB
    private WebServiceExecutionManager webServiceExecutionManager;

    @EJB
    private LogbookManager logbookManager;

    @EJB
    private LotManager lotManager;


    /**
     * MEtodo que gatilla la subida de un lote
     * @param rut: rut del process
     * @param lotNumber lote del process
     * @param movementType tipo de movimiento
     * @param file archivo en formato base64
     * @return retorna un objeto de tipo ProccessResult con el codigo y la descripcion
     */
    @WebMethod
    public ProcessResult2 processLot(
            @WebParam(name = "brokerRut") String rut,
            @WebParam(name = "lotNumber")  String lotNumber,
            @WebParam(name = "date")  Date date,
            @WebParam(name = "user")  String user,
            @WebParam(name = "movementType") String movementType,
            @WebParam(name = "file") byte[] file){

        System.out.println("===== [PROCESS_LOT] INICIO DEL PROCESO =====");
        System.out.println("[PROCESS_LOT] Parametros recibidos:");
        System.out.println("  - brokerRut: " + rut);
        System.out.println("  - lotNumber: " + lotNumber);
        System.out.println("  - date: " + date);
        System.out.println("  - user: " + user);
        System.out.println("  - movementType: " + movementType);
        System.out.println("  - file size: " + (file != null ? file.length : 0) + " bytes");

        if(rut == null || rut.isEmpty()) {
            System.out.println("[PROCESS_LOT] ERROR: RUT nulo o vacio");
            return new ProcessResult2(ProcessResult.STATUS_ERROR, MISSING_PARAMETER_BROKER_RUT);
        }
        if(movementType == null || movementType.isEmpty()) {
            System.out.println("[PROCESS_LOT] ERROR: movementType nulo o vacio");
            return new ProcessResult2(ProcessResult.STATUS_ERROR, MISSING_PARAMETER_MOVEMENT_TYPE);
        }
        if(file == null || file.length==0) {
            System.out.println("[PROCESS_LOT] ERROR: archivo nulo o vacio");
            return new ProcessResult2(ProcessResult.STATUS_ERROR, MISSING_PARAMETER_FILE);
        }

        System.out.println("[PROCESS_LOT] Llamando a WebServiceExecutionManager.execute()");
        ProcessResult pr= webServiceExecutionManager.execute(rut, lotNumber, date, movementType, file, user);
        System.out.println("[PROCESS_LOT] Resultado del proceso:");
        System.out.println("  - status: " + pr.getStatus());
        System.out.println("  - errorDetail: " + pr.getErrorDetail());
        System.out.println("  - bulkId: " + pr.getBulkId());
        System.out.println("===== [PROCESS_LOT] FIN DEL PROCESO =====");
        return new ProcessResult2(pr.getStatus(),pr.getErrorDetail());

    }
    /**
     * MEtodo que gatilla la subida de un lote
     * @param rut: rut del process
     * @param lotNumber lote del process
     * @param movementType tipo de movimiento
     * @param file archivo en formato base64
     * @return ProcessResult retorna un objeto de tipo ProccessResult con el codigo y la descripcion ademas del builk id
     */
    @WebMethod
    public ProcessResult processLot2(
            @WebParam(name = "brokerRut") String rut,
            @WebParam(name = "lotNumber")  String lotNumber,
            @WebParam(name = "date")  Date date,
            @WebParam(name = "user")  String user,
            @WebParam(name = "movementType") String movementType,
            @WebParam(name = "file") byte[] file){


        if(rut == null || rut.isEmpty())
            return new ProcessResult(ProcessResult.STATUS_ERROR,MISSING_PARAMETER_BROKER_RUT,0);
        if(movementType == null || movementType.isEmpty())
            return new ProcessResult(ProcessResult.STATUS_ERROR,MISSING_PARAMETER_MOVEMENT_TYPE,0);
        if(file == null || file.length==0)
            return new ProcessResult(ProcessResult.STATUS_ERROR,MISSING_PARAMETER_FILE,0);


        ProcessResult pRR=webServiceExecutionManager.execute(rut, lotNumber, date, movementType, file, user);
        System.out.println(pRR.toString());
        return pRR;

    }
    @WebMethod
    public WsInfoMovimientosResponseBo infoCargaMovimientos(
            @WebParam(name = "Solicitud") long solicitud,
            @WebParam(name= "Lote") long lote,
            @WebParam(name = "Sets") ArrayOfSet sets
    ){

        return webServiceExecutionManager.infoCargaMovimientos(solicitud, lote, sets);
    }


    @WebMethod
    public ProcessLog getLotLog(
            @WebParam(name = "brokerRut") String rut,
            @WebParam(name = "lotNumber")  String lotNumber){

        ProcessLog processLog = new ProcessLog(null, rut, null, lotNumber, null);

        if(rut == null || rut.isEmpty())
            return new ProcessLog(MISSING_PARAMETER_BROKER_RUT);
        if(lotNumber == null || lotNumber.isEmpty())
            return new ProcessLog("Missing parameter: lotNumber");

        try {
            List<Lot> lotes = lotManager.findByRutAndLotNumber(rut, lotNumber);
            List<cl.metlife.abm.domain.Log> logs = logbookManager.findByBrokerRutAndLotNumber(rut, lotNumber);

            if(lotes.isEmpty())
                return new ProcessLog("Sin resultados");

            return populateProcessLog(processLog, logs);

        } catch (Exception e) {
            e.printStackTrace();
            processLog.setStatus("ERROR");
        }

        return processLog;
    }

    private ProcessLog populateProcessLog(ProcessLog processLog, List<cl.metlife.abm.domain.Log> logs) {
        processLog.setLotId(Long.valueOf(processLog.getLotNumber()));
        processLog.setMovementType(logs.get(0).getLot().getFileType().getName());
        processLog.setStatus(logs.get(0).getLot().getLotStatus().getName());
        processLog.setLogs(logMaps(logs));
        return processLog;
    }

    private List<Log> logMaps(List<cl.metlife.abm.domain.Log> byProcessId) {
        List<Log> logs = new ArrayList<>();

        for (cl.metlife.abm.domain.Log log : byProcessId) {
            Log log1 = new Log();

            log1.setBrokerRut(log.getBrokerRut());
            log1.setDate(log.getDate());
            log1.setLevel(log.getLevel());
            log1.setStep(log.getStep());
            log1.setMessage(log.getComment());
            logs.add(log1);
        }

        return logs;
    }
}
