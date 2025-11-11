package cl.metlife.abm.domain;

import cl.blueprintsit.framework.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by BluePrints Developer on 09-08-2018.
 */
@Entity
@Table(name = "ABM_TIPO_RANGO")
public class RangoType extends BaseEntity implements Serializable {

    static final public Long DIARIO = 1L;
    static final public Long SEMANAL = 2L;
    static final public Long MENSUAL = 3L;
    static final public Long ANUAL = 4L;
    private Long id;
    private String name;

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
    @Column(name = "NOMBRE")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
