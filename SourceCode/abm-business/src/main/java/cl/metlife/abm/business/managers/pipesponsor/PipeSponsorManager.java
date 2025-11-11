package cl.metlife.abm.business.managers.pipesponsor;

import cl.metlife.abm.business.execution.WebServiceExecutionManager;
import cl.metlife.abm.business.managers.FileManager;
import cl.metlife.abm.business.managers.LogbookManager;
import cl.metlife.abm.business.managers.pipesponsor.exception.PipeSponsorException;
import cl.metlife.abm.business.managers.sftp.SFTPManager;
import cl.metlife.abm.domain.*;
import cl.metlife.abm.domain.Process;
import cl.metlife.abm.persistence.dao.AltaCargaDAO;
import cl.metlife.abm.persistence.dao.AltaTitularDAO;
import cl.metlife.abm.persistence.dao.ExclusionCargaDAO;
import cl.metlife.abm.persistence.dao.ExclusionTitularDAO;
import cl.metlife.abm.persistence.dao.TraspasoTitularDAO;
import cl.metlife.abm.persistence.dao.exception.PipeSponsorDBException;
import cl.metlife.abm.ws.domain.FileErrorDetail;
import cl.metlife.ws.clients.pipesponsor.*;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PipeSponsorManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PipeSponsorManager.class);
    @EJB
    PipeSponsorServiceManager pipeSponsorServiceManager;

    @EJB
    LogbookManager logbookManager;

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
    FileManager fileManager;


    public boolean sendPipeSposor(Process process, String filename, byte[] file, Long fileDefinitionId, Lot lot, String username, List<String> errorFileContent, String brokerRut, String currentExcelFileAfterDownload, List<FileErrorDetail> fileErrorDetailList, boolean isWS) throws PipeSponsorException {
        LogProcessDTO logDataDTO = null;

        try {
            ArrayOfSponsorRemoteFiles arrayOfSponsorRemoteFiles = makeArrayOfSponsorRemoteFiles(filename, file, fileDefinitionId);

            ISponsorMouleService service = pipeSponsorServiceManager.getService();

            logDataDTO = service.setSponsorFiles(arrayOfSponsorRemoteFiles);

            if (logDataDTO == null) {
                throw new PipeSponsorException("El servicio de PipeSponsor tiene problemas de sincronía. Favor consulte a su Administrador.");
            }

            if (logDataDTO.getLogProcessFiles() != null) {
                logDataDTO.getLogProcessFiles().getValue().getLogProcessFileDTO();
                for (LogProcessFileDTO dto : logDataDTO.getLogProcessFiles().getValue().getLogProcessFileDTO()) {
                    String logFileName = dto.getFileOrgName().getValue();

                    for (LogProcessDataDTO logProcessData : dto.getLogProcessDatas().getValue().getLogProcessDataDTO()) {
                        //verifico si hay algun error al momento de procesar el archivo
                        if (logProcessData.getErrDescription().getValue().length() > 0) {
                            if (!isWS) {
                                fileManager.colourErrorCell(brokerRut, lot.getFilename(), SFTPManager.RESULTS_FOLDER_NAME, logProcessData.getProcessDataRow(), logProcessData.getProcessDataCol().getValue());

                                logbookManager.log(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, "Hubo un error en el archivo " + filename
                                        + ", Fila: " + +logProcessData.getProcessDataRow() + ", Columna: " + logProcessData.getProcessDataCol().getValue() + ", Error :" + logProcessData.getErrDescription().getValue() + ".", lot, null, username);
                            } else {
                                String errormessage = "Hubo un error al validar archivo en pipe de sponsor. " +
                                        ", Fila: " + +logProcessData.getProcessDataRow() + ", Columna: " + logProcessData.getProcessDataCol().getValue() + ", Error :" + logProcessData.getErrDescription().getValue() + ".";
                                logbookManager.wsLog(process, Log.LOG_LEVEL_ERROR, Log.LOG_STEP_PIPESPONSOR, errormessage, null, lot, username, brokerRut);
                            }

                            errorFileContent.add("Archivo: " + logFileName + " Columna: " + logProcessData.getProcessDataCol().getValue() + " Fila: " +
                                    logProcessData.getProcessDataRow() + " Error :" + logProcessData.getErrDescription().getValue());

                            if (fileErrorDetailList != null) {
                                FileErrorDetail errorDetail = makeFileErrorDetail(logProcessData);
                                fileErrorDetailList.add(errorDetail);
                            }
                        }
                    }
                }
                if (errorFileContent.size() > 0)
                    return false;
            } else {
                logbookManager.info(process, Log.LOG_STEP_PIPESPONSOR, "Se procesó con éxito el archivo " + filename, null);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new PipeSponsorException("Ocurrió un error al cargar el archivo " + filename, e);
        }

        logbookManager.info(process, Log.LOG_STEP_PIPESPONSOR, "Se envió el archivo correctamente a pipeSponsor, se espera respuesta del servidor " + filename, null);
        return true;
    }

    private FileErrorDetail makeFileErrorDetail(LogProcessDataDTO logProcessData) {
        FileErrorDetail errorDetail = new FileErrorDetail();
        errorDetail.setColumna(logProcessData.getProcessDataCol().getValue());
        errorDetail.setDescripcion(logProcessData.getErrDescription().getValue());
        errorDetail.setError(logProcessData.getErrMessage().getValue());
        errorDetail.setFila(logProcessData.getProcessDataRow());
        return errorDetail;
    }

    private ArrayOfSponsorRemoteFiles makeArrayOfSponsorRemoteFiles(String filename, byte[] file, Long fileDefinitionId) {
        ObjectFactory fact = new ObjectFactory();

        SponsorRemoteFiles fileToUpload = fact.createSponsorRemoteFiles();

        fileToUpload.setSponsorCode(fact.createSponsorRemoteFilesSponsorCode(filename.split("_")[0]));
        fileToUpload.setFileDefinitionId(fileDefinitionId);
        fileToUpload.setExtension(fact.createSponsorRemoteFilesExtension(FilenameUtils.getExtension(filename)));
        fileToUpload.setFileName(fact.createSponsorRemoteFilesFileName(filename));

        fileToUpload.setFileBuffer(fact.createSponsorRemoteFilesFileBuffer(file));

        ArrayOfSponsorRemoteFiles arrayOfSponsorRemoteFiles = fact.createArrayOfSponsorRemoteFiles();
        arrayOfSponsorRemoteFiles.getSponsorRemoteFiles().add(fileToUpload);

        LOGGER.debug(fileToUpload.getSponsorCode().getValue());
        LOGGER.debug(fileToUpload.getFileDefinitionId().toString());
        LOGGER.debug(fileToUpload.getExtension().getValue());
        LOGGER.debug(fileToUpload.getFileName().getValue());
        LOGGER.debug(fileToUpload.toString());
        return arrayOfSponsorRemoteFiles;
    }

    public List<AltaTitular> findAltaTitularByBroker(String broker) throws PipeSponsorDBException {
        return altaTitularDAO.findPipesponsorFileByBrokerRut(broker);
    }

    public List<AltaCarga> findAltaCargaByBroker(String broker) throws PipeSponsorDBException {
        return altaCargaDAO.findPipesponsorFileByBrokerRut(broker);
    }

    public List<ExclusionTitular> findExclusionTitularByBroker(String broker) throws PipeSponsorDBException {
        return exclusionTitularDAO.findPipesponsorFileByBrokerRut(broker);
    }

    public List<ExclusionCarga> findExclusionCargaByBroker(String broker) throws PipeSponsorDBException {
        return exclusionCargaDAO.findPipesponsorFileByBrokerRut(broker);
    }

    public List<TraspasoTitular> findTraspasoTitularCargaByBroker(String broker) throws PipeSponsorDBException {
        return traspasoTitularDAO.findPipesponsorFileByBrokerRut(broker);
    }

}