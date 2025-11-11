
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConditionalEspecDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConditionalEspecDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="ColumnDefinition" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ColumnDefinitionDTO" minOccurs="0"/>
 *         &lt;element name="ColumnDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ConditionalEspecId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileColumnValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FkBusinessObject" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LogicalOperation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LogicalSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Order" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionalEspecDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "columnDefinition",
    "columnDefinitionId",
    "conditionalEspecId",
    "fileColumnValue",
    "fkBusinessObject",
    "isEnable",
    "logicalOperation",
    "logicalSymbol",
    "order"
})
public class ConditionalEspecDTO
    extends Dto
{

    @XmlElementRef(name = "ColumnDefinition", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ColumnDefinitionDTO> columnDefinition;
    @XmlElement(name = "ColumnDefinitionId")
    protected Long columnDefinitionId;
    @XmlElement(name = "ConditionalEspecId")
    protected Long conditionalEspecId;
    @XmlElementRef(name = "FileColumnValue", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileColumnValue;
    @XmlElement(name = "FkBusinessObject")
    protected Long fkBusinessObject;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElementRef(name = "LogicalOperation", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> logicalOperation;
    @XmlElementRef(name = "LogicalSymbol", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> logicalSymbol;
    @XmlElement(name = "Order")
    protected Integer order;

    /**
     * Obtiene el valor de la propiedad columnDefinition.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ColumnDefinitionDTO }{@code >}
     *     
     */
    public JAXBElement<ColumnDefinitionDTO> getColumnDefinition() {
        return columnDefinition;
    }

    /**
     * Define el valor de la propiedad columnDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ColumnDefinitionDTO }{@code >}
     *     
     */
    public void setColumnDefinition(JAXBElement<ColumnDefinitionDTO> value) {
        this.columnDefinition = value;
    }

    /**
     * Obtiene el valor de la propiedad columnDefinitionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getColumnDefinitionId() {
        return columnDefinitionId;
    }

    /**
     * Define el valor de la propiedad columnDefinitionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setColumnDefinitionId(Long value) {
        this.columnDefinitionId = value;
    }

    /**
     * Obtiene el valor de la propiedad conditionalEspecId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConditionalEspecId() {
        return conditionalEspecId;
    }

    /**
     * Define el valor de la propiedad conditionalEspecId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConditionalEspecId(Long value) {
        this.conditionalEspecId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileColumnValue.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileColumnValue() {
        return fileColumnValue;
    }

    /**
     * Define el valor de la propiedad fileColumnValue.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileColumnValue(JAXBElement<String> value) {
        this.fileColumnValue = value;
    }

    /**
     * Obtiene el valor de la propiedad fkBusinessObject.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFkBusinessObject() {
        return fkBusinessObject;
    }

    /**
     * Define el valor de la propiedad fkBusinessObject.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFkBusinessObject(Long value) {
        this.fkBusinessObject = value;
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
     * Obtiene el valor de la propiedad logicalOperation.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLogicalOperation() {
        return logicalOperation;
    }

    /**
     * Define el valor de la propiedad logicalOperation.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLogicalOperation(JAXBElement<String> value) {
        this.logicalOperation = value;
    }

    /**
     * Obtiene el valor de la propiedad logicalSymbol.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLogicalSymbol() {
        return logicalSymbol;
    }

    /**
     * Define el valor de la propiedad logicalSymbol.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLogicalSymbol(JAXBElement<String> value) {
        this.logicalSymbol = value;
    }

    /**
     * Obtiene el valor de la propiedad order.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Define el valor de la propiedad order.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

}
