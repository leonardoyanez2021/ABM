
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
 *         &lt;element name="GetConditionalBySponsorResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfConditionalSpecSummaryDTO" minOccurs="0"/>
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
    "getConditionalBySponsorResult"
})
@XmlRootElement(name = "GetConditionalBySponsorResponse")
public class GetConditionalBySponsorResponse {

    @XmlElementRef(name = "GetConditionalBySponsorResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfConditionalSpecSummaryDTO> getConditionalBySponsorResult;

    /**
     * Obtiene el valor de la propiedad getConditionalBySponsorResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfConditionalSpecSummaryDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfConditionalSpecSummaryDTO> getGetConditionalBySponsorResult() {
        return getConditionalBySponsorResult;
    }

    /**
     * Define el valor de la propiedad getConditionalBySponsorResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfConditionalSpecSummaryDTO }{@code >}
     *     
     */
    public void setGetConditionalBySponsorResult(JAXBElement<ArrayOfConditionalSpecSummaryDTO> value) {
        this.getConditionalBySponsorResult = value;
    }

}
