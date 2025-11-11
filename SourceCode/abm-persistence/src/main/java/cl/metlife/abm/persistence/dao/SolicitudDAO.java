package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.ESolicitud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class SolicitudDAO {

    @PersistenceContext(unitName = "ABMPersistenceUnit")
    private EntityManager em;



    public ESolicitud getById(Long id){
        try {
            ESolicitud  solicitud = em.find(ESolicitud.class,id);
            em.detach(solicitud);
            return solicitud;
        }catch (NoResultException e){
            return null;
        }
    }

}
