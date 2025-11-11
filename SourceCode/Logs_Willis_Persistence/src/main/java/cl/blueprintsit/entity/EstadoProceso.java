package cl.blueprintsit.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by BlueprintsIT on 5/4/2016.
 */
@Entity
@Table(name = "PREWEB_ESTADO_PROCESO")
public class EstadoProceso extends BaseEntity implements Serializable {

    private Long id;
    private String estado ;
    private String nombre ;

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
    @Column(name = "estado", nullable = true, insertable = true, updatable = true)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Basic
    @Column(name = "nombre", nullable = true, insertable = true, updatable = true)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
