package cl.metlife.abm.domain;

import cl.blueprintsit.framework.domain.BaseEntity;
import cl.metlife.abm.ws.domain.ErrorNums;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ABM_EINFORESULT")
public class EInfoResult extends BaseEntity implements Serializable {
    Long id;
    int numero;
    // Descripción = descripción del error en caso de existir.
    String descripcion;
    //CantidadMovimientos = Cantidad de movimientos de la carga masiva.
    int cantidadMovimientos;
    // MovimientosError = Cantidad de Movimientos con error.
    int movimientosError;
    // MovimientosOk = Cantidad de Movimientos sin error.
    int movimientosOk;
    // Solicitud = Solicitud asociada a la carga masiva. Siempre es una solicitud por carga masiva
    ESolicitud solicitud;
    Long idSolicitud;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Basic
    @Column(name = "NUM_ERROR")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Basic
    @Column(name = "DESC_ERROR")
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Basic
    @Column(name = "CANT_MOV")
    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos(int cantidadMovimientos) {
        this.cantidadMovimientos = cantidadMovimientos;
    }
    @Basic
    @Column(name = "CANT_MOV_ERROR")
    public int getMovimientosError() {
        return movimientosError;
    }

    public void setMovimientosError(int movimientosError) {
        this.movimientosError = movimientosError;
    }
    @Basic
    @Column(name = "CANT_MOV_OK")
    public int getMovimientosOk() {
        return movimientosOk;
    }

    public void setMovimientosOk(int movimientosOk) {
        this.movimientosOk = movimientosOk;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ID_SOL")
    public ESolicitud getSolicitud() {
        return solicitud;
    }
    public void setSolicitud(ESolicitud solicitud) {
        this.solicitud = solicitud;
    }
    @Basic
    @Column(name = "ID_SOL")
    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public void setErrorNum(ErrorNums n){
        this.setNumero(n.getId());
        this.setDescripcion(n.getNameError());
    }
}
