
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
 *         &lt;element name="GetLogTargetDetailByLogIdResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}PagedListDTOOfErrorDescriptionDTOTg3ItwTH" minOccurs="0"/>
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
    "getLogTargetDetailByLogIdResult"
})
@XmlRootElement(name = "GetLogTargetDetailByLogIdResponse")
public class GetLogTargetDetailByLogIdResponse {

    @XmlElementRef(name = "GetLogTargetDetailByLogIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PagedListDTOOfErrorDescriptionDTOTg3ItwTH> getLogTargetDetailByLogIdResult;

    /**
     * Obtiene el valor de la propiedad getLogTargetDetailByLogIdResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfErrorDescriptionDTOTg3ItwTH }{@code >}
     *     
     */
    public JAXBElement<PagedListDTOOfErrorDescriptionDTOTg3ItwTH> getGetLogTargetDetailByLogIdResult() {
        return getLogTargetDetailByLogIdResult;
    }

    /**
     * Define el valor de la propiedad getLogTargetDetailByLogIdResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfErrorDescriptionDTOTg3ItwTH }{@code >}
     *     
     */
    public void setGetLogTargetDetailByLogIdResult(JAXBElement<PagedListDTOOfErrorDescriptionDTOTg3ItwTH> value) {
        this.getLogTargetDetailByLogIdResult = value;
    }

}
