
package cl.blueprintsit.ws.pipesponsor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="outputEntityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "outputEntityId"
})
@XmlRootElement(name = "GetOutputEntityById")
public class GetOutputEntityById {

    protected Long outputEntityId;

    /**
     * Gets the value of the outputEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOutputEntityId() {
        return outputEntityId;
    }

    /**
     * Sets the value of the outputEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOutputEntityId(Long value) {
        this.outputEntityId = value;
    }

}
