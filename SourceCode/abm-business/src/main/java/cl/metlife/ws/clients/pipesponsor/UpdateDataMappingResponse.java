
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
 *         &lt;element name="UpdateDataMappingResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "updateDataMappingResult"
})
@XmlRootElement(name = "UpdateDataMappingResponse")
public class UpdateDataMappingResponse {

    @XmlElement(name = "UpdateDataMappingResult")
    protected Integer updateDataMappingResult;

    /**
     * Obtiene el valor de la propiedad updateDataMappingResult.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUpdateDataMappingResult() {
        return updateDataMappingResult;
    }

    /**
     * Define el valor de la propiedad updateDataMappingResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUpdateDataMappingResult(Integer value) {
        this.updateDataMappingResult = value;
    }

}
