
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BulkDetalleBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BulkDetalleBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Error" type="{http://preingreso.metlife.cl/}ErrorBo" minOccurs="0"/>
 *         &lt;element name="Detalles" type="{http://preingreso.metlife.cl/}ArrayOfDetalleBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkDetalleBo", propOrder = {
    "error",
    "detalles"
})
public class BulkDetalleBo {

    @XmlElement(name = "Error")
    protected ErrorBo error;
    @XmlElement(name = "Detalles")
    protected ArrayOfDetalleBo detalles;

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
     * Obtiene el valor de la propiedad detalles.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalleBo }
     *     
     */
    public ArrayOfDetalleBo getDetalles() {
        return detalles;
    }

    /**
     * Define el valor de la propiedad detalles.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalleBo }
     *     
     */
    public void setDetalles(ArrayOfDetalleBo value) {
        this.detalles = value;
    }

}
