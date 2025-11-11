
package cl.blueprintsit.ws.pipesponsor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateOutputEntityResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "updateOutputEntityResult"
})
@XmlRootElement(name = "UpdateOutputEntityResponse")
public class UpdateOutputEntityResponse {

    @XmlElement(name = "UpdateOutputEntityResult")
    protected Integer updateOutputEntityResult;

    /**
     * Gets the value of the updateOutputEntityResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUpdateOutputEntityResult() {
        return updateOutputEntityResult;
    }

    /**
     * Sets the value of the updateOutputEntityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUpdateOutputEntityResult(Integer value) {
        this.updateOutputEntityResult = value;
    }

}
