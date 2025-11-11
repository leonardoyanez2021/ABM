package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.EInfoResult;
import cl.metlife.abm.domain.EMovimiento;
import cl.metlife.abm.domain.ESolicitud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
public class InfoResultDAO {
    static final Logger logger = LoggerFactory.getLogger(InfoResultDAO.class);

    @PersistenceContext(unitName = "ABMPersistenceUnit")
    private EntityManager em;


    public EInfoResult getById(Long id) {
        try {
            EInfoResult info = em.find(EInfoResult.class, id);
            em.detach(info);
            return info;
        } catch (NoResultException e) {
            return null;
        }
    }
    public EInfoResult getInfoById(Long id){
        return em.createQuery("SELECT i from EInfoResult i where i.id=:idInfo ", EInfoResult.class)
                .setParameter("idInfo", id).getSingleResult();
    }
    public EInfoResult getInfoBySolicitud(Long idSol){

        return em.createQuery("SELECT i from  EInfoResult i where i.idSolicitud=:idSolicitud ", EInfoResult.class)
                .setParameter("idSolicitud", idSol)
                .getSingleResult();
    }
    public EInfoResult getInfoByMov(Long IdM){
        return em.createQuery("SELECT i from EInfoResult i, ESolicitud s, EMovimiento m where i.idSolicitud=s.id and s.id=m.solId and m.id=:idMovimiento", EInfoResult.class)
                .setParameter("idMovimiento", IdM)
                .getSingleResult();
    }


    public EInfoResult createInfoResult() {
        try {
            EInfoResult e = new EInfoResult();
            em.persist(e);
            em.detach(e);
            return e;
        }catch (Exception e){
            logger.info("Ocurrio un error en la creacion y persistencia de un nuevo InfoResult"+ e.getMessage(), e);
            return null;
        }
    }

    public boolean persist(EInfoResult in) {
        System.out.println("[INFO_RESULT_DAO] >> PERSIST EInfoResult <<");
        System.out.println("[INFO_RESULT_DAO] Datos a persistir:");
        System.out.println("  - Numero: " + in.getNumero());
        System.out.println("  - Descripcion: " + in.getDescripcion());
        System.out.println("  - IdSolicitud: " + in.getIdSolicitud());
        System.out.println("  - CantidadMovimientos: " + in.getCantidadMovimientos());
        System.out.println("  - MovimientosOk: " + in.getMovimientosOk());
        System.out.println("  - MovimientosError: " + in.getMovimientosError());
        if(in.getSolicitud() != null) {
            System.out.println("  - Solicitud.Id: " + in.getSolicitud().getId());
            System.out.println("  - Solicitud.Lote: " + in.getSolicitud().getLote());
            System.out.println("  - Solicitud.Movimientos.size: " + (in.getSolicitud().getMovimientos() != null ? in.getSolicitud().getMovimientos().size() : 0));
        }

        try{
            em.persist(in);
            System.out.println("[INFO_RESULT_DAO] >> EInfoResult PERSISTIDO EXITOSAMENTE <<");
            return true;
        }catch (Exception e){
            System.out.println("[INFO_RESULT_DAO] >> ERROR AL PERSISTIR EInfoResult: " + e.getMessage() + " <<");
            logger.error("No es posible persistir el objeto en la DB:"+e.getMessage(), e);
            logger.info(Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
            return false;
        }
    }

    public EInfoResult getInfoBySets(List<Integer> sets) {

        List<EInfoResult> results= em.createQuery("Select i from EInfoResult i, ESolicitud s, EMovimiento m where i.idSolicitud=s.id and s.id=m.solId and m.folio in (:sets)", EInfoResult.class)
                .setParameter("sets",sets)
                .getResultList();
        if(results.isEmpty()){
            return null;
        }
        else{
            return results.get(0);
        }
    }

    public EInfoResult getInfoByLote(int lote) {
        List<EInfoResult> results= em.createQuery("Select i from EInfoResult i, ESolicitud s, EMovimiento m where i.idSolicitud=s.id and s.id=m.solId and s.lote=:lote", EInfoResult.class)
                .setParameter("lote",lote)
                .getResultList();
        if(results.isEmpty()){
            return null;
        }
        else{
            return results.get(0);
        }
    }

    public EInfoResult getInfoByLoteAndSets(int lote, List<Integer> sets) {
        List<EInfoResult> results= em.createQuery("Select i from EInfoResult i, ESolicitud s, EMovimiento m where i.idSolicitud=s.id and s.id=m.solId and s.lote=:lote and m.folio in (:sets)", EInfoResult.class)
                .setParameter("lote",lote)
                .setParameter("sets",sets)
                .getResultList();
        if(results.isEmpty()){
            return null;
        }
        else{
            return results.get(0);
        }
    }

    public EInfoResult getInfoBySolicitudAndSets(Long idSolicitud, List<Integer> sets) {
        List<EInfoResult> results= em.createQuery("Select i from EInfoResult i, ESolicitud s, EMovimiento m where i.idSolicitud=s.id and s.id=m.solId and s.id=:idSol and m.folio in (:sets)", EInfoResult.class)
                .setParameter("idSol",idSolicitud)
                .setParameter("sets",sets)
                .getResultList();
        if(results.isEmpty()){
            return null;
        }
        else{
            return results.get(0);
        }

    }

    public EInfoResult getInfoBySolicitudAndLote(Long idSolicitud, int lote) {
        List<EInfoResult> results= em.createQuery("Select i from EInfoResult i, ESolicitud s, EMovimiento m where i.idSolicitud=s.id and s.id=m.solId and s.id=:idSol and s.lote=:lote", EInfoResult.class)
                .setParameter("idSol",idSolicitud)
                .setParameter("lote",lote)
                .getResultList();
        if(results.isEmpty()){
            return null;
        }
        else{
            return results.get(0);
        }
    }

    public EInfoResult getInfoBySolicitudAndLoteAndSets(Long idSolicitud, int lote, List<Integer> sets) {
        List<EInfoResult> results= em.createQuery("Select i from EInfoResult i, ESolicitud s, EMovimiento m where i.idSolicitud=s.id and s.id=m.solId and s.id=:idSol and s.lote=:lote and m.folio in (:sets)", EInfoResult.class)
                .setParameter("idSol", idSolicitud)
                .setParameter("lote",lote)
                .setParameter("sets",sets)
                .getResultList();
        if(results.isEmpty()){
            return null;
        }
        else{
            return results.get(0);
        }
    }

    public void persistSol(ESolicitud so) {
        System.out.println("[INFO_RESULT_DAO] >> PERSIST ESolicitud <<");
        System.out.println("[INFO_RESULT_DAO] Datos de ESolicitud a persistir:");
        System.out.println("  - ID: " + so.getId());
        System.out.println("  - TipoSolicitud: " + so.getTipoSolicitud());
        System.out.println("  - Estado: " + so.getEstado());
        System.out.println("  - Lote: " + so.getLote());
        System.out.println("  - PortalRut: " + so.getPortalRut());
        System.out.println("  - Usuario: " + so.getUsuario());
        System.out.println("  - Movimiento: " + so.getMovimiento());
        System.out.println("  - MovimientoId: " + so.getMovimientoId());
        System.out.println("  - FechaSolicitud: " + so.getFechaSolicitud());
        System.out.println("  - Movimientos asociados: " + (so.getMovimientos() != null ? so.getMovimientos().size() : 0));

        if(so.getMovimientos() != null && !so.getMovimientos().isEmpty()) {
            for(int i = 0; i < Math.min(3, so.getMovimientos().size()); i++) {
                EMovimiento mov = so.getMovimientos().get(i);
                System.out.println("  - Movimiento #" + (i+1) + ": Fila=" + mov.getFila() + ", IdError=" + mov.getIdError() + ", Desc=" + mov.getDescripcion());
            }
        }

        try{
            em.persist(so);
            System.out.println("[INFO_RESULT_DAO] >> ESolicitud PERSISTIDA EXITOSAMENTE con ID: " + so.getId() + " <<");

        }catch(Exception e){
            System.out.println("[INFO_RESULT_DAO] >> ERROR AL PERSISTIR ESolicitud: " + e.getMessage() + " <<");
            logger.info("Error "+e.getMessage(),e);
            e.printStackTrace();
        }
    }
    public void persistMov(EMovimiento mo){
        try {
            em.persist(mo);
        }catch(Exception e){
            logger.info("Error "+e.getMessage(),e);
        }
    }

    public Long getMaxSol() {
        try {
            List<Long> lista = em.createQuery("select max(i) from ESolicitud i", Long.class).getResultList();
            if (lista.isEmpty()) {
                return 1L;
            } else {
                Long l = Long.parseLong("" + (lista.get(0)));
                return l + 1L;
            }
        }catch(Exception e){
            return null;
        }
    }
}
