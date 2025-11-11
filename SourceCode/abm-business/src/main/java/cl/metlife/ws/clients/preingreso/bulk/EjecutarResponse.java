
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
 *         &lt;element name="EjecutarResult" type="{http://preingreso.metlife.cl/}ErrorBo" minOccurs="0"/>
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
    "ejecutarResult"
})
@XmlRootElement(name = "EjecutarResponse")
public class EjecutarResponse {

    @XmlElement(name = "EjecutarResult")
    protected ErrorBo ejecutarResult;

    /**
     * Obtiene el valor de la propiedad ejecutarResult.
     * 
     * @return
     *     possible object is
     *     {@link ErrorBo }
     *     
     */
    public ErrorBo getEjecutarResult() {
        return ejecutarResult;
    }

    /**
     * Define el valor de la propiedad ejecutarResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorBo }
     *     
     */
    public void setEjecutarResult(ErrorBo value) {
        this.ejecutarResult = value;
    }

}
