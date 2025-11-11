package cl.blueprintsit.dao;

import cl.blueprintsit.entity.Logs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.*;
import java.text.ParseException;

/**
 * Created by BlueprintsIT on 5/3/2016.
 */
@Stateless(name="LogDAO")
public class LogsDAO implements Serializable {

    @PersistenceContext(unitName = "preIngreso")
    private EntityManager em;


    public Logs getById(Long id) {
        return em.find(Logs.class,id);
    }

    public Logs create(Logs logs) {
        em.persist(logs);
        em.flush();

        return logs;
    }
    public List<Logs> findAll() {
        return em.createQuery("select l from Logs l order by l.id desc ", Logs.class).getResultList();
    }

    public List<Logs> findByDate(Date dateIni, Date dateFin) {
        Calendar calendar =  getLast24Hour(dateFin);

        List<Logs> logses=new ArrayList<Logs>();
        logses =  em.createQuery("select l from Logs l where l.fecha > :dateIni and l.fecha< :dateFin order by l.id desc ", Logs.class)
                .setParameter("dateIni",dateIni)
                .setParameter("dateFin",calendar.getTime())
                .getResultList();


        return logses;
    }

    public List<Logs> findByCorredor() {
        // Versión Emily
        //return em.createQuery("select distinct(l.rutCorredor) from Logs l where l.rutCorredor<>'0' and l.rutCorredor is not null ", Logs.class)
        //        .getResultList();

        return em.createQuery("select distinct(l.rutCorredor) from Logs l where l.rutCorredor = '78882050K'", Logs.class).getResultList();
    }

    public List<Logs> findByLote() {
        return em.createQuery("select distinct(l.lote) from Logs l where l.lote is not null ", Logs.class)
                .getResultList();
    }

    public List<Logs> findByDateRutCorredor(Date dateIni, Date dateFin, String rutCorredor) {
        Calendar calendar = getLast24Hour(dateFin);

        return em.createQuery("select l from Logs l where l.fecha > :dateIni and l.fecha< :dateFin " +
                "and l.rutCorredor = :corredor order by l.id desc ", Logs.class)
                .setParameter("dateIni",dateIni)
                .setParameter("dateFin",calendar)
                .setParameter("corredor", rutCorredor)
                .getResultList();
    }

    public List<Logs> findByTypeProcess() {
        return em.createQuery("select distinct(l.tipo) from Logs l where l.tipo is not null ", Logs.class)
                .getResultList();
    }

    public List<Logs> findByNameProcess() {
        return em.createQuery("select distinct(l.proceso) from Logs l where l.proceso is not null ", Logs.class)
                .getResultList();
    }

    public List<Logs> findByDateNameProcess(Date dateIni, Date dateFin, String nameProcess) {
        Calendar calendar = getLast24Hour(dateFin);

        return em.createQuery("select l from Logs l where l.fecha > :dateIni and l.fecha< :dateFin " +
                "and l.proceso = :nameProcess order by l.id desc ", Logs.class)
                .setParameter("dateIni",dateIni)
                .setParameter("dateFin",calendar)
                .setParameter("nameProcess", nameProcess)
                .getResultList();
    }

    private Calendar getLast24Hour(Date dateFin) {
        Calendar calendar =  new GregorianCalendar();
        calendar.setTimeInMillis(dateFin.getTime());
        calendar.add(Calendar.HOUR, 23);
        calendar.add(Calendar.MINUTE, 59);
        calendar.add(Calendar.SECOND, 59);
        return calendar;
    }

    public List<Logs> findByDateTypeProcess(Date dateIni, Date dateFin, String typeLog) {
        Calendar calendar =  getLast24Hour(dateFin);

        return em.createQuery("select l from Logs l where l.fecha > :dateIni and l.fecha< :dateFin " +
                "and l.tipo = :typeLog order by l.id desc ", Logs.class)
                .setParameter("dateIni",dateIni)
                .setParameter("dateFin",calendar)
                .setParameter("typeLog", typeLog)
                .getResultList();
    }

    public List<Logs> findByDateLote(Date dateIni, Date dateFin, String idLote) {
        Calendar calendar =  getLast24Hour(dateFin);

        return em.createQuery("select l from Logs l where l.fecha > :dateIni and l.fecha< :dateFin " +
                "and l.lote = :idLote order by l.id desc ", Logs.class)
                .setParameter("dateIni",dateIni)
                .setParameter("dateFin",calendar)
                .setParameter("idLote", Integer.valueOf(idLote))
                .getResultList();
    }

    public Long countFiltered(Map<String, Object> filters) throws ParseException {
        TypedQuery<Long> query = null;

        query = em.createQuery("SELECT count(l.id) FROM Logs l  " + UtilsLike.buildWhereClauses(filters), Long.class);

        UtilsLike.setFilterParams(filters, query);
        return query.getSingleResult();
    }

    public List<Logs> findFiltered(int first, int pageSize, String sortField,Boolean sortOrder,Map<String, Object> filters) throws ParseException{

        List<Logs> response = new ArrayList<Logs>();
        StringBuilder orderClause = new StringBuilder();
        String clause =  "";
        if ( sortField != null && !"".equals(sortField) )
            orderClause.append(" ORDER BY l." + sortField + (sortOrder != null && sortOrder ? " ASC" : " DESC"));
        else
            orderClause.append(" ORDER BY l.id DESC");


        TypedQuery<Logs> query = null;
        query =  em.createQuery("select l from Logs l " + UtilsLike.buildWhereClauses(filters) + orderClause.toString() , Logs.class);

        query.setFirstResult(first);
        query.setMaxResults(pageSize);
        UtilsLike.setFilterParams(filters, query);
        List<Logs> res = query.getResultList();

        return res;
    }

    private String getSqlString(Map<String, Object> filters, String sql) {
        //String sql = "SELECT l FROM Logs l where ";
        int con=1;
        for (String field : filters.keySet()) {

            if (filters.size()> 1 && con<filters.size()){
                if (field.equals("fecha")){
                    sql = sql + " l." +field +" BETWEEN :fechaInicial and :fechaFinal and  ";
                }else
                    sql = sql + " l." +field +" like :"+field +" and ";
            }
            else{
                if (field.equals("fecha")){
                    sql = sql + " l." +field +" BETWEEN :fechaInicial and :fechaFinal ";
                }else
                    sql = sql + " l." +field +" like :"+field +" ";
            }


            con++;
        }
        return sql;
    }
}


