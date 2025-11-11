package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.ExclusionTitular;

import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Created by Blueprints on 9/16/2015.
 */
@Stateless
public class ExclusionTitularDAO extends OperationDAO<ExclusionTitular>{
    @Override
    protected Query findAllQuery() {
        return em.createQuery("select i from ExclusionTitular i");
    }

    @Override
    protected Query findPipesponsorFileByBrokerRutQuery(String brokerRut)
    {
        return em.createQuery("select i from ExclusionTitular i where i.rutCorredor =: brokerRut and i.procesado is null ").setParameter("brokerRut", brokerRut);
    }

    @Override
    protected Query findPipesponsorFileByLotIdQuery(Long lotId)
    {
        return em.createQuery("select i from ExclusionTitular i where i.lotId =: lotId and i.procesado is null ").setParameter("lotId", lotId);
    }

    @Override
    protected Query updateStatusQuery(Long lotId, String status)
    {
        return em.createQuery("update ExclusionTitular at set at.procesado = :status where at.lotId=:lotId").setParameter("lotId", lotId).setParameter("status", status);
    }

    @Override
    protected Query findByBrokerRutAndLotNumberQuery(String brokerRut, Long lotNumber)
    {
        return em.createQuery("select i from ExclusionTitular i where i.rutCorredor =:brokerRut and i.lote =:lotNumber ")
                .setParameter("brokerRut", brokerRut).setParameter("lotNumber", lotNumber);
    }
}