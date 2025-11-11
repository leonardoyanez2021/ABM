package cl.blueprintsit.beans;

import cl.blueprintsit.dao.ConfigurationLogDAO;
import cl.blueprintsit.dao.EstadoProcesoDAO;
import cl.blueprintsit.entity.ConfigurationLog;
import cl.blueprintsit.process.AccessParameters;
import cl.blueprintsit.process.ReadSFTPWork;
import cl.blueprintsit.type.ConnectionBD;
import cl.blueprintsit.type.UpdateCodeFileNet;
import org.apache.axis.encoding.ser.ElementSerializer;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BlueprintsIT on 5/4/2016.
 */
@ManagedBean(name = "configuracionBean")
@ViewScoped
public class ConfiguracionDetalleBean {

    static private final org.slf4j.Logger log = LoggerFactory.getLogger(ConfiguracionDetalleBean.class);
    private String estadoProceso;
    private boolean flagProcess;
    @EJB
    private ConfigurationLogDAO configurationDAO;
    @EJB
    private EstadoProcesoDAO estadoProcesoDAO;

    @EJB
    private SchedulerBean schedulerBean;


    public List<ConfigurationLog> getConfiguracion(){
        return configurationDAO.findConfigurationEditable();
    }

    public  void initProcess(){
        this.flagProcess = true;
        try{
            schedulerBean.startWorking();

        } catch (Exception e) {
            log.error("Ocurrio un error al iniciar job",e);
        }
    }

    public  void stopProcess(){
        this.flagProcess = false;
        try{
            schedulerBean.stopWorking();

        } catch (Exception e) {
            log.error("Ocurrio un error al detener proceso",e);
        }
    }

    public  void startNow(){
        this.flagProcess = true;
        try{
            schedulerBean.startNow();

        } catch (Exception e) {
            log.error("Ocurrio un error al iniciar ahora",e);
        }
    }

    public String getEstadoProceso() {
        //String estado = estadoProcesoDAO.getById(1l).getEstado();
        estadoProceso = estadoProcesoDAO.getById(1l).getEstado();
        if (estadoProceso.equals(AccessParameters.processing))
            return "INICIADO";

        if (estadoProceso.equals(AccessParameters.forProcess))
            return "DETENIDO";

        return "DETENIDO";
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public void addMessageProcess() {
        String summary = flagProcess ? "Iniciado proceso" : "Detenido proceso";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public boolean getDisableStop() {
        if (getEstadoProceso().equals("DETENIDO")) {
            return true;
        }

        return false;
    }

    public boolean getDisableInit(){
        if(getEstadoProceso().equals("INICIADO")){
            return true;
        }

        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;

        String query1, query2, query3, query4;
        query1 = "select POLIZA from COLALTATITCAR  where procesado = 2 ";
        query2 = "select POLIZA from COLALTACARGAS where procesado = 2 ";
        query3 = "select POLIZA from COLEXCLUIRTITULAR where procesado = 2 ";
        query4 = "select POLIZA from COLEXCLUIRCARGA where procesado = 2 ";

        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();

            if (connection != null) {
                ps = connection.prepareStatement(query1);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    return true;
                }

                ps = connection.prepareStatement(query2);
                ResultSet rs2 = ps.executeQuery();

                while (rs2.next()) {
                    return true;
                }

                ps = connection.prepareStatement(query3);
                ResultSet rs3 = ps.executeQuery();

                while (rs3.next()) {
                    return true;
                }

                ps = connection.prepareStatement(query4);
                ResultSet rs4 = ps.executeQuery();

                while (rs4.next()) {
                    return true;
                }
                connection.close();
            }
        } catch (SQLException e) {
            log.error("Error al obtener los procesado en 2, para mostrar botón iniciar");
        }

        return false;
    }
}
