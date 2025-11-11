package cl.metlife.abm.domain;

import cl.blueprintsit.framework.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "ABM_EMOVIMIENTO")
public class EMovimiento extends BaseEntity implements Serializable {


    Long id;
    int fila;
    int idError;
    String descripcion;
    long folio;
    ESolicitud eSolicitud;
    Long solId;

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
    @Column(name = "FILA")
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
    @Basic
    @Column(name = "ERROR_ID")
    public int getIdError() {
        return idError;
    }

    public void setIdError(int id) {
        this.idError = id;
    }
    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Basic
    @Column(name = "FOLIO")
    public long getFolio() {
        return folio;
    }

    public void setFolio(long folio) {
        this.folio = folio;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SOL")
    public ESolicitud geteSolicitud() {
        return eSolicitud;
    }

    public void seteSolicitud(ESolicitud eSolicitud) {
        this.eSolicitud = eSolicitud;
    }
    @Basic
    @Column(name = "ID_SOL")
    public Long getSolId() {
        return solId;
    }

    public void setSolId(Long solId) {
        this.solId = solId;
    }
}
