
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
 *         &lt;element name="GetActivitiesByProcessResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfLogProcessActivityDTO" minOccurs="0"/>
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
    "getActivitiesByProcessResult"
})
@XmlRootElement(name = "GetActivitiesByProcessResponse")
public class GetActivitiesByProcessResponse {

    @XmlElementRef(name = "GetActivitiesByProcessResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfLogProcessActivityDTO> getActivitiesByProcessResult;

    /**
     * Obtiene el valor de la propiedad getActivitiesByProcessResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessActivityDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLogProcessActivityDTO> getGetActivitiesByProcessResult() {
        return getActivitiesByProcessResult;
    }

    /**
     * Define el valor de la propiedad getActivitiesByProcessResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessActivityDTO }{@code >}
     *     
     */
    public void setGetActivitiesByProcessResult(JAXBElement<ArrayOfLogProcessActivityDTO> value) {
        this.getActivitiesByProcessResult = value;
    }

}
