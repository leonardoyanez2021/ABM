package cl.metlife.abm.domain;

import cl.blueprintsit.framework.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ABM_DESIGNACIONBENEFICIARIO")
public class DesignacionBeneficiario extends Operation implements Serializable {


    private Long numGrupo;
    private String vigDesde;
    private String vigHasta;
    private Long rutTitular;
    private String dvTitular;
    private Long rutCarga;
    private String dvCarga;
    private String nombre;
    private String apPat;
    private String apMat;
    private String fechaAC;
    private String relacion;
    private String sexo;
    private Long renta;
    private String tipoPersona;
    private String tipoB;
    private Long porcentaje;

    @Id
    @Column(name = "ROWID")
    @Override
    public String getRowId() {
        return super.getRowId();
    }

    @Override
    public void setRowId(String rowId) {
        super.setRowId(rowId);
    }

    @Basic
    @Column(name = "POLIZA")
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Basic
    @Column(name = "NUM_GRUPO")
    public Long getNumgrupo() {
        return numGrupo;
    }

    public void setNumgrupo(Long numgrupo) {
        this.numGrupo = numgrupo;
    }
    @Basic
    @Column(name = "VIGDESDE")
    public String getVigDesde() {
        return vigDesde;
    }

    public void setVigDesde(String vigDesde) {
        this.vigDesde = vigDesde;
    }
    @Basic
    @Column(name = "VIGHASTA")
    public String getVigHasta() {
        return vigHasta;
    }

    public void setVigHasta(String vigHasta) {
        this.vigHasta = vigHasta;
    }
    @Basic
    @Column(name = "RUT_TITULAR")
    public Long getRutTitular() {
        return rutTitular;
    }

    public void setRutTitular(Long rutTitular) {
        this.rutTitular = rutTitular;
    }
    @Basic
    @Column(name = "DV_TITULAR")
    public String getDvTitular() {
        return dvTitular;
    }

    public void setDvTitular(String dvTitular) {
        this.dvTitular = dvTitular;
    }
    @Basic
    @Column(name = "RUT_CARGA")
    public Long getRutCarga() {
        return rutCarga;
    }

    public void setRutCarga(Long rutCarga) {
        this.rutCarga = rutCarga;
    }
    @Basic
    @Column(name = "DV_CARGA")
    public String getDvCarga() {
        return dvCarga;
    }

    public void setDvCarga(String dvCarga) {
        this.dvCarga = dvCarga;
    }
    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Basic
    @Column(name = "AP_PATERNO")
    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }
    @Basic
    @Column(name = "AP_MATERNO")
    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }
    @Basic
    @Column(name = "FECHA_AC")
    public String getFechaAC() {
        return fechaAC;
    }

    public void setFechaAC(String fechaAC) {
        this.fechaAC = fechaAC;
    }
    @Basic
    @Column(name = "RELACION")
    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    @Basic
    @Column(name = "SEXO")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    @Basic
    @Column(name = "RENTA")
    public Long getRenta() {
        return renta;
    }

    public void setRenta(Long renta) {
        this.renta = renta;
    }
    @Basic
    @Column(name = "TIPO_PERSONA")
    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    @Basic
    @Column(name = "TIPO_B")
    public String getTipoB() {
        return tipoB;
    }

    public void setTipoB(String tipoB) {
        this.tipoB = tipoB;
    }
    @Basic
    @Column(name = "PORCENTAJE")
    public Long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Long porcentaje) {
        this.porcentaje = porcentaje;
    }
    @Basic
    @Column(name = "LOT_ID")

    public Long getLotID() {
        return super.lotId;
    }

    public void setLotID(Long lotID) {
        super.lotId= lotID;
    }
    @Basic
    @Column(name = "PROCESADO")
    public String getProcesado() {
        return procesado;
    }

    public void setProcesado(String procesado) {
        this.procesado = procesado;
    }

}
