package cl.blueprintsit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PACDBCH_HOMOLOGACION", schema = "SALUD", catalog = "")
@IdClass(PacdbchHomologacionEntityPK.class)
public class PacdbchHomologacionEntity {
    private long codProducto;
    private String descProducto;
    private String tipoRiesgo;
    private String descRiesgo;
    private String fechaCreacion;
    private String horaCreacion;
    private String fechaActualizacion;
    private String horaActualizacion;

    @Id
    @Column(name = "COD_PRODUCTO")
    public long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(long codProducto) {
        this.codProducto = codProducto;
    }

    @Basic
    @Column(name = "DESC_PRODUCTO")
    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    @Id
    @Column(name = "TIPO_RIESGO")
    public String getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(String tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

    @Basic
    @Column(name = "DESC_RIESGO")
    public String getDescRiesgo() {
        return descRiesgo;
    }

    public void setDescRiesgo(String descRiesgo) {
        this.descRiesgo = descRiesgo;
    }

    @Basic
    @Column(name = "FECHA_CREACION")
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "HORA_CREACION")
    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    @Basic
    @Column(name = "FECHA_ACTUALIZACION")
    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @Basic
    @Column(name = "HORA_ACTUALIZACION")
    public String getHoraActualizacion() {
        return horaActualizacion;
    }

    public void setHoraActualizacion(String horaActualizacion) {
        this.horaActualizacion = horaActualizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacdbchHomologacionEntity that = (PacdbchHomologacionEntity) o;
        return codProducto == that.codProducto &&
                Objects.equals(descProducto, that.descProducto) &&
                Objects.equals(tipoRiesgo, that.tipoRiesgo) &&
                Objects.equals(descRiesgo, that.descRiesgo) &&
                Objects.equals(fechaCreacion, that.fechaCreacion) &&
                Objects.equals(horaCreacion, that.horaCreacion) &&
                Objects.equals(fechaActualizacion, that.fechaActualizacion) &&
                Objects.equals(horaActualizacion, that.horaActualizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProducto, descProducto, tipoRiesgo, descRiesgo, fechaCreacion, horaCreacion, fechaActualizacion, horaActualizacion);
    }
}
