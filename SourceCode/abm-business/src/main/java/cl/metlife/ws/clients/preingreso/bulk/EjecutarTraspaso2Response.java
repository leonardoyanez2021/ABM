
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
 *         &lt;element name="EjecutarTraspaso2Result" type="{http://preingreso.metlife.cl/}WsSolicitudResponseBo" minOccurs="0"/>
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
    "ejecutarTraspaso2Result"
})
@XmlRootElement(name = "EjecutarTraspaso2Response")
public class EjecutarTraspaso2Response {

    @XmlElement(name = "EjecutarTraspaso2Result")
    protected WsSolicitudResponseBo ejecutarTraspaso2Result;

    /**
     * Obtiene el valor de la propiedad ejecutarTraspaso2Result.
     * 
     * @return
     *     possible object is
     *     {@link WsSolicitudResponseBo }
     *     
     */
    public WsSolicitudResponseBo getEjecutarTraspaso2Result() {
        return ejecutarTraspaso2Result;
    }

    /**
     * Define el valor de la propiedad ejecutarTraspaso2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link WsSolicitudResponseBo }
     *     
     */
    public void setEjecutarTraspaso2Result(WsSolicitudResponseBo value) {
        this.ejecutarTraspaso2Result = value;
    }

}
