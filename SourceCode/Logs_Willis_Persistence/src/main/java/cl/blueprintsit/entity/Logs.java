package cl.blueprintsit.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by BlueprintsIT on 5/3/2016.
 */
@Entity
@Table(name = "PREWEB_LOG")
public class Logs extends BaseEntity implements Serializable {

    private Long id;
    private String mensaje ;
    private Date fecha ;
    private String tipo ;
    private String proceso ;
    private String rutCorredor;
    private int lote;

    @Id
    @SequenceGenerator(name="ADDRESS_SEQUENCE_GENERATOR", sequenceName="PREWEB_LOGSEQUENCE")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_SEQUENCE_GENERATOR")
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MENSAJE", nullable = true, insertable = true, updatable = true)
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Basic
    @Column(name = "FECHA", nullable = true, insertable = true, updatable = true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "TIPO", nullable = true, insertable = true, updatable = true)
    public String getTipo() {
        return tipo;
    }

     public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "PROCESO", nullable = true, insertable = true, updatable = true)
    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    @Basic
    @Column(name = "RUT_CORREDOR", nullable = true, insertable = true, updatable = true)
    public String getRutCorredor() {
        return rutCorredor;
    }

    public void setRutCorredor(String rutCorredor) {
        this.rutCorredor = rutCorredor;
    }


    @Basic
    @Column(name = "LOTE", nullable = true, insertable = true, updatable = true)
    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }
}
