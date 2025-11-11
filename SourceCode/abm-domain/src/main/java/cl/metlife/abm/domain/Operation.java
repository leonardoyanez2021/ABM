package cl.metlife.abm.domain;

import cl.blueprintsit.framework.domain.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class Operation extends BaseEntity implements Serializable
{
    protected Long id; // POLICY
    protected String numGru;
    protected String rutTit;
    protected String dvTit;
    protected Long lote;
    protected String codigoBarra;
    protected String rutCorredor;
    protected String nombreCorredor;
    protected String fechaHoraCarga;
    protected String codigoFilenet;
    protected String otroDato;
    protected Long idCarga;
    protected String procesado;
    protected Long lotId;

    protected String rowId;

    public String getRowId() {return rowId;}
    public void setRowId(String rowId){this.rowId=rowId;}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getNumGru(){return numGru;}
    public void setNumGru(String numGru){this.numGru=numGru;}

    public String getRutTit(){return rutTit;}
    public void setRutTit(String rutTit){this.rutTit=rutTit;}

    public String getDvTit(){return dvTit;}
    public void setDvTit(String dvTit){this.dvTit=dvTit;}

    public String getCodigoBarra(){return codigoBarra;}
    public void setCodigoBarra(String codigoBarra){this.codigoBarra=codigoBarra;}

    public String getRutCorredor(){return rutCorredor;}
    public void setRutCorredor(String rutCorredor){this.rutCorredor=rutCorredor;}

    public String getNombreCorredor(){return nombreCorredor;}
    public void setNombreCorredor(String nombreCorredor){this.nombreCorredor=nombreCorredor;}

    public String getFechaHoraCarga(){return fechaHoraCarga;}
    public void setFechaHoraCarga(String fechaHoraCarga){this.fechaHoraCarga=fechaHoraCarga;}

    public Long getLote(){return lote;}
    public void setLote(Long lote){this.lote=lote;}

    public String getCodigoFilenet(){return codigoFilenet;}
    public void setCodigoFilenet(String codigoFilenet){this.codigoFilenet=codigoFilenet;}

    public String getOtroDato(){return otroDato;}
    public void setOtroDato(String otroDato){this.otroDato=otroDato;}

    public Long getIdCarga(){return idCarga;}
    public void setIdCarga(Long idCarga){this.idCarga=idCarga;}

    public String getProcesado(){return procesado;}
    public void setProcesado(String procesado){this.procesado=procesado;}

    public Long getLotId(){return lotId;}
    public void setLotId(Long lotId){this.lotId=lotId;}
}
