
package cl.metlife.ws.clients.pipesponsor;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ColumnDefinitionLzDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ColumnDefinitionLzDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="ColumnAllowBlanks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ColumnDataTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ColumnDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ColumnFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColumnIsKey" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ColumnIsMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ColumnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColumnNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColumnOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ColumnWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FileDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileInterfaceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MaxDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MaxNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MinDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MinNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RutVCheckDigit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeListId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnDefinitionLzDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "columnAllowBlanks",
    "columnDataTypeId",
    "columnDefinitionId",
    "columnFormat",
    "columnIsKey",
    "columnIsMandatory",
    "columnName",
    "columnNotes",
    "columnOrder",
    "columnWidth",
    "fileDefinitionId",
    "fileInterfaceId",
    "fileName",
    "fileTypeDescription",
    "fileTypeId",
    "isEnable",
    "maxDate",
    "maxNumber",
    "minDate",
    "minNumber",
    "rutVCheckDigit",
    "typeDescription",
    "typeListId"
})
public class ColumnDefinitionLzDTO
    extends Dto
{

    @XmlElement(name = "ColumnAllowBlanks")
    protected Boolean columnAllowBlanks;
    @XmlElement(name = "ColumnDataTypeId")
    protected Integer columnDataTypeId;
    @XmlElement(name = "ColumnDefinitionId")
    protected Long columnDefinitionId;
    @XmlElementRef(name = "ColumnFormat", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> columnFormat;
    @XmlElement(name = "ColumnIsKey")
    protected Boolean columnIsKey;
    @XmlElement(name = "ColumnIsMandatory")
    protected Boolean columnIsMandatory;
    @XmlElementRef(name = "ColumnName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> columnName;
    @XmlElementRef(name = "ColumnNotes", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> columnNotes;
    @XmlElement(name = "ColumnOrder")
    protected Integer columnOrder;
    @XmlElement(name = "ColumnWidth")
    protected Integer columnWidth;
    @XmlElement(name = "FileDefinitionId")
    protected Long fileDefinitionId;
    @XmlElementRef(name = "FileInterfaceId", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> fileInterfaceId;
    @XmlElementRef(name = "FileName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileName;
    @XmlElementRef(name = "FileTypeDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileTypeDescription;
    @XmlElement(name = "FileTypeId")
    protected Long fileTypeId;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElementRef(name = "MaxDate", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> maxDate;
    @XmlElementRef(name = "MaxNumber", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> maxNumber;
    @XmlElementRef(name = "MinDate", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> minDate;
    @XmlElementRef(name = "MinNumber", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> minNumber;
    @XmlElementRef(name = "RutVCheckDigit", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> rutVCheckDigit;
    @XmlElementRef(name = "TypeDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> typeDescription;
    @XmlElementRef(name = "TypeListId", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> typeListId;

    /**
     * Obtiene el valor de la propiedad columnAllowBlanks.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isColumnAllowBlanks() {
        return columnAllowBlanks;
    }

    /**
     * Define el valor de la propiedad columnAllowBlanks.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setColumnAllowBlanks(Boolean value) {
        this.columnAllowBlanks = value;
    }

    /**
     * Obtiene el valor de la propiedad columnDataTypeId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getColumnDataTypeId() {
        return columnDataTypeId;
    }

    /**
     * Define el valor de la propiedad columnDataTypeId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnDataTypeId(Integer value) {
        this.columnDataTypeId = value;
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
     * Obtiene el valor de la propiedad columnFormat.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getColumnFormat() {
        return columnFormat;
    }

    /**
     * Define el valor de la propiedad columnFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setColumnFormat(JAXBElement<String> value) {
        this.columnFormat = value;
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
     * Obtiene el valor de la propiedad columnNotes.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getColumnNotes() {
        return columnNotes;
    }

    /**
     * Define el valor de la propiedad columnNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setColumnNotes(JAXBElement<String> value) {
        this.columnNotes = value;
    }

    /**
     * Obtiene el valor de la propiedad columnOrder.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getColumnOrder() {
        return columnOrder;
    }

    /**
     * Define el valor de la propiedad columnOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnOrder(Integer value) {
        this.columnOrder = value;
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
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getFileInterfaceId() {
        return fileInterfaceId;
    }

    /**
     * Define el valor de la propiedad fileInterfaceId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setFileInterfaceId(JAXBElement<Long> value) {
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
     * Obtiene el valor de la propiedad fileTypeDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileTypeDescription() {
        return fileTypeDescription;
    }

    /**
     * Define el valor de la propiedad fileTypeDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileTypeDescription(JAXBElement<String> value) {
        this.fileTypeDescription = value;
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
     * Obtiene el valor de la propiedad maxDate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getMaxDate() {
        return maxDate;
    }

    /**
     * Define el valor de la propiedad maxDate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setMaxDate(JAXBElement<XMLGregorianCalendar> value) {
        this.maxDate = value;
    }

    /**
     * Obtiene el valor de la propiedad maxNumber.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMaxNumber() {
        return maxNumber;
    }

    /**
     * Define el valor de la propiedad maxNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMaxNumber(JAXBElement<BigDecimal> value) {
        this.maxNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad minDate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getMinDate() {
        return minDate;
    }

    /**
     * Define el valor de la propiedad minDate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setMinDate(JAXBElement<XMLGregorianCalendar> value) {
        this.minDate = value;
    }

    /**
     * Obtiene el valor de la propiedad minNumber.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMinNumber() {
        return minNumber;
    }

    /**
     * Define el valor de la propiedad minNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMinNumber(JAXBElement<BigDecimal> value) {
        this.minNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad rutVCheckDigit.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getRutVCheckDigit() {
        return rutVCheckDigit;
    }

    /**
     * Define el valor de la propiedad rutVCheckDigit.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setRutVCheckDigit(JAXBElement<Long> value) {
        this.rutVCheckDigit = value;
    }

    /**
     * Obtiene el valor de la propiedad typeDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTypeDescription() {
        return typeDescription;
    }

    /**
     * Define el valor de la propiedad typeDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTypeDescription(JAXBElement<String> value) {
        this.typeDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad typeListId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getTypeListId() {
        return typeListId;
    }

    /**
     * Define el valor de la propiedad typeListId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setTypeListId(JAXBElement<Integer> value) {
        this.typeListId = value;
    }

}
