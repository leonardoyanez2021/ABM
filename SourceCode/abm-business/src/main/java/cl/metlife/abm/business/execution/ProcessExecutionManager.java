package cl.metlife.abm.business.execution;

import cl.metlife.abm.business.execution.exception.FileTypeException;
import cl.metlife.abm.business.managers.*;
import cl.metlife.abm.business.managers.localfolder.LocalFolderManager;
import cl.metlife.abm.business.managers.pipesponsor.PipeSponsorManager;
import cl.metlife.abm.business.managers.pipesponsor.exception.PipeSponsorException;
import cl.metlife.abm.business.managers.preingreso.PreIngresoManager;
import cl.metlife.abm.business.managers.preingreso.exception.PreIngresoException;
import cl.metlife.abm.business.managers.sftp.SFTPManager;
import cl.metlife.abm.business.managers.sftp.exception.SFTPConnectionException;
import cl.metlife.abm.domain.*;
import cl.metlife.abm.domain.Process;
import cl.metlife.abm.persistence.dao.*;
import cl.metlife.abm.persistence.dao.exception.PipeSponsorDBException;
import jcifs.smb.SmbFile;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;

/**
 * Created by BluePrints Developer on 25-01-2017.
 */
@Stateless
public class ProcessExecutionManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessExecutionManager.class);
    public static final int ALTA_TITULAR_CARGA = 1;
    public static final int BAJA_TITULAR = 2;
    public static final int BAJA_CARGA = 3;
    public static final int TRASPASO_TITULAR = 4;
    public static final int DESIGNACION_BENEFICIARIO = 6;
    public static final int NORMAL_PROCESS_TYPE = 1; // Application Process Execution
    public static final int WEBSERVICE_PROCESS_TYPE = 2; // Webservice Process Execution
    private static final String PREINGRESO_USER = "preingreso.service.username";
    public static final String LOTE_QUE_LLEGA_AL_FIX_FILE = "lote que llega al fixFile";
    public static final String LOT_ID = "Lot Id\r\n";
    public static final String FIXALTATIT = "FIXALTATIT";
    //public static final int MAX_WAIT_CYCLES = 60;

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
    private MailSendlManager mailSendlManager;

    @EJB
    private LogbookManager logbookManager;

    @EJB
    private SFTPManager sftpManager;

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
    private PipeTablesManager pipeTablesManager;

    @EJB
    private LocalFolderManager localFolderManager;

    @EJB
    private ABMConfigurationManager configurationManager;

    @Asynchronous
    public void execute(Process process, String executionType) {
        execute(process, null, executionType);
    }

    @Asynchronous
    public void execute(Process process, String username, String executionType)  {

         String brokerRut="";
        try{
            brokerRut = process.getBrokerRut().replace(".", "");

            //inicio proceso
            logbookManager.info(process, Log.LOG_STEP_EJECUCION_GENERAL ,"Iniciando Proceso " + executionType + " " +
                    (process.getProcessTypeId().equals(ProcessType.PROCESS_TYPE_NORMAL) ? "Corredor ": " Multicorredor")
                    + " " + process.getBrokerName() + " (" + process.getBrokerRut() + ")" , username);

            logbookManager.info(process, Log.LOG_STEP_EJECUCION_GENERAL ,"Se procederá a conectar con servidor SFTP " + process.getHost()+":"+process.getPort()+"/"+process.getUser(), username);
            // Check SFTP and local folders. (Create, Move, Delete)
            checkFolders(process, brokerRut);
            // Getting the list of .csv in broker folder.
            List<String> currentExcelFiles = localFolderManager.listCSVFilesByRut(brokerRut);
            if(currentExcelFiles != null){
                if(!currentExcelFiles.isEmpty()){
                    int brokerFilesCount = countBrokerFiles(currentExcelFiles, brokerRut);
                    if(brokerFilesCount > 0){
                        logbookManager.info(process, Log.LOG_STEP_EJECUCION_GENERAL, "Se encontraron " + currentExcelFiles.size() + " archivos en la carpeta local. Solo " + brokerFilesCount + " de " + currentExcelFiles.size() + " archivos son válidos para procesar.", username);
                        currentExcelFiles = getOnlyFilesOfBroker(currentExcelFiles, brokerRut);
                        int csvCount = 1;
                        Lot persistedLot = null;
                        for (String currentExcelFile : currentExcelFiles) {
                            String currentExcelFileAfterDownload = "";
                            try {
                                String lot = getLotByFilename(currentExcelFile);
                                persistedLot = new Lot();
                                persistedLot.setCreationDate(new Date());
                                persistedLot.setProcessId(process.getId());
                                persistedLot.setFilename(currentExcelFile);
                                persistedLot.setNumber(lot);
                                persistedLot.setLotStatusId(LotStatus.CREATED);
                                currentExcelFileAfterDownload = Lot.PROCESSING_SUFFIX + currentExcelFile;
                                Long fileTypeId = getFileTypeIdByFilenameAndValidate(currentExcelFile);

                                LOGGER.info(String.format("CurrentExcelFile: %s",currentExcelFile));
                                LOGGER.info(String.format("FileTypeId: %s", fileTypeId));

                                persistedLot.setFileTypeId(fileTypeId);
                                String n=process.getFileDefinitionIdTraspTit();
                                LOGGER.info(String.format(" %s",n));
                                Long pipeSponsorId = getPipeSponsorId(process, fileTypeId);

                                LOGGER.info(String.format("PipeSponsorId : %s", pipeSponsorId));

                                persistedLot = lotManager.create(persistedLot);
                                Long id=persistedLot.getId();

                                LOGGER.info(String.format("idpersistedLot: %s",id));
                                byte[] fileBytes = localFolderManager.getFile(brokerRut, currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
                                byte[] fileBytesFormatted = fixFile(new String(fileBytes), Long.parseLong(persistedLot.getNumber()),fileTypeId,false);
                                logbookManager.info(process, Log.LOG_STEP_EJECUCION_GENERAL, csvCount + "/" + currentExcelFiles.size() + " Se obtuvo el archivo " + currentExcelFile + " correctamente.", username);
                                localFolderManager.saveFileAsExcel(brokerRut,currentExcelFileAfterDownload, SFTPManager.RESULTS_FOLDER_NAME, persistedLot);
                                // Uploading file into Pipe.
                                boolean pipeResponse = callToPipeSponsor(brokerRut, process, username, currentExcelFile, pipeSponsorId, persistedLot, fileBytesFormatted, currentExcelFileAfterDownload);
                                if(!pipeResponse){
                                    logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, "Hubo un error al cargar el archivo a PipeSponsor", null, username);
                                    localFolderManager.renameFile(brokerRut, currentExcelFileAfterDownload, Lot.ERROR_SUFFIX + currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
                                    localFolderManager.moveFileToResultFolder(brokerRut, Lot.ERROR_SUFFIX, currentExcelFile);
                                    csvCount++;
                                   checkErrorsAndSendMail(persistedLot, process);
                                    continue;
                                 }

                                // Processing data after be uploaded in Pipe.
                                processRowsAfterPipeLoad(process, brokerRut, currentExcelFile, fileTypeId, persistedLot, currentExcelFileAfterDownload);

                                logbookManager.log(process, Log.LOG_STEP_PREINGRESO, "El proceso Preingreso ha finalizado correctamente", null, username);
                            } catch (JAXBException | FileTypeException e)
                            {   logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_EJECUCION_GENERAL, e.getMessage(),persistedLot, e, username);
                                LOGGER.error(e.getMessage(), e);
                                localFolderManager.renameFile(brokerRut, currentExcelFileAfterDownload, Lot.ERROR_SUFFIX + currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
                            }catch (PipeSponsorException | PipeSponsorDBException e) {
                                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, e.getMessage(),persistedLot, e, username);
                                LOGGER.error(e.getMessage(), e);
                                localFolderManager.renameFile(brokerRut, currentExcelFileAfterDownload, Lot.ERROR_SUFFIX + currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
                            } catch (PreIngresoException e) {
                                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PREINGRESO, e.getMessage(), e, username);
                                LOGGER.error(e.getMessage(), e);
                                localFolderManager.renameFile(brokerRut, currentExcelFileAfterDownload, Lot.ERROR_SUFFIX + currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
                            }
                            csvCount++;
                            checkErrorsAndSendMail(persistedLot, process);
                        }

                    } else {
                        logbookManager.info(process, Log.LOG_STEP_EJECUCION_GENERAL, "No se encontraron archivos .csv del corredor para procesar.", username);
                    }
                } else {
                    logbookManager.info(process, Log.LOG_STEP_SFTP, "No se encontraron archivos .csv para procesar.", username);
                }
            } else {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_SFTP, "No se encontraron Archivos .csv para procesar", username);
            }
        } catch (SFTPConnectionException e) {
            logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_SFTP, e.getMessage(), e, username);
            LOGGER.error(e.getMessage(), e);
        } catch (SQLException e) {
            logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, e.getMessage(), e, username);
            LOGGER.error(e.getMessage(), e);
        } catch (Exception e) {
            logbookManager.info(process, Log.LOG_STEP_SFTP, "Error: "+e.getMessage(), username);
        }
    }

    private void checkErrorsAndSendMail(Lot processed, Process process) {
        List<Log> logs = logbookManager.findByProcessIdAndStatus(processed.getProcessId(), processed.getId(), Log.LOG_LEVEL_ERROR);
        try{
            if(!logs.isEmpty()){
                sftpManager.saveFromLocalToSftp(logs, processed, process.getBrokerRut(), process.getHost(), Integer.parseInt(process.getPort()), process.getUser(), process.getPassword());
                sftpManager.uploadMarkedExcel(process.getBrokerRut(), processed, process.getHost(), Integer.parseInt(process.getPort()), process.getUser(), process.getPassword());
                SmbFile adjunto =  localFolderManager.getErrorFile(process.getBrokerRut(), SFTPManager.RESULTS_FOLDER_NAME, processed.getFilename());
                mailSendlManager.sendMail(processed, logs, process, adjunto);
                logbookManager.log(process, Log.LOG_LEVEL_INFO, Log.LOG_STEP_EJECUCION_GENERAL, "Se envió email con errores al correo: " + process.getErrorMail() + ". Lotname: " + processed.getFilename(), processed, null, null, null);
            } else
                LOGGER.debug("No hay logs de error para ser enviados.");
        } catch (Exception e){
            logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_EJECUCION_GENERAL, "Error en el servidor de SMTP, El error es el siguiente : "+e.getMessage(), processed, null, e, null);
        }
    }

    private void checkFolders(Process process, String rut) throws Exception {
        // Checking if folders are created
        sftpManager.checkFolders(rut, process);
        // Checking if local folders are created
        try {
            String localFolder = localFolderManager.checkFoldersAndReturnLocalPath(rut);

            logbookManager.info(process, Log.LOG_STEP_SFTP, "Conexión Establecida", null);
            // Moving excel files from SFTP to local.
            sftpManager.moveFromSftpToLocalByFolderNameAndDelete(process, process.getBrokerRut().replace(".", ""), SFTPManager.EXCEL_FOLDER_NAME, localFolder);
            // Moving pdf files from SFTP to local.

            sftpManager.movePDFFromSftpToLocalByFolderNameAndDelete(process, process.getBrokerRut().replace(".", ""));
        }
        catch(Exception e){
            //logbookManager.info(process, Log.LOG_STEP_SFTP,"sadas",null);
        }
    }
    private void processRowsAfterPipeLoad(Process process, String brokerRut, String currentExcelFile, Long fileTypeId, Lot persistedLot,
                                       String currentExcelFileAfterDownload) throws PreIngresoException, PipeSponsorDBException, JAXBException, SQLException {
        // Registrar detalle local y enviar a preingreso.
        boolean preingresoFlowResponse = false;
        ProccesRowResponse pRR= new ProccesRowResponse(preingresoFlowResponse);
        LOGGER.info("Comenzando proceso de preingreso");
        LOGGER.info("FileType : "+fileTypeId);

        if (fileTypeId.equals(FileType.ALTA_TITULAR)) {
            List<AltaTitular> list = synchronize(persistedLot, altaTitularDAO,true);
            pRR = process(process, persistedLot, list, altaTitularDAO, ProcessExecutionManager.NORMAL_PROCESS_TYPE);

        } else if (fileTypeId.equals(FileType.ALTA_CARGA)) {
            LOGGER.info("INGRESO A ALTA CARGA");
            List<AltaCarga> list = synchronize(persistedLot, altaCargaDAO,true);
            pRR = process(process, persistedLot, list, altaCargaDAO, ProcessExecutionManager.NORMAL_PROCESS_TYPE);

        } else if (fileTypeId.equals(FileType.BAJA_TITULAR)) {
            LOGGER.info("INGRESO A BAJA TITULAR");
            List<ExclusionTitular> list = synchronize(persistedLot, exclusionTitularDAO,true);
            pRR = process(process, persistedLot, list, exclusionTitularDAO, ProcessExecutionManager.NORMAL_PROCESS_TYPE);

        } else if (fileTypeId.equals(FileType.BAJA_CARGA)) {
            LOGGER.info("INGRESO A BAJA CARGA");
            List<ExclusionCarga> list = synchronize(persistedLot, exclusionCargaDAO,true);
            pRR = process(process, persistedLot, list, exclusionCargaDAO, ProcessExecutionManager.NORMAL_PROCESS_TYPE);
        } else if (fileTypeId.equals(FileType.TRASPASO_TITULAR)) {
            LOGGER.info("INGRESO A TRASPASO TITULAR");
            List<TraspasoTitular> list = synchronize(persistedLot, traspasoTitularDAO,true);
            pRR = process(process, persistedLot, list, traspasoTitularDAO, ProcessExecutionManager.NORMAL_PROCESS_TYPE);
        }else if (fileTypeId.equals(FileType.DESIGNACION_BENEFICIARIO)) {
            LOGGER.info("INGRESO A DESIGNACIÓN BENEFICIARIO");

            List<DesignacionBeneficiario> list = synchronize(persistedLot, designacionBeneficiarioDAO,true);
            pRR = process(process, persistedLot, list, designacionBeneficiarioDAO, ProcessExecutionManager.NORMAL_PROCESS_TYPE);
        }

        persistedLot.setLotStatusId(((process.isConsiderBarcodes()) ? LotStatus.LOADED_IN_PIPESPONSOR: LotStatus.FINALIZED));
        lotManager.update(persistedLot);

        if(pRR.isResponse()){
            // Si no falla, Se marca como Procesado_
            LOGGER.info("CurrentExcelFileAfterDownload");
            LOGGER.info(currentExcelFileAfterDownload);
            LOGGER.info("CurrentExcelFile");
            LOGGER.info(String.format(" %s%s",Lot.SUCCESSFUL_SUFFIX, currentExcelFile));


            LOGGER.info("Renombrando Archivo");
            localFolderManager.renameFile(brokerRut, currentExcelFileAfterDownload, Lot.SUCCESSFUL_SUFFIX + currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
            LOGGER.info("Renombrando Archivo");
            localFolderManager.moveFileToResultFolder(brokerRut, Lot.SUCCESSFUL_SUFFIX, currentExcelFile);
        } else{
            localFolderManager.renameFile(brokerRut, currentExcelFileAfterDownload, Lot.ERROR_SUFFIX + currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
            localFolderManager.moveFileToResultFolder(brokerRut, Lot.ERROR_SUFFIX, currentExcelFile);
        }

    }

    public <U extends Operation, T extends OperationDAO<U>> List<U> synchronize(Lot persistedLot, T op, boolean isNormalExecution) throws PipeSponsorDBException {
        List<U> list;

        Long l= Long.parseLong(persistedLot.getNumber());

        LOGGER.info(persistedLot.getNumber());
        LOGGER.info(String.format(" %s",persistedLot.getId()));

        int cont = 0;
        do {
            list = pipeTablesManager.findUnprocessedRows(l,op);

            LOGGER.info(String.format( "%s",list.size()));
            if(list.isEmpty()&& !isNormalExecution){
                list = pipeTablesManager.findUnprocessedRows(persistedLot.getId(),op);
            }
            if(list.isEmpty()&&isNormalExecution) {
                list = pipeTablesManager.findUnprocessedRows(persistedLot.getId(), op);
            }
            LOGGER.info(String.format( "%s",list.size()));
            if (waitingToGetListAgain(list)) break;

            if(cont> 20)
                throw new PipeSponsorDBException("Timeout al esperar carga de Pipe de Sponsor. Error puede ser causado por archivo con datos inválidos");
            LOGGER.info(String.format( "%s",cont));
            cont++;
        } while(list.isEmpty());

        LOGGER.info(String.format( "%s",list.size()));

        return list;
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

    private <U extends Operation, T extends OperationDAO<U>> ProccesRowResponse process(Process process, Lot persistedLot, List<U> list, T opDAO, int processType) throws JAXBException, SQLException, PreIngresoException, PipeSponsorDBException {
        int index = 0;
        List<Detail> detailList = new ArrayList<>();
        for (U op : list) {
            try {
                Detail detail = detailManager.create(detailManager.map(op, persistedLot, process.isConsiderBarcodes(), ++index));
                detailList.add(detail);
            } catch (Exception e) {
                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_EJECUCION_GENERAL, "Hubo un error al procesar el alta " + op.toString(), null);
            }
        }
        String user = configurationManager.getByKey(PREINGRESO_USER).getValor();
        boolean response = false;
        ProccesRowResponse pRR=new ProccesRowResponse(response);
        if (opDAO instanceof AltaTitularDAO || opDAO instanceof AltaCargaDAO){
            pRR = preIngresoManager.createAlta(detailList, process, user, ProcessExecutionManager.ALTA_TITULAR_CARGA, processType,Long.parseLong(persistedLot.getNumber()));
        }else if (opDAO instanceof ExclusionTitularDAO){
            pRR = preIngresoManager.createBajaTitular(detailList, process, user, ProcessExecutionManager.BAJA_TITULAR, processType,Long.parseLong(persistedLot.getNumber()));
        }else if (opDAO instanceof ExclusionCargaDAO){
            pRR = preIngresoManager.createBajaCarga(detailList, process, user, ProcessExecutionManager.BAJA_CARGA, processType,Long.parseLong(persistedLot.getNumber()));
        }else if(opDAO instanceof TraspasoTitularDAO) {
            pRR = preIngresoManager.createTransaction(detailList, process, user, ProcessExecutionManager.TRASPASO_TITULAR, processType,Long.parseLong(persistedLot.getNumber()));
        }
        else if(opDAO instanceof DesignacionBeneficiarioDAO){
            pRR = preIngresoManager.DesignarBeneficiario(detailList, process, user, ProcessExecutionManager.DESIGNACION_BENEFICIARIO, processType,Long.parseLong(persistedLot.getNumber()));
        }
        if(pRR.isResponse()) {
            if(process.isConsiderBarcodes()) {
                updateDetailStatus(detailList, DetailsStatus.CREATED);
            }else{
                updateDetailStatus(detailList, DetailsStatus.FINALIZED);
            }
        } else {
            updateDetailStatus(detailList, DetailsStatus.ERROR);
        }
        changeToProcessed(list,opDAO);
        return pRR;
    }
    public void updateDetailStatus(List<Detail> details, Long statusId) {
        LOGGER.info("Pase por updateDetailStatus ");
        LOGGER.info(String.format("Status id: %s",statusId));
        for (Detail detail : details) {
            LOGGER.info(detail.toString());
            detail.setStatusId(statusId);
            detailManager.update(detail);
        }
    }
    private boolean callToPipeSponsor(String brokerRut, Process process, String username, String currentExcelFile, Long pipeSponsorId, Lot persistedLot, byte[] fileBytesFormatted, String currentExcelFileAfterDownload) throws JAXBException, SQLException, PipeSponsorException {
        boolean response = false;
        try {
            List<String> errorFileContent = new ArrayList<>();
            response = pipeSponsorManager.sendPipeSposor(process, currentExcelFile, fileBytesFormatted, pipeSponsorId, persistedLot, username, errorFileContent, brokerRut, currentExcelFileAfterDownload,null,false);
        } catch (PipeSponsorException e) {
            // Si falla, se marca como Error_
            localFolderManager.renameFile(brokerRut, currentExcelFileAfterDownload, Lot.ERROR_SUFFIX + currentExcelFile, SFTPManager.EXCEL_FOLDER_NAME);
            throw new PipeSponsorException(e.getMessage());
        }

        return response;
    }
    public StringBuilder fixFileAltaTit(String[] rows, Long lotid, boolean isweb){
        StringBuilder finalString = new StringBuilder();
        //mecanica para el archivo
        LOGGER.info(LOTE_QUE_LLEGA_AL_FIX_FILE);
        LOGGER.info(String.format( "%s",lotid));

        if(rows[0].endsWith(";")){
            finalString.append(rows[0].concat(LOT_ID));
        }
        else{
            finalString.append(rows[0].concat(";").concat(LOT_ID));
        }
        if(isweb){
            LOGGER.info(FIXALTATIT);
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[24]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        else{
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[24]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        return finalString;
    }

    private String joinArray(String[] splintedRow, String s, Long lotid) {
        StringBuilder reconString=new StringBuilder();
        for(int i=0;i<splintedRow.length-1;i++){
            reconString.append(splintedRow[i]).append(s);
        }
        reconString.append(splintedRow[splintedRow.length-1]).append(s).append(lotid).append("\r\n");
        return reconString.toString();
    }

    public StringBuilder fixFileBajaTit(String[] rows, Long lotid, boolean isweb){
        StringBuilder finalString = new StringBuilder();
        //mecanica para el archivo
        LOGGER.info(LOTE_QUE_LLEGA_AL_FIX_FILE);
        LOGGER.info(String.format( "%s",lotid));

        if(rows[0].endsWith(";")){
            finalString.append(rows[0].concat(LOT_ID));
        }
        else{
            finalString.append(rows[0].concat(";").concat(LOT_ID));
        }
        if(isweb){
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[5]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        else{
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[5]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        return finalString;
    }
    public StringBuilder fixFileAltaCarga(String[] rows, Long lotid, boolean isweb){
        StringBuilder finalString = new StringBuilder();
        //mecanica para el archivo
        LOGGER.info("lote que llega al fixFile");
        LOGGER.info(String.format( "%s",lotid));

        if(rows[0].endsWith(";")){
            finalString.append(rows[0].concat("Lot Id\r\n"));
        }
        else{
            finalString.append(rows[0].concat(";Lot Id\r\n"));
        }

        // Detectar formato: contar columnas en el header o primer registro de datos
        boolean isExtendedFormat = false;
        if(rows.length > 1){
            String firstDataRow = rows[1];
            String[] testSplit = firstDataRow.split(";");
            // Si tiene 28 columnas, es formato extendido (ALTA_TITULAR structure)
            // Si tiene 21 columnas, es formato estándar (ALTA_CARGA)
            isExtendedFormat = (testSplit.length >= 28);
            LOGGER.info("fixFileAltaCarga - Formato detectado: " + (isExtendedFormat ? "28 columnas (extendido)" : "21 columnas (estandar)"));
        }

        int lotColumnIndex = isExtendedFormat ? 24 : 17;

        if(isweb){
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0 && SplitedRow.length > lotColumnIndex){
                        SplitedRow[lotColumnIndex]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        else{
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0 && SplitedRow.length > lotColumnIndex){
                        SplitedRow[lotColumnIndex]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        return finalString;
    }
    public StringBuilder fixFileBajaCarga(String[] rows, Long lotid, boolean isweb){
        StringBuilder finalString = new StringBuilder();
        //mecanica para el archivo
        LOGGER.info("lote que llega al fixFile");
        LOGGER.info(String.format( "%s",lotid));

        if(rows[0].endsWith(";")){
            finalString.append(rows[0].concat("Lot Id\r\n"));
        }
        else{
            finalString.append(rows[0].concat(";Lot Id\r\n"));
        }
        if(isweb){
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[10]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        else{
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[10]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        return finalString;
    }
    public StringBuilder fixFileDesignacionBenef(String[] rows, Long lotid, boolean isweb){
        StringBuilder finalString = new StringBuilder();
        //mecanica para el archivo
        LOGGER.info("lote que llega al fixFile");
        LOGGER.info(String.format( "%s",lotid));

        if(rows[0].endsWith(";")){
            finalString.append(rows[0].concat("Lot Id\r\n"));
        }
        else{
            finalString.append(rows[0].concat(";Lot Id\r\n"));
        }
        if(isweb){
            LOGGER.info("FIXDESIGNACIONBENEF");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{

                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        else{
            LOGGER.info("FIXDESIGNACIONBENEF");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{

                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        return finalString;
    }
    public StringBuilder fixFileTraspasoTit(String[] rows, Long lotid, boolean isweb){
        StringBuilder finalString = new StringBuilder();
        //mecanica para el archivo
        LOGGER.info("lote que llega al fixFile");
        LOGGER.info(String.format( "%s",lotid));

        if(rows[0].endsWith(";")){
            finalString.append(rows[0].concat("Lot Id\r\n"));
        }
        else{
            finalString.append(rows[0].concat(";Lot Id\r\n"));
        }
        if(isweb){
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[8]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        else{
            LOGGER.info("FIXALTATIT");
            for(int i=1;i<rows.length;i++){
                String row=rows[i];
                String[] SplitedRow= row.split(";");
                String filaVacia=row.replace(";","").trim();
                if(filaVacia.isEmpty()){
                    //esta fila no va de vuelta
                }
                else{
                    if(i!=0){
                        SplitedRow[8]=""+lotid;
                    }
                    row = joinArray(SplitedRow,";",lotid);
                    finalString.append(row);
                }
            }
        }
        return finalString;
    }



    public byte[] fixFile(String str, Long lotId, Long Filetypeid, boolean isWeb) {
        StringBuilder finalString2 = new StringBuilder();
        String[] rows ;
        if(str.contains("\r\n"))
            rows = str.split("\r\n");
        else
            rows = str.split("\n");
        LOGGER.info("FILE TYPE ID");
        LOGGER.info(String.format( "%s",Filetypeid));
        LOGGER.info("lotId");
        LOGGER.info(String.format( "%s",lotId));


        if(Filetypeid== 1L){
            finalString2=fixFileAltaTit(rows,lotId,isWeb);
        }else if (Filetypeid==2L)
        {
            finalString2=fixFileAltaCarga(rows,lotId,isWeb);
        }else if (Filetypeid==3L)
        {
            finalString2=fixFileBajaTit(rows,lotId,isWeb);
        }else if (Filetypeid==4L)
        {
            finalString2=fixFileBajaCarga(rows,lotId,isWeb);
        }else if (Filetypeid==5L)
        {
            finalString2=fixFileTraspasoTit(rows,lotId,isWeb);
        }else{
            finalString2=fixFileDesignacionBenef(rows,lotId,isWeb);
        }
        return finalString2.toString().getBytes(StandardCharsets.UTF_8);
    }

    public <U extends Operation,T extends OperationDAO<U>> void changeToProcessed(List<U> list, T opDAO) throws PipeSponsorDBException {
        for (U op : list) {
            pipeTablesManager.updateStatus(op.getLotId(), "1",opDAO);
        }
    }

    /**
     * This method get the File Definition ID Param to send files into PipeSponsor.
     * @param process is the current process
     * @param fileTypeId is the file type id.
     * @return fileDefinitionId.
     */
    public Long getPipeSponsorId(Process process, Long fileTypeId) {
        if(fileTypeId.equals(FileType.ALTA_TITULAR))
            return Long.valueOf(process.getFileDefinitionIdAltaTit());
        else if(fileTypeId.equals(FileType.ALTA_CARGA))
            return Long.valueOf(process.getFileDefinitionIdAltaCar());
        else if(fileTypeId.equals(FileType.BAJA_TITULAR))
            return Long.valueOf(process.getFileDefinitionIdExcTit());
        else if(fileTypeId.equals(FileType.BAJA_CARGA))
            return Long.valueOf(process.getFileDefinitionIdExcCar());
        else if(fileTypeId.equals(FileType.TRASPASO_TITULAR)){
            Long p= Long.valueOf(process.getFileDefinitionIdTraspTit());
            LOGGER.info(String.format("FileDefinitionIdTraspTit: %s", p));
            return p;
        }else{
            Long p= Long.valueOf(process.getFileDefinitionIdDesignBenef());
            LOGGER.info(String.format("FileDefinitionIdDesignBenef: %s", p));
            return p;
        }
    }

    /**
     * This method return the lot number of filename.
     * @param currentExcelFile
     * @return lot number String.
     */
    private String getLotByFilename(String currentExcelFile) {
        String[] splittedName = currentExcelFile.split("_");

        return splittedName[2];
    }

    private Long getFileTypeIdByFilenameAndValidate(String currentExcelFile) throws FileTypeException {
        LOGGER.info(currentExcelFile);

        currentExcelFile=currentExcelFile.replaceAll(" ", "");
        currentExcelFile = currentExcelFile.replace(".csv", "");
        currentExcelFile = currentExcelFile.replace(".CSV", "");
        String[] splittedName = currentExcelFile.split("_");
        String response = "";


        List<FileType> fileTypes = fileTypeManager.findAll();

        Long fileId =-1L;
        StringBuilder possibleErrorMessage = new StringBuilder();
        for (FileType fileType : fileTypes) {
            LOGGER.info(fileType.getFileId());
            possibleErrorMessage.append(fileType.getFileId() + ", ");
            boolean contains = currentExcelFile.contains(fileType.getFileId());
            if(contains){
                fileId=fileType.getId();
            }
        }
        if(fileId!=-1L){
            return fileId;
        }
        else{

            String errorMessage = possibleErrorMessage.toString().substring(0, possibleErrorMessage.length() - 1);
            throw new FileTypeException("El identificador del archivo " + currentExcelFile + " es inválido. Identificadores reconocidos: " + errorMessage + ".");
        }
    }

    private List<String> getOnlyFilesOfBroker(List<String> currentExcelFiles, String rut) {
        List<String> brokerList = new ArrayList<>();

        for (String currentExcelFile : currentExcelFiles) {
            if(currentExcelFile.startsWith(rut.replace("-", "")))
                brokerList.add(currentExcelFile);
        }
        return brokerList;
    }
    private int countBrokerFiles(List<String> currentExcelFiles, String rut) {
        int count = 0;

        for (String currentExcelFile : currentExcelFiles) {
            String[] splitted = currentExcelFile.split("_");

            if(splitted[0].equals(rut.replace("-", "")))
                count++;
        }

        return count;
    }

}
