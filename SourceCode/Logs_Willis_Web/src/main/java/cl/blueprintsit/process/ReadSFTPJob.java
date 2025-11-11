package cl.blueprintsit.process;


import cl.blueprintsit.powercenter.wrapper.PowerCenterWrapper;
import cl.blueprintsit.powercenter.wrapper.exception.PowerCenterServiceException;
import cl.blueprintsit.type.*;
import cl.blueprintsit.ws.filenet.ConectorFileNetWSI;
import cl.blueprintsit.ws.filenet.Document;
import cl.blueprintsit.ws.filenet.FileNetWS;
import cl.blueprintsit.ws.filenet.Metadata;
import cl.blueprintsit.ws.pipesponsor.*;

import com.informatica.wsh.VoidResponse;
import com.jcraft.jsch.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.util.SystemOutLogger;
import org.quartz.*;

import java.io.*;

import jxl.read.biff.BiffException;
import org.slf4j.LoggerFactory;

import javax.persistence.Access;
import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by BlueprintsIT on 4/22/2016.
 */
@DisallowConcurrentExecution
public class ReadSFTPJob implements Job {

	static private final org.slf4j.Logger log = LoggerFactory.getLogger(ReadSFTPJob.class);

	JSch jsch = new JSch();
	Session session = null;
	ChannelSftp sftp = null;
	SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	private String USER_SFTP=null;
	private String HOST_SFTP=null;
	private Integer PORT_SFTP =null;
	private String PASS_SFTP =null;
	private String FOLDER_REMOTE_DOCUMENT=null;
	private String FOLDER_REMOTE_IMAGEN =null;
	private String FOLDER_LOCAL_IMAGEN =null;
	private String FOLDER_LOCAL_DOCUMENT =null;
	private String ID_FILE_INCORPORACION=null;
	private String ID_FILE_INCORPO_DEPE=null;
	private String ID_FILE_EXCLUIR_TITULAR=null;
	private String ID_FILE_EXCLUIR_CARGA=null;
	private String TIME_EJECUTION=null;
	private String rutArchivoCorredor= null;
	private int loteArchivo;
	private String fileProcessing;
	private String PWC_RepositoryDomainName =null;
	private String PWC_Password =null;
	private String PWC_UserName =null;
	private String PWC_RepositoryName =null;
	private String PWC_domainName =null;
	private String PWC_folderName =null;
	private String PWC_serviceName =null;
	private String PWC_workflowName_001;//wf_001_ALTA_TITULAR
	private String PWC_workflowName_002;//wf_002_ALTA_CARGAS
	private String PWC_workflowName_003;//wf_003_BAJA_TITULAR
	private String PWC_workflowName_004;//wf_004_BAJA_CARGAS
	//NRA Agregamos la variale PWC_workflowName_005
	private String BORRAR_ARCHIVO=null;
	private String PWC_workflowName_005;//wf_005_BANCHILE_POLIZAS
	private String ID_FILE_POLIZAS_BCOCHILE= null;
	//NRA codigo para archivos pipe. 
	private Long PS_FileDefinitionId_BCOCHILE;
	private String endpoint;
	private ConnectionBD connectionBD = new ConnectionBD();
	private String URL_WS_FileNet;
	private String URL_WS_PipeSponsor;

	private Long PS_FileDefinitionId_ALTATIT;
	private Long PS_FileDefinitionId_ALTACAR;
	private Long PS_FileDefinitionId_EXCTIT;
	private Long PS_FileDefinitionId_EXCCAR;


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		searchParameterConf(); //Busca los parametros de configuracion inicial
		Calendar calendar = Calendar.getInstance();
		Date date =  calendar.getTime();
		Date nextDate = date;

		String[] timeEje = TIME_EJECUTION.split(":");

		if (timeEje[0].equals("00"))//En que momento va a iniciar la tarea
			nextDate.setMinutes(date.getMinutes() + Integer.valueOf(timeEje[1]));
		else
		{
			nextDate.setHours(date.getHours() + Integer.valueOf(timeEje[0]));
		}
		try {
			connectionBD.statusProcess(AccessParameters.process_nextEjecution, AccessParameters.processing, "INICIO - PROXIMA EJECUCION: "+formatter2.format(nextDate));
			connectionBD.registerLog("PROXIMA EJECUCION: "+formatter2.format(nextDate), AccessParameters.logTypeINFO, "EJECUCION GENERAL",null, 0);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		log.info("PROXIMA EJECUCION: "+formatter2.format(nextDate));
		

		// INICIALIZA LOS PROCESOS CON EL ESTADO "POR PROCESAR"
		try {
			processInitializarce();
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		try {
			// inicio RRG
			JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
			//fetch parameters from JobDataMap		
			//String strEntidad = dataMap.getString("entidad"); // RRG
			String strEntidad = "BCO_CHILE"; // Se setea en duro ya que dataMap viene nulo
			log.debug("entidad:"+ strEntidad);
			log.info("==================================================================================");
			log.info("=================PROCESANDO ENTIDAD:"+ strEntidad);
			log.info("==================================================================================");
			//if (connectionBD.searchParameterConfSFTP()){ // RRG
			searchParameterConf(strEntidad);
			if(connectionBD.searchParameterConfSFTP(strEntidad)) {
				log.info("rrg.Entidad : "+strEntidad);
				if	(strEntidad.equalsIgnoreCase("BCO_CHILE")){
					// fin RRG	//NRA se agrego al if la validacion de cuando sea bco_chile, solo leera la carpeta de documentos .
					processFileSFTP( strEntidad,FOLDER_REMOTE_DOCUMENT, FOLDER_LOCAL_DOCUMENT,AccessParameters.process_DownloadDocumento);
				} /*else {
					processFileSFTP(FOLDER_REMOTE_DOCUMENT, FOLDER_LOCAL_DOCUMENT,AccessParameters.process_DownloadDocumento);
					processFileSFTP(FOLDER_REMOTE_IMAGEN, FOLDER_LOCAL_IMAGEN,AccessParameters.process_DownloadImag);
				}*/
			}
			Connection connection = connectionBD.getConnectionPipeSponsor();
			if (connection!=null){
				connection.close();
				readContentFolderDocument(strEntidad); //Lee el contenido del archivo excel y guardar en bd
				Calendar cal = Calendar.getInstance();
				Date date1 =  cal.getTime();
					connectionBD.registerLog("FIN FLUJO DEL PROCESO "+  formatter2.format(date1), AccessParameters.logTypeINFO, "EJECUCION GENERAL",null,0);
				log.info("FIN FLUJO DEL PROCESO "+  formatter2.format(date1));
				log.info("==================================================================================");
				log.info("=================FIN ENTIDAD:"+ strEntidad);
				log.info("==================================================================================");
			}else {
				log.info("NO HAY CONEXION CON LA BD DE PIPESPONSOR");
				connectionBD.registerLog("NO HAY CONEXION CON LA BD DE PIPESPONSOR", AccessParameters.logTypeERROR, "EJECUCION GENERAL",null,0);}

		} catch (Exception e) {
			try {
				connectionBD.registerLog("OCURRIO UN ERROR EN EL FLUJO DEL PROCESO", AccessParameters.logTypeERROR, "EJECUCION GENERAL",null,0);
			} catch (SQLException e1) {

				log.error(e1.getMessage());
			}
			e.printStackTrace();
			log.error("OCURRIO UN ERROR EN EL FLUJO DEL PROCESO, " + e.getStackTrace().toString());

		}
	}

	/*COLOCA TODOS LOS PROCESO CON ESTADO "POR PROCESAR"*/
	private void processInitializarce() throws SQLException {
		connectionBD.statusProcess(AccessParameters.process_DownloadDocumento, AccessParameters.forProcess, null);
		connectionBD.statusProcess(AccessParameters.process_DownloadImag, AccessParameters.forProcess,null);
		connectionBD.statusProcess(AccessParameters.process_PipeSponsor, AccessParameters.forProcess,null);
		connectionBD.statusProcess(AccessParameters.process_FileNet, AccessParameters.forProcess,null);
		connectionBD.statusProcess(AccessParameters.process_FileNet, AccessParameters.forProcess,null);
	}

	/*HACE LA CONEXION CON SFTP, Y DEVUELVE LA CONEXION OBTENIDA*/
	public ChannelSftp getConnectionSFTP() {

		ChannelSftp sftp = new ChannelSftp();
		try {
			log.info("INGRESA A LA CONFIGURACION DE CONEXION SFTP ");
			session = jsch.getSession(USER_SFTP, HOST_SFTP, PORT_SFTP);
			UserInfo ui = new SUserInfo(PASS_SFTP, null);			
			/* Informacion de las rutas del archivo */
			session.setUserInfo(ui);
			session.setPassword(PASS_SFTP);
			session.setTimeout(3600000);
			session.connect();
			sftp = (ChannelSftp) session.openChannel("sftp");
			sftp.connect(3600000);
			
		} catch (JSchException e) {
			connectionBD.registerLog("PROBLEMAS AL CONECTAR CON EL SFTP: "+e.getMessage(),AccessParameters.logTypeERROR, "SFTP", null,0);
			sftp =  null;
			log.error(e.getMessage());

		}
		finally {
			return sftp;
		}
	}
	/* LEE LOS ARCHIVOS DE LA CARPETA SFT RECIBIDA COMO PARAMETRO DE ENTRADA (folderRemote),
    Y LOS GUARDA EN LA CARPETA DE SALIDA (folderLocal) */
	private void processFileSFTP(String folderRemote, String folderLocal, int process ) throws SQLException {
		log.info("Se esta ingresando a la carpeta remota del SFTP: " + folderRemote + " para ser guardada en :" + folderLocal + " de proceso " + process);
		sftp = getConnectionSFTP();
		if (sftp!=null){
			String fileName="";
			try {
				if (!folderRemote.equalsIgnoreCase("")){
					sftp.cd(folderRemote);
				}           
				try {
					connectionBD.statusProcess(process, AccessParameters.processing, null); //indica el estado del proceso
					Vector<ChannelSftp.LsEntry> fileList = sftp.ls(folderRemote);
					log.info("Lista de archivos: "+fileList.size());
					int cantFile = 0;                  
					for(ChannelSftp.LsEntry entry : fileList) {
						fileName =entry.getFilename();
						
						if  ( !fileName.equalsIgnoreCase(".") && !fileName.equalsIgnoreCase("..")) {
							sftp.get(fileName,folderLocal);
							cantFile ++;
							connectionBD.registerLog(fileList.size()+"-"+cantFile+" - Descargado: "+folderRemote+""+fileName, AccessParameters.logTypeINFO, "SFTP", null,0);

							log.info(fileList.size()+"-"+cantFile+" - Descargado: "+folderRemote+""+fileName);
							deleteFileSFTP(folderRemote,fileName);

						}

					}
					connectionBD.registerLog("Ruta: "+folderRemote+" archivos descargados "+cantFile, AccessParameters.logTypeINFO,"SFTP", null,0);         

				} catch (SftpException e) {
					connectionBD.registerLog("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName, AccessParameters.logTypeERROR,"SFTP", null,0);
					sftp.exit();
					sftp.disconnect();
					session.disconnect();
					log.error("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName + " " + e.toString());
					e.printStackTrace();
				} catch (SQLException e) {
					sftp.exit();
					sftp.disconnect();
					session.disconnect();
					log.error("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName + " " + e.toString());
					e.printStackTrace();
				}
			}catch (SftpException e) {           
				sftp.exit();
				sftp.disconnect();
				session.disconnect();
				connectionBD.registerLog("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName, AccessParameters.logTypeERROR,"SFTP", null,0);
				log.error("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName +" ERROR:"+e.toString());
				e.printStackTrace();
			}
			connectionBD.statusProcess(process, AccessParameters.processed,null);
			sftp.exit();
			sftp.disconnect();
			session.disconnect();
		}
	}

	//NRA Agibibz sobrecarga el metodo para agregar la entidad a procesar
	private void processFileSFTP(String strEntidad , String folderRemote, String folderLocal, int process ) throws SQLException {
		searchParameterConf(strEntidad); //Busca los parametros de configuracion inicial
		log.info("Se esta ingresando a la carpeta remota del SFTP: " + folderRemote + " para ser guardada en :" + folderLocal + " de proceso " + process);
		sftp = getConnectionSFTP();
		if (sftp!=null){
			String fileName="";
			try {
				if (!folderRemote.equalsIgnoreCase("")){
					sftp.cd(folderRemote);
				}           
				try {
					connectionBD.statusProcess(process, AccessParameters.processing, null); //indica el estado del proceso
					Vector<ChannelSftp.LsEntry> fileList = sftp.ls(folderRemote);
					log.info("Lista de archivos: "+fileList.size());
					int cantFile = 0;                  
					for(ChannelSftp.LsEntry entry : fileList) {
						
						fileName =entry.getFilename();
				//		String[] nArch = fileName.split(".");
				//		String nombre = nArch[0];
						
						if  ( !fileName.equalsIgnoreCase(".") && !fileName.equalsIgnoreCase("..")) {
							
							  String[] strNArchivo =fileName.split("\\.");
							//NRA , VOY AL SFTP Y LLAMO AL NOMBRE DEL ARCHIVO SCS
							if(strNArchivo.length>0 && strNArchivo[0].equalsIgnoreCase("SCS")){
								
								sftp.get(fileName,folderLocal);
								cantFile ++;
								connectionBD.registerLog(fileList.size()+"-"+cantFile+" - Descargado: "+folderRemote+""+fileName, AccessParameters.logTypeINFO, "SFTP", null,0);
								
							}
	

							log.info(fileList.size()+"-"+cantFile+" - Descargado: "+folderRemote+""+fileName);
							//NRA traemos el parametro bborrar archivo , para sabebr si borrarlos de la carpeta sftp una ves extraidos.

							//NRA Recordad descomentar al finalizar las pruebas .
							if(strEntidad.equalsIgnoreCase("BCO_CHILE")){
								deleteFileSFTP(folderRemote,fileName);
							}else {
								
								deleteFileSFTP(folderRemote,fileName);

							}

						}

					}
					connectionBD.registerLog("Ruta: "+folderRemote+" archivos descargados "+cantFile, AccessParameters.logTypeINFO,"SFTP", null,0);         

				} catch (SftpException e) {
					connectionBD.registerLog("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName, AccessParameters.logTypeERROR,"SFTP", null,0);
					sftp.exit();
					sftp.disconnect();
					session.disconnect();
					log.error(e.toString());
					e.printStackTrace();

				} catch (SQLException e) {
					sftp.exit();
					sftp.disconnect();
					session.disconnect();
					log.error(e.toString());
					e.printStackTrace();
				}
			}catch (SftpException e) {           
				sftp.exit();
				sftp.disconnect();
				session.disconnect();
				connectionBD.registerLog("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName, AccessParameters.logTypeERROR,"SFTP", null,0);
				log.error("PROBLEMAS ACCEDIENDO A: "+folderRemote+""+fileName +" ERROR:" + e.toString());
				e.printStackTrace();
			}
			connectionBD.statusProcess(process, AccessParameters.processed,null);
			sftp.exit();
			sftp.disconnect();
			session.disconnect();
		}
	}


	public void deleteFileSFTP(String directory, String deleteFile) throws SQLException {
		try {
			log.info("Se comienza con la eliminación del archivo");
			log.info("Directorio" + directory + ", archivo a borrar :" + deleteFile);
			sftp.cd(directory);
			sftp.rm(deleteFile);
		} catch (Exception e) {
			log.error("PROBLEMAS AL ELIMINAR: "+directory+""+deleteFile+" ERROR: "+ e.getMessage());
			connectionBD.registerLog("PROBLEMAS AL ELIMINAR: "+directory+"/"+deleteFile, AccessParameters.logTypeERROR, "SFTP", null,0);
			e.printStackTrace();
		}
	}


	private boolean sendPipeSposor(File archivo,Long codigoPipeSponsor ) throws JAXBException, SQLException {
		File file = archivo;
		try {
			String urlPipeSponsor = URL_WS_PipeSponsor;
			URL url = new URL(urlPipeSponsor);

			SponsorModuleService srv = new SponsorModuleService(url, new QName("http://tempuri.org/", "SponsorModuleService"));
			if (file.exists()){

				ObjectFactory fact = new ObjectFactory();

				SponsorRemoteFiles fileToUpload = fact.createSponsorRemoteFiles();
				// PROD.
				// log.info("El codigo de sponsor asociado a éste proceso es " + file.getName().split("_")[0]);
				fileToUpload.setSponsorCode(fact.createSponsorRemoteFilesSponsorCode(file.getName().split("_")[0]));
				//fileToUpload.setSponsorCode(fact.createSponsorRemoteFilesSponsorCode("WILLI"));
				fileToUpload.setFileDefinitionId(codigoPipeSponsor);
				
				//if   ( !(file.getName().split("_")[0]).equalsIgnoreCase(FilenameUtils.getExtension(file.getName()))) {  
				
				if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("CSV") ) {
					fileToUpload.setExtension(fact.createSponsorRemoteFilesExtension(FilenameUtils.getExtension(file.getName())));
				} else {
					fileToUpload.setExtension(fact.createSponsorRemoteFilesExtension(""));
				}
				
				fileToUpload.setFileName(fact.createSponsorRemoteFilesFileName(file.getName()));

				byte[] bFile = new byte[(int) file.length()];
				FileInputStream fileInputStream =  new FileInputStream(file);
				fileInputStream.read(bFile);
				fileInputStream.close();

				fileToUpload.setFileBuffer(fact.createSponsorRemoteFilesFileBuffer(bFile));

				ArrayOfSponsorRemoteFiles arrayOfSponsorRemoteFiles = fact.createArrayOfSponsorRemoteFiles();
				arrayOfSponsorRemoteFiles.getSponsorRemoteFiles().add(fileToUpload);
				LogProcessDTO logDataDTO = null;
				try {
					logDataDTO = srv.getBasicHttpBindingISponsorMouleService().setSponsorFiles(arrayOfSponsorRemoteFiles);
					if (logDataDTO==null){
						connectionBD.registerLog("WEB SERVICE - PROBLEMAS AL CARGAR EL ARCHIVO: "+file.getName(), AccessParameters.logTypeERROR, AccessParameters.process_PipeSponsor_name,null,0);
						return false;
					} 
					
				}catch (Exception e){
					connectionBD.registerLog("WEB SERVICE - PROBLEMAS AL CARGAR EL ARCHIVO: "+file.getName(), AccessParameters.logTypeERROR, AccessParameters.process_PipeSponsor_name,null,0);
					e.printStackTrace();
					return false;
				}

				log.info("CARGADO EN PIPESPONSOR: "+file.getName());

				List<String> errorFileContent = new ArrayList<String>();
				if (logDataDTO!=null && logDataDTO.getLogProcessFiles()!=null){
					logDataDTO.getLogProcessFiles().getValue().getLogProcessFileDTO();
					for (LogProcessFileDTO dto : logDataDTO.getLogProcessFiles().getValue().getLogProcessFileDTO()){

						String logFileName = dto.getFileOrgName().getValue();
						for (LogProcessDataDTO logProcessData: dto.getLogProcessDatas().getValue().getLogProcessDataDTO()){
							//verifico si hay algun error al momento de procesar el archivo
							if (logProcessData.getErrDescription().getValue().length()>0){
								log.error("Archivo: "+logFileName+" Columna: "+logProcessData.getProcessDataCol().getValue() +" Fila: "+logProcessData.getProcessDataRow());

								// Obteniendo Lote y RUT para loguear el ERROR.
								String[] partesArchivo = logFileName.split("_");

								connectionBD.registerLog("Archivo: "+logFileName+" Columna: "+logProcessData.getProcessDataCol().getValue() +" Fila: "+logProcessData.getProcessDataRow(),
										AccessParameters.logTypeERROR, "PIPE SPONSOR",partesArchivo[0], Integer.valueOf(partesArchivo[2]));

								errorFileContent.add("Archivo: "+logFileName+" Columna: "+logProcessData.getProcessDataCol().getValue() +" Fila: "+
										logProcessData.getProcessDataRow() +" Error :" +logProcessData.getErrDescription());
							}
						}
					}
					if (errorFileContent.size()>0)
						return false;
				}else{
					connectionBD.registerLog("PROCESADO CON EXITO: "+file.getName(), AccessParameters.logTypeINFO, AccessParameters.process_PipeSponsor_name,null,0);
					log.info("PROCESADO CON EXITO: "+file.getName());
					return true;
				}
			}
		}catch (Exception e) {
			connectionBD.registerLog("WEB SERVICE - OCURRIO UN ERROR CARGANDO ARCHIVO: "+file.getName(), AccessParameters.logTypeERROR, AccessParameters.process_PipeSponsor_name,null,0);
			log.error(e.getStackTrace().toString());
			e.printStackTrace();
			return false;
		}
		// Obteniendo Lote y RUT para loguear el ERROR.
		String[] partesArchivo = file.getName().split("_");

		connectionBD.registerLog("CARGADO EN PIPE SPONSOR: "+file.getName(), AccessParameters.logTypeINFO, AccessParameters.process_PipeSponsor_name,partesArchivo[0],Integer.valueOf(partesArchivo[2]));
		return true;
	}
	
	
	/* RRG SobreCargado*/
	
	private boolean sendPipeSposor(String strEntidad, File archivo,Long codigoPipeSponsor ) throws JAXBException, SQLException {
		File file = archivo;
		try {
			String urlPipeSponsor = URL_WS_PipeSponsor;
			URL url = new URL(urlPipeSponsor);

			SponsorModuleService srv = new SponsorModuleService(url, new QName("http://tempuri.org/", "SponsorModuleService"));
			if (file.exists()){

				ObjectFactory fact = new ObjectFactory();

				SponsorRemoteFiles fileToUpload = fact.createSponsorRemoteFiles();
				// PROD.
				// log.info("El codigo de sponsor asociado a éste proceso es " + file.getName().split("_")[0]);
				
				if (strEntidad.equalsIgnoreCase("BCO_CHILE")) {
					
					fileToUpload.setSponsorCode( fact.createSponsorRemoteFilesSponsorCode("97004000" ) );
					fileToUpload.setFileDefinitionId(  Long.parseLong(PS_FileDefinitionId_BCOCHILE+"" ) ); 
				} else {
				
					fileToUpload.setSponsorCode(fact.createSponsorRemoteFilesSponsorCode(file.getName().split("_")[0]));
					//fileToUpload.setSponsorCode(fact.createSponsorRemoteFilesSponsorCode("WILLI"));
					fileToUpload.setFileDefinitionId(codigoPipeSponsor);
				}
				
				//if   ( !(file.getName().split("_")[0]).equalsIgnoreCase(FilenameUtils.getExtension(file.getName()))) {  
				
				if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("csv") ) {
					fileToUpload.setExtension(fact.createSponsorRemoteFilesExtension(FilenameUtils.getExtension(file.getName())));
				} else {

					fileToUpload.setExtension(fact.createSponsorRemoteFilesExtension(""));
				}
				
				fileToUpload.setFileName(fact.createSponsorRemoteFilesFileName(file.getName())
						);

				byte[] bFile = new byte[(int) file.length()];
				FileInputStream fileInputStream =  new FileInputStream(file);
				fileInputStream.read(bFile);
				fileInputStream.close();

				fileToUpload.setFileBuffer(fact.createSponsorRemoteFilesFileBuffer(bFile));

				ArrayOfSponsorRemoteFiles arrayOfSponsorRemoteFiles = fact.createArrayOfSponsorRemoteFiles();
				arrayOfSponsorRemoteFiles.getSponsorRemoteFiles().add(fileToUpload);
				LogProcessDTO logDataDTO = null;
				try {
					logDataDTO = srv.getBasicHttpBindingISponsorMouleService().setSponsorFiles(arrayOfSponsorRemoteFiles);
					if (logDataDTO==null){
						connectionBD.registerLog("WEB SERVICE - PROBLEMAS AL CARGAR EL ARCHIVO: "+file.getName(), AccessParameters.logTypeERROR, AccessParameters.process_PipeSponsor_name,null,0);
						return false;
					} 
					
				}catch (Exception e){
					connectionBD.registerLog("WEB SERVICE - PROBLEMAS AL CARGAR EL ARCHIVO: "+file.getName(), AccessParameters.logTypeERROR, AccessParameters.process_PipeSponsor_name,null,0);
					e.printStackTrace();
					return false;
				}

				log.info("CARGADO EN PIPESPONSOR: "+file.getName());

				List<String> errorFileContent = new ArrayList<String>();
				if (logDataDTO!=null && logDataDTO.getLogProcessFiles()!=null){
					logDataDTO.getLogProcessFiles().getValue().getLogProcessFileDTO();
					for (LogProcessFileDTO dto : logDataDTO.getLogProcessFiles().getValue().getLogProcessFileDTO()){

						String logFileName = dto.getFileOrgName().getValue();
						for (LogProcessDataDTO logProcessData: dto.getLogProcessDatas().getValue().getLogProcessDataDTO()){
							//verifico si hay algun error al momento de procesar el archivo
							if (logProcessData.getErrDescription().getValue().length()>0){
								log.error("Archivo: "+logFileName+" Columna: "+logProcessData.getProcessDataCol().getValue() +" Fila: "+logProcessData.getProcessDataRow());

								// Obteniendo Lote y RUT para loguear el ERROR.
								String[] partesArchivo = logFileName.split("_");

								connectionBD.registerLog("Archivo: "+logFileName+" Columna: "+logProcessData.getProcessDataCol().getValue() +" Fila: "+logProcessData.getProcessDataRow(),
										AccessParameters.logTypeERROR, "PIPE SPONSOR",partesArchivo[0], Integer.valueOf(partesArchivo[2]));

								errorFileContent.add("Archivo: "+logFileName+" Columna: "+logProcessData.getProcessDataCol().getValue() +" Fila: "+
										logProcessData.getProcessDataRow() +" Error :" +logProcessData.getErrDescription());
							}
						}
					}
					if (errorFileContent.size()>0)
						return false;
				}else{
					connectionBD.registerLog("PROCESADO CON EXITO: "+file.getName(), AccessParameters.logTypeINFO, AccessParameters.process_PipeSponsor_name,null,0);
					log.info("PROCESADO CON EXITO: "+file.getName());
					return true;
				}
			}
		}catch (Exception e) {
			connectionBD.registerLog("WEB SERVICE - OCURRIO UN ERROR CARGANDO ARCHIVO: "+file.getName(), AccessParameters.logTypeERROR, AccessParameters.process_PipeSponsor_name,null,0);
			log.error(e.getStackTrace().toString());
			e.printStackTrace();
			return false;
		}
		// Obteniendo Lote y RUT para loguear el ERROR.
		
		 if (!strEntidad.equalsIgnoreCase("BCO_CHILE")) {
		
			 String partesArchivo[] = file.getName().split("_");
			 connectionBD.registerLog("CARGADO EN PIPE SPONSOR: "+file.getName(), AccessParameters.logTypeINFO, AccessParameters.process_PipeSponsor_name,partesArchivo[0],Integer.valueOf(partesArchivo[2]));
		 } else {
			 String partesArchivo[] = new String[3];
			 partesArchivo[0] = "0";
			 partesArchivo[1] = "0";
			 partesArchivo[2] = "0";
			 connectionBD.registerLog("CARGADO EN PIPE SPONSOR: "+file.getName(), AccessParameters.logTypeINFO, AccessParameters.process_PipeSponsor_name,partesArchivo[0],Integer.valueOf(partesArchivo[2]));
		 }
		
		
		return true;
	}
	/* RRG*/
	

	/*LEE EL CONTENIDO QUE SE ENCUETRA EN LA CARPETA LOCAL DELS SERVIDOR */
	private void readContentFolderDocument(String entidad) throws IOException, BiffException, SQLException {
		List<File> ficheros = searchListFile(FOLDER_LOCAL_DOCUMENT);
		if (ficheros!=null){

			connectionBD.statusProcess(AccessParameters.process_PipeSponsor, AccessParameters.processing,null);
			
			if (!entidad.equalsIgnoreCase("BCO_CHILE")) {
			
				processFile(ID_FILE_INCORPORACION, ficheros, AccessParameters.incorporacion);
				processFile(ID_FILE_INCORPO_DEPE, ficheros, AccessParameters.incorpo_dependiente);
				processFile(ID_FILE_EXCLUIR_TITULAR, ficheros, AccessParameters.exclusion_titular);
				processFile(ID_FILE_EXCLUIR_CARGA, ficheros, AccessParameters.exclusion_carga);
			} else {
			//NRA se agrega el processFile para BCO_CHILE
				processFile(entidad , ID_FILE_POLIZAS_BCOCHILE, ficheros,AccessParameters.polizasBcoChile);
			}
		}
		//Se indica la ruta de los archivos que se van a leer
		connectionBD.statusProcess(AccessParameters.process_PipeSponsor, AccessParameters.processed,null);
	}


	 /*SEGUN EL TIPO DE ARCHIVO A PROCESAR, VERIFICA SI YA FUE PROCESADO. EN CASO DE NO HABER SIDO PROCESADO
    LO CARGA EN PIPE_SPONSOR. BUSCA LAS IMAGENES ASOCIADAS A CADA REGISTRO Y LAS CARGA EN FILENET*/
    private void processFile(String typeFile, List<File> ficheros, int procesFile) throws SQLException {
        String workFlow = null;
        boolean flag = false;
        List<UpdateCodeFileNet> poliza_CodBarra = new ArrayList<UpdateCodeFileNet>();

        for (int x=0;x<ficheros.size();x++) {
            File file = ficheros.get(x);
            fileProcessing = file.getName() ;
            File newfile = new File("Procesado_"+file.getName() );

            if (file.exists() && file.getName().toLowerCase().indexOf(typeFile.toLowerCase() + ".csv") != -1 &&
                    file.getName().indexOf("Procesado_") == -1 && file.getName().indexOf("Error_") == -1) {

                try {
                    String[] datosArchivo = file.getName().split("_");
                    rutArchivoCorredor = datosArchivo[0];
                    loteArchivo = Integer.valueOf(datosArchivo[2]);

                    //obtengo el archivo y subo a pipeSponsor
                    switch (procesFile) {
                        case AccessParameters.incorporacion: {//colaltaTitCar
                            log.info("ENTRE AL METODO INCORPORACION");
                            flag = sendPipeSposor(file, PS_FileDefinitionId_ALTATIT);

                            if(flag){
                                for(int i = 0; i <= 60; i++) {
                                    log.debug("intentando buscar resultado de pipe de sponsor");

                                    poliza_CodBarra = connectionBD.getCodigoBarra(rutArchivoCorredor, loteArchivo, procesFile, fileProcessing);
                                    if(poliza_CodBarra != null && poliza_CodBarra.size()>0)
                                        break;

                                    log.debug("no trajo resultados, esperando 10 seg para intentar denuevo");

                                    try {
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e) {
                                        log.error("Error loco con threads",e);
                                    }
                                }

                                log.info("Se hace la consulta de codigos de barras con : " + rutArchivoCorredor + ", " + loteArchivo);
                                log.info("OBTUVE " + poliza_CodBarra.size() + " CODIGOS DE BARRA.");
                                for (UpdateCodeFileNet updateCodeFileNet : poliza_CodBarra) {
                                    log.info(updateCodeFileNet.getCodBarra());
                                }
                            }

                            workFlow = this.PWC_workflowName_001; //wf_001_ALTA_TITULAR*/
                            break;
                        }
                        case AccessParameters.incorpo_dependiente: { //colaltacargas
                            flag = sendPipeSposor(file, PS_FileDefinitionId_ALTACAR);

                            if(flag){
                                for(int i = 0; i <= 60; i++) {
                                    log.debug("intentando buscar resultado de pipe de sponsor");

                                    poliza_CodBarra = connectionBD.getCodigoBarra(rutArchivoCorredor,loteArchivo,procesFile,fileProcessing);
                                    if(poliza_CodBarra != null && poliza_CodBarra.size()>0)
                                        break;

                                    log.debug("no trajo resultados, esperando 10 seg para intentar denuevo");

                                    try {
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e) {
                                        log.error("Error loco con threads",e);
                                    }
                                }

                                log.info("Se hace la consulta de codigos de barras con : " + rutArchivoCorredor + ", " + loteArchivo);
                                log.info("OBTUVE " + poliza_CodBarra.size() + " CODIGOS DE BARRA.");
                                for (UpdateCodeFileNet updateCodeFileNet : poliza_CodBarra) {
                                    log.info(updateCodeFileNet.getCodBarra());
                                }
                            }

                            workFlow = this.PWC_workflowName_002;//wf_002_ALTA_CARGAS
                            break;
                        }
                        case AccessParameters.exclusion_carga: {
                            flag = sendPipeSposor(file, PS_FileDefinitionId_EXCCAR);

                            if(flag){
                                for(int i = 0; i <= 60; i++) {
                                    log.debug("intentando buscar resultado de pipe de sponsor");

                                    poliza_CodBarra = connectionBD.getCodigoBarra(rutArchivoCorredor,loteArchivo,procesFile,fileProcessing);
                                    if(poliza_CodBarra != null && poliza_CodBarra.size()>0)
                                        break;

                                    log.debug("no trajo resultados, esperando 10 seg para intentar denuevo");

                                    try {
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e) {
                                        log.error("Error loco con threads",e);
                                    }
                                }

                                log.info("Se hace la consulta de codigos de barras con : " + rutArchivoCorredor + ", " + loteArchivo);
                                log.info("OBTUVE " + poliza_CodBarra.size() + " CODIGOS DE BARRA.");
                                for (UpdateCodeFileNet updateCodeFileNet : poliza_CodBarra) {
                                    log.info(updateCodeFileNet.getCodBarra());
                                }
                            }

                            workFlow = this.PWC_workflowName_004;//WF_04_BAJA_CARGAS
                            break;
                        }
                        case AccessParameters.exclusion_titular: {
                            flag = sendPipeSposor(file, PS_FileDefinitionId_EXCTIT);

                            if(flag){
                                for(int i = 0; i <= 60; i++) {
                                    log.debug("intentando buscar resultado de pipe de sponsor");

                                    poliza_CodBarra = connectionBD.getCodigoBarra(rutArchivoCorredor,loteArchivo,procesFile,fileProcessing);
                                    if(poliza_CodBarra != null && poliza_CodBarra.size()>0)
                                        break;

                                    log.debug("no trajo resultados, esperando 10 seg para intentar denuevo");

                                    try {
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e) {
                                        log.error("Error loco con threads",e);
                                    }
                                }

                                log.info("Se hace la consulta de codigos de barras con : " + rutArchivoCorredor + ", " + loteArchivo);
                                log.info("OBTUVE " + poliza_CodBarra.size() + " CODIGOS DE BARRA.");
                                for (UpdateCodeFileNet updateCodeFileNet : poliza_CodBarra) {
                                    log.info(updateCodeFileNet.getCodBarra());
                                }
                            }

                            workFlow = this.PWC_workflowName_003;//wf_003_BAJA_TITULAR
                            break;
                        }
                    }

                    //SI EL ARCHIVO SUBIO CORRECTAMENTE EN PIPE_SPONSOR ENTONCES SE ACTUALIZA EL CAMPO PROCESADO EN LA TABLA CORRESPONDIENTE
                    if (flag == true){
                        ConnectionBD connectionBD = new ConnectionBD();
                        connectionBD.processRegister(procesFile,rutArchivoCorredor,String.valueOf(loteArchivo));

                        //SE CARGAN LAS IMAGENES EN FILENET
                        if (poliza_CodBarra.size()!=0)
                            sendFileNet(poliza_CodBarra,rutArchivoCorredor, procesFile);

                        //HACE EL LLAMADO A POWER_CENTER
                        callPowerCenter(workFlow);

                        // Se espera a que el workflow termine para cambiar el archivo.
                        boolean workflowStatusBoolean = waitWorkFlowToChangeProcessedFile(workFlow);

                        if(workflowStatusBoolean)
                            file.renameTo(new File(FOLDER_LOCAL_DOCUMENT + "" + newfile));
                        else {
                            File newfileError = new File("Error_"+file.getName() );
                            file.renameTo(new File(FOLDER_LOCAL_DOCUMENT+""+newfileError));
                        }
                    }else{
                        File newfileError = new File("Error_"+file.getName() );
                        file.renameTo(new File(FOLDER_LOCAL_DOCUMENT+""+newfileError));
                    }
                } catch (JAXBException e) {
                    log.error("ERROR AL LEER EL ARCHIVO: "+file.getName() +" - ERROR: "+e.getMessage(),e);
                    connectionBD.registerLog("ERROR AL LEER EL ARCHIVO: "+file.getName() +" - ERROR: "+e.getMessage() ,
                            AccessParameters.logTypeINFO,AccessParameters.process_PipeSponsor_name,rutArchivoCorredor,loteArchivo);
                } catch (PowerCenterServiceException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*SEGUN EL TIPO DE ARCHIVO A PROCESAR, VERIFICA SI YA FUE PROCESADO. EN CASO DE NO HABER SIDO PROCESADO
    LO CARGA EN PIPE_SPONSOR. BUSCA LAS IMAGENES ASOCIADAS A CADA REGISTRO Y LAS CARGA EN FILENET*/
    /*NRA agibiz sobrecarga el metodo para validar que la entidad a procesar sea willis o bco chile */
    private void processFile(String strEntidad ,String typeFile, List<File> ficheros, int procesFile) throws SQLException {
    	String workFlow = null;
    	boolean flag = false;
    	boolean ejecucion=false;

    	//boolean flag = true;
    	List<UpdateCodeFileNet> poliza_CodBarra = new ArrayList<UpdateCodeFileNet>();
//
    	for (int x=0;x<ficheros.size();x++) {
    		File file = ficheros.get(x);
    		String n  = file.getName();
    		fileProcessing = file.getName() ;
    		File newfile = new File("Procesado_"+file.getName() );
    		
    		
    		
    		
    		String[] arrNombre =n.split("\\.");
    		if(arrNombre.length>0){
    		String strPrefijo = arrNombre[0];
    		
    		//NRA 
            //if (file.exists() &&strPrefijo.equalsIgnoreCase("SCS")&&
    		if (file.exists() &&strPrefijo.equalsIgnoreCase(typeFile)&&
                    file.getName().indexOf("Procesado_") == -1 && file.getName().indexOf("Error_") == -1) {

                try {
     

    			if (strEntidad.equalsIgnoreCase("BCO_CHILE") ) {
    				switch(procesFile){
    				case AccessParameters.polizasBcoChile:{
    					log.info(" CASE wf_005_CARGA_RBI_PIPE");
    					log.info("ENTRANDO A INCORPORACION POLIZAS BANCO CHILE");					
    					try {
    						log.info("file.length:"+ file.length() );
    						log.info("file.getTotalSpace:"+ file.getTotalSpace()  );
    						log.info("file.length:"+ file.getName() );
    						
    						// si tiene extension no se debe enviar a pipe sponsor
    						
    						if (file.getName().indexOf("csv") ==-1 ) {
    								flag = sendPipeSposor(strEntidad,file,PS_FileDefinitionId_BCOCHILE);
    								ejecucion = true;
    						}  else {
    							log.info("Archivo " + file.getName()+" No Correspone a :"+strEntidad);
    							
    						}
    						log.info("FLAG : : : : : : :: "+flag);
    					} catch (JAXBException e1) {
    						// TODO Auto-generated catch block
    						log.error(e1.getMessage());
    					}
    					
    					if(flag){
    						//for (int i = 0; i <60; i++) {                        			
    						for (int i = 0; i <2; i++) {
    							log.debug("No se trajeron resultados , esperando 10 seg para volver a intentar ");
    							try{
    								Thread.sleep(10000);                        				
    							} catch (InterruptedException e) {
    								log.error("Error loco con threads",e);
    							}
    						}

    					}
    					
    					if (ejecucion) { 
    						workFlow = this.PWC_workflowName_005; //	wf_005_BANCHILE_POLIZAS
    					}
    					break;

    				}

    			}

                    	  if (!ejecucion) {
                    	  
                    		  File newfileError = new File("Error_"+file.getName() );
                    		  file.renameTo(new File(FOLDER_LOCAL_DOCUMENT+""+newfileError));
                    	  }
                      //}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.info("***************************************************************************");
				e.printStackTrace();
				log.error(e.getMessage());
				log.info("***************************************************************************");
			}
    	}
    	//}
    }
    	
    	if (strEntidad.equalsIgnoreCase("BCO_CHILE") ) {
	    	if (flag == true ){
	            ConnectionBD connectionBD = new ConnectionBD();
	           // connectionBD.processRegister(procesFile,rutArchivoCorredor,String.valueOf(loteArchivo));
	
	            //SE CARGAN LAS IMAGENES EN FILENET
	//            if (poliza_CodBarra.size()!=0)
	//                sendFileNet(poliza_CodBarra,rutArchivoCorredor, procesFile);
	
	            //HACE EL LLAMADO A POWER_CENTER
	            callPowerCenter(workFlow);
	
	            // Se espera a que el workflow termine para cambiar el archivo.
	            boolean workflowStatusBoolean=true;
				try {
					workflowStatusBoolean = waitWorkFlowToChangeProcessedFile(workFlow);
				} catch (PowerCenterServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	            if(workflowStatusBoolean)
	                file.renameTo(new File(FOLDER_LOCAL_DOCUMENT + "" + newfile));
	            else {
	                File newfileError = new File("Error_"+file.getName() );
	                file.renameTo(new File(FOLDER_LOCAL_DOCUMENT+""+newfileError));
	            }
	        }	
    	}
    	}
    	
    }





	private boolean waitWorkFlowToChangeProcessedFile(String workFlow) throws PowerCenterServiceException {
		PowerCenterWrapper powerCenter = new PowerCenterWrapper();

		for(int i = 0; i <= 60; i++) {
			log.debug("Consultando si el workflow " + workFlow + " terminó");

			String processRunning = powerCenter.workflowStatus(this.PWC_folderName , workFlow, this.PWC_domainName, this. PWC_serviceName,
					this.PWC_RepositoryDomainName, this.PWC_RepositoryName,this.PWC_UserName , this.PWC_Password, this.endpoint);

			if(processRunning.equals("success"))
				return true;

			if(processRunning.equals("fail"))
				return false;
			log.debug("Aún está procesado el workflow " + workFlow + ", se esperan 10 segundos....");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				log.error("Error loco con threads",e);
			}
		}
		return false;
	}

	private void callPowerCenter(String workFlow) throws SQLException {
		try {

			PowerCenterWrapper powerCenter = new PowerCenterWrapper();
			connectionBD.statusProcess(AccessParameters.process_PowerCenter,AccessParameters.processing,null);

			log.debug("Me estoy intentando conectar con las siguientes credenciales a PWC: " + this.PWC_UserName + "/" + this.PWC_Password);

			// Revisando que no existan procesados corriendo antes de ejecutar el siguiente.
			for(int i = 0; i <= 60; i++) {
				log.debug("Verificando que no exista algún workflow corriendo.");

				String processRunning = powerCenter.waitTillWorkflowComplete(this.PWC_folderName , workFlow, this.PWC_domainName, this. PWC_serviceName,
						this.PWC_RepositoryDomainName, this.PWC_RepositoryName,this.PWC_UserName , this.PWC_Password, this.endpoint);

				if(processRunning.equals("NO"))
					break;

				log.debug("Hay procesos en ejecucion, esperando 10 seg para intentar denuevo");

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					log.error("Error loco con threads",e);
				}
			}


			String result= powerCenter.runWorkflow(this.PWC_folderName , workFlow, this.PWC_domainName, this. PWC_serviceName,
					this.PWC_RepositoryDomainName, this.PWC_RepositoryName,this.PWC_UserName , this.PWC_Password, this.endpoint);
			if (result.equals("OK"))
			log.info("******************************************************************");
			log.info("**************RESULT EQUALS OK ************************************");
			log.info("******************************************************************");
				connectionBD.registerLog(workFlow +" Ejecutado para el archivo: "+fileProcessing, AccessParameters.logTypeINFO,
						workFlow,rutArchivoCorredor,loteArchivo);

			connectionBD.statusProcess(AccessParameters.process_PowerCenter,AccessParameters.processed,null);
		} catch (PowerCenterServiceException e) {
			log.error("ERROR AL EJECUTAR PWC:  "+workFlow+" - ERROR: "+e.getMessage());
			connectionBD.registerLog("ERROR AL EJECUTAR PWC:"+workFlow+" - "+e.getMessage(), AccessParameters.logTypeERROR,
					workFlow,rutArchivoCorredor,loteArchivo);
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	private List<File> searchListFile(String folder) throws SQLException {


		File ficheros = new File(folder);
		List<File> filesList = new ArrayList<File>();

		int pos =0;
		if (ficheros.exists()){
			File[] listFiles = ficheros.listFiles();
			for (int i=0; i<ficheros.listFiles().length;i++){
				File file = listFiles[i];
				if (file.getName().indexOf("Procesado_") == -1 && file.getName().indexOf("Error_") == -1){
					filesList.add(file);
				}
			}

			if (filesList.size()==0){
				log.info("NO HAY FICHEROS PARA PROCESAR EN EL DIRECTORIO: " +folder);
				connectionBD.registerLog("NO HAY FICHEROS PARA PROCESAR EN EL DIRECTORIO: " +folder, AccessParameters.logTypeINFO,"PIPE SPONSOR", rutArchivoCorredor,loteArchivo);
				return null;
			}
			return  filesList;
		}
		else {
			log.info("NO HAY FICHEROS EN EL DIRECTORIO: " +folder);
			connectionBD.registerLog("NO HAY FICHEROS EN EL DIRECTORIO: " +folder, AccessParameters.logTypeINFO,"PIPE SPONSOR", rutArchivoCorredor,loteArchivo);}
		return  null;
	}

	private String  sendFileNet( List<UpdateCodeFileNet> poliza_CodBarra, String rut ,int typeFile ) throws SQLException {
		log.info("ENTRE A EL METODO ENVIAR FILENET");
		String file = null;
		String codigoFileNet = "";

		// <PDF formato "123.pdf", Codigo filenet>
		HashMap<String, String> pdfEnFilenet = new HashMap<String, String>();
		for (UpdateCodeFileNet  u :  poliza_CodBarra){

			file = u.getCodBarra() +".pdf";

			try {
				String urlFilenet = URL_WS_FileNet;
				URL url = new URL(urlFilenet);
				ConectorFileNetWSI filenet = new FileNetWS(url, new QName("http://filenet.ws.metlife.cl/", "FileNetWS")).getFilenet();
				((BindingProvider) filenet).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 1000 * 2 * 60);

				log.info("Hice la conexion con el servicio web de filenet");

				try {
					connectionBD.statusProcess(AccessParameters.process_FileNet, AccessParameters.processing,null);
					File fichero = new File(FOLDER_LOCAL_IMAGEN+"/"+file);

					log.info("Tome la carpeta para enviar a filenet");

					List<Metadata> metadataArrayList = new ArrayList<Metadata>();
					Metadata metadata = new Metadata();
					metadata.setName("DocumentTitle");metadata.setValue(file);
					metadataArrayList.add(metadata);

					Metadata metadata1 = new Metadata();
					metadata1.setName("businessDocumentId");metadata1.setValue(rut);
					metadataArrayList.add(metadata1);

					Metadata metadata2 = new Metadata();
					metadata2.setName("creatorTaskId");metadata2.setValue(AccessParameters.CreatorTaskId);
					metadataArrayList.add(metadata2);

					if(!pdfEnFilenet.containsKey(file)){
						List<String> stringList = filenet.searchDocuments(AccessParameters.ApplicationId,metadataArrayList);

						if (stringList.size()!=0){
							codigoFileNet = stringList.get(stringList.size()-1);
							connectionBD.registerLog("SE ACTUALIZO CORRECTAMENTE EL CODIGO FILENET DE LA IMAGEN: " +file+ ".", AccessParameters.logTypeINFO,
									AccessParameters.process_FileNet_name, rutArchivoCorredor,loteArchivo);
							pdfEnFilenet.put(file, codigoFileNet);
						} else {
							if (fichero.exists()) {
								String encodeFile = encodeFile(FOLDER_LOCAL_IMAGEN + "/" + file);
								Document document = new Document();
								document.setFilename(file);
								document.setSerializedFile(encodeFile);
								codigoFileNet = filenet.putDocument(AccessParameters.ApplicationId, AccessParameters.CreatorTaskId, rut, document);
								connectionBD.registerLog("SE CARGO CORRECTAMENTE LA IMAGEN: " +file+ " A FILENET", AccessParameters.logTypeINFO,
										AccessParameters.process_FileNet_name, rutArchivoCorredor,loteArchivo);
								pdfEnFilenet.put(file, codigoFileNet);
							} else{
								log.error("NO EXISTE LA IMAGEN: " +file  + " EN LA CARPETA: " + FOLDER_LOCAL_IMAGEN+" DEL ARCHIVO:"+fileProcessing );
								connectionBD.registerLog("NO EXISTE LA IMAGEN: " +file  + " EN LA CARPETA: " + FOLDER_LOCAL_IMAGEN+" DEL ARCHIVO:"+fileProcessing,
										AccessParameters.logTypeERROR,AccessParameters.process_FileNet_name, rutArchivoCorredor,loteArchivo);
							}
						}
					} else {
						codigoFileNet = pdfEnFilenet.get(file);
					}

					for(int i = 0; i <= 60; i++) {
					
						log.debug(i+".verificando el codigo filenet: " + codigoFileNet);

						if(codigoFileNet != null)
							break;

						log.debug("no trajo resultados de codigo filenet");

						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							log.error("Error loco con threads",e);
						}
					}

					if (fichero.exists() && fichero.getName().indexOf("Procesado_") == -1){

						boolean lologre = false;

						for(int i = 0; i <= 60; i++) { 
							log.debug(i+ ".Voy a cambiar el nombre del archivo " + fichero.getName() + " a procesado.");

							boolean asdasd = fichero.renameTo(new File(FOLDER_LOCAL_IMAGEN+""+"Procesado_"+fichero.getName()));
							if(asdasd){
								lologre = true;
								break;
							} else {
								log.debug("Revisando si ya está duplicado.");
								File ficheroDuplicadoEnProcesado = new File(FOLDER_LOCAL_IMAGEN+"/Procesado_"+file);
								if(ficheroDuplicadoEnProcesado.exists()){
									SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
									fichero.renameTo(new File(FOLDER_LOCAL_IMAGEN+""+"Procesado_" + fichero.getName().replace(".pdf", "") + "_" + simpleDateFormat.format(new Date()) + ".pdf"));
									lologre = true;
									break;
								}
							}

							log.debug("no pude cambiar el nombre del archivo " + fichero.getName() + ", esperando 10 segundos.");

							try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								log.error("Error loco con threads",e);
							}
						}
						log.info("Ya trate cambie el nombre del archivo {} a procesado. resultado = {}",fichero.getName(),lologre);
						if(!lologre)
							throw new RuntimeException("Me fui a la b tratando decambiarle el nombre al archivo");
					}
					updateCode(typeFile,file, codigoFileNet);
				}catch (Exception e){
					log.error("PROBLEMAS SUBIENDO A FILENET EL ARCHIVO: " +file);
					connectionBD.registerLog("PROBLEMAS SUBIENDO A FILENET EL ARCHIVO: " +file, AccessParameters.logTypeERROR,
							AccessParameters.process_FileNet_name, rutArchivoCorredor,loteArchivo);
				}
			}catch (Exception e){
				log.error("WEB SERVICE - PROBLEMAS AL CONECTAR CON FILENET. PROCESANDO: " + fileProcessing +" IMAGEN: "+file+" ERROR: "+e.getMessage());
				connectionBD.registerLog("WEB SERVICE - PROBLEMAS AL CONECTAR CON FILENET. PROCESANDO: " + fileProcessing +" IMAGEN: "+file+" ERROR: "+e.getMessage(), AccessParameters.logTypeERROR,
						AccessParameters.process_FileNet_name, rutArchivoCorredor,loteArchivo);
			}
		}
		connectionBD.statusProcess(AccessParameters.process_FileNet, AccessParameters.processed,null);
		return codigoFileNet;
	}
	private void updateCode(int typeFile, String file,String codFileNet  ) throws SQLException {
		ConnectionBD connectionBD = new ConnectionBD();
		connectionBD.updateCodFileNet(typeFile,file, codFileNet);
	}

	private String encodeFile(String fileName) throws SQLException, IOException {

		Base64 base64 = new Base64();
		File file = new File(fileName);
		byte[] fileArray = new byte[(int) file.length()];
		InputStream inputStream = null;
		String encodedFile = "";

		try {
			inputStream = new FileInputStream(file);
			inputStream.read(fileArray);
			encodedFile = base64.encodeToString(fileArray);
			inputStream.close();
		} catch (Exception e) {
			inputStream.close();
			log.error("PROBLEMAS CODIFICANDO EL ARCHIVO: " +file +" ERROR: "+e.getMessage());
			connectionBD.registerLog("PROBLEMAS CODIFICANDO EL ARCHIVO: " +file +" ERROR: "+e.getMessage(), AccessParameters.logTypeERROR,AccessParameters.process_FileNet_name, rutArchivoCorredor,loteArchivo);
		}

		return encodedFile;
	}

	/* NRA agibiz sobrecarga de metodo y se agrega una condicon a la query */
	private void searchParameterConf(String entidad) {
		PreparedStatement ps = null;
		try {
			Connection connection = connectionBD.getConnectionPreIngreso();
			//Connection connection = connectionBD.getConnectionJDBC();
			if (connection != null) {
				String query = " select ID, PARAMETRO, VALOR from PREWEB_CONFIGURACION where   identidad = '"+  entidad +"' order by ID ASC  ";

				ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_USER))
						USER_SFTP = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_HOST))
						HOST_SFTP = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_PASS))
						PASS_SFTP = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_PORT))
						PORT_SFTP = Integer.valueOf(rs.getString("VALOR"));

					if (rs.getString("PARAMETRO").equals(AccessParameters.TIME_EJE))
						TIME_EJECUTION = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_REMOTE_DOCUMENT))
						FOLDER_REMOTE_DOCUMENT = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_REMOTE_IMAGEN))
						FOLDER_REMOTE_IMAGEN = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_LOCAL_IMAGEN))
						FOLDER_LOCAL_IMAGEN = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_LOCAL_DOCUMENT))
						FOLDER_LOCAL_DOCUMENT = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_ALTA_TITULAR))
						ID_FILE_INCORPORACION = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_ALTA_CARGA))
						ID_FILE_INCORPO_DEPE = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_EXCLUIR_TITULAR))
						ID_FILE_EXCLUIR_TITULAR = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_EXCLUIR_CARGA))
						ID_FILE_EXCLUIR_CARGA = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_RepositoryDomainName))
						PWC_RepositoryDomainName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_RepositoryName))
						PWC_RepositoryName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_UserName))
						PWC_UserName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_Password))
						PWC_Password = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_folderName))
						PWC_folderName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_001))
						PWC_workflowName_001 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_domainName))
						PWC_domainName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_serviceName))
						PWC_serviceName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_002))
						PWC_workflowName_002 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_003))
						PWC_workflowName_003 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_004))
						PWC_workflowName_004 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.endpoint))
						endpoint = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.URL_WS_FileNet))
						URL_WS_FileNet = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_ALTATIT))
						PS_FileDefinitionId_ALTATIT = rs.getLong("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_ALTACAR))
						PS_FileDefinitionId_ALTACAR = rs.getLong("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_EXCTIT))
						PS_FileDefinitionId_EXCTIT = rs.getLong("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_EXCCAR))
						PS_FileDefinitionId_EXCCAR = rs.getLong("VALOR");

				
					if (rs.getString("PARAMETRO").equals(AccessParameters.URL_WS_PipeSponsor))
					URL_WS_PipeSponsor = rs.getString("VALOR");
					

					//NRA traemos el BORRAR_ARCHIVO
					if(rs.getString("PARAMETRO").equals(AccessParameters.BORRAR_ARCHIVO))
						BORRAR_ARCHIVO = rs.getString("VALOR");
				   //  NRA workFlow agibiz
					if(rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_005))
						PWC_workflowName_005 = rs.getString("VALOR");
					
					// FIN
					//NRA FILEDEFINITIONID PARA BANCHILE
					if(rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_BCOCHILE))
						PS_FileDefinitionId_BCOCHILE = rs.getLong("VALOR");
					
					//if(rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_BCOCHILE))
					//	PS_FileDefinitionId_BCOCHILE = rs.getLong("VALOR");
					
				
					if(rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_POLIZAS_BCOCHILE))
						ID_FILE_POLIZAS_BCOCHILE = rs.getString("VALOR");
				}
			}
			connection.close();
		} catch (SQLException e) {
			log.error("PROBLEMAS AL LEER LAS VARIABLES DE CONFIGURACION EN BD - TABLA:PREWEB_CONFIGURACION");
			log.error(e.getMessage());
		}

	}

	private void searchParameterConf() {
		//String entidad="BCO_CHILE";
		PreparedStatement ps = null;

		try {
			//Connection connection = connectionBD.getConnectionJDBC();
			Connection connection = connectionBD.getConnectionPreIngreso();
			if (connection != null) {
				String query = " select ID, PARAMETRO, VALOR from PREWEB_CONFIGURACION order by ID ASC ";
				//String query = " select ID, PARAMETRO, VALOR from PREWEB_CONFIGURACION where   id_entidad = '"+  entidad +"' order by ID ASC ";
				ps = connection.prepareStatement(query);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_USER))
						USER_SFTP = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_HOST))
						HOST_SFTP = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_PASS))
						PASS_SFTP = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.SFTP_PORT))
						PORT_SFTP = Integer.valueOf(rs.getString("VALOR"));

					if (rs.getString("PARAMETRO").equals(AccessParameters.TIME_EJE))
						TIME_EJECUTION = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_REMOTE_DOCUMENT))
						FOLDER_REMOTE_DOCUMENT = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_REMOTE_IMAGEN))
						FOLDER_REMOTE_IMAGEN = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_LOCAL_IMAGEN))
						FOLDER_LOCAL_IMAGEN = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.FOLDER_LOCAL_DOCUMENT))
						FOLDER_LOCAL_DOCUMENT = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_ALTA_TITULAR))
						ID_FILE_INCORPORACION = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_ALTA_CARGA))
						ID_FILE_INCORPO_DEPE = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_EXCLUIR_TITULAR))
						ID_FILE_EXCLUIR_TITULAR = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_EXCLUIR_CARGA))
						ID_FILE_EXCLUIR_CARGA = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_RepositoryDomainName))
						PWC_RepositoryDomainName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_RepositoryName))
						PWC_RepositoryName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_UserName))
						PWC_UserName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_Password))
						PWC_Password = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_folderName))
						PWC_folderName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_001))
						PWC_workflowName_001 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_domainName))
						PWC_domainName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_serviceName))
						PWC_serviceName = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_002))
						PWC_workflowName_002 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_003))
						PWC_workflowName_003 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_004))
						PWC_workflowName_004 = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.endpoint))
						endpoint = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.URL_WS_FileNet))
						URL_WS_FileNet = rs.getString("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_ALTATIT))
						PS_FileDefinitionId_ALTATIT = rs.getLong("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_ALTACAR))
						PS_FileDefinitionId_ALTACAR = rs.getLong("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_EXCTIT))
						PS_FileDefinitionId_EXCTIT = rs.getLong("VALOR");

					if (rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_EXCCAR))
						PS_FileDefinitionId_EXCCAR = rs.getLong("VALOR");
					if (rs.getString("PARAMETRO").equals(AccessParameters.URL_WS_PipeSponsor))
						URL_WS_PipeSponsor = rs.getString("VALOR");

					//NRA traemos el BORRAR_ARCHIVO
					if(rs.getString("PARAMETRO").equals(AccessParameters.BORRAR_ARCHIVO))
						BORRAR_ARCHIVO = rs.getString("VALOR");
					//  NRA workFlow agibiz
					if(rs.getString("PARAMETRO").equals(AccessParameters.PWC_workflowName_005))
						PWC_workflowName_005 = rs.getString("VALOR");
					// FIN
					//NRA FILEDEFINITIONID PARA BANCHILE
					if(rs.getString("PARAMETRO").equals(AccessParameters.PS_FileDefinitionId_BCOCHILE))
						PS_FileDefinitionId_BCOCHILE = rs.getLong("VALOR");
					
					if(rs.getString("PARAMETRO").equals(AccessParameters.ID_FILE_POLIZAS_BCOCHILE))
						ID_FILE_POLIZAS_BCOCHILE = rs.getString("VALOR");

				}
			}
			connection.close();
		} catch (SQLException e) {
			log.error("PROBLEMAS AL LEER LAS VARIABLES DE CONFIGURACION EN BD - TABLA:PREWEB_CONFIGURACION");
	
			log.error(e.getMessage());
		}
	}

}
