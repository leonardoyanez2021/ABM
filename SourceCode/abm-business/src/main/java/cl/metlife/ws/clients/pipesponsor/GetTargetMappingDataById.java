
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
 *         &lt;element name="targetMappingDataId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "targetMappingDataId"
})
@XmlRootElement(name = "GetTargetMappingDataById")
public class GetTargetMappingDataById {

    protected Long targetMappingDataId;

    /**
     * Obtiene el valor de la propiedad targetMappingDataId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetMappingDataId() {
        return targetMappingDataId;
    }

    /**
     * Define el valor de la propiedad targetMappingDataId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetMappingDataId(Long value) {
        this.targetMappingDataId = value;
    }

}
