
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MovtoBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MovtoBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PolizaNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GrupoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GrupoNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileNetCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MetlifeCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Titular" type="{http://preingreso.metlife.cl/}TitularBo" minOccurs="0"/>
 *         &lt;element name="Carga" type="{http://preingreso.metlife.cl/}CargaBo" minOccurs="0"/>
 *         &lt;element name="Corredor" type="{http://preingreso.metlife.cl/}CorredorBo" minOccurs="0"/>
 *         &lt;element name="Error" type="{http://preingreso.metlife.cl/}ErrorBo" minOccurs="0"/>
 *         &lt;element name="Set" type="{http://preingreso.metlife.cl/}SetBo" minOccurs="0"/>
 *         &lt;element name="DetalleNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Estado" type="{http://preingreso.metlife.cl/}EstadoBo" minOccurs="0"/>
 *         &lt;element name="PortalRut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PortalUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "grupoNombre",
    "lote",
    "barcode",
    "fileNetCodigo",
    "metlifeCodigo",
    "titular",
    "carga",
    "corredor",
    "error",
    "set",
    "detalleNumero",
    "estado",
    "portalRut",
    "portalUsuario"
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
    @XmlElement(name = "GrupoNombre")
    protected String grupoNombre;
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
    @XmlElement(name = "Set")
    protected SetBo set;
    @XmlElement(name = "DetalleNumero", required = true, type = Integer.class, nillable = true)
    protected Integer detalleNumero;
    @XmlElement(name = "Estado")
    protected EstadoBo estado;
    @XmlElement(name = "PortalRut")
    protected String portalRut;
    @XmlElement(name = "PortalUsuario")
    protected String portalUsuario;

    /**
     * Obtiene el valor de la propiedad bulkId.
     * 
     */
    public int getBulkId() {
        return bulkId;
    }

    /**
     * Define el valor de la propiedad bulkId.
     * 
     */
    public void setBulkId(int value) {
        this.bulkId = value;
    }

    /**
     * Obtiene el valor de la propiedad polizaNumero.
     * 
     */
    public int getPolizaNumero() {
        return polizaNumero;
    }

    /**
     * Define el valor de la propiedad polizaNumero.
     * 
     */
    public void setPolizaNumero(int value) {
        this.polizaNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad grupoId.
     * 
     */
    public int getGrupoId() {
        return grupoId;
    }

    /**
     * Define el valor de la propiedad grupoId.
     * 
     */
    public void setGrupoId(int value) {
        this.grupoId = value;
    }

    /**
     * Obtiene el valor de la propiedad grupoNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrupoNombre() {
        return grupoNombre;
    }

    /**
     * Define el valor de la propiedad grupoNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrupoNombre(String value) {
        this.grupoNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad lote.
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
     * Define el valor de la propiedad lote.
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
     * Obtiene el valor de la propiedad barcode.
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
     * Define el valor de la propiedad barcode.
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
     * Obtiene el valor de la propiedad fileNetCodigo.
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
     * Define el valor de la propiedad fileNetCodigo.
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
     * Obtiene el valor de la propiedad metlifeCodigo.
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
     * Define el valor de la propiedad metlifeCodigo.
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
     * Obtiene el valor de la propiedad titular.
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
     * Define el valor de la propiedad titular.
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
     * Obtiene el valor de la propiedad carga.
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
     * Define el valor de la propiedad carga.
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
     * Obtiene el valor de la propiedad corredor.
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
     * Define el valor de la propiedad corredor.
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
     * Obtiene el valor de la propiedad error.
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
     * Define el valor de la propiedad error.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorBo }
     *     
     */
    public void setError(ErrorBo value) {
        this.error = value;
    }

    /**
     * Obtiene el valor de la propiedad set.
     * 
     * @return
     *     possible object is
     *     {@link SetBo }
     *     
     */
    public SetBo getSet() {
        return set;
    }

    /**
     * Define el valor de la propiedad set.
     * 
     * @param value
     *     allowed object is
     *     {@link SetBo }
     *     
     */
    public void setSet(SetBo value) {
        this.set = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleNumero.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDetalleNumero() {
        return detalleNumero;
    }

    /**
     * Define el valor de la propiedad detalleNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDetalleNumero(Integer value) {
        this.detalleNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoBo }
     *     
     */
    public EstadoBo getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoBo }
     *     
     */
    public void setEstado(EstadoBo value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad portalRut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalRut() {
        return portalRut;
    }

    /**
     * Define el valor de la propiedad portalRut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalRut(String value) {
        this.portalRut = value;
    }

    /**
     * Obtiene el valor de la propiedad portalUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalUsuario() {
        return portalUsuario;
    }

    /**
     * Define el valor de la propiedad portalUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalUsuario(String value) {
        this.portalUsuario = value;
    }

}
