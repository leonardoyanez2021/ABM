
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
 *         &lt;element name="GetFileSecurityKeyByIdResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileSecurityKeyDTO" minOccurs="0"/>
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
    "getFileSecurityKeyByIdResult"
})
@XmlRootElement(name = "GetFileSecurityKeyByIdResponse")
public class GetFileSecurityKeyByIdResponse {

    @XmlElementRef(name = "GetFileSecurityKeyByIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileSecurityKeyDTO> getFileSecurityKeyByIdResult;

    /**
     * Obtiene el valor de la propiedad getFileSecurityKeyByIdResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileSecurityKeyDTO }{@code >}
     *     
     */
    public JAXBElement<FileSecurityKeyDTO> getGetFileSecurityKeyByIdResult() {
        return getFileSecurityKeyByIdResult;
    }

    /**
     * Define el valor de la propiedad getFileSecurityKeyByIdResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileSecurityKeyDTO }{@code >}
     *     
     */
    public void setGetFileSecurityKeyByIdResult(JAXBElement<FileSecurityKeyDTO> value) {
        this.getFileSecurityKeyByIdResult = value;
    }

}
