
package cl.metlife.ws.clients.pipesponsor;

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
 *         &lt;element name="UpdateConditionalEspecResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "updateConditionalEspecResult"
})
@XmlRootElement(name = "UpdateConditionalEspecResponse")
public class UpdateConditionalEspecResponse {

    @XmlElement(name = "UpdateConditionalEspecResult")
    protected Integer updateConditionalEspecResult;

    /**
     * Obtiene el valor de la propiedad updateConditionalEspecResult.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUpdateConditionalEspecResult() {
        return updateConditionalEspecResult;
    }

    /**
     * Define el valor de la propiedad updateConditionalEspecResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUpdateConditionalEspecResult(Integer value) {
        this.updateConditionalEspecResult = value;
    }

}
