
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="standardConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "standardConceptId"
})
@XmlRootElement(name = "GetStandardConceptById")
public class GetStandardConceptById {

    protected Long standardConceptId;

    /**
     * Obtiene el valor de la propiedad standardConceptId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStandardConceptId() {
        return standardConceptId;
    }

    /**
     * Define el valor de la propiedad standardConceptId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStandardConceptId(Long value) {
        this.standardConceptId = value;
    }

}
