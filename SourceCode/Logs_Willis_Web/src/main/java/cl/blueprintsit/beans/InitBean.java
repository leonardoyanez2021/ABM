package cl.blueprintsit.beans;

import cl.blueprintsit.business.authentication.auth.List;
import cl.blueprintsit.dao.EstadoProcesoDAO;
import cl.blueprintsit.dao.HomologacionDAO;
import cl.blueprintsit.dao.LogsDAO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Created by BlueprintsIT on 4/26/2016.
 */
@ManagedBean(name = "initProcess")
@ViewScoped
public class InitBean implements Serializable {

    @EJB
    private EstadoProcesoDAO estadoProcesoDAO;
    @EJB
    private LogsDAO logsDAO;

    @EJB
    private HomologacionDAO homologacionDAO;


    public HomologacionDAO getHomologacionDAO() {
        return homologacionDAO;
    }

    public void setHomologacionDAO(HomologacionDAO homologacionDAO) {
        this.homologacionDAO = homologacionDAO;
    }

    //Variables
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    private LogLazyDataModel logClient;

    public LogLazyDataModel getLogs(){

        if (logClient==null)
            logClient  = new LogLazyDataModel(logsDAO);
        return logClient;
    }

    public void refreshTable(){
        logClient = null;
    }
}
