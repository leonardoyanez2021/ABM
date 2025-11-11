package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.domain.EInfoResult;
import cl.metlife.abm.domain.EMovimiento;
import cl.metlife.abm.domain.ESolicitud;
import cl.metlife.abm.mappers.MapperInfo;
import cl.metlife.abm.ws.domain.InfoResult;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class InfoCargaMovDAO {


    @EJB
    MovimientoDAO movimientoDAO;

    @EJB
    SolicitudDAO solicitudDAO;

    @EJB
    InfoResultDAO infoResultDAO;

    public EMovimiento getMovimientoById(Long id) {
        return movimientoDAO.getById(id);
    }
    public List<EMovimiento> getMovimientosBySolicitud(ESolicitud es){
        return movimientoDAO.getMovimientosBySolicitud(es);
    }
    public List<EMovimiento> getMovimientosByLote(int Lote) {
        return movimientoDAO.getMovimientosByLote(Lote);
    }
    public List<EMovimiento> getMovimientosByLoteAndSolicitud(int Lote, ESolicitud e) {
        return movimientoDAO.getMovimientosByLoteAndSolicitud(Lote, e);
    }
    public ESolicitud getSolById(Long id){
        return solicitudDAO.getById(id);
    }

    public EInfoResult createInfoResult(){
        return  infoResultDAO.createInfoResult();
    }
    public InfoResult getInfoBySets(List<Integer> sets) {
        return MapperInfo.mapperInfoResult(infoResultDAO.getInfoBySets(sets));
    }
    public InfoResult getInfoByLote(int lote) {
        return MapperInfo.mapperInfoResult(infoResultDAO.getInfoByLote(lote));
    }
    public InfoResult getInfoByLoteAndSets(int lote, List<Integer> sets) {
        return MapperInfo.mapperInfoResult(infoResultDAO.getInfoByLoteAndSets(lote, sets));
    }

    public InfoResult getInfoBySolicitud(Long idSolicitud) {
        return MapperInfo.mapperInfoResult(infoResultDAO.getInfoBySolicitud(idSolicitud));
    }

    public InfoResult getInfoBySolicitudAndSets(Long idSolicitud, List<Integer> sets) {
        return MapperInfo.mapperInfoResult(infoResultDAO.getInfoBySolicitudAndSets(idSolicitud,sets));
    }

    public InfoResult getInfoBySolicitudAndLote(Long idSolicitud, int lote) {
        return MapperInfo.mapperInfoResult(infoResultDAO.getInfoBySolicitudAndLote(idSolicitud,lote));
    }

    public InfoResult getInfoBySolicitudAndLoteAndSets(Long idSolicitud, int lote, List<Integer> sets) {
        return MapperInfo.mapperInfoResult(infoResultDAO.getInfoBySolicitudAndLoteAndSets(idSolicitud,lote,sets));
    }
}
