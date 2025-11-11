
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BulkBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BulkBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EstadoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "BulkBo", propOrder = {
    "id",
    "estadoId",
    "error"
})
public class BulkBo {

    @XmlElement(name = "Id", required = true, type = Integer.class, nillable = true)
    protected Integer id;
    @XmlElement(name = "EstadoId", required = true, type = Integer.class, nillable = true)
    protected Integer estadoId;
    @XmlElement(name = "Error")
    protected ErrorBo error;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEstadoId() {
        return estadoId;
    }

    /**
     * Define el valor de la propiedad estadoId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEstadoId(Integer value) {
        this.estadoId = value;
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

}
