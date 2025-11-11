
package cl.metlife.ws.clients.preingreso.session;

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
 *         &lt;element name="LogonResult" type="{http://preingreso.metlife.cl/}SesionBo" minOccurs="0"/>
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
    "logonResult"
})
@XmlRootElement(name = "LogonResponse")
public class LogonResponse {

    @XmlElement(name = "LogonResult")
    protected SesionBo logonResult;

    /**
     * Obtiene el valor de la propiedad logonResult.
     * 
     * @return
     *     possible object is
     *     {@link SesionBo }
     *     
     */
    public SesionBo getLogonResult() {
        return logonResult;
    }

    /**
     * Define el valor de la propiedad logonResult.
     * 
     * @param value
     *     allowed object is
     *     {@link SesionBo }
     *     
     */
    public void setLogonResult(SesionBo value) {
        this.logonResult = value;
    }

}
