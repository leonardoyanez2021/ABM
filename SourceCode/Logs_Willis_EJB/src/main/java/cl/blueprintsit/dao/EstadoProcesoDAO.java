package cl.blueprintsit.dao;

import cl.blueprintsit.entity.EstadoProceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by BlueprintsIT on 5/4/2016.
 */
@Stateless(name="EstadoProcesoDAO")
public class EstadoProcesoDAO implements Serializable {
    @PersistenceContext(unitName = "preIngreso")
    private EntityManager em;

    public EstadoProceso getById(Long id) {
		em.refresh(em.find(EstadoProceso.class,id));
        return em.find(EstadoProceso.class,id);
    }

    public EstadoProceso create(EstadoProceso estadoProceso) {
        em.persist(estadoProceso);
        em.flush();

        return estadoProceso;
    }
    public List<EstadoProceso> findAll() {
        return em.createQuery("select l from EstadoProceso l order by l.id asc ", EstadoProceso.class).getResultList();
    }

    public EstadoProceso update(EstadoProceso estadoProceso) {
        if ( estadoProceso == null )
            throw new IllegalArgumentException("Data can't be null");

        EstadoProceso updated = em.merge(estadoProceso);
        em.flush();

        return updated;
    }

}
