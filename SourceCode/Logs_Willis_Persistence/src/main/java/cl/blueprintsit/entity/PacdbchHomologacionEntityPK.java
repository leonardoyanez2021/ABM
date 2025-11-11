package cl.blueprintsit.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PacdbchHomologacionEntityPK implements Serializable {
    private long codProducto;
    private String tipoRiesgo;

    @Column(name = "COD_PRODUCTO")
    @Id
    public long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(long codProducto) {
        this.codProducto = codProducto;
    }

    @Column(name = "TIPO_RIESGO")
    @Id
    public String getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(String tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacdbchHomologacionEntityPK that = (PacdbchHomologacionEntityPK) o;
        return codProducto == that.codProducto &&
                Objects.equals(tipoRiesgo, that.tipoRiesgo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProducto, tipoRiesgo);
    }
}
