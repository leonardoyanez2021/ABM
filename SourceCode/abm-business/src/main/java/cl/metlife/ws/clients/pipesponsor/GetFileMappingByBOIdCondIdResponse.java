
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
 *         &lt;element name="GetFileMappingByBOIdCondIdResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileMappingDTO" minOccurs="0"/>
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
    "getFileMappingByBOIdCondIdResult"
})
@XmlRootElement(name = "GetFileMappingByBOIdCondIdResponse")
public class GetFileMappingByBOIdCondIdResponse {

    @XmlElementRef(name = "GetFileMappingByBOIdCondIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileMappingDTO> getFileMappingByBOIdCondIdResult;

    /**
     * Obtiene el valor de la propiedad getFileMappingByBOIdCondIdResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileMappingDTO }{@code >}
     *     
     */
    public JAXBElement<FileMappingDTO> getGetFileMappingByBOIdCondIdResult() {
        return getFileMappingByBOIdCondIdResult;
    }

    /**
     * Define el valor de la propiedad getFileMappingByBOIdCondIdResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileMappingDTO }{@code >}
     *     
     */
    public void setGetFileMappingByBOIdCondIdResult(JAXBElement<FileMappingDTO> value) {
        this.getFileMappingByBOIdCondIdResult = value;
    }

}
