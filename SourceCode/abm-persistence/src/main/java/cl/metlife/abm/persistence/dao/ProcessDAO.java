package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.Process;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blueprints on 9/16/2015.
 */
@Stateless
public class ProcessDAO {

    public static final String PARAMETER_CANT_BE_NULL = "PArameter can't be null";

    @PersistenceContext(unitName = "ABMPersistenceUnit")
    private EntityManager em;

    public Process getById(long id) {

        try {
            Process process = em.find(Process.class,id);
            em.detach(process);
            return process;
        }catch (NoResultException e){
            return null;
        }catch(Exception e){
            return null;
        }
    }
    public List<Process> findAll() {
        List<Process> resultList = em.createQuery("select i from Process i", Process.class)
                .getResultList();
        for (Process process : resultList) {
            em.detach(process);
        }
        return new ArrayList<>(resultList);
    }

    public Process create(Process process) {
        if ( process == null )
            throw new IllegalArgumentException(PARAMETER_CANT_BE_NULL);

        em.persist(process);
        //se debe hacer flush para garantizar la creacion del ID
        em.flush();
        em.detach(process);
        return process;
    }

    public Process update(Process process) {

        if ( process == null )
            throw new IllegalArgumentException(PARAMETER_CANT_BE_NULL);

        Process updated = em.merge(process);
        em.flush();

        em.detach(updated);

        return updated;
    }

    public boolean delete(Process process) {

        if ( process == null )
            throw new IllegalArgumentException(PARAMETER_CANT_BE_NULL);

        Process toDelete = em.find(Process.class,process.getId());
        
        if(toDelete==null)
            return false;
        
        em.remove(toDelete);

        return true;
    }

    public Process getByMultiBrokerRut(String multiBrokerRut) {
        try {
            return em.createQuery("select i from Process i where i.brokerRut =:multiBrokerRut", Process.class).setParameter("multiBrokerRut", multiBrokerRut).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    public List<Process> findActiveProcesses() {
        List<Process> resultList = em.createQuery("select i from Process i where i.active =:active", Process.class).setParameter("active", true).getResultList();
        for (Process process : resultList) {
            em.detach(process);
        }

        return new ArrayList<>(resultList);
    }

    public List<String> getAllRegisteredRuts(){
        return em.createQuery("select DISTINCT(i.brokerRut) from Process i where i.brokerRut is not null order by i.brokerRut asc",String.class).getResultList();
    }
}