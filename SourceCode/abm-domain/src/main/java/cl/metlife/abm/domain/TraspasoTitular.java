package cl.metlife.abm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ABM_TRASPASO_MULTICO")
public class TraspasoTitular extends Operation implements Serializable {

    private String polizaDest;
    private String numGruDest;
    private String fechaDesde;
    private String historialTopeLiquidaciones;

    @Basic
    @Column(name = "POLIZA_DESTINO")
    public String getPolizaDest(){return polizaDest;}

    public void setPolizaDest(String polizaDest) {this.polizaDest = polizaDest;}

    @Basic
    @Column(name = "GRUPO_DESTINO")
    public String getNumGruDest(){return numGruDest;}

    public void setNumGruDest(String numGruDest) {this.numGruDest = numGruDest;}

    @Basic
    @Column(name = "VIGENCIA_DESDE")
    public String getFechaDesde(){return fechaDesde;}

    public void setFechaDesde(String fechaDesde) {this.fechaDesde = fechaDesde;}

    @Basic
    @Column(name = "HISTORIA_TOPE_LIQUIDACION")
    public String getHistorialTopeLiquidaciones(){return historialTopeLiquidaciones;}

    public void setHistorialTopeLiquidaciones(String historialTopeLiquidaciones){this.historialTopeLiquidaciones = historialTopeLiquidaciones;}

    @Override
    public String toString() {
        return "traspaso titular "+ "[policy: " + id + ", ruttit: " + rutTit + "-" + dvTit +",policydestino: " + polizaDest +  ", lote: " + lote + ", lotid: " + lotId + "]";
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
    @Column(name = "GRUPO")
    @Override
    public String getNumGru() {
        return super.getNumGru();
    }

    @Override
    public void setNumGru(String numGru) {
        super.setNumGru(numGru);
    }

    @Basic
    @Column(name = "RUT_ASEGURADO")
    @Override
    public String getRutTit() {
        return super.getRutTit();
    }

    @Override
    public void setRutTit(String rutTit) {
        super.setRutTit(rutTit);
    }

    @Basic
    @Column(name = "DV_RUT_ASEGURADO")
    @Override
    public String getDvTit() {
        return super.getDvTit();
    }

    @Override
    public void setDvTit(String dvTit) {
        super.setDvTit(dvTit);
    }

    @Basic
    @Column(name = "CODIGO_DE_BARRA")
    @Override
    public String getCodigoBarra() {
        return super.getCodigoBarra();
    }

    @Override
    public void setCodigoBarra(String codigoBarra) {
        super.setCodigoBarra(codigoBarra);
    }

    @Basic
    @Column(name = "RUT_CORREDOR")
    @Override
    public String getRutCorredor() {
        return super.getRutCorredor();
    }

    @Override
    public void setRutCorredor(String rutCorredor) {
        super.setRutCorredor(rutCorredor);
    }

    @Basic
    @Column(name = "NOMBRE_CORREDOR")
    @Override
    public String getNombreCorredor() {
        return super.getNombreCorredor();
    }

    @Override
    public void setNombreCorredor(String nombreCorredor) {
        super.setNombreCorredor(nombreCorredor);
    }

    @Transient
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

    @Transient
    @Override
    public String getCodigoFilenet() {
        return super.getCodigoFilenet();
    }

    @Override
    public void setCodigoFilenet(String codigoFilenet) {
        super.setCodigoFilenet(codigoFilenet);
    }

    @Transient
    @Override
    public String getOtroDato() {
        return super.getOtroDato();
    }

    @Override
    public void setOtroDato(String otroDato) {
        super.setOtroDato(otroDato);
    }

    @Transient
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
