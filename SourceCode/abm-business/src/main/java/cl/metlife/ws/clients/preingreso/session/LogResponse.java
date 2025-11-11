
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
 *         &lt;element name="LogResult" type="{http://preingreso.metlife.cl/}LogBo" minOccurs="0"/>
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
    "logResult"
})
@XmlRootElement(name = "LogResponse")
public class LogResponse {

    @XmlElement(name = "LogResult")
    protected LogBo logResult;

    /**
     * Obtiene el valor de la propiedad logResult.
     * 
     * @return
     *     possible object is
     *     {@link LogBo }
     *     
     */
    public LogBo getLogResult() {
        return logResult;
    }

    /**
     * Define el valor de la propiedad logResult.
     * 
     * @param value
     *     allowed object is
     *     {@link LogBo }
     *     
     */
    public void setLogResult(LogBo value) {
        this.logResult = value;
    }

}
