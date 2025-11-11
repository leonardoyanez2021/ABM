
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para OutputEntityDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OutputEntityDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="ColumnCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="EntityDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EntityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EntityNameAlias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EntityOwner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OutputConnectionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OutputEntityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputEntityDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "columnCount",
    "entityDescription",
    "entityName",
    "entityNameAlias",
    "entityOwner",
    "isEnable",
    "outputConnectionId",
    "outputEntityId"
})
public class OutputEntityDTO
    extends Dto
{

    @XmlElement(name = "ColumnCount")
    protected Integer columnCount;
    @XmlElementRef(name = "EntityDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> entityDescription;
    @XmlElementRef(name = "EntityName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> entityName;
    @XmlElementRef(name = "EntityNameAlias", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> entityNameAlias;
    @XmlElementRef(name = "EntityOwner", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> entityOwner;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElement(name = "OutputConnectionId")
    protected Long outputConnectionId;
    @XmlElement(name = "OutputEntityId")
    protected Long outputEntityId;

    /**
     * Obtiene el valor de la propiedad columnCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getColumnCount() {
        return columnCount;
    }

    /**
     * Define el valor de la propiedad columnCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnCount(Integer value) {
        this.columnCount = value;
    }

    /**
     * Obtiene el valor de la propiedad entityDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEntityDescription() {
        return entityDescription;
    }

    /**
     * Define el valor de la propiedad entityDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEntityDescription(JAXBElement<String> value) {
        this.entityDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad entityName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEntityName() {
        return entityName;
    }

    /**
     * Define el valor de la propiedad entityName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEntityName(JAXBElement<String> value) {
        this.entityName = value;
    }

    /**
     * Obtiene el valor de la propiedad entityNameAlias.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEntityNameAlias() {
        return entityNameAlias;
    }

    /**
     * Define el valor de la propiedad entityNameAlias.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEntityNameAlias(JAXBElement<String> value) {
        this.entityNameAlias = value;
    }

    /**
     * Obtiene el valor de la propiedad entityOwner.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEntityOwner() {
        return entityOwner;
    }

    /**
     * Define el valor de la propiedad entityOwner.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEntityOwner(JAXBElement<String> value) {
        this.entityOwner = value;
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
     * Obtiene el valor de la propiedad outputConnectionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOutputConnectionId() {
        return outputConnectionId;
    }

    /**
     * Define el valor de la propiedad outputConnectionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOutputConnectionId(Long value) {
        this.outputConnectionId = value;
    }

    /**
     * Obtiene el valor de la propiedad outputEntityId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOutputEntityId() {
        return outputEntityId;
    }

    /**
     * Define el valor de la propiedad outputEntityId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOutputEntityId(Long value) {
        this.outputEntityId = value;
    }

}
