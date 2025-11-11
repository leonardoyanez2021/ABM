
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
 *         &lt;element name="fileInterface" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileInterfaceDTO" minOccurs="0"/>
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
    "fileInterface"
})
@XmlRootElement(name = "AddNewFileInterface")
public class AddNewFileInterface {

    @XmlElementRef(name = "fileInterface", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileInterfaceDTO> fileInterface;

    /**
     * Obtiene el valor de la propiedad fileInterface.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileInterfaceDTO }{@code >}
     *     
     */
    public JAXBElement<FileInterfaceDTO> getFileInterface() {
        return fileInterface;
    }

    /**
     * Define el valor de la propiedad fileInterface.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileInterfaceDTO }{@code >}
     *     
     */
    public void setFileInterface(JAXBElement<FileInterfaceDTO> value) {
        this.fileInterface = value;
    }

}
