
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ColumnMappingFullInfoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ColumnMappingFullInfoDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessObjectFieldId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BusinessObjectFieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColumnDataTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ColumnDataTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColumnDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ColumnIsKey" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ColumnIsMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ColumnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColumnWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FileDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileInterfaceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="InterfaceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnMappingFullInfoDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObjectFieldId",
    "businessObjectFieldName",
    "columnDataTypeId",
    "columnDataTypeName",
    "columnDefinitionId",
    "columnIsKey",
    "columnIsMandatory",
    "columnName",
    "columnWidth",
    "fileDefinitionId",
    "fileInterfaceId",
    "fileName",
    "fileTypeId",
    "interfaceName"
})
public class ColumnMappingFullInfoDTO
    extends Dto
{

    @XmlElement(name = "BusinessObjectFieldId")
    protected Long businessObjectFieldId;
    @XmlElementRef(name = "BusinessObjectFieldName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessObjectFieldName;
    @XmlElement(name = "ColumnDataTypeId")
    protected Long columnDataTypeId;
    @XmlElementRef(name = "ColumnDataTypeName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> columnDataTypeName;
    @XmlElement(name = "ColumnDefinitionId")
    protected Long columnDefinitionId;
    @XmlElement(name = "ColumnIsKey")
    protected Boolean columnIsKey;
    @XmlElement(name = "ColumnIsMandatory")
    protected Boolean columnIsMandatory;
    @XmlElementRef(name = "ColumnName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> columnName;
    @XmlElement(name = "ColumnWidth")
    protected Integer columnWidth;
    @XmlElement(name = "FileDefinitionId")
    protected Long fileDefinitionId;
    @XmlElement(name = "FileInterfaceId")
    protected Long fileInterfaceId;
    @XmlElementRef(name = "FileName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileName;
    @XmlElement(name = "FileTypeId")
    protected Long fileTypeId;
    @XmlElementRef(name = "InterfaceName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interfaceName;

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
     * Obtiene el valor de la propiedad businessObjectFieldName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessObjectFieldName() {
        return businessObjectFieldName;
    }

    /**
     * Define el valor de la propiedad businessObjectFieldName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessObjectFieldName(JAXBElement<String> value) {
        this.businessObjectFieldName = value;
    }

    /**
     * Obtiene el valor de la propiedad columnDataTypeId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getColumnDataTypeId() {
        return columnDataTypeId;
    }

    /**
     * Define el valor de la propiedad columnDataTypeId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setColumnDataTypeId(Long value) {
        this.columnDataTypeId = value;
    }

    /**
     * Obtiene el valor de la propiedad columnDataTypeName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getColumnDataTypeName() {
        return columnDataTypeName;
    }

    /**
     * Define el valor de la propiedad columnDataTypeName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setColumnDataTypeName(JAXBElement<String> value) {
        this.columnDataTypeName = value;
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
     * Obtiene el valor de la propiedad columnIsKey.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isColumnIsKey() {
        return columnIsKey;
    }

    /**
     * Define el valor de la propiedad columnIsKey.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setColumnIsKey(Boolean value) {
        this.columnIsKey = value;
    }

    /**
     * Obtiene el valor de la propiedad columnIsMandatory.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isColumnIsMandatory() {
        return columnIsMandatory;
    }

    /**
     * Define el valor de la propiedad columnIsMandatory.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setColumnIsMandatory(Boolean value) {
        this.columnIsMandatory = value;
    }

    /**
     * Obtiene el valor de la propiedad columnName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getColumnName() {
        return columnName;
    }

    /**
     * Define el valor de la propiedad columnName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setColumnName(JAXBElement<String> value) {
        this.columnName = value;
    }

    /**
     * Obtiene el valor de la propiedad columnWidth.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getColumnWidth() {
        return columnWidth;
    }

    /**
     * Define el valor de la propiedad columnWidth.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnWidth(Integer value) {
        this.columnWidth = value;
    }

    /**
     * Obtiene el valor de la propiedad fileDefinitionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileDefinitionId() {
        return fileDefinitionId;
    }

    /**
     * Define el valor de la propiedad fileDefinitionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileDefinitionId(Long value) {
        this.fileDefinitionId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileInterfaceId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileInterfaceId() {
        return fileInterfaceId;
    }

    /**
     * Define el valor de la propiedad fileInterfaceId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileInterfaceId(Long value) {
        this.fileInterfaceId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileName() {
        return fileName;
    }

    /**
     * Define el valor de la propiedad fileName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileName(JAXBElement<String> value) {
        this.fileName = value;
    }

    /**
     * Obtiene el valor de la propiedad fileTypeId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileTypeId() {
        return fileTypeId;
    }

    /**
     * Define el valor de la propiedad fileTypeId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileTypeId(Long value) {
        this.fileTypeId = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterfaceName() {
        return interfaceName;
    }

    /**
     * Define el valor de la propiedad interfaceName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterfaceName(JAXBElement<String> value) {
        this.interfaceName = value;
    }

}
