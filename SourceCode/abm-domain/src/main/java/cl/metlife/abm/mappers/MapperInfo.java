package cl.metlife.abm.mappers;

import cl.metlife.abm.domain.EInfoResult;
import cl.metlife.abm.domain.EMovimiento;
import cl.metlife.abm.domain.ESolicitud;
import cl.metlife.abm.ws.domain.ErrorNums;
import cl.metlife.abm.ws.domain.InfoResult;
import cl.metlife.abm.ws.domain.Movimiento;
import cl.metlife.abm.ws.domain.Solicitud;

import java.util.ArrayList;
import java.util.List;

public abstract class MapperInfo {




public static InfoResult mapperInfoResult(EInfoResult i){
    InfoResult infoResult = new InfoResult();
    if(i!=null) {
        List<Movimiento> movimientos = getMovimientosFromEMovList(i.getSolicitud().getMovimientos());
        Solicitud solicitud = mapperSolWithoutMovs(i.getSolicitud());
        solicitud.setMovimientos(movimientos);
        infoResult.setNumero(i.getNumero());
        infoResult.setDescripcion(i.getDescripcion());
        infoResult.setCantidadMovimientos(i.getCantidadMovimientos());
        infoResult.setMovimientosOk(i.getMovimientosOk());
        infoResult.setMovimientosError(i.getMovimientosError());
        infoResult.setSolicitud(solicitud);
    }
    else {
        infoResult.setNumero(ErrorNums.NO_DATA.getId());
        infoResult.setDescripcion(ErrorNums.NO_DATA.getNameError());
        infoResult.setMovimientosOk(0);
        infoResult.setCantidadMovimientos(0);
        infoResult.setMovimientosError(0);
    }
    return infoResult;
}
public static Movimiento mapperMovimiento(EMovimiento e){
    Movimiento m= new Movimiento();
    m.setId(e.getId());
    m.setIdError(e.getIdError());
    m.setDescripcion(e.getDescripcion());
    m.setFila(e.getFila());
    m.setFolio(e.getFolio());
    return m;
}
public static Solicitud mapperSolWithMovs(ESolicitud e){
    Solicitud s=singleMapperSol(e);
    List<Movimiento> movimientos =getMovimientosFromEMovList(e.getMovimientos());
    s.setMovimientos(movimientos);
    return s;
}
private static List<Movimiento> getMovimientosFromEMovList(List<EMovimiento> e){
    List<Movimiento> movimientos= new ArrayList<>();
    for (EMovimiento m:e) {
        movimientos.add(mapperMovimiento(m));
    }
    return movimientos;
}

public static Solicitud mapperSolWithoutMovs(ESolicitud e){
    return  singleMapperSol(e);
}
private static Solicitud singleMapperSol(ESolicitud e) {
    Solicitud s= new Solicitud();
    s.setIdSolicitud(e.getId());
    s.setTipoSolicitud(e.getTipoSolicitud());
    s.setEstado(e.getEstado());
    s.setMovimiento(e.getMovimiento());
    s.setMovimientoId(e.getMovimientoId());
    s.setLote(e.getLote());
    s.setFechaSolicitud(e.getFechaSolicitud());
    s.setFechaRecepcionCorredor(e.getFechaRecepcionCorredor());
    s.setPortalRut(e.getPortalRut());
    s.setPortalUsuario(e.getPortalUsuario());
    s.setUsuario(e.getUsuario());
    return s;
}

}
