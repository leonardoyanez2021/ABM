
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para DmMovtoAltaBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DmMovtoAltaBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PolizaNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GrupoNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Titular" type="{http://preingreso.metlife.cl/}DmTitularBo" minOccurs="0"/>
 *         &lt;element name="Carga" type="{http://preingreso.metlife.cl/}DmCargaBo" minOccurs="0"/>
 *         &lt;element name="Observacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoBeneficiario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Porcentaje" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaTerminoVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Capital" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Renta" type="{http://preingreso.metlife.cl/}DmRentaBo" minOccurs="0"/>
 *         &lt;element name="Tercero" type="{http://preingreso.metlife.cl/}DmTerceroBo" minOccurs="0"/>
 *         &lt;element name="Cobranza" type="{http://preingreso.metlife.cl/}DmCobranzaBo" minOccurs="0"/>
 *         &lt;element name="Venta" type="{http://preingreso.metlife.cl/}DmVentaBo" minOccurs="0"/>
 *         &lt;element name="PortalRut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PortalUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Corredor" type="{http://preingreso.metlife.cl/}DmCorredorBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DmMovtoAltaBo", propOrder = {
    "bulkId",
    "polizaNumero",
    "grupoNumero",
    "titular",
    "carga",
    "observacion",
    "tipoPersona",
    "tipoBeneficiario",
    "porcentaje",
    "fechaInicioVigencia",
    "fechaTerminoVigencia",
    "capital",
    "renta",
    "tercero",
    "cobranza",
    "venta",
    "portalRut",
    "portalUsuario",
    "corredor"
})
public class DmMovtoAltaBo {

    @XmlElement(name = "BulkId")
    protected int bulkId;
    @XmlElement(name = "PolizaNumero")
    protected int polizaNumero;
    @XmlElement(name = "GrupoNumero")
    protected int grupoNumero;
    @XmlElement(name = "Titular")
    protected DmTitularBo titular;
    @XmlElement(name = "Carga")
    protected DmCargaBo carga;
    @XmlElement(name = "Observacion")
    protected String observacion;
    @XmlElement(name = "TipoPersona")
    protected String tipoPersona;
    @XmlElement(name = "TipoBeneficiario")
    protected String tipoBeneficiario;
    @XmlElement(name = "Porcentaje")
    protected int porcentaje;
    @XmlElement(name = "FechaInicioVigencia", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioVigencia;
    @XmlElement(name = "FechaTerminoVigencia", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaTerminoVigencia;
    @XmlElement(name = "Capital", required = true, type = Double.class, nillable = true)
    protected Double capital;
    @XmlElement(name = "Renta")
    protected DmRentaBo renta;
    @XmlElement(name = "Tercero")
    protected DmTerceroBo tercero;
    @XmlElement(name = "Cobranza")
    protected DmCobranzaBo cobranza;
    @XmlElement(name = "Venta")
    protected DmVentaBo venta;
    @XmlElement(name = "PortalRut")
    protected String portalRut;
    @XmlElement(name = "PortalUsuario")
    protected String portalUsuario;
    @XmlElement(name = "Corredor")
    protected DmCorredorBo corredor;

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
     * Obtiene el valor de la propiedad grupoNumero.
     * 
     */
    public int getGrupoNumero() {
        return grupoNumero;
    }

    /**
     * Define el valor de la propiedad grupoNumero.
     * 
     */
    public void setGrupoNumero(int value) {
        this.grupoNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad titular.
     * 
     * @return
     *     possible object is
     *     {@link DmTitularBo }
     *     
     */
    public DmTitularBo getTitular() {
        return titular;
    }

    /**
     * Define el valor de la propiedad titular.
     * 
     * @param value
     *     allowed object is
     *     {@link DmTitularBo }
     *     
     */
    public void setTitular(DmTitularBo value) {
        this.titular = value;
    }

    /**
     * Obtiene el valor de la propiedad carga.
     * 
     * @return
     *     possible object is
     *     {@link DmCargaBo }
     *     
     */
    public DmCargaBo getCarga() {
        return carga;
    }

    /**
     * Define el valor de la propiedad carga.
     * 
     * @param value
     *     allowed object is
     *     {@link DmCargaBo }
     *     
     */
    public void setCarga(DmCargaBo value) {
        this.carga = value;
    }

    /**
     * Obtiene el valor de la propiedad observacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Define el valor de la propiedad observacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacion(String value) {
        this.observacion = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoPersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Define el valor de la propiedad tipoPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPersona(String value) {
        this.tipoPersona = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    /**
     * Define el valor de la propiedad tipoBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoBeneficiario(String value) {
        this.tipoBeneficiario = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentaje.
     * 
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * Define el valor de la propiedad porcentaje.
     * 
     */
    public void setPorcentaje(int value) {
        this.porcentaje = value;
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
     * Obtiene el valor de la propiedad fechaTerminoVigencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaTerminoVigencia() {
        return fechaTerminoVigencia;
    }

    /**
     * Define el valor de la propiedad fechaTerminoVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaTerminoVigencia(XMLGregorianCalendar value) {
        this.fechaTerminoVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad capital.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCapital() {
        return capital;
    }

    /**
     * Define el valor de la propiedad capital.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCapital(Double value) {
        this.capital = value;
    }

    /**
     * Obtiene el valor de la propiedad renta.
     * 
     * @return
     *     possible object is
     *     {@link DmRentaBo }
     *     
     */
    public DmRentaBo getRenta() {
        return renta;
    }

    /**
     * Define el valor de la propiedad renta.
     * 
     * @param value
     *     allowed object is
     *     {@link DmRentaBo }
     *     
     */
    public void setRenta(DmRentaBo value) {
        this.renta = value;
    }

    /**
     * Obtiene el valor de la propiedad tercero.
     * 
     * @return
     *     possible object is
     *     {@link DmTerceroBo }
     *     
     */
    public DmTerceroBo getTercero() {
        return tercero;
    }

    /**
     * Define el valor de la propiedad tercero.
     * 
     * @param value
     *     allowed object is
     *     {@link DmTerceroBo }
     *     
     */
    public void setTercero(DmTerceroBo value) {
        this.tercero = value;
    }

    /**
     * Obtiene el valor de la propiedad cobranza.
     * 
     * @return
     *     possible object is
     *     {@link DmCobranzaBo }
     *     
     */
    public DmCobranzaBo getCobranza() {
        return cobranza;
    }

    /**
     * Define el valor de la propiedad cobranza.
     * 
     * @param value
     *     allowed object is
     *     {@link DmCobranzaBo }
     *     
     */
    public void setCobranza(DmCobranzaBo value) {
        this.cobranza = value;
    }

    /**
     * Obtiene el valor de la propiedad venta.
     * 
     * @return
     *     possible object is
     *     {@link DmVentaBo }
     *     
     */
    public DmVentaBo getVenta() {
        return venta;
    }

    /**
     * Define el valor de la propiedad venta.
     * 
     * @param value
     *     allowed object is
     *     {@link DmVentaBo }
     *     
     */
    public void setVenta(DmVentaBo value) {
        this.venta = value;
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

    /**
     * Obtiene el valor de la propiedad corredor.
     * 
     * @return
     *     possible object is
     *     {@link DmCorredorBo }
     *     
     */
    public DmCorredorBo getCorredor() {
        return corredor;
    }

    /**
     * Define el valor de la propiedad corredor.
     * 
     * @param value
     *     allowed object is
     *     {@link DmCorredorBo }
     *     
     */
    public void setCorredor(DmCorredorBo value) {
        this.corredor = value;
    }

}
