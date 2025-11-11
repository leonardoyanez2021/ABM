
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
 *         &lt;element name="fileRelationship" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileRelationshipDTO" minOccurs="0"/>
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
    "fileRelationship"
})
@XmlRootElement(name = "UpdateFileRelationship")
public class UpdateFileRelationship {

    @XmlElementRef(name = "fileRelationship", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FileRelationshipDTO> fileRelationship;

    /**
     * Obtiene el valor de la propiedad fileRelationship.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FileRelationshipDTO }{@code >}
     *     
     */
    public JAXBElement<FileRelationshipDTO> getFileRelationship() {
        return fileRelationship;
    }

    /**
     * Define el valor de la propiedad fileRelationship.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FileRelationshipDTO }{@code >}
     *     
     */
    public void setFileRelationship(JAXBElement<FileRelationshipDTO> value) {
        this.fileRelationship = value;
    }

}
