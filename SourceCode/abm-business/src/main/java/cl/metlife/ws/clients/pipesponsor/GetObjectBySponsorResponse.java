
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
 *         &lt;element name="GetObjectBySponsorResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfBusinessObjectDTO" minOccurs="0"/>
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
    "getObjectBySponsorResult"
})
@XmlRootElement(name = "GetObjectBySponsorResponse")
public class GetObjectBySponsorResponse {

    @XmlElementRef(name = "GetObjectBySponsorResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBusinessObjectDTO> getObjectBySponsorResult;

    /**
     * Obtiene el valor de la propiedad getObjectBySponsorResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBusinessObjectDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBusinessObjectDTO> getGetObjectBySponsorResult() {
        return getObjectBySponsorResult;
    }

    /**
     * Define el valor de la propiedad getObjectBySponsorResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBusinessObjectDTO }{@code >}
     *     
     */
    public void setGetObjectBySponsorResult(JAXBElement<ArrayOfBusinessObjectDTO> value) {
        this.getObjectBySponsorResult = value;
    }

}
