package cl.metlife.abm.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by BluePrints Developer on 22-05-2017.
 */
@Entity
@Table(name = "ABM_TESTALTATITULAR")
public class AltaTitular extends Operation implements Serializable {
    private String fechaDesde;
    private String fechaHasta;
    private String rutCar;
    private String dvCar;
    private String pat;
    private String mat;
    private String nom;
    private String fechaNacimiento;
    private String rel;
    private String sex;
    private String renta;
    private String capital;
    private String peso;
    private String estatura;
    private String preExistencia;
    private String banco;
    private String tipoCuenta;
    private String numeroCuenta;
    private String email;
    private String celular;

    @Basic
    @Column(name = "VDESDE")
    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    @Basic
    @Column(name = "VHASTA")
    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Basic
    @Column(name = "RUTCARGA")
    public String getRutCar() {
        return rutCar;
    }

    public void setRutCar(String rutCar) {
        this.rutCar = rutCar;
    }

    @Basic
    @Column(name = "DVCARGA")
    public String getDvCar() {
        return dvCar;
    }

    public void setDvCar(String dvCar) {
        this.dvCar = dvCar;
    }

    @Basic
    @Column(name = "PATERNO")
    public String getPat() {
        return pat;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }

    @Basic
    @Column(name = "MATERNO")
    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "FNACIMIENTO")
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "RELACION")
    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Basic
    @Column(name = "SEXO")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "RENTA")
    public String getRenta() {
        return renta;
    }

    public void setRenta(String renta) {
        this.renta = renta;
    }

    @Basic
    @Column(name = "CAPITAL")
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "PESO")
    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Basic
    @Column(name = "ESTATURA")
    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    @Basic
    @Column(name = "PREEXISTENCIA")
    public String getPreExistencia() {
        return preExistencia;
    }

    public void setPreExistencia(String preExistencia) {
        this.preExistencia = preExistencia;
    }

    @Basic
    @Column(name = "BANCO")
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Basic
    @Column(name = "TIPODECUENTA")
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Basic
    @Column(name = "NUMEROCUENTA")
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "CELULAR")
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "alta titular "+ "[policy: " + id + ", ruttit: " + rutTit + "-" + dvTit + ", nombre: " + nom + pat + mat + ", lote: " + lote + ", lotid: " + lotId + "]";
    }

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
    @Column(name = "NUMGRUP")
    @Override
    public String getNumGru() {
        return super.getNumGru();
    }

    @Override
    public void setNumGru(String numGru) {
        super.setNumGru(numGru);
    }

    @Basic
    @Column(name = "RUTTITULAR")
    @Override
    public String getRutTit() {
        return super.getRutTit();
    }

    @Override
    public void setRutTit(String rutTit) {
        super.setRutTit(rutTit);
    }

    @Basic
    @Column(name = "DVTITUTAR")
    @Override
    public String getDvTit() {
        return super.getDvTit();
    }

    @Override
    public void setDvTit(String dvTit) {
        super.setDvTit(dvTit);
    }

    @Basic
    @Column(name = "CODBARRA")
    @Override
    public String getCodigoBarra() {
        return super.getCodigoBarra();
    }

    @Override
    public void setCodigoBarra(String codigoBarra) {
        super.setCodigoBarra(codigoBarra);
    }

    @Basic
    @Column(name = "RUTCORREDOR")
    @Override
    public String getRutCorredor() {
        return super.getRutCorredor();
    }

    @Override
    public void setRutCorredor(String rutCorredor) {
        super.setRutCorredor(rutCorredor);
    }

    @Basic
    @Column(name = "NOMBRECORREDOR")
    @Override
    public String getNombreCorredor() {
        return super.getNombreCorredor();
    }

    @Override
    public void setNombreCorredor(String nombreCorredor) {
        super.setNombreCorredor(nombreCorredor);
    }

    @Basic
    @Column(name = "FECHAHORACARGA")
    @Override
    public String getFechaHoraCarga() {
        return super.getFechaHoraCarga();
    }

    @Override
    public void setFechaHoraCarga(String fechaHoraCarga) {
        super.setFechaHoraCarga(fechaHoraCarga);
    }

    @Basic
    @Column(name = "LOTE")
    @Override
    public Long getLote() {
        return super.getLote();
    }

    @Override
    public void setLote(Long lote) {
        super.setLote(lote);
    }

    @Basic
    @Column(name = "CODIGOFILENET")
    @Override
    public String getCodigoFilenet() {
        return super.getCodigoFilenet();
    }

    @Override
    public void setCodigoFilenet(String codigoFilenet) {
        super.setCodigoFilenet(codigoFilenet);
    }

    @Basic
    @Column(name = "OTRODATO")
    @Override
    public String getOtroDato() {
        return super.getOtroDato();
    }

    @Override
    public void setOtroDato(String otroDato) {
        super.setOtroDato(otroDato);
    }

    @Basic
    @Column(name = "IDCARGA")
    @Override
    public Long getIdCarga() {
        return super.getIdCarga();
    }

    @Override
    public void setIdCarga(Long idCarga) {
        super.setIdCarga(idCarga);
    }

    @Basic
    @Column(name = "PROCESADO")
    @Override
    public String getProcesado() {
        return super.getProcesado();
    }

    @Override
    public void setProcesado(String procesado) {
        super.setProcesado(procesado);
    }

    @Basic
    @Column(name = "LOT_ID")
    @Override
    public Long getLotId() {
        return super.getLotId();
    }

    @Override
    public void setLotId(Long lotId) {
        super.setLotId(lotId);
    }
}