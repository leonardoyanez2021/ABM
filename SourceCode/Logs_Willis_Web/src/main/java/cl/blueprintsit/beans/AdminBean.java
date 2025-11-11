package cl.blueprintsit.beans;

import cl.blueprintsit.dao.ConfigurationLogDAO;
import cl.blueprintsit.dao.EstadoProcesoDAO;
import cl.blueprintsit.entity.ConfigurationLog;
import cl.blueprintsit.process.AccessParameters;
import cl.blueprintsit.type.ConnectionBD;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by BlueprintsIT on 5/4/2016.
 */
@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminBean {

    public void setProcesadoToAll(){
        try {
            procesadoByTableId(1L);
            procesadoByTableId(2L);
            procesadoByTableId(3L);
            procesadoByTableId(4L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void procesadoByTableId(Long option) throws SQLException {
        int typeProceso = Integer.valueOf(option.toString());
        String query= null;
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;
        int result = -1;
        switch (typeProceso){
            case 1:{
                query = "UPDATE COLALTATITCAR SET PROCESADO = ? ";
                break;
            }
            case 2:{
                query = "UPDATE COLALTACARGAS SET PROCESADO = ? ";
                break;
            }
            case 3:{
                query = "UPDATE COLEXCLUIRTITULAR SET PROCESADO = ? ";
                break;
            }
            case 4:{
                query = "UPDATE COLEXCLUIRCARGA SET PROCESADO = ? ";
                break;
            }
        }

        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();
            if (connection != null) {
                ps = connection.prepareStatement(query);
                ps.setString(1,"1");
                result = ps.executeUpdate();
            }

            connection.close();

        } catch (SQLException e) {
            connection.close();
        }
    }

    public void deleteAll(){
        try {
            deleteAllByTableId(1L);
            deleteAllByTableId(2L);
            deleteAllByTableId(3L);
            deleteAllByTableId(4L);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllByTableId(Long option) throws SQLException {
        int typeProceso = Integer.valueOf(option.toString());
        String query= null;
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;
        int result = -1;
        switch (typeProceso){
            case 1:{
                query = "DELETE FROM COLALTATITCAR ";
                break;
            }
            case 2:{
                query = "DELETE FROM COLALTACARGAS ";
                break;
            }
            case 3:{
                query = "DELETE FROM COLEXCLUIRTITULAR ";
                break;
            }
            case 4:{
                query = "DELETE FROM COLEXCLUIRCARGA ";
                break;
            }
        }

        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();
            if (connection != null) {
                ps = connection.prepareStatement(query);
                result = ps.executeUpdate();
            }
            connection.close();

        } catch (SQLException e) {
            connection.close();
        }
    }
}
