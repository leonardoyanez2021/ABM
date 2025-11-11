
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
 *         &lt;element name="GetFailedTargetLogInformationPagedResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}PagedListDTOOfSponsorProcessLogDTOTg3ItwTH" minOccurs="0"/>
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
    "getFailedTargetLogInformationPagedResult"
})
@XmlRootElement(name = "GetFailedTargetLogInformationPagedResponse")
public class GetFailedTargetLogInformationPagedResponse {

    @XmlElementRef(name = "GetFailedTargetLogInformationPagedResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PagedListDTOOfSponsorProcessLogDTOTg3ItwTH> getFailedTargetLogInformationPagedResult;

    /**
     * Obtiene el valor de la propiedad getFailedTargetLogInformationPagedResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfSponsorProcessLogDTOTg3ItwTH }{@code >}
     *     
     */
    public JAXBElement<PagedListDTOOfSponsorProcessLogDTOTg3ItwTH> getGetFailedTargetLogInformationPagedResult() {
        return getFailedTargetLogInformationPagedResult;
    }

    /**
     * Define el valor de la propiedad getFailedTargetLogInformationPagedResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfSponsorProcessLogDTOTg3ItwTH }{@code >}
     *     
     */
    public void setGetFailedTargetLogInformationPagedResult(JAXBElement<PagedListDTOOfSponsorProcessLogDTOTg3ItwTH> value) {
        this.getFailedTargetLogInformationPagedResult = value;
    }

}
