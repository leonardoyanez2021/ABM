
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegacySystemDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegacySystemDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LegacySystemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LegacySystemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LegacySystemNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegacySystemDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "isEnable",
    "legacySystemId",
    "legacySystemName",
    "legacySystemNotes"
})
public class LegacySystemDTO
    extends Dto
{

    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElement(name = "LegacySystemId")
    protected Long legacySystemId;
    @XmlElementRef(name = "LegacySystemName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> legacySystemName;
    @XmlElementRef(name = "LegacySystemNotes", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> legacySystemNotes;

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
     * Obtiene el valor de la propiedad legacySystemId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLegacySystemId() {
        return legacySystemId;
    }

    /**
     * Define el valor de la propiedad legacySystemId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLegacySystemId(Long value) {
        this.legacySystemId = value;
    }

    /**
     * Obtiene el valor de la propiedad legacySystemName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegacySystemName() {
        return legacySystemName;
    }

    /**
     * Define el valor de la propiedad legacySystemName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegacySystemName(JAXBElement<String> value) {
        this.legacySystemName = value;
    }

    /**
     * Obtiene el valor de la propiedad legacySystemNotes.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLegacySystemNotes() {
        return legacySystemNotes;
    }

    /**
     * Define el valor de la propiedad legacySystemNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLegacySystemNotes(JAXBElement<String> value) {
        this.legacySystemNotes = value;
    }

}
