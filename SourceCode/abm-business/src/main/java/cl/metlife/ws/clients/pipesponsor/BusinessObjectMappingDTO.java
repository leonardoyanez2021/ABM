
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BusinessObjectMappingDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BusinessObjectMappingDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessObjectField" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}BusinessObjectFieldDTO" minOccurs="0"/>
 *         &lt;element name="BusinessObjectFieldId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputColumnId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessObjectMappingDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObjectField",
    "businessObjectFieldId",
    "isEnable",
    "outputColumnId"
})
public class BusinessObjectMappingDTO
    extends Dto
{

    @XmlElementRef(name = "BusinessObjectField", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<BusinessObjectFieldDTO> businessObjectField;
    @XmlElement(name = "BusinessObjectFieldId")
    protected Long businessObjectFieldId;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElement(name = "OutputColumnId")
    protected Long outputColumnId;

    /**
     * Obtiene el valor de la propiedad businessObjectField.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectFieldDTO }{@code >}
     *     
     */
    public JAXBElement<BusinessObjectFieldDTO> getBusinessObjectField() {
        return businessObjectField;
    }

    /**
     * Define el valor de la propiedad businessObjectField.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectFieldDTO }{@code >}
     *     
     */
    public void setBusinessObjectField(JAXBElement<BusinessObjectFieldDTO> value) {
        this.businessObjectField = value;
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
     * Obtiene el valor de la propiedad outputColumnId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOutputColumnId() {
        return outputColumnId;
    }

    /**
     * Define el valor de la propiedad outputColumnId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOutputColumnId(Long value) {
        this.outputColumnId = value;
    }

}
