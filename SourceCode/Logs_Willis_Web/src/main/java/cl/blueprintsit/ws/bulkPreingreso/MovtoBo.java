
package cl.blueprintsit.ws.bulkPreingreso;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MovtoBo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MovtoBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PolizaNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GrupoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileNetCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MetlifeCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Titular" type="{http://preingreso.metlife.cl/}TitularBo" minOccurs="0"/>
 *         &lt;element name="Carga" type="{http://preingreso.metlife.cl/}CargaBo" minOccurs="0"/>
 *         &lt;element name="Corredor" type="{http://preingreso.metlife.cl/}CorredorBo" minOccurs="0"/>
 *         &lt;element name="Error" type="{http://preingreso.metlife.cl/}ErrorBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovtoBo", propOrder = {
    "bulkId",
    "polizaNumero",
    "grupoId",
    "lote",
    "barcode",
    "fileNetCodigo",
    "metlifeCodigo",
    "titular",
    "carga",
    "corredor",
    "error"
})
@XmlSeeAlso({
    MovtoBajaBo.class,
    MovtoAltaBo.class
})
public class MovtoBo {

    @XmlElement(name = "BulkId")
    protected int bulkId;
    @XmlElement(name = "PolizaNumero")
    protected int polizaNumero;
    @XmlElement(name = "GrupoId")
    protected int grupoId;
    @XmlElement(name = "Lote")
    protected String lote;
    @XmlElement(name = "Barcode")
    protected String barcode;
    @XmlElement(name = "FileNetCodigo")
    protected String fileNetCodigo;
    @XmlElement(name = "MetlifeCodigo")
    protected String metlifeCodigo;
    @XmlElement(name = "Titular")
    protected TitularBo titular;
    @XmlElement(name = "Carga")
    protected CargaBo carga;
    @XmlElement(name = "Corredor")
    protected CorredorBo corredor;
    @XmlElement(name = "Error")
    protected ErrorBo error;

    /**
     * Gets the value of the bulkId property.
     * 
     */
    public int getBulkId() {
        return bulkId;
    }

    /**
     * Sets the value of the bulkId property.
     * 
     */
    public void setBulkId(int value) {
        this.bulkId = value;
    }

    /**
     * Gets the value of the polizaNumero property.
     * 
     */
    public int getPolizaNumero() {
        return polizaNumero;
    }

    /**
     * Sets the value of the polizaNumero property.
     * 
     */
    public void setPolizaNumero(int value) {
        this.polizaNumero = value;
    }

    /**
     * Gets the value of the grupoId property.
     * 
     */
    public int getGrupoId() {
        return grupoId;
    }

    /**
     * Sets the value of the grupoId property.
     * 
     */
    public void setGrupoId(int value) {
        this.grupoId = value;
    }

    /**
     * Gets the value of the lote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLote() {
        return lote;
    }

    /**
     * Sets the value of the lote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLote(String value) {
        this.lote = value;
    }

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcode(String value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the fileNetCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileNetCodigo() {
        return fileNetCodigo;
    }

    /**
     * Sets the value of the fileNetCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileNetCodigo(String value) {
        this.fileNetCodigo = value;
    }

    /**
     * Gets the value of the metlifeCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetlifeCodigo() {
        return metlifeCodigo;
    }

    /**
     * Sets the value of the metlifeCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetlifeCodigo(String value) {
        this.metlifeCodigo = value;
    }

    /**
     * Gets the value of the titular property.
     * 
     * @return
     *     possible object is
     *     {@link TitularBo }
     *     
     */
    public TitularBo getTitular() {
        return titular;
    }

    /**
     * Sets the value of the titular property.
     * 
     * @param value
     *     allowed object is
     *     {@link TitularBo }
     *     
     */
    public void setTitular(TitularBo value) {
        this.titular = value;
    }

    /**
     * Gets the value of the carga property.
     * 
     * @return
     *     possible object is
     *     {@link CargaBo }
     *     
     */
    public CargaBo getCarga() {
        return carga;
    }

    /**
     * Sets the value of the carga property.
     * 
     * @param value
     *     allowed object is
     *     {@link CargaBo }
     *     
     */
    public void setCarga(CargaBo value) {
        this.carga = value;
    }

    /**
     * Gets the value of the corredor property.
     * 
     * @return
     *     possible object is
     *     {@link CorredorBo }
     *     
     */
    public CorredorBo getCorredor() {
        return corredor;
    }

    /**
     * Sets the value of the corredor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorredorBo }
     *     
     */
    public void setCorredor(CorredorBo value) {
        this.corredor = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorBo }
     *     
     */
    public ErrorBo getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorBo }
     *     
     */
    public void setError(ErrorBo value) {
        this.error = value;
    }

}
