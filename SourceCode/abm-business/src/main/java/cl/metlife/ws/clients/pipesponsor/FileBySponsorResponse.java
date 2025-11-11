
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
 *         &lt;element name="FileBySponsorResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfFileDTO" minOccurs="0"/>
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
    "fileBySponsorResult"
})
@XmlRootElement(name = "FileBySponsorResponse")
public class FileBySponsorResponse {

    @XmlElementRef(name = "FileBySponsorResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFileDTO> fileBySponsorResult;

    /**
     * Obtiene el valor de la propiedad fileBySponsorResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFileDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFileDTO> getFileBySponsorResult() {
        return fileBySponsorResult;
    }

    /**
     * Define el valor de la propiedad fileBySponsorResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFileDTO }{@code >}
     *     
     */
    public void setFileBySponsorResult(JAXBElement<ArrayOfFileDTO> value) {
        this.fileBySponsorResult = value;
    }

}
