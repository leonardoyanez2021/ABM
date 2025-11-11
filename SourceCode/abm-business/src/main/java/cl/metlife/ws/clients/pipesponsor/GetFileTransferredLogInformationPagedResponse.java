
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
 *         &lt;element name="GetFileTransferredLogInformationPagedResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}PagedListDTOOfSponsorProcessLogDTOTg3ItwTH" minOccurs="0"/>
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
    "getFileTransferredLogInformationPagedResult"
})
@XmlRootElement(name = "GetFileTransferredLogInformationPagedResponse")
public class GetFileTransferredLogInformationPagedResponse {

    @XmlElementRef(name = "GetFileTransferredLogInformationPagedResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PagedListDTOOfSponsorProcessLogDTOTg3ItwTH> getFileTransferredLogInformationPagedResult;

    /**
     * Obtiene el valor de la propiedad getFileTransferredLogInformationPagedResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfSponsorProcessLogDTOTg3ItwTH }{@code >}
     *     
     */
    public JAXBElement<PagedListDTOOfSponsorProcessLogDTOTg3ItwTH> getGetFileTransferredLogInformationPagedResult() {
        return getFileTransferredLogInformationPagedResult;
    }

    /**
     * Define el valor de la propiedad getFileTransferredLogInformationPagedResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfSponsorProcessLogDTOTg3ItwTH }{@code >}
     *     
     */
    public void setGetFileTransferredLogInformationPagedResult(JAXBElement<PagedListDTOOfSponsorProcessLogDTOTg3ItwTH> value) {
        this.getFileTransferredLogInformationPagedResult = value;
    }

}
