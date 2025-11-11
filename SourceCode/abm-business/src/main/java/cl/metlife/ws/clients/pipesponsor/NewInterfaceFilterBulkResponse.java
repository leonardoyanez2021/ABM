
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
 *         &lt;element name="NewInterfaceFilterBulkResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "newInterfaceFilterBulkResult"
})
@XmlRootElement(name = "NewInterfaceFilterBulkResponse")
public class NewInterfaceFilterBulkResponse {

    @XmlElement(name = "NewInterfaceFilterBulkResult")
    protected Integer newInterfaceFilterBulkResult;

    /**
     * Obtiene el valor de la propiedad newInterfaceFilterBulkResult.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNewInterfaceFilterBulkResult() {
        return newInterfaceFilterBulkResult;
    }

    /**
     * Define el valor de la propiedad newInterfaceFilterBulkResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNewInterfaceFilterBulkResult(Integer value) {
        this.newInterfaceFilterBulkResult = value;
    }

}
