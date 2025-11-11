
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
 *         &lt;element name="tipoMovimiento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreAdjunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaRecepcion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="portalRut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portalNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="agrupacionCorredor" type="{http://preingreso.metlife.cl/}AgrupacionCorredor" minOccurs="0"/>
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
    "tipoMovimiento",
    "nombreAdjunto",
    "fechaRecepcion",
    "portalRut",
    "portalNombre",
    "agrupacionCorredor"
})
@XmlRootElement(name = "Crear")
public class Crear {

    protected String sesionId;
    protected int tipoMovimiento;
    protected String nombreAdjunto;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRecepcion;
    protected String portalRut;
    protected String portalNombre;
    protected AgrupacionCorredor agrupacionCorredor;

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
     * Obtiene el valor de la propiedad tipoMovimiento.
     * 
     */
    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Define el valor de la propiedad tipoMovimiento.
     * 
     */
    public void setTipoMovimiento(int value) {
        this.tipoMovimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAdjunto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAdjunto() {
        return nombreAdjunto;
    }

    /**
     * Define el valor de la propiedad nombreAdjunto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAdjunto(String value) {
        this.nombreAdjunto = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRecepcion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Define el valor de la propiedad fechaRecepcion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRecepcion(XMLGregorianCalendar value) {
        this.fechaRecepcion = value;
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
     * Obtiene el valor de la propiedad portalNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalNombre() {
        return portalNombre;
    }

    /**
     * Define el valor de la propiedad portalNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalNombre(String value) {
        this.portalNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad agrupacionCorredor.
     * 
     * @return
     *     possible object is
     *     {@link AgrupacionCorredor }
     *     
     */
    public AgrupacionCorredor getAgrupacionCorredor() {
        return agrupacionCorredor;
    }

    /**
     * Define el valor de la propiedad agrupacionCorredor.
     * 
     * @param value
     *     allowed object is
     *     {@link AgrupacionCorredor }
     *     
     */
    public void setAgrupacionCorredor(AgrupacionCorredor value) {
        this.agrupacionCorredor = value;
    }

}
