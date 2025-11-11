
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
 *         &lt;element name="GetOutputColumnByIdResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}OutputColumnDTO" minOccurs="0"/>
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
    "getOutputColumnByIdResult"
})
@XmlRootElement(name = "GetOutputColumnByIdResponse")
public class GetOutputColumnByIdResponse {

    @XmlElementRef(name = "GetOutputColumnByIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<OutputColumnDTO> getOutputColumnByIdResult;

    /**
     * Obtiene el valor de la propiedad getOutputColumnByIdResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OutputColumnDTO }{@code >}
     *     
     */
    public JAXBElement<OutputColumnDTO> getGetOutputColumnByIdResult() {
        return getOutputColumnByIdResult;
    }

    /**
     * Define el valor de la propiedad getOutputColumnByIdResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OutputColumnDTO }{@code >}
     *     
     */
    public void setGetOutputColumnByIdResult(JAXBElement<OutputColumnDTO> value) {
        this.getOutputColumnByIdResult = value;
    }

}
