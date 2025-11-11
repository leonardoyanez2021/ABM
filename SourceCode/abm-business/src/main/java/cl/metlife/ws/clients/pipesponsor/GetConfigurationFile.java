
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
 *         &lt;element name="sponsorFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="businessId" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOflong" minOccurs="0"/>
 *         &lt;element name="filesId" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOflong" minOccurs="0"/>
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
    "sponsorFile",
    "businessId",
    "filesId"
})
@XmlRootElement(name = "GetConfigurationFile")
public class GetConfigurationFile {

    @XmlElementRef(name = "sponsorFile", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorFile;
    @XmlElementRef(name = "businessId", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOflong> businessId;
    @XmlElementRef(name = "filesId", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOflong> filesId;

    /**
     * Obtiene el valor de la propiedad sponsorFile.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSponsorFile() {
        return sponsorFile;
    }

    /**
     * Define el valor de la propiedad sponsorFile.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSponsorFile(JAXBElement<String> value) {
        this.sponsorFile = value;
    }

    /**
     * Obtiene el valor de la propiedad businessId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}
     *     
     */
    public JAXBElement<ArrayOflong> getBusinessId() {
        return businessId;
    }

    /**
     * Define el valor de la propiedad businessId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}
     *     
     */
    public void setBusinessId(JAXBElement<ArrayOflong> value) {
        this.businessId = value;
    }

    /**
     * Obtiene el valor de la propiedad filesId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}
     *     
     */
    public JAXBElement<ArrayOflong> getFilesId() {
        return filesId;
    }

    /**
     * Define el valor de la propiedad filesId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOflong }{@code >}
     *     
     */
    public void setFilesId(JAXBElement<ArrayOflong> value) {
        this.filesId = value;
    }

}
