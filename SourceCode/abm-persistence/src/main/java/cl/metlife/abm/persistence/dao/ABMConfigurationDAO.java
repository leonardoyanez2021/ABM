package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.ABMConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blueprints on 9/16/2015.
 */
@Stateless
public class ABMConfigurationDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ABMConfigurationDAO.class);

    public static final String PARAMETER_CANT_BE_NULL = "PArameter can't be null";
    @PersistenceContext(unitName = "ABMPersistenceUnit")
    private EntityManager em;

    public ABMConfiguration getById(long id) {

        try {
            ABMConfiguration group = em.find(ABMConfiguration.class,id);
            em.detach(group);
            return group;
        }catch (NoResultException e){
            return null;
        }

    }

    public List<ABMConfiguration> findAll() {
        Query environmentQuery = em.createQuery("select i from ABMConfiguration i where i.name=:key and i.entorno=:entorno", ABMConfiguration.class).setParameter("key", ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER)
                .setParameter("entorno", "BOTH");
        ABMConfiguration environmentQueryResult = (ABMConfiguration) environmentQuery.getSingleResult();
        em.detach(environmentQueryResult);

        Query query = em.createQuery("select i from ABMConfiguration i where i.entorno=:entorno").setParameter("entorno", environmentQueryResult.getValor());

        List<ABMConfiguration> resultList = query.getResultList();

        for (ABMConfiguration ABMConfiguration : resultList) {
            em.detach(ABMConfiguration);
        }

        List<ABMConfiguration> returnList = new ArrayList<ABMConfiguration>();
        returnList.add(environmentQueryResult);
        returnList.addAll(resultList);

        return returnList;
    }

    public ABMConfiguration update(ABMConfiguration ABMConfiguration) {

        if ( ABMConfiguration == null )
            throw new IllegalArgumentException(PARAMETER_CANT_BE_NULL);

        ABMConfiguration updated = em.merge(ABMConfiguration);
        em.flush();

        em.detach(updated);

        return updated;
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ABMConfiguration getByKey(String key) {
        LOGGER.debug(String.format("Llave asignada: %s ",key));
        Query environmentQuery = em.createQuery("select i from ABMConfiguration i where i.name=:key and i.entorno=:entorno", ABMConfiguration.class).setParameter("key", ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER)
                .setParameter("entorno", "BOTH");
        ABMConfiguration environmentQueryResult = (ABMConfiguration) environmentQuery.getSingleResult();

        if(key.equals(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER))
            return environmentQueryResult;

        Query query = em.createQuery("select i from ABMConfiguration i where i.name=:key and i.entorno=:entorno", ABMConfiguration.class).setParameter("key", key).setParameter("entorno", environmentQueryResult.getValor());

        ABMConfiguration result = (ABMConfiguration) query.getSingleResult();

        return result;
    }
}