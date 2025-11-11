
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
 *         &lt;element name="AddNewBusinessObjectFieldResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}BusinessObjectFieldDTO" minOccurs="0"/>
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
    "addNewBusinessObjectFieldResult"
})
@XmlRootElement(name = "AddNewBusinessObjectFieldResponse")
public class AddNewBusinessObjectFieldResponse {

    @XmlElementRef(name = "AddNewBusinessObjectFieldResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<BusinessObjectFieldDTO> addNewBusinessObjectFieldResult;

    /**
     * Obtiene el valor de la propiedad addNewBusinessObjectFieldResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectFieldDTO }{@code >}
     *     
     */
    public JAXBElement<BusinessObjectFieldDTO> getAddNewBusinessObjectFieldResult() {
        return addNewBusinessObjectFieldResult;
    }

    /**
     * Define el valor de la propiedad addNewBusinessObjectFieldResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectFieldDTO }{@code >}
     *     
     */
    public void setAddNewBusinessObjectFieldResult(JAXBElement<BusinessObjectFieldDTO> value) {
        this.addNewBusinessObjectFieldResult = value;
    }

}
