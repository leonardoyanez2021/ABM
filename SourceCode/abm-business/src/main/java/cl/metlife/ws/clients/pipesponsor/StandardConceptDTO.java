
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para StandardConceptDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="StandardConceptDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StandardConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StandardConceptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StandardConceptNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardConceptDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "isEnable",
    "standardConceptId",
    "standardConceptName",
    "standardConceptNotes"
})
public class StandardConceptDTO
    extends Dto
{

    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElement(name = "StandardConceptId")
    protected Long standardConceptId;
    @XmlElementRef(name = "StandardConceptName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> standardConceptName;
    @XmlElementRef(name = "StandardConceptNotes", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> standardConceptNotes;

    /**
     * Obtiene el valor de la propiedad isEnable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEnable() {
        return isEnable;
    }

    /**
     * Define el valor de la propiedad isEnable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEnable(Boolean value) {
        this.isEnable = value;
    }

    /**
     * Obtiene el valor de la propiedad standardConceptId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStandardConceptId() {
        return standardConceptId;
    }

    /**
     * Define el valor de la propiedad standardConceptId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStandardConceptId(Long value) {
        this.standardConceptId = value;
    }

    /**
     * Obtiene el valor de la propiedad standardConceptName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStandardConceptName() {
        return standardConceptName;
    }

    /**
     * Define el valor de la propiedad standardConceptName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStandardConceptName(JAXBElement<String> value) {
        this.standardConceptName = value;
    }

    /**
     * Obtiene el valor de la propiedad standardConceptNotes.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStandardConceptNotes() {
        return standardConceptNotes;
    }

    /**
     * Define el valor de la propiedad standardConceptNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStandardConceptNotes(JAXBElement<String> value) {
        this.standardConceptNotes = value;
    }

}
