
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
 *         &lt;element name="AddNewColumnsBulkResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfColumnDefinitionLzDTO" minOccurs="0"/>
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
    "addNewColumnsBulkResult"
})
@XmlRootElement(name = "AddNewColumnsBulkResponse")
public class AddNewColumnsBulkResponse {

    @XmlElementRef(name = "AddNewColumnsBulkResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfColumnDefinitionLzDTO> addNewColumnsBulkResult;

    /**
     * Obtiene el valor de la propiedad addNewColumnsBulkResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfColumnDefinitionLzDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfColumnDefinitionLzDTO> getAddNewColumnsBulkResult() {
        return addNewColumnsBulkResult;
    }

    /**
     * Define el valor de la propiedad addNewColumnsBulkResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfColumnDefinitionLzDTO }{@code >}
     *     
     */
    public void setAddNewColumnsBulkResult(JAXBElement<ArrayOfColumnDefinitionLzDTO> value) {
        this.addNewColumnsBulkResult = value;
    }

}
