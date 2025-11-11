
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
 *         &lt;element name="fechaDesde" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaHasta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="corredorRutDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="corredorNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="movtoEstadoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="agrupacionCorredorRutDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fechaDesde",
    "fechaHasta",
    "corredorRutDv",
    "corredorNombre",
    "movtoEstadoId",
    "agrupacionCorredorRutDv"
})
@XmlRootElement(name = "BulkDetalle")
public class BulkDetalle {

    protected String sesionId;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer bulkId;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDesde;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHasta;
    protected String corredorRutDv;
    protected String corredorNombre;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer movtoEstadoId;
    protected String agrupacionCorredorRutDv;

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
     * Obtiene el valor de la propiedad corredorNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorredorNombre() {
        return corredorNombre;
    }

    /**
     * Define el valor de la propiedad corredorNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorredorNombre(String value) {
        this.corredorNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad movtoEstadoId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMovtoEstadoId() {
        return movtoEstadoId;
    }

    /**
     * Define el valor de la propiedad movtoEstadoId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMovtoEstadoId(Integer value) {
        this.movtoEstadoId = value;
    }

    /**
     * Obtiene el valor de la propiedad agrupacionCorredorRutDv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgrupacionCorredorRutDv() {
        return agrupacionCorredorRutDv;
    }

    /**
     * Define el valor de la propiedad agrupacionCorredorRutDv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgrupacionCorredorRutDv(String value) {
        this.agrupacionCorredorRutDv = value;
    }

}
