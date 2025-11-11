
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Ejecutar2Result" type="{http://preingreso.metlife.cl/}WsSolicitudResponseBo" minOccurs="0"/>
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
    "ejecutar2Result"
})
@XmlRootElement(name = "Ejecutar2Response")
public class Ejecutar2Response {

    @XmlElement(name = "Ejecutar2Result")
    protected WsSolicitudResponseBo ejecutar2Result;

    /**
     * Obtiene el valor de la propiedad ejecutar2Result.
     * 
     * @return
     *     possible object is
     *     {@link WsSolicitudResponseBo }
     *     
     */
    public WsSolicitudResponseBo getEjecutar2Result() {
        return ejecutar2Result;
    }

    /**
     * Define el valor de la propiedad ejecutar2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link WsSolicitudResponseBo }
     *     
     */
    public void setEjecutar2Result(WsSolicitudResponseBo value) {
        this.ejecutar2Result = value;
    }

}
