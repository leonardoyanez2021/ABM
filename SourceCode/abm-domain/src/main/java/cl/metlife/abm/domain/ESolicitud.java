package cl.metlife.abm.domain;

import cl.blueprintsit.framework.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "ABM_ESOLICITUD")
public class ESolicitud extends BaseEntity implements Serializable {

    Long id;
    Date fechaSolicitud;
    Date fechaRecepcionCorredor;
    String tipoSolicitud;
    int movimientoId;
    String movimiento;
    String usuario;
    String portalRut;
    String portalUsuario;
    String estado;
    Long Lote;
    List<EMovimiento> movimientos;

    @Id
    @Column(name = "ID_SOL")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Basic
    @Column(name = "FECHA_SOL")
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    @Basic
    @Column(name = "FECHA_RECEP")
    public Date getFechaRecepcionCorredor() {
        return fechaRecepcionCorredor;
    }

    public void setFechaRecepcionCorredor(Date fechaRecepcionCorredor) {
        this.fechaRecepcionCorredor = fechaRecepcionCorredor;
    }

    @Basic
    @Column(name = "TIPO_SOL")
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    @Basic
    @Column(name = "MOV_ID")
    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }
    @Basic
    @Column(name = "MOV_NAME")
    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    @Basic
    @Column(name = "PORTAL_RUT")
    public String getPortalRut() {
        return portalRut;
    }

    public void setPortalRut(String portalRut) {
        this.portalRut = portalRut;
    }
    @Basic
    @Column(name = "USER_PORTAL")
    public String getPortalUsuario() {
        return portalUsuario;
    }

    public void setPortalUsuario(String portalUsuario) {
        this.portalUsuario = portalUsuario;
    }
    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Basic
    @Column(name = "LOTE")
    public Long getLote() {
        return Lote;
    }

    public void setLote(Long lote) {
        Lote = lote;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ID_SOL")
    public List<EMovimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<EMovimiento> movimientos) {
        this.movimientos = movimientos;
    }


}
