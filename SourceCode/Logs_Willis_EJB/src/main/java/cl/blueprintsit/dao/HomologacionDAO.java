package cl.blueprintsit.dao;

import cl.blueprintsit.entity.PacdbchHomologacionEntity;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Stateless(name="homologacionDAO")
public class HomologacionDAO implements Serializable {

    @PersistenceContext(unitName = "ingresoHomologacion")
    private EntityManager em;

    private Checkbox checkbox;
    private boolean selected;
    java.util.Date fecha = new Date();
    private List<PacdbchHomologacionEntity> homologacionCheck;

    private Long codigo=null;

    private ArrayList <PacdbchHomologacionEntity> homologacionLista=new ArrayList<>();
    private ArrayList<PacdbchHomologacionEntity> homologacionEliminados=new ArrayList<>();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    //instanciamos la entity para utilizar sus metodos.
     PacdbchHomologacionEntity pacdbchHomologacionEntity = new PacdbchHomologacionEntity();

    public PacdbchHomologacionEntity getPacdbchHomologacionEntity() {
        return pacdbchHomologacionEntity;
    }

    public void setPacdbchHomologacionEntity(PacdbchHomologacionEntity pacdbchHomologacionEntity) {
        this.pacdbchHomologacionEntity = pacdbchHomologacionEntity;
    }
       //metodo para traer todos los datos de la tabla
       public List<PacdbchHomologacionEntity> findAll() {
        return em.createQuery("select h from PacdbchHomologacionEntity h order by h.codProducto desc ", PacdbchHomologacionEntity.class).getResultList();
   }
        //metodo para insertar datos en la tabla

        public void insertar( PacdbchHomologacionEntity pacdbchHomologacionEntity){
            try {
                String fechaCreacion =  new SimpleDateFormat("dd-MM-yyyy").format(fecha);
                pacdbchHomologacionEntity.setFechaCreacion(fechaCreacion);
                String horaCreacion = new SimpleDateFormat("HH:mm").format(fecha);
                pacdbchHomologacionEntity.setHoraCreacion(horaCreacion);
                em.persist(pacdbchHomologacionEntity);
                em.flush();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Insertados"));
            }catch (Exception e){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar los datos"));
            }


        }

        //metodo para eliminar homologacion/nes
        public void eliminarHomologacion(List<PacdbchHomologacionEntity> homologacionEntityList) {

            try {


                for (PacdbchHomologacionEntity lista : homologacionEntityList) {
                    Long algo = lista.getCodProducto();
                    if (!em.contains(lista)) {
                        lista = em.merge(lista);
                    }
                    em.remove(lista);

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos Eliminados "));

                }

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al eliminar los datos", e.toString()));
                System.out.println(e);
            }
        }

        public List<PacdbchHomologacionEntity> getByCodProducto(Long codProducto) {
            Query query = em.createQuery("select h from PacdbchHomologacionEntity h where h.codProducto = :codProducto ")
                .setParameter("codProducto",codProducto);

            List<PacdbchHomologacionEntity> pacdbchHomologacionEntities = query.getResultList();
            for (PacdbchHomologacionEntity h: pacdbchHomologacionEntities){
                return pacdbchHomologacionEntities;
            }
            return null;
        }

        public  <T> PacdbchHomologacionEntity merge(PacdbchHomologacionEntity var1){
        return em.merge(var1);
        }



    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public List<PacdbchHomologacionEntity> getHomologacionCheck() {
        return homologacionCheck;
    }

    public void setHomologacionCheck(List<PacdbchHomologacionEntity> homologacionCheck) {
        this.homologacionCheck = homologacionCheck;
    }
}
