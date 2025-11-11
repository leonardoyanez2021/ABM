
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
 *         &lt;element name="GetFileMappingByIdResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileMappingDTO" minOccurs="0"/>
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
    "getFileMappingByIdResult"
})
@XmlRootElement(name = "GetFileMappingByIdResponse")
public class GetFileMappingByIdResponse {

    @XmlElementRef(name = "GetFileMappingByIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileMappingDTO> getFileMappingByIdResult;

    /**
     * Obtiene el valor de la propiedad getFileMappingByIdResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileMappingDTO }{@code >}
     *     
     */
    public JAXBElement<FileMappingDTO> getGetFileMappingByIdResult() {
        return getFileMappingByIdResult;
    }

    /**
     * Define el valor de la propiedad getFileMappingByIdResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileMappingDTO }{@code >}
     *     
     */
    public void setGetFileMappingByIdResult(JAXBElement<FileMappingDTO> value) {
        this.getFileMappingByIdResult = value;
    }

}
