package cl.blueprintsit.beans;

import cl.blueprintsit.dao.ConfigurationLogDAO;
import cl.blueprintsit.dao.EstadoProcesoDAO;
import cl.blueprintsit.dao.LogsDAO;
import cl.blueprintsit.entity.EstadoProceso;
import cl.blueprintsit.entity.Logs;
import cl.blueprintsit.model.PDF;
import cl.blueprintsit.process.AccessParameters;

import cl.blueprintsit.type.ConnectionBD;
import cl.blueprintsit.type.ParameterFilenet;
import cl.blueprintsit.ws.filenet.ConectorFileNetWSI;
import cl.blueprintsit.ws.filenet.Document;
import cl.blueprintsit.ws.filenet.FileNetWS;
import cl.blueprintsit.ws.filenet.Metadata;
import org.apache.commons.codec.binary.Base64;
import org.primefaces.model.DualListModel;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.xml.namespace.QName;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by BlueprintsIT on 5/11/2016.
 */
@ManagedBean(name = "uploadFilenetBean")
@ViewScoped
public class UploadFileNetBean extends BaseBean {

    static private final org.slf4j.Logger log = LoggerFactory.getLogger(UploadFileNetBean.class);

    @EJB
    private ConfigurationLogDAO configurationDAO;
    @EJB
    private LogsDAO logsDAO;
    @EJB
    private EstadoProcesoDAO estadoProcesoDAO;

    private Connection connection = null;
    private PreparedStatement ps = null;
    private String ID_SESION_PREINGRESO_USER=null;
    private String ID_SESION_PREINGRESO_PASS=null;
    private ConnectionBD connectionBD= new ConnectionBD();

    private String foldePDF=null;

    private List<String> fileUpload;
    private String rutCorredor;

    // List for pdf
    private DualListModel<String> archivosPdf;

    @PostConstruct
    public void init(){
        // Default Featured.
        rutCorredor = "78882050K";

        // List of pdfs
        List<String> files = new ArrayList<String>();
        foldePDF = configurationDAO.getByName(AccessParameters.FOLDER_LOCAL_IMAGEN).getValor();

        File f = new File(foldePDF);
        if (f.exists()){
            for (String archivo: f.list()){

                if (archivo.indexOf("Procesado_") == -1){
                    files.add(archivo);
                }
            }
        }

        archivosPdf = new DualListModel<String>(files, new ArrayList<String>());
    }

    public String getRutCorredor() {
        return rutCorredor;
    }

    public void setRutCorredor(String rutCorredor) {
        this.rutCorredor = rutCorredor;
    }

    public List<String> getListCorredor(){
        List<String> rutCorredoresValidos = new ArrayList<String>();
        rutCorredoresValidos.add("78882050K");

        return rutCorredoresValidos;
        // Emily
        //return  logsDAO.findByCorredor();
    }

    /*Verifica si hay registros en PipeSponsor que tengan ese pdf asociado. Devuelve true si existen registros*/
    private boolean isExistRegisterInPipeSponsor(String archivo) throws SQLException {

        if (connectionBD.findIfExistRegisters(archivo, AccessParameters.incorporacion))//verifica en AltaTitularCarga
            return true;
        if (connectionBD.findIfExistRegisters(archivo, AccessParameters.incorpo_dependiente))//verifica en AltaCarga
            return true;
        if (connectionBD.findIfExistRegisters(archivo, AccessParameters.exclusion_carga))//verifica en BajaTitular
            return true;
        if (connectionBD.findIfExistRegisters(archivo, AccessParameters.exclusion_titular))//verifica en BajaCarga
            return true;

        return false;
    }


    public List<String> getFileUpload() {
        return fileUpload;
    }


    public void setFileUpload(List<String> fileUpload) {
        this.fileUpload = fileUpload;
    }

    public void sendFileNet() throws SQLException {
        if (this.archivosPdf.getTarget().size() == 0 ){
            showError("Error", "Debe seleccionar mínimo 1 archivo para realizar una carga.");
            return;
        }

        boolean error = false;
        for (String targetFile : archivosPdf.getTarget()) {
            if(!isExistRegisterInPipeSponsor(targetFile)){
                showError("Error", "El archivo " + targetFile + " no está registrado en Pipe Sponsor, por lo cual no se puede subir a filenet.");
                error = true;
                return;
            }
        }

        if(error)
            return;

        // Ahora se valida si cada archivo tiene algun ingreso.
        ID_SESION_PREINGRESO_USER= configurationDAO.getByName(AccessParameters.ID_SESION_PREINGRESO_USER).getValor();
        ID_SESION_PREINGRESO_PASS =configurationDAO.getByName(AccessParameters.ID_SESION_PREINGRESO_PASS).getValor();
        String codigoFileNet = null;
        int dataColAltaTitCar= 0, dataColAltaCargas=0, dataCalExcluirTitular =0, dataColExcluirCarga=0;

        if (this.archivosPdf.getTarget().size()>0){
            for (String file: this.archivosPdf.getTarget()){
                try {
                    File fichero = new File(foldePDF+"/"+file);
                    codigoFileNet = findCodigoFileNet(fichero);

                    try {
                        String urlSesionBulk = configurationDAO.getByName(AccessParameters.URL_WS_SesionBulk).getValor();
                        URL url = new URL(urlSesionBulk);

                        if (codigoFileNet!=null){
                            log.info("Obtenido codigo de FileNet para el archivo: "+file);
                            connectionBD.registerLog("Obtenido codigo de FileNet para el archivo: "+file,AccessParameters.logTypeINFO,"FILENET", rutCorredor,0);
                            List<ParameterFilenet> filenetList = new ArrayList<ParameterFilenet>();
                            int canModify=-1;
                            ConnectionBD connectionBD = new ConnectionBD();
                            //actualizando alta titular
                            dataColAltaTitCar = connectionBD.updateCodFileNet(AccessParameters.incorporacion, file, codigoFileNet);
                            if (dataColAltaTitCar>0){
                                filenetList = connectionBD.findDateUpdated(AccessParameters.incorporacion,file, codigoFileNet);
                                connectionBD.updateCodFileNetPreIngreso(filenetList, ID_SESION_PREINGRESO_USER, ID_SESION_PREINGRESO_PASS, rutCorredor,url);
                                canModify =-1;filenetList = new ArrayList<ParameterFilenet>();
                            }
                            //actualizando alta_carga
                            dataColAltaCargas =connectionBD.updateCodFileNet(AccessParameters.incorpo_dependiente,file, codigoFileNet);
                            if (dataColAltaCargas>0){
                                filenetList = connectionBD.findDateUpdated(AccessParameters.incorpo_dependiente, file, codigoFileNet);
                                connectionBD.updateCodFileNetPreIngreso(filenetList, ID_SESION_PREINGRESO_USER, ID_SESION_PREINGRESO_PASS,rutCorredor,url);
                                canModify =-1;filenetList = new ArrayList<ParameterFilenet>();
                            }

                            //actualizando baja_titular
                            dataCalExcluirTitular =  connectionBD.updateCodFileNet(AccessParameters.exclusion_titular,file, codigoFileNet);
                            if (dataCalExcluirTitular>0){
                                filenetList = connectionBD.findDateUpdated(AccessParameters.exclusion_titular,file, codigoFileNet);
                                connectionBD.updateCodFileNetPreIngreso(filenetList, ID_SESION_PREINGRESO_USER, ID_SESION_PREINGRESO_PASS,rutCorredor,url);
                                canModify =-1;filenetList = new ArrayList<ParameterFilenet>();
                            }

                            //actualizando excluir carga
                            dataColExcluirCarga = connectionBD.updateCodFileNet(AccessParameters.exclusion_carga,file, codigoFileNet);
                            if (dataColExcluirCarga>0){
                                filenetList = connectionBD.findDateUpdated(AccessParameters.exclusion_carga,file, codigoFileNet);
                                connectionBD.updateCodFileNetPreIngreso(filenetList, ID_SESION_PREINGRESO_USER, ID_SESION_PREINGRESO_PASS,rutCorredor,url);
                            }

                            fichero.renameTo(new File(foldePDF+""+"Procesado_"+fichero.getName()));
                        }

                        EstadoProceso proceso =  estadoProcesoDAO.getById(5l);
                        proceso.setEstado("PROCESADO");
                        estadoProcesoDAO.update(proceso);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Archivos cargado con exito..!"));
                        if (dataColAltaTitCar>0)
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Alta titular carga, actualizados: "+dataColAltaTitCar));
                        if (dataColAltaCargas>0)
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Alta carga, actualizados:"+dataColAltaCargas));
                        if (dataCalExcluirTitular>0)
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Excluir titular, actualizados: "+dataCalExcluirTitular));
                        if (dataColExcluirCarga>0)
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Excluir carga, actualizados: "+dataColExcluirCarga));

                    }catch (Exception e){
                        log.error("PROBLEMAS SUBIENDO A FILENET EL ARCHIVO:  "+ file,e.getMessage());
                        generateLog("PROBLEMAS SUBIENDO A FILENET EL ARCHIVO: " +file,AccessParameters.logTypeERROR);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "PROBLEMAS SUBIENDO A FILENET EL ARCHIVO: " +file));
                    }
                }catch (Exception e){
                    log.error("PROBLEMAS SUBIENDO A FILENET EL ARCHIVO: () ", file,e.getMessage());
                    generateLog("PROBLAMAS AL CONECTAR CON FILENET "+ file ,AccessParameters.logTypeERROR);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "PROBLEMAS AL CONECTAR CON FILENET, INTENTE MAS TARDE"));
                }
            }
        }

        init();
    }

    private String findCodigoFileNet(File fichero) throws SQLException {

        String codigoFileNet = null;
        try {

            String urlFilenet = configurationDAO.getByName(AccessParameters.URL_WS_FileNet).getValor();
            URL url = new URL(urlFilenet);
            ConectorFileNetWSI filenet = new FileNetWS(url, new QName("http://filenet.ws.metlife.cl/", "FileNetWS")).getFilenet();

            List<Metadata> metadataArrayList = new ArrayList<Metadata>();
            Metadata metadata = new Metadata();
            metadata.setName("DocumentTitle");metadata.setValue(fichero.getName());
            metadataArrayList.add(metadata);

            Metadata metadata1 = new Metadata();
            metadata1.setName("businessDocumentId");metadata1.setValue(rutCorredor);
            metadataArrayList.add(metadata1);

            Metadata metadata2 = new Metadata();
            metadata2.setName("creatorTaskId");metadata2.setValue(AccessParameters.CreatorTaskId);
            metadataArrayList.add(metadata2);

            List<String> stringList = filenet.searchDocuments(AccessParameters.ApplicationId,metadataArrayList);

            if (stringList.size()!=0){
                codigoFileNet = stringList.get(stringList.size()-1);
            }else{
                if (fichero.exists()) {
                    String encodeFile = encodeFile(foldePDF + fichero.getName());
                    Document document = new Document();
                    document.setSerializedFile(encodeFile);
                    document.setFilename(fichero.getName());

                    codigoFileNet = filenet.putDocument(AccessParameters.ApplicationId, AccessParameters.CreatorTaskId, this.rutCorredor, document);

                }
            }

            for(int i = 0; i <= 60; i++) {
                log.debug("verificando el codigo filenet en subida a filenet: " + codigoFileNet);

                if(codigoFileNet != null)
                    break;

                log.debug("no trajo resultados de codigo filenet en subida a filenet");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    log.error("Error loco con threads",e);
                }
            }

            fichero.renameTo(new File(foldePDF+""+"Procesado_"+fichero.getName()));

        } catch (MalformedURLException e) {
            e.printStackTrace();
            generateLog("PROBLEMAS AL CONECTAR CON FILENET "+e.getMessage() ,AccessParameters.logTypeERROR);
        }
        catch (Exception e){
            generateLog("PROBLEMAS AL CONECTAR CON FILENET: "+ fichero.getName() +" "+e.getMessage() ,AccessParameters.logTypeERROR);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "PROBLEMAS AL CONECTAR CON FILENET, INTENTE MAS TARDE"));
        }


        return codigoFileNet;
    }

    private void generateLog(String mensaje,String tipo) throws SQLException {
        connectionBD.registerLog(mensaje, tipo, "FILENET", rutCorredor,0);
    }

    private String encodeFile(String fileName) throws IOException {

        File file = new File(fileName);
        Base64 base64 = new Base64();
        byte[] fileArrayByte = new byte[(int) file.length()];
        InputStream inputStreamFile = null;
        String encodedFile = "";

        try {
            inputStreamFile = new FileInputStream(file);
            inputStreamFile.read(fileArrayByte);
            encodedFile = base64.encodeToString(fileArrayByte);
            inputStreamFile.close();

        } catch (Exception e) {
            inputStreamFile.close();
            System.out.println("No se puedo codificar el archivo: "+ file);
        }
        return encodedFile;
    }

    public DualListModel<String> getArchivosPdf() {
        return archivosPdf;
    }

    public void setArchivosPdf(DualListModel<String> archivosPdf) {
        this.archivosPdf = archivosPdf;
    }
}
