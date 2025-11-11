
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
 *         &lt;element name="AddNewFileMappingResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileMappingDTO" minOccurs="0"/>
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
    "addNewFileMappingResult"
})
@XmlRootElement(name = "AddNewFileMappingResponse")
public class AddNewFileMappingResponse {

    @XmlElementRef(name = "AddNewFileMappingResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileMappingDTO> addNewFileMappingResult;

    /**
     * Obtiene el valor de la propiedad addNewFileMappingResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileMappingDTO }{@code >}
     *     
     */
    public JAXBElement<FileMappingDTO> getAddNewFileMappingResult() {
        return addNewFileMappingResult;
    }

    /**
     * Define el valor de la propiedad addNewFileMappingResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileMappingDTO }{@code >}
     *     
     */
    public void setAddNewFileMappingResult(JAXBElement<FileMappingDTO> value) {
        this.addNewFileMappingResult = value;
    }

}
