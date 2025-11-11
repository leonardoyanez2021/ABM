package cl.blueprintsit.process;

import javax.xml.bind.JAXBElement;

/**
 * Created by BlueprintsIT on 4/22/2016.
 */
public class AccessParameters {


    final public static Long ejecutarMinuto = 5L;

    /* TYPE FILE AND COLUMN: CODIGO DE BARRA FORMULARIO */
    final public static int incorporacion = 1; //
    final public static int incorpo_dependiente = 2; //incorporaciones
    final public static int exclusion_titular = 3;
    final public static int exclusion_carga = 4;
    /*NRA incorporacion  RBI */
    final public static int polizasBcoChile =5;

    final public static String logTypeINFO = "INFO";
    final public static String logTypeERROR = "ERROR";

    final public static String CreatorTaskId = "aplicacion_web_log";
    final public static String ApplicationId = "2";

    final public static int process_nextEjecution = 1;
    final public static int process_DownloadDocumento = 2;
    final public static int process_DownloadImag = 3;
    final public static int process_PipeSponsor = 4;
    final public static int process_FileNet = 5;
    final public static int process_PowerCenter = 6;
    
    
    //NRA process RBI a PIPE para almacenar en preweb_log , el nombre del proceso que genero la excepcion 
    final public static String process_BChile_name = "CARGA BCHILE";

    final public static String process_PipeSponsor_name = "PIPE SPONSOR";
    final public static String process_PowerCenter_Name = "POWER CENTER";
    final public static String process_FileNet_name = "FILENET";

    final public static String processing = "PROCESANDO";
    final public static String processed = "PROCESADO";
    final public static String forProcess = "POR PROCESAR";

    // PARAMETROS DE CONFIGUACION, QUE SERAN BUSCADOS EN LA TABLA PREWEB_CONFIGURACION;
    final public static String SFTP_USER ="SFTP_USER";
    final public static String SFTP_HOST ="SFTP_HOST";
    final public static String SFTP_PASS="SFTP_PASS";
    final public static String SFTP_PORT="SFTP_PORT";
    final public static String TIME_EJE="TIME_EJE";
    final public static String FOLDER_REMOTE_DOCUMENT="FOLDER_REMOTE_DOCUMENT";
    final public static String FOLDER_REMOTE_IMAGEN="FOLDER_REMOTE_IMAGEN";
    final public static String FOLDER_LOCAL_IMAGEN="FOLDER_LOCAL_IMAGEN";
    final public static String FOLDER_LOCAL_DOCUMENT="FOLDER_LOCAL_DOCUMENT";
    final public static String ID_FILE_ALTA_TITULAR="ID_FILE_ALTA_TITULAR";
    final public static String ID_FILE_ALTA_CARGA="ID_FILE_ALTA_CARGA";
    final public static String ID_FILE_EXCLUIR_TITULAR="ID_FILE_EXCLUIR_TITULAR";
    final public static String ID_FILE_EXCLUIR_CARGA="ID_FILE_EXCLUIR_CARGA";
    final public static String FOLDER_REMOTE_LOG="FOLDER_REMOTE_LOG";
    final public static String ID_SESION_PREINGRESO_USER = "ID_SESION_PREINGRESO_USER";
    final public static String ID_SESION_PREINGRESO_PASS="ID_SESION_PREINGRESO_PASS";
    final public static String PWC_RepositoryDomainName="PWC_RepositoryDomainName";
    final public static String PWC_RepositoryName="PWC_RepositoryName";
    final public static String PWC_UserName="PWC_UserName";
    final public static String PWC_Password="PWC_Password";
    final public static String PWC_folderName="PWC_folderName";
    final public static String PWC_domainName="PWC_domainName";
    final public static String PWC_serviceName="PWC_serviceName";
    final public static String endpoint="PWC_endponit";
    //NRA agregamos el Borrar_archivo y el id del archivo de la poliza
    final public static String BORRAR_ARCHIVO = "BORRARARCHIVO";  
    final public static String ID_FILE_POLIZAS_BCOCHILE="ID_FILE_POLIZAS_BCOCHILE";
    
    final public static String PWC_workflowName_001="PWC_workflowName_001";//wf_001_ALTA_TITULAR
    final public static String PWC_workflowName_002="PWC_workflowName_002";//wf_002_ALTA_CARGAS
    final public static String PWC_workflowName_003="PWC_workflowName_003";//wf_003_BAJA_TITULAR
    final public static String PWC_workflowName_004="PWC_workflowName_004";//wf_004_BAJA_CARGAS
    //NRA agibibz agrega un nuevo parametro de configuracion para PipeSponsor 
    final public static String PWC_workflowName_005="PWC_workflowName_005";//wf_005_BANCHILE_POLIZAS

    //URL de los web services
    final public static String URL_WS_Autenticacion = "URL_WS_Autenticacion";
    final public static String URL_WS_Autenticacion_Endpoint = "URL_WS_Autenticacion_Endpoint";
    final public static String URL_WS_FileNet = "URL_WS_FileNet";
    final public static String URL_WS_SesionBulk = "URL_WS_SesionBulk";
    final public static String URL_WS_Bulk = "URL_WS_Bulk";

    final public static String PS_SponsorCode = "PS_SponsorCode";
    final public static String PS_FileDefinitionId_ALTATIT="PS_FileDefinitionId_ALTATIT";
    final public static String PS_FileDefinitionId_ALTACAR="PS_FileDefinitionId_ALTACAR";
    final public static String PS_FileDefinitionId_EXCTIT="PS_FileDefinitionId_EXCTIT";
    final public static String PS_FileDefinitionId_EXCCAR="PS_FileDefinitionId_EXCCAR";
    //NRA definicion del id del archivo banco chile
	 final public static String PS_FileDefinitionId_BCOCHILE ="PS_FileDefinitionId_BCOCHILE";

    final public static String URL_WS_PipeSponsor="URL_WS_PipeSponsor";
    final public static String SFTP_ENABLE="SFTP_ENABLE";


}
