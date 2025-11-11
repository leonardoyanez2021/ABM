package cl.blueprintsit.beans;

import cl.blueprintsit.dao.ConfigurationLogDAO;
import cl.blueprintsit.dao.LogsDAO;
import cl.blueprintsit.entity.ConfigurationLog;
import cl.blueprintsit.process.AccessParameters;
import cl.blueprintsit.process.SUserInfo;
import cl.blueprintsit.type.ConnectionBD;
import cl.blueprintsit.ws.bulkPreingreso.BulkDetalleBo;
import cl.blueprintsit.ws.bulkPreingreso.DetalleBo;
import cl.blueprintsit.ws.bulkPreingreso.WsBulk;
import cl.blueprintsit.ws.sesionPreingreso.SesionBo;
import cl.blueprintsit.ws.sesionPreingreso.WsSesion;
import cl.blueprintsit.ws.sesionPreingreso.WsSesionSoap;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.UserInfo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.primefaces.event.SelectEvent;
import com.jcraft.jsch.*;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by BlueprintsIT on 5/16/2016.
 */
@ManagedBean(name = "sendSFTPBean")
@ViewScoped
public class SendFileSFTPBean {

    private final static Logger log = LogManager.getLogger(AuthenticationBean.class);

    private Date dateIni;
    private Date dateFin;
    private String dateActual;
    private String dateSelect;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd_MM_yyyy");
    Calendar calendar =  Calendar.getInstance();
    private ConnectionBD connectionBD= new ConnectionBD();

    ChannelSftp channelSftp = null;
    Session session = null;
    @EJB
    private ConfigurationLogDAO configurationDAO;
    @EJB
    private LogsDAO logsDAO;

    public void buttonAction(ActionEvent actionEvent) throws SQLException {
        String nameFile =  null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        log.info("Se comienza con la obtención de datos para el rango de fechas " + sdf.format(dateIni) + " hasta " + sdf.format(dateFin));

        if (this.dateIni==null && this.dateFin==null )
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Debe selecionar un rango de fechas"));
            return;
        }

        List<DetalleBo> detalleBos = findDataPreingreso();
        if (detalleBos.size()==0){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No se encontraron datos para generar el archivo"));
            return;
        }

        String folderLocalLog = configurationDAO.getByName(AccessParameters.FOLDER_LOCAL_DOCUMENT).getValor();
        nameFile =  "Log_"+formatter2.format(calendar.getTime())+".xlsx";                   //crea el nombre del archivo a generar con Log_FECHA.xlsx

        File file = generateFileExcel(folderLocalLog, detalleBos, nameFile); //genera el archivo Excel, segun la fechas de inicio y fin seleccionada
        sendFileToSFTP(file, folderLocalLog, nameFile);
    }

    private void sendFileToSFTP(File file,String folderLocalLog, String nameFile ) throws SQLException {

        String folderRemote = configurationDAO.getByName(AccessParameters.FOLDER_REMOTE_LOG).getValor();

        ConfigurationLog conf  = configurationDAO.getByName(AccessParameters.SFTP_ENABLE);
        boolean enableSFTP = Boolean.parseBoolean(conf.getValor());

        if (enableSFTP){
            channelSftp = getConecctionSFTP();
            nameFile =  "Log_"+formatter2.format(calendar.getTime())+".xlsx";

            if (channelSftp!=null){
                try {
                    channelSftp.cd(folderRemote); //va a la carpeta del SFTP donde se guardara el archivo
                    try {
                        channelSftp.put(new FileInputStream(file), file.getName());
                    } catch (FileNotFoundException e) {
                        generateLog("Problemas cargado en SFTP el archivo: "+file.getName(), AccessParameters.logTypeERROR,"ENVIO LOG SFTP");

                        FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Problemas cargado en SFTP el archivo: "+file.getName()));

                    }

                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cargado correctamente, archivo: "+nameFile));

                    generateLog( "Cargado correctamente, archivo: "+nameFile, AccessParameters.logTypeINFO,"ENVIO LOG SFTP");

                } catch (SftpException e) {
                    generateLog("No se encuentra la carpeta: "+folderRemote, AccessParameters.logTypeERROR,"ENVIO LOG SFTP");
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se encuentra la carpeta: "+folderRemote));
                    e.printStackTrace();
                }
                channelSftp.exit();
                channelSftp.disconnect();
                session.disconnect();
            }
        }else{
            generateLog("No esta habilitada la conexion al SFTP, el archivo será generado en: "+folderLocalLog , AccessParameters.logTypeINFO,"ENVIO LOG SFTP");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "No esta habilitada la conexion al SFTP, el archivo será generado en: "+folderLocalLog));
        }


    }

    private void generateLog(String message, String logTypeERROR,String proceso) throws SQLException {

        connectionBD.registerLog(message, logTypeERROR, proceso, null,0);
    }


    private List<DetalleBo> findDataPreingreso() throws SQLException {
        List<DetalleBo> listDetalleBos = new ArrayList<DetalleBo>();
        log.info("Buscando data en preingreso.");
        String user= configurationDAO.getByName(AccessParameters.ID_SESION_PREINGRESO_USER).getValor();
        String pass =configurationDAO.getByName(AccessParameters.ID_SESION_PREINGRESO_PASS).getValor();

        GregorianCalendar a = new GregorianCalendar(); a.setTime(this.dateIni);
        GregorianCalendar b = new GregorianCalendar(); b.setTime(this.dateFin);
        XMLGregorianCalendar fechaDesde = null, fechaHasta =null;
        try {
            fechaDesde = DatatypeFactory.newInstance().newXMLGregorianCalendar(a);
            fechaHasta = DatatypeFactory.newInstance().newXMLGregorianCalendar(b);

            try {
                String urlSesionBulk = configurationDAO.getByName(AccessParameters.URL_WS_SesionBulk).getValor();
                URL url = new URL(urlSesionBulk);

                log.info("URL Primer servicio web: " + configurationDAO.getByName(AccessParameters.URL_WS_SesionBulk).getValor());
                log.info("Usuario servicio web: " + user);
                log.info("Password servicio web: " + pass);

                WsSesion wsSesion = new WsSesion(url, new QName("http://preingreso.metlife.cl/", "WsSesion"));
                WsSesionSoap wsSesionSoap = wsSesion.getWsSesionSoap();
                SesionBo sesionBo = wsSesionSoap.logon(user, pass);
                if (sesionBo.getId()!=null){
                    log.info("Ejecuté el primer servicio.");
                    log.info("ID Generado por el primer servicio: " + sesionBo.getId());
                    String stringUrlBulk = configurationDAO.getByName(AccessParameters.URL_WS_Bulk).getValor();
                    log.info("URL Segundo servicio: " + stringUrlBulk);
                    URL urlBulk = new URL(stringUrlBulk);
                    WsBulk wsBulk = new WsBulk(urlBulk, new QName("http://preingreso.metlife.cl/", "WsBulk"));

                    log.info("Ahora voy a invocar el segundo servicio, con las fechas " +fechaDesde + " hasta " +fechaHasta);
                    BulkDetalleBo bulkDetalleBo = wsBulk.getWsBulkSoap().bulkDetalle(sesionBo.getId(),null, fechaDesde, fechaHasta );
                    wsSesionSoap.logout(sesionBo.getId());

                    if (bulkDetalleBo.getDetalles().getDetalleBo().size()!=0)
                        listDetalleBos =  bulkDetalleBo.getDetalles().getDetalleBo();
                    else
                        log.info("La lista de respuesta no contiene datos.");
                }
            }catch (Exception e){
                log.error("ERROR CONECTANDO A BULK_DETALLE, ERROR: "+e.getMessage());
                connectionBD.registerLog("ERROR CONECTANDO A BULK_DETALLE, ERROR: "+e.getMessage(), AccessParameters.logTypeERROR, "ENVIO LOG SFTP", null,0);
            }
        } catch (DatatypeConfigurationException e) {
            log.error("ERROR TRANSFORMANDO FECHA DE CONSULTA: " +e.getMessage());
        }
        return listDetalleBos;
    }

    private ChannelSftp getConecctionSFTP() throws SQLException {
        ChannelSftp sftp = new ChannelSftp();
        JSch jsch = new JSch();

        String sftp_password =  configurationDAO.getByNameBCOCHILE(AccessParameters.SFTP_PASS).getValor();
        String sftp_user = configurationDAO.getByNameBCOCHILE(AccessParameters.SFTP_USER).getValor();
        String sftp_host = configurationDAO.getByNameBCOCHILE(AccessParameters.SFTP_HOST).getValor();
        String valor = configurationDAO.getByNameBCOCHILE(AccessParameters.SFTP_PORT).getValor();
        int sftp_port = Integer.valueOf(valor);

        try {
            session = jsch.getSession(sftp_user, sftp_host, sftp_port);
            UserInfo ui = new SUserInfo(sftp_password, null);
            session.setPassword(sftp_password);
            session.setUserInfo(ui);
            session.setTimeout(200);
            session.connect();
            sftp = (ChannelSftp) session.openChannel("sftp");
            sftp.connect();

        } catch (JSchException e) {
            System.out.println("No se puede conectar con el SFTP");
            connectionBD.registerLog("No se puede conectar con el SFTP: "+e.getMessage(), AccessParameters.logTypeERROR, "ENVIO LOG SFTP", null,0);
            e.printStackTrace();
            sftp =  null;
        }
        return sftp;
    }

    public String getDateSelect() {
        if (this.dateIni!=null){
            dateSelect =  formatter.format(this.dateIni);
        }else dateSelect = getDateActual();

        return dateSelect;
    }


    public void onDateSelect(SelectEvent event) {
        getDateSelect();
    }


    public String getDateActual() {
        Calendar calendar = Calendar.getInstance();
        dateActual = formatter.format(calendar.getTime());
        return dateActual;
    }


    public Date getDateIni() {
        return dateIni;
    }

    public void setDateIni(Date dateIni) {
        this.dateIni = dateIni;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    private File generateFileExcel(String ruta,  List<DetalleBo> detalleBos, String nameFile) {

        String rutaArchivo = ruta + ""+nameFile;
        File archivoXLS = new File(rutaArchivo);
        if(archivoXLS.exists())
            archivoXLS.delete();
        try {
            archivoXLS.createNewFile();
            Workbook libro = new XSSFWorkbook();
            Sheet hoja = libro.createSheet("Logs");
            //Create header
            Row fila = hoja.createRow(0);
            Cell cell1 =  fila.createCell(0); cell1.setCellValue("poliza");
            Cell cell2 =  fila.createCell(1); cell2.setCellValue("numgru");
            Cell cell3 =  fila.createCell(2); cell3.setCellValue("rut titular");
            Cell cell4 =  fila.createCell(3); cell4.setCellValue("dv titular");
            Cell cell5 =  fila.createCell(4); cell5.setCellValue("rut carga");
            Cell cell6 =  fila.createCell(5); cell6.setCellValue("dv carga");
            Cell cell7 =  fila.createCell(6); cell7.setCellValue("estado");
            Cell cell8 =  fila.createCell(7); cell8.setCellValue("fecha Recepcion CIA");
            Cell cell9 =  fila.createCell(8); cell9.setCellValue("fecha Estado");
            Cell cell10 =  fila.createCell(9); cell10.setCellValue("codigo de barra");

            for(int c=1;c<detalleBos.size();c++){
                fila = hoja.createRow(c);
                DetalleBo detalleBo= detalleBos.get(c-1);
                cell1 =  fila.createCell(0); //poliza
                if (detalleBo.getPolizaNumero()!=null)
                    cell1.setCellValue(detalleBo.getPolizaNumero().toString());
                else
                    cell1.setCellValue("");

                cell2 =  fila.createCell(1); //numgrup
                if (detalleBo.getGrupo()!=null)
                    cell2.setCellValue(detalleBo.getGrupo().toString());
                else
                    cell2.setCellValue("");

                cell3 =  fila.createCell(2);//rut titular
                if (detalleBo.getTitular().getRut()!=null)
                    cell3.setCellValue(detalleBo.getTitular().getRut().toString());
                else
                    cell3.setCellValue("");

                cell4 =  fila.createCell(3);//DV titular
                if (detalleBo.getTitular().getDv()!=null)
                    cell4.setCellValue(detalleBo.getTitular().getDv().toString());
                else
                    cell4.setCellValue("");

                cell5 =  fila.createCell(4);//rut carga
                if (detalleBo.getCarga().getRut()!=null )
                    cell5.setCellValue(detalleBo.getCarga().getRut().toString());
                else cell5.setCellValue("");

                cell6 =  fila.createCell(5);//dv carga
                if (detalleBo.getCarga().getRut()!=null )
                    cell6.setCellValue(detalleBo.getCarga().getRut().toString());
                else cell6.setCellValue("");

                cell7 =  fila.createCell(6);
                if (detalleBo.getEstado().getDescripcion()!=null)
                    cell7.setCellValue(detalleBo.getEstado().getDescripcion().toString());
                else
                    cell7.setCellValue("");

                cell8 =  fila.createCell(7);
                if (detalleBo.getFechaInicioVigencia()!=null)
                    cell8.setCellValue(detalleBo.getFechaInicioVigencia().toString().replace("T00:00:00",""));
                else
                    cell8.setCellValue("");

                cell9 =  fila.createCell(8);
                if (detalleBo.getFechaTerminoVigencia()!=null)
                    cell9.setCellValue(detalleBo.getFechaTerminoVigencia().toString().replace("T00:00:00",""));
                else
                    cell9.setCellValue("");

                cell10 =  fila.createCell(9);
                if (detalleBo.getCodigoBarra()!=null)
                    cell10.setCellValue(detalleBo.getCodigoBarra().toString());
                else
                    cell10.setCellValue("");
            }
            FileOutputStream salida = new FileOutputStream(archivoXLS);
            libro.write(salida);
            salida.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Archivo creado con exito..!"));
            generateLog("Archivo creado con exito. Nombre: "+nameFile, AccessParameters.logTypeINFO,"ENVIO LOG SFTP");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return archivoXLS;
    }

}
