package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.AltaTitular;
import cl.metlife.abm.persistence.dao.exception.PipeSponsorDBException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blueprints on 9/16/2015.
 */
@Stateless
public class AltaTitularDAO extends OperationDAO<AltaTitular>{
    @Override
    protected Query findAllQuery() {
        return em.createQuery("select i from AltaTitular i");
    }

    @Override
    protected Query findPipesponsorFileByBrokerRutQuery(String brokerRut)
    {
        return em.createQuery("select i from AltaTitular where i.rutCorredor =: brokerRut and i.procesado is null ").setParameter("brokerRut", brokerRut);
    }

    @Override
    protected Query findPipesponsorFileByLotIdQuery(Long lotId)
    {
        return em.createQuery("select i from AltaTitular i where i.lotId =: lotId and i.procesado is null ").setParameter("lotId", lotId);
    }

    @Override
    protected Query updateStatusQuery(Long lotId, String status)
    {
        String query= "update AltaTitular at set at.procesado = :status where at.lotId=:lotId";
        System.out.println("QUERY: " + query);
        return em.createQuery(query).setParameter("lotId", lotId).setParameter("status", status);
    }

    @Override
    protected Query findByBrokerRutAndLotNumberQuery(String brokerRut, Long lotNumber)
    {
        return em.createQuery("select i from AltaTitular i where i.rutCorredor =:brokerRut and i.lote =:lotNumber ")
                .setParameter("brokerRut", brokerRut).setParameter("lotNumber", lotNumber);
    }
}