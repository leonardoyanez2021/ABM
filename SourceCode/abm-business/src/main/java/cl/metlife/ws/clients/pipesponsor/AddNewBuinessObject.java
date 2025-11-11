
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="businessObject" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}BusinessObjectDTO" minOccurs="0"/>
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
    "businessObject"
})
@XmlRootElement(name = "AddNewBuinessObject")
public class AddNewBuinessObject {

    @XmlElementRef(name = "businessObject", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<BusinessObjectDTO> businessObject;

    /**
     * Obtiene el valor de la propiedad businessObject.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectDTO }{@code >}
     *     
     */
    public JAXBElement<BusinessObjectDTO> getBusinessObject() {
        return businessObject;
    }

    /**
     * Define el valor de la propiedad businessObject.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectDTO }{@code >}
     *     
     */
    public void setBusinessObject(JAXBElement<BusinessObjectDTO> value) {
        this.businessObject = value;
    }

}
