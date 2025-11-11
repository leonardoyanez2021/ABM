
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para MovtoTraspasoBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MovtoTraspasoBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Dv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolizaNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GrupoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PolizaNumeroDestino" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GrupoIdDestino" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="HistoriaTopesLiquidaciones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoBarraFormulario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Corredor" type="{http://preingreso.metlife.cl/}CorredorBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovtoTraspasoBo", propOrder = {
    "bulkId",
    "rut",
    "dv",
    "polizaNumero",
    "grupoId",
    "polizaNumeroDestino",
    "grupoIdDestino",
    "fechaInicioVigencia",
    "historiaTopesLiquidaciones",
    "lote",
    "codigoBarraFormulario",
    "corredor"
})
public class MovtoTraspasoBo {

    @XmlElement(name = "BulkId")
    protected int bulkId;
    @XmlElement(name = "Rut")
    protected int rut;
    @XmlElement(name = "Dv")
    protected String dv;
    @XmlElement(name = "PolizaNumero")
    protected int polizaNumero;
    @XmlElement(name = "GrupoId")
    protected int grupoId;
    @XmlElement(name = "PolizaNumeroDestino")
    protected int polizaNumeroDestino;
    @XmlElement(name = "GrupoIdDestino")
    protected int grupoIdDestino;
    @XmlElement(name = "FechaInicioVigencia", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioVigencia;
    @XmlElement(name = "HistoriaTopesLiquidaciones")
    protected int historiaTopesLiquidaciones;
    @XmlElement(name = "Lote")
    protected String lote;
    @XmlElement(name = "CodigoBarraFormulario")
    protected String codigoBarraFormulario;
    @XmlElement(name = "Corredor")
    protected CorredorBo corredor;

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
     * Obtiene el valor de la propiedad rut.
     * 
     */
    public int getRut() {
        return rut;
    }

    /**
     * Define el valor de la propiedad rut.
     * 
     */
    public void setRut(int value) {
        this.rut = value;
    }

    /**
     * Obtiene el valor de la propiedad dv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDv() {
        return dv;
    }

    /**
     * Define el valor de la propiedad dv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDv(String value) {
        this.dv = value;
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
     * Obtiene el valor de la propiedad polizaNumeroDestino.
     * 
     */
    public int getPolizaNumeroDestino() {
        return polizaNumeroDestino;
    }

    /**
     * Define el valor de la propiedad polizaNumeroDestino.
     * 
     */
    public void setPolizaNumeroDestino(int value) {
        this.polizaNumeroDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad grupoIdDestino.
     * 
     */
    public int getGrupoIdDestino() {
        return grupoIdDestino;
    }

    /**
     * Define el valor de la propiedad grupoIdDestino.
     * 
     */
    public void setGrupoIdDestino(int value) {
        this.grupoIdDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicioVigencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    /**
     * Define el valor de la propiedad fechaInicioVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicioVigencia(XMLGregorianCalendar value) {
        this.fechaInicioVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad historiaTopesLiquidaciones.
     * 
     */
    public int getHistoriaTopesLiquidaciones() {
        return historiaTopesLiquidaciones;
    }

    /**
     * Define el valor de la propiedad historiaTopesLiquidaciones.
     * 
     */
    public void setHistoriaTopesLiquidaciones(int value) {
        this.historiaTopesLiquidaciones = value;
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
     * Obtiene el valor de la propiedad codigoBarraFormulario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBarraFormulario() {
        return codigoBarraFormulario;
    }

    /**
     * Define el valor de la propiedad codigoBarraFormulario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBarraFormulario(String value) {
        this.codigoBarraFormulario = value;
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

}
