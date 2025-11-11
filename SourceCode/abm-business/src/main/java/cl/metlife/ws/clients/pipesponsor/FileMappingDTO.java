
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FileMappingDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FileMappingDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessObject" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}BusinessObjectDTO" minOccurs="0"/>
 *         &lt;element name="BusinessObjectId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ConditionalEspecId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileMappingId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileRelationships" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfFileRelationshipDTO" minOccurs="0"/>
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
@XmlType(name = "FileMappingDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObject",
    "businessObjectId",
    "conditionalEspecId",
    "fileMappingId",
    "fileRelationships",
    "isEnable"
})
public class FileMappingDTO
    extends Dto
{

    @XmlElementRef(name = "BusinessObject", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<BusinessObjectDTO> businessObject;
    @XmlElement(name = "BusinessObjectId")
    protected Long businessObjectId;
    @XmlElementRef(name = "ConditionalEspecId", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> conditionalEspecId;
    @XmlElement(name = "FileMappingId")
    protected Long fileMappingId;
    @XmlElementRef(name = "FileRelationships", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFileRelationshipDTO> fileRelationships;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;

    /**
     * Obtiene el valor de la propiedad businessObject.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectDTO }{@code >}
     *     
     */
    public JAXBElement<BusinessObjectDTO> getBusinessObject() {
        return businessObject;
    }

    /**
     * Define el valor de la propiedad businessObject.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BusinessObjectDTO }{@code >}
     *     
     */
    public void setBusinessObject(JAXBElement<BusinessObjectDTO> value) {
        this.businessObject = value;
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
     * Obtiene el valor de la propiedad conditionalEspecId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getConditionalEspecId() {
        return conditionalEspecId;
    }

    /**
     * Define el valor de la propiedad conditionalEspecId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setConditionalEspecId(JAXBElement<Long> value) {
        this.conditionalEspecId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileMappingId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileMappingId() {
        return fileMappingId;
    }

    /**
     * Define el valor de la propiedad fileMappingId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileMappingId(Long value) {
        this.fileMappingId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileRelationships.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFileRelationshipDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFileRelationshipDTO> getFileRelationships() {
        return fileRelationships;
    }

    /**
     * Define el valor de la propiedad fileRelationships.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFileRelationshipDTO }{@code >}
     *     
     */
    public void setFileRelationships(JAXBElement<ArrayOfFileRelationshipDTO> value) {
        this.fileRelationships = value;
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
