
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Detalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Detalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fila" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ErrorNro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ErrorDetalle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FolioSet" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EstadoSet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaTraspasoSet" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Solicitud_Id_Rel" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Detalle", propOrder = {
    "fila",
    "errorNro",
    "errorDetalle",
    "folioSet",
    "estadoSet",
    "fechaTraspasoSet",
    "solicitudIdRel"
})
public class Detalle {

    @XmlElement(name = "Fila")
    protected int fila;
    @XmlElement(name = "ErrorNro")
    protected int errorNro;
    @XmlElement(name = "ErrorDetalle")
    protected String errorDetalle;
    @XmlElement(name = "FolioSet")
    protected long folioSet;
    @XmlElement(name = "EstadoSet")
    protected String estadoSet;
    @XmlElement(name = "FechaTraspasoSet", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaTraspasoSet;
    @XmlElement(name = "Solicitud_Id_Rel", required = true, type = Long.class, nillable = true)
    protected Long solicitudIdRel;

    /**
     * Obtiene el valor de la propiedad fila.
     * 
     */
    public int getFila() {
        return fila;
    }

    /**
     * Define el valor de la propiedad fila.
     * 
     */
    public void setFila(int value) {
        this.fila = value;
    }

    /**
     * Obtiene el valor de la propiedad errorNro.
     * 
     */
    public int getErrorNro() {
        return errorNro;
    }

    /**
     * Define el valor de la propiedad errorNro.
     * 
     */
    public void setErrorNro(int value) {
        this.errorNro = value;
    }

    /**
     * Obtiene el valor de la propiedad errorDetalle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDetalle() {
        return errorDetalle;
    }

    /**
     * Define el valor de la propiedad errorDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDetalle(String value) {
        this.errorDetalle = value;
    }

    /**
     * Obtiene el valor de la propiedad folioSet.
     * 
     */
    public long getFolioSet() {
        return folioSet;
    }

    /**
     * Define el valor de la propiedad folioSet.
     * 
     */
    public void setFolioSet(long value) {
        this.folioSet = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoSet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSet() {
        return estadoSet;
    }

    /**
     * Define el valor de la propiedad estadoSet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSet(String value) {
        this.estadoSet = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaTraspasoSet.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaTraspasoSet() {
        return fechaTraspasoSet;
    }

    /**
     * Define el valor de la propiedad fechaTraspasoSet.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaTraspasoSet(XMLGregorianCalendar value) {
        this.fechaTraspasoSet = value;
    }

    /**
     * Obtiene el valor de la propiedad solicitudIdRel.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSolicitudIdRel() {
        return solicitudIdRel;
    }

    /**
     * Define el valor de la propiedad solicitudIdRel.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSolicitudIdRel(Long value) {
        this.solicitudIdRel = value;
    }

}
