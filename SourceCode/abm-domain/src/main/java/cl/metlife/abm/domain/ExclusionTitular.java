package cl.metlife.abm.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by BluePrints Developer on 22-05-2017.
 */
@Entity
@Table(name = "ABM_TESTEXCLUIRTITULAR")
public class ExclusionTitular extends Operation implements Serializable {
    private String fechaHasta;

    @Basic
    @Column(name = "VHASTA")
    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "baja titular "+ "[policy: " + super.id + ", ruttit: " + super.rutTit + "-" + super.dvTit + ", lote: " + super.lote + ", lotid: " + super.lotId + "]";
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