package cl.metlife.abm.ws.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solicitud {
    private Long idSolicitud;
    private Date fechaSolicitud;
    private Date fechaRecepcionCorredor;
    private String tipoSolicitud;
    private int movimientoId;
    private String movimiento;
    private String usuario;
    private String portalRut;
    private String portalUsuario;
    private String estado;
    private Long lote;
    private List<Movimiento> movimientos;

    public Solicitud(Long idSolicitud, Date fechaSolicitud, Date fechaRecepcionCorredor, String tipoSolicitud, int movimientoId, String movimiento, String usuario, String portalRut, String portalUsuario, String estado, Long lote, List<Movimiento> movimientos) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRecepcionCorredor = fechaRecepcionCorredor;
        this.tipoSolicitud = tipoSolicitud;
        this.movimientoId = movimientoId;
        this.movimiento = movimiento;
        this.usuario = usuario;
        this.portalRut = portalRut;
        this.portalUsuario = portalUsuario;
        this.estado = estado;
        this.lote = lote;
        this.movimientos = movimientos;
    }

    public Solicitud(Solicitud s) {
        this.idSolicitud = s.getIdSolicitud();
        this.fechaSolicitud = s.getFechaSolicitud();
        this.fechaRecepcionCorredor = s.getFechaRecepcionCorredor();
        this.tipoSolicitud = s.getTipoSolicitud();
        this.movimientoId = s.getMovimientoId();
        this.movimiento = s.getMovimiento();
        this.usuario = s.getUsuario();
        this.portalRut = s.getPortalRut();
        this.portalUsuario = s.getPortalUsuario();
        this.estado = s.getEstado();
        this.lote = s.getLote();
        this.movimientos = s.getMovimientos();

    }

    public Solicitud() {
        this.idSolicitud = 0L;
        this.fechaSolicitud = new Date();
        this.fechaRecepcionCorredor = new Date();
        this.tipoSolicitud ="";
        this.movimientoId = 0;
        this.movimiento = "";
        this.usuario = "";
        this.portalRut = "";
        this.portalUsuario = "";
        this.estado="";
        this.lote = 0L;
        this.movimientos = new ArrayList<>();
    }

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaRecepcionCorredor() {
        return fechaRecepcionCorredor;
    }

    public void setFechaRecepcionCorredor(Date fechaRecepcionCorredor) {
        this.fechaRecepcionCorredor = fechaRecepcionCorredor;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPortalRut() {
        return portalRut;
    }

    public void setPortalRut(String portalRut) {
        this.portalRut = portalRut;
    }

    public String getPortalUsuario() {
        return portalUsuario;
    }

    public void setPortalUsuario(String portalUsuario) {
        this.portalUsuario = portalUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getLote() {
        return lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "idSolicitud=" + idSolicitud +
                ", fechaSolicitud=" + fechaSolicitud +
                ", fechaRecepcionCorredor=" + fechaRecepcionCorredor +
                ", tipoSolicitud='" + tipoSolicitud + '\'' +
                ", movimientoId=" + movimientoId +
                ", movimiento='" + movimiento + '\'' +
                ", usuario='" + usuario + '\'' +
                ", portalRut='" + portalRut + '\'' +
                ", portalUsuario='" + portalUsuario + '\'' +
                ", estado='" + estado + '\'' +
                ", lote=" + lote +
                ", movimientos=" + movimientosToString() +
                '}';
    }
    private String movimientosToString(){
        StringBuilder sb = new StringBuilder();

        for (Movimiento m:movimientos) {
           sb.append(m.toString()).append("\n");
        }
        return sb.toString();

    }

}
