
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FileReportDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FileReportDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="FileColumnCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FileColumnDelimiter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileEncrypted" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileNameRegExpression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileRowFooterCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FileRowHeaderCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FileSkipEmptyRows" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileXsdPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SponsorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileReportDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "fileColumnCount",
    "fileColumnDelimiter",
    "fileDefinitionId",
    "fileEncrypted",
    "fileName",
    "fileNameRegExpression",
    "fileNotes",
    "fileRowFooterCount",
    "fileRowHeaderCount",
    "fileSkipEmptyRows",
    "fileTypeDescription",
    "fileXsdPath",
    "isEnable",
    "sponsorCode"
})
public class FileReportDTO
    extends Dto
{

    @XmlElement(name = "FileColumnCount")
    protected Integer fileColumnCount;
    @XmlElementRef(name = "FileColumnDelimiter", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileColumnDelimiter;
    @XmlElement(name = "FileDefinitionId")
    protected Long fileDefinitionId;
    @XmlElement(name = "FileEncrypted")
    @XmlSchemaType(name = "unsignedByte")
    protected Short fileEncrypted;
    @XmlElementRef(name = "FileName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileName;
    @XmlElementRef(name = "FileNameRegExpression", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileNameRegExpression;
    @XmlElementRef(name = "FileNotes", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileNotes;
    @XmlElement(name = "FileRowFooterCount")
    protected Integer fileRowFooterCount;
    @XmlElement(name = "FileRowHeaderCount")
    protected Integer fileRowHeaderCount;
    @XmlElementRef(name = "FileSkipEmptyRows", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileSkipEmptyRows;
    @XmlElementRef(name = "FileTypeDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileTypeDescription;
    @XmlElementRef(name = "FileXsdPath", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileXsdPath;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElementRef(name = "SponsorCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorCode;

    /**
     * Obtiene el valor de la propiedad fileColumnCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFileColumnCount() {
        return fileColumnCount;
    }

    /**
     * Define el valor de la propiedad fileColumnCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFileColumnCount(Integer value) {
        this.fileColumnCount = value;
    }

    /**
     * Obtiene el valor de la propiedad fileColumnDelimiter.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileColumnDelimiter() {
        return fileColumnDelimiter;
    }

    /**
     * Define el valor de la propiedad fileColumnDelimiter.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileColumnDelimiter(JAXBElement<String> value) {
        this.fileColumnDelimiter = value;
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
     * Obtiene el valor de la propiedad fileEncrypted.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getFileEncrypted() {
        return fileEncrypted;
    }

    /**
     * Define el valor de la propiedad fileEncrypted.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setFileEncrypted(Short value) {
        this.fileEncrypted = value;
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
     * Obtiene el valor de la propiedad fileNameRegExpression.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileNameRegExpression() {
        return fileNameRegExpression;
    }

    /**
     * Define el valor de la propiedad fileNameRegExpression.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileNameRegExpression(JAXBElement<String> value) {
        this.fileNameRegExpression = value;
    }

    /**
     * Obtiene el valor de la propiedad fileNotes.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileNotes() {
        return fileNotes;
    }

    /**
     * Define el valor de la propiedad fileNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileNotes(JAXBElement<String> value) {
        this.fileNotes = value;
    }

    /**
     * Obtiene el valor de la propiedad fileRowFooterCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFileRowFooterCount() {
        return fileRowFooterCount;
    }

    /**
     * Define el valor de la propiedad fileRowFooterCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFileRowFooterCount(Integer value) {
        this.fileRowFooterCount = value;
    }

    /**
     * Obtiene el valor de la propiedad fileRowHeaderCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFileRowHeaderCount() {
        return fileRowHeaderCount;
    }

    /**
     * Define el valor de la propiedad fileRowHeaderCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFileRowHeaderCount(Integer value) {
        this.fileRowHeaderCount = value;
    }

    /**
     * Obtiene el valor de la propiedad fileSkipEmptyRows.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileSkipEmptyRows() {
        return fileSkipEmptyRows;
    }

    /**
     * Define el valor de la propiedad fileSkipEmptyRows.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileSkipEmptyRows(JAXBElement<String> value) {
        this.fileSkipEmptyRows = value;
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
     * Obtiene el valor de la propiedad fileXsdPath.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileXsdPath() {
        return fileXsdPath;
    }

    /**
     * Define el valor de la propiedad fileXsdPath.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileXsdPath(JAXBElement<String> value) {
        this.fileXsdPath = value;
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
     * Obtiene el valor de la propiedad sponsorCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSponsorCode() {
        return sponsorCode;
    }

    /**
     * Define el valor de la propiedad sponsorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSponsorCode(JAXBElement<String> value) {
        this.sponsorCode = value;
    }

}
