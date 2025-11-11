package cl.blueprintsit.beans;

import cl.blueprintsit.dao.EstadoProcesoDAO;
import cl.blueprintsit.entity.EstadoProceso;
import cl.blueprintsit.process.AccessParameters;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by BlueprintsIT on 5/4/2016.
 */
@ManagedBean(name = "estadoProcesoBean")
@ViewScoped
public class EstadoProcesoBean {

    @EJB
    public EstadoProcesoDAO estadoProcesoDAO;

    public List<EstadoProceso> getEstadoProcesos(){
        return estadoProcesoDAO.findAll();
    }

    public String estadoProcess(){

        EstadoProceso estadoProceso =  estadoProcesoDAO.getById(Long.valueOf(String.valueOf(AccessParameters.process_nextEjecution)));
        return estadoProceso.getEstado();
    }


}
