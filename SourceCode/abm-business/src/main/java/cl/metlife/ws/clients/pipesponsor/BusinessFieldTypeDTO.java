
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para BusinessFieldTypeDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BusinessFieldTypeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusinessFieldTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessFieldTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BusinessFieldTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessObjectFields" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfBusinessObjectFieldDTO" minOccurs="0"/>
 *         &lt;element name="DefaultType" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://schemas.microsoft.com/2003/10/Serialization/}Id"/>
 *       &lt;attribute ref="{http://schemas.microsoft.com/2003/10/Serialization/}Ref"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessFieldTypeDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessFieldTypeDescription",
    "businessFieldTypeId",
    "businessFieldTypeName",
    "businessObjectFields",
    "defaultType"
})
public class BusinessFieldTypeDTO {

    @XmlElementRef(name = "BusinessFieldTypeDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessFieldTypeDescription;
    @XmlElement(name = "BusinessFieldTypeId")
    protected Long businessFieldTypeId;
    @XmlElementRef(name = "BusinessFieldTypeName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessFieldTypeName;
    @XmlElementRef(name = "BusinessObjectFields", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBusinessObjectFieldDTO> businessObjectFields;
    @XmlElement(name = "DefaultType")
    protected Short defaultType;
    @XmlAttribute(name = "Id", namespace = "http://schemas.microsoft.com/2003/10/Serialization/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Ref", namespace = "http://schemas.microsoft.com/2003/10/Serialization/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object ref;

    /**
     * Obtiene el valor de la propiedad businessFieldTypeDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessFieldTypeDescription() {
        return businessFieldTypeDescription;
    }

    /**
     * Define el valor de la propiedad businessFieldTypeDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessFieldTypeDescription(JAXBElement<String> value) {
        this.businessFieldTypeDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad businessFieldTypeId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessFieldTypeId() {
        return businessFieldTypeId;
    }

    /**
     * Define el valor de la propiedad businessFieldTypeId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessFieldTypeId(Long value) {
        this.businessFieldTypeId = value;
    }

    /**
     * Obtiene el valor de la propiedad businessFieldTypeName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessFieldTypeName() {
        return businessFieldTypeName;
    }

    /**
     * Define el valor de la propiedad businessFieldTypeName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessFieldTypeName(JAXBElement<String> value) {
        this.businessFieldTypeName = value;
    }

    /**
     * Obtiene el valor de la propiedad businessObjectFields.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBusinessObjectFieldDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBusinessObjectFieldDTO> getBusinessObjectFields() {
        return businessObjectFields;
    }

    /**
     * Define el valor de la propiedad businessObjectFields.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBusinessObjectFieldDTO }{@code >}
     *     
     */
    public void setBusinessObjectFields(JAXBElement<ArrayOfBusinessObjectFieldDTO> value) {
        this.businessObjectFields = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultType.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDefaultType() {
        return defaultType;
    }

    /**
     * Define el valor de la propiedad defaultType.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDefaultType(Short value) {
        this.defaultType = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad ref.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRef() {
        return ref;
    }

    /**
     * Define el valor de la propiedad ref.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRef(Object value) {
        this.ref = value;
    }

}
