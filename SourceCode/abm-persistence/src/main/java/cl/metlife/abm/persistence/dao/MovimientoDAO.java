package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.EMovimiento;
import cl.metlife.abm.domain.ESolicitud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MovimientoDAO {
    @PersistenceContext(unitName = "ABMPersistenceUnit")
    private EntityManager em;


    public EMovimiento getById(Long id) {

        try {
            EMovimiento movimiento = em.find(EMovimiento.class,id);
            em.detach(movimiento);
            return movimiento;
        }catch (NoResultException e){
            return null;
        }
    }
    public List<EMovimiento> getMovimientosBySolicitud(ESolicitud es){
        return em.createQuery("SELECT e from EMovimiento e where e.solId=:idSolicitud ", EMovimiento.class)
                .setParameter("idSolicitud", es.getId())
                .getResultList();
    }
    public List<EMovimiento> getMovimientosByLote(int Lote){

        return em.createQuery("SELECT e from EMovimiento e, ESolicitud s where e.solId=s.id and s.lote=: lote", EMovimiento.class)
                .setParameter("lote", Lote)
                .getResultList();
    }
    public List<EMovimiento> getMovimientosByLoteAndSolicitud(int Lote, ESolicitud e){

        return em.createQuery("SELECT e from EMovimiento e, ESolicitud s where e.solId=s.id and s.lote=:lote and s.id=:idSolicitud", EMovimiento.class)
                .setParameter("lote", Lote)
                .setParameter("idSolicitud", e.getId())
                .getResultList();
    }



}
