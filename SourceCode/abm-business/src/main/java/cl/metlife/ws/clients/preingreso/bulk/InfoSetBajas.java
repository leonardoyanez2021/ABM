
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sesionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="setId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaDesde" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaHasta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="corredorRutDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sesionId",
    "bulkId",
    "setId",
    "lote",
    "fechaDesde",
    "fechaHasta",
    "corredorRutDv",
    "login"
})
@XmlRootElement(name = "InfoSetBajas")
public class InfoSetBajas {

    protected String sesionId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer bulkId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer setId;
    protected String lote;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDesde;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHasta;
    protected String corredorRutDv;
    protected String login;

    /**
     * Obtiene el valor de la propiedad sesionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesionId() {
        return sesionId;
    }

    /**
     * Define el valor de la propiedad sesionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesionId(String value) {
        this.sesionId = value;
    }

    /**
     * Obtiene el valor de la propiedad bulkId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBulkId() {
        return bulkId;
    }

    /**
     * Define el valor de la propiedad bulkId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBulkId(Integer value) {
        this.bulkId = value;
    }

    /**
     * Obtiene el valor de la propiedad setId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSetId() {
        return setId;
    }

    /**
     * Define el valor de la propiedad setId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSetId(Integer value) {
        this.setId = value;
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
     * Obtiene el valor de la propiedad fechaDesde.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Define el valor de la propiedad fechaDesde.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDesde(XMLGregorianCalendar value) {
        this.fechaDesde = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Define el valor de la propiedad fechaHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHasta(XMLGregorianCalendar value) {
        this.fechaHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad corredorRutDv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorredorRutDv() {
        return corredorRutDv;
    }

    /**
     * Define el valor de la propiedad corredorRutDv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorredorRutDv(String value) {
        this.corredorRutDv = value;
    }

    /**
     * Obtiene el valor de la propiedad login.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define el valor de la propiedad login.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

}
