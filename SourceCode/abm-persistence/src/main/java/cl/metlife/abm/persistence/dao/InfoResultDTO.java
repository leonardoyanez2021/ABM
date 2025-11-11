package cl.metlife.abm.persistence.dao;

import cl.metlife.abm.ws.domain.ErrorNums;
import cl.metlife.abm.ws.domain.InfoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class InfoResultDTO {
// se encarga del parsering entre DTO y DAO
    static final Logger LOGGER = LoggerFactory.getLogger(InfoResultDTO.class);

    @EJB
    InfoCargaMovDAO infoCargaMovDAO;


    public InfoResult getInfoResult(Long idSolicitud, int lote, List<Integer> sets){
        InfoResult info= new InfoResult();

        //chorrera de if's
        LOGGER.info(String.format("idSolicitud: %d, lote: %d, sets: %s", idSolicitud, lote, sets));

        if(idSolicitud==null || idSolicitud==0L){
            if(lote==0){
                if(sets ==null){
                // caso sin data retorno un objeto sin datos y con codigo "objeto en blanco"
                    info.setNumero(ErrorNums.EMPTY_3.getId());
                    info.setDescripcion(ErrorNums.EMPTY_3.getNameError());
                    info.setMovimientosError(0);
                    info.setCantidadMovimientos(0);
                    info.setMovimientosOk(0);
                    return info;
                }else{
                    if(sets.isEmpty()){
                        info.setNumero(ErrorNums.EMPTY_3.getId());
                        info.setDescripcion(ErrorNums.EMPTY_3.getNameError());
                        info.setMovimientosError(0);
                        info.setCantidadMovimientos(0);
                        info.setMovimientosOk(0);
                        return info;
                    }else {
                        return infoCargaMovDAO.getInfoBySets(sets);
                        //existe una lista de sets con folio
                    }

                }
            }else{
                if(sets ==null || sets.isEmpty() || sets.get(0)==0){
                    return infoCargaMovDAO.getInfoByLote(lote);
                }else{
                    return infoCargaMovDAO.getInfoByLoteAndSets(lote,sets);
                }
            }

        }else{
            if(lote==0){
                if(sets==null || sets.isEmpty() || sets.get(0)==0){
                    return infoCargaMovDAO.getInfoBySolicitud(idSolicitud);
                }else{
                    System.out.println(sets);
                    return infoCargaMovDAO.getInfoBySolicitudAndSets(idSolicitud,sets);
                }
            }else{
                if(sets==null || sets.isEmpty() || sets.get(0)==0){
                    return infoCargaMovDAO.getInfoBySolicitudAndLote(idSolicitud,lote);
                }else{
                    return infoCargaMovDAO.getInfoBySolicitudAndLoteAndSets(idSolicitud, lote, sets);
                }
            }
        }
    }
    public InfoResult createInfoResult(){
        return new InfoResult(infoCargaMovDAO.createInfoResult());
    }



}
