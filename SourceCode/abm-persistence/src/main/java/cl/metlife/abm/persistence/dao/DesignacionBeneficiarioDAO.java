package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.DesignacionBeneficiario;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class DesignacionBeneficiarioDAO extends OperationDAO<DesignacionBeneficiario> {
    @Override
    protected Query findAllQuery() {
        return em.createQuery("select i from DesignacionBeneficiario i");
    }


    @Override
    protected Query findPipesponsorFileByLotIdQuery(Long lotId)
    {
        System.out.println("LOTEEEEEEEEEEEEEEEEEEEEEEE");
        System.out.println(lotId);
        return em.createQuery("select i from DesignacionBeneficiario i where i.lotID =: lotId and i.procesado is null ").setParameter("lotId", lotId);
    }

    @Override
    protected Query updateStatusQuery(Long lotId, String status)
    {
        return em.createQuery("update DesignacionBeneficiario at set at.procesado = :status where at.lotID=:lotId").setParameter("lotId", lotId).setParameter("status", status);
    }




}
