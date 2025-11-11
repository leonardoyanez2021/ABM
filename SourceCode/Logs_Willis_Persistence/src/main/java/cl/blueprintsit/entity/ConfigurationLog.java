package cl.blueprintsit.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by BlueprintsIT on 4/28/2016.
 */
@Entity
@Table(name = "PREWEB_CONFIGURACION")
public class ConfigurationLog extends BaseEntity implements Serializable {

    private Long id;
    private String parametro ;
    private String valor ;
    private String descripcion ;
    private String editable;
    private String identidad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parametro", nullable = true, insertable = true, updatable = true)
    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Basic
    @Column(name = "valor", nullable = true, insertable = true, updatable = true)
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, insertable = true, updatable = true)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "editable", nullable = true, insertable = true, updatable = true)
    public String getEditable() {
            return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    @Basic
    @Column(name = "identidad", nullable = true, insertable = true, updatable = true)
    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }
}
