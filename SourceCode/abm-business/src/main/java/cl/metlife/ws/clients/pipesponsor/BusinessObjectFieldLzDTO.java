
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BusinessObjectFieldLzDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BusinessObjectFieldLzDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessFieldTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BusinessObjectFieldId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BusinessObjectId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FieldDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FieldMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FieldOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessObjectFieldLzDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessFieldTypeId",
    "businessObjectFieldId",
    "businessObjectId",
    "fieldDescription",
    "fieldMandatory",
    "fieldName",
    "fieldOrder",
    "isEnable"
})
public class BusinessObjectFieldLzDTO
    extends Dto
{

    @XmlElement(name = "BusinessFieldTypeId")
    protected Long businessFieldTypeId;
    @XmlElement(name = "BusinessObjectFieldId")
    protected Long businessObjectFieldId;
    @XmlElement(name = "BusinessObjectId")
    protected Long businessObjectId;
    @XmlElementRef(name = "FieldDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fieldDescription;
    @XmlElement(name = "FieldMandatory")
    protected Boolean fieldMandatory;
    @XmlElementRef(name = "FieldName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fieldName;
    @XmlElement(name = "FieldOrder")
    protected Integer fieldOrder;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;

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
     * Obtiene el valor de la propiedad businessObjectFieldId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessObjectFieldId() {
        return businessObjectFieldId;
    }

    /**
     * Define el valor de la propiedad businessObjectFieldId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessObjectFieldId(Long value) {
        this.businessObjectFieldId = value;
    }

    /**
     * Obtiene el valor de la propiedad businessObjectId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessObjectId() {
        return businessObjectId;
    }

    /**
     * Define el valor de la propiedad businessObjectId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessObjectId(Long value) {
        this.businessObjectId = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFieldDescription() {
        return fieldDescription;
    }

    /**
     * Define el valor de la propiedad fieldDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFieldDescription(JAXBElement<String> value) {
        this.fieldDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldMandatory.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFieldMandatory() {
        return fieldMandatory;
    }

    /**
     * Define el valor de la propiedad fieldMandatory.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFieldMandatory(Boolean value) {
        this.fieldMandatory = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFieldName() {
        return fieldName;
    }

    /**
     * Define el valor de la propiedad fieldName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFieldName(JAXBElement<String> value) {
        this.fieldName = value;
    }

    /**
     * Obtiene el valor de la propiedad fieldOrder.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFieldOrder() {
        return fieldOrder;
    }

    /**
     * Define el valor de la propiedad fieldOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFieldOrder(Integer value) {
        this.fieldOrder = value;
    }

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

}
