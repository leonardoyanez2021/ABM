
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
 *         &lt;element name="GetFileInterfaceByIdNoColumnsResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileInterfaceLzDTO" minOccurs="0"/>
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
    "getFileInterfaceByIdNoColumnsResult"
})
@XmlRootElement(name = "GetFileInterfaceByIdNoColumnsResponse")
public class GetFileInterfaceByIdNoColumnsResponse {

    @XmlElementRef(name = "GetFileInterfaceByIdNoColumnsResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileInterfaceLzDTO> getFileInterfaceByIdNoColumnsResult;

    /**
     * Obtiene el valor de la propiedad getFileInterfaceByIdNoColumnsResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileInterfaceLzDTO }{@code >}
     *     
     */
    public JAXBElement<FileInterfaceLzDTO> getGetFileInterfaceByIdNoColumnsResult() {
        return getFileInterfaceByIdNoColumnsResult;
    }

    /**
     * Define el valor de la propiedad getFileInterfaceByIdNoColumnsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileInterfaceLzDTO }{@code >}
     *     
     */
    public void setGetFileInterfaceByIdNoColumnsResult(JAXBElement<FileInterfaceLzDTO> value) {
        this.getFileInterfaceByIdNoColumnsResult = value;
    }

}
