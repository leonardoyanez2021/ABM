package cl.blueprintsit.dao;

import cl.blueprintsit.entity.ConfigurationLog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by BlueprintsIT on 4/28/2016.
 */
@Stateless(name="ConfigurationLogDAO")
public class ConfigurationLogDAO implements Serializable {

    @PersistenceContext(unitName = "preIngreso")
    private EntityManager em;

    public ConfigurationLog getById(Long id) {

        return em.find(ConfigurationLog.class,id);
    }
    public ConfigurationLog getByName(String name) {
         Query query = em.createQuery("select c from ConfigurationLog c where c.parametro = :name ")
                 .setParameter("name",name);

        List<ConfigurationLog> logs = query.getResultList();
        for (ConfigurationLog c: logs){
            return c;
        }
        return null;
    }

    public ConfigurationLog getByNameBCOCHILE(String name) {
        Query query = em.createQuery("select c from ConfigurationLog c where c.parametro = :name ")
                .setParameter("name",name);

        List<ConfigurationLog> logs = query.getResultList();
        for (ConfigurationLog c: logs){
            if(c.getIdentidad().equals("BCO_CHILE"))
                return c;
        }
        return null;
    }

    public List<ConfigurationLog> findConfigurationEditable() {
        return em.createQuery("select c from ConfigurationLog c where c.editable ='T' order by c.id asc", ConfigurationLog.class).getResultList();
    }

    public List<ConfigurationLog>  findAll() {
        return em.createQuery("select c from ConfigurationLog c order by c.id asc", ConfigurationLog.class).getResultList();
    }

    public ConfigurationLog create(ConfigurationLog configuration) {

        em.persist(configuration);
        em.flush();

        return configuration;
    }

    public ConfigurationLog update(ConfigurationLog confi) {
        if ( confi == null )
            throw new IllegalArgumentException("Configuracion can't be null");

        ConfigurationLog updated = em.merge(confi);
        em.flush();

        return updated;
    }

}
