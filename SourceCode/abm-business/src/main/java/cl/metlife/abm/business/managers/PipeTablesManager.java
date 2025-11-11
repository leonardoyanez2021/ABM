package cl.metlife.abm.business.managers;


import cl.metlife.abm.domain.*;
import cl.metlife.abm.persistence.dao.*;
import cl.metlife.abm.persistence.dao.exception.PipeSponsorDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import java.util.List;

/**
 * Created by Blueprints on 9/16/2015.
 */
@Stateless
public class PipeTablesManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(PipeTablesManager.class);

    public <U extends Operation,T extends OperationDAO<U>> List<U> findUnprocessedRows(Long lotId, T op) throws PipeSponsorDBException {
        return op.findPipesponsorFileByLotId(lotId);
    }
    public List<DesignacionBeneficiario> findUnprocessedRows2(Long lotId, DesignacionBeneficiarioDAO designacionBeneficiarioDAO) throws PipeSponsorDBException {
        return designacionBeneficiarioDAO.findPipesponsorFileByLotId(lotId);
    }


    public <U extends Operation,T extends OperationDAO<U>> List<U> findByBrokerRutAndLotNumber(String brokerRut, Long lotNumber, T op) throws PipeSponsorDBException {
        return op.findByBrokerRutAndLotNumber(brokerRut, lotNumber);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public <U extends Operation,T extends OperationDAO<U>> void update(U op, T opDao) {
        opDao.update(op);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public <T extends OperationDAO> void updateStatus(Long lotId, String status, T op) throws PipeSponsorDBException {
        op.updateStatus(lotId, status);
    }

}