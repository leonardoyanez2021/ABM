
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
 *         &lt;element name="UpdateColumnDefinitionResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "updateColumnDefinitionResult"
})
@XmlRootElement(name = "UpdateColumnDefinitionResponse")
public class UpdateColumnDefinitionResponse {

    @XmlElement(name = "UpdateColumnDefinitionResult")
    protected Integer updateColumnDefinitionResult;

    /**
     * Obtiene el valor de la propiedad updateColumnDefinitionResult.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUpdateColumnDefinitionResult() {
        return updateColumnDefinitionResult;
    }

    /**
     * Define el valor de la propiedad updateColumnDefinitionResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUpdateColumnDefinitionResult(Integer value) {
        this.updateColumnDefinitionResult = value;
    }

}
