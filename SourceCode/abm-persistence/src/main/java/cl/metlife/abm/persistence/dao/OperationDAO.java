package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.*;
import cl.metlife.abm.persistence.dao.exception.PipeSponsorDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OperationDAO<T extends Operation> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationDAO.class);
    public static final String PARAMETER_CANT_BE_NULL = "PArameter can't be null";
    @PersistenceContext(unitName = "ABMPersistenceUnit")
    protected EntityManager em;

    protected Query findAllQuery()
    {
        return null;
    }

    public List<T> findAll() {
        Query query = findAllQuery();

        List<T> resultList = query.getResultList();

        for (T altaCarga : resultList) {
            em.detach(altaCarga);
        }

        List<T> returnList = new ArrayList<T>();
        returnList.addAll(resultList);

        return returnList;
    }

    protected Query findPipesponsorFileByBrokerRutQuery(String brokerRut)
    {
        return null;
    }

    public List<T> findPipesponsorFileByBrokerRut(String brokerRut) throws PipeSponsorDBException {
        try {
            Query query = findPipesponsorFileByBrokerRutQuery(brokerRut);

            List<T> resultList = query.getResultList();

            for (T altaCarga : resultList) {
                em.detach(altaCarga);
            }

            List<T> returnList = new ArrayList<T>();
            returnList.addAll(resultList);

            return returnList;
        } catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            throw new PipeSponsorDBException("Hubo un error al descargar la data de PipeSponsor.");
        }
    }


    public void update(T altaCarga) {
        if ( altaCarga == null )
            throw new IllegalArgumentException(PARAMETER_CANT_BE_NULL);

        T updated = em.merge(altaCarga);
        em.flush();
    }

    protected Query findPipesponsorFileByLotIdQuery(Long lotId)
    {
        return null;
    }

    public List<T> findPipesponsorFileByLotId(Long lotId) throws PipeSponsorDBException {
        try {
            Query query = findPipesponsorFileByLotIdQuery(lotId);
            List<T> resultList = query.getResultList();
            for (T altaCarga : resultList) {
                em.detach(altaCarga);
            }
            List<T> returnList = new ArrayList<T>();
            returnList.addAll(resultList);

            return returnList;
        } catch (Exception e){
            System.out.println("Stacktrace::::::::");
            LOGGER.error(e.getMessage(),e);
            e.printStackTrace();
            System.out.println("Stacktrace::::::::");
            throw new PipeSponsorDBException("Hubo un error al descargar la data de PipeSponsor.");
        }
    }

    protected Query updateStatusQuery(Long lotId, String status)
    {
        return null;
    }

    public int updateStatus(Long lotId, String status) throws PipeSponsorDBException {
        try {
            Query query = updateStatusQuery(lotId, status);

            int response = query.executeUpdate();

            return response;
        } catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            throw new PipeSponsorDBException("Hubo un error al updatear status de la data insertada de PipeSponsor.");
        }
    }

    protected Query findByBrokerRutAndLotNumberQuery(String brokerRut, Long lotNumber)
    {
        return null;
    }

    public List<T> findByBrokerRutAndLotNumber(String brokerRut, Long lotNumber) throws PipeSponsorDBException {
        try {
            Query query = findByBrokerRutAndLotNumberQuery(brokerRut, lotNumber);

            List<T> resultList = query.getResultList();

            return resultList;
        } catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            throw new PipeSponsorDBException("Hubo un error al descargar la data de PipeSponsor.");
        }
    }
}
