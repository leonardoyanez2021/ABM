
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para SponsorProcessLogDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SponsorProcessLogDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessObjectId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BusinessObjectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileError" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InsertedNRows" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessFileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ProcessDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ProcessFinishDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ProcessStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportedNRows" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SponsorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SponsorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SponsorProcessLogDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObjectId",
    "businessObjectName",
    "fileError",
    "fileName",
    "insertedNRows",
    "logProcessFileId",
    "logProcessId",
    "logProcessTargetId",
    "processDate",
    "processFinishDate",
    "processStatus",
    "reportedNRows",
    "sponsorCode",
    "sponsorName"
})
public class SponsorProcessLogDTO
    extends Dto
{

    @XmlElement(name = "BusinessObjectId")
    protected Long businessObjectId;
    @XmlElementRef(name = "BusinessObjectName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessObjectName;
    @XmlElement(name = "FileError")
    protected Boolean fileError;
    @XmlElementRef(name = "FileName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileName;
    @XmlElement(name = "InsertedNRows")
    protected Long insertedNRows;
    @XmlElement(name = "LogProcessFileId")
    protected Long logProcessFileId;
    @XmlElement(name = "LogProcessId")
    protected Long logProcessId;
    @XmlElement(name = "LogProcessTargetId")
    protected Long logProcessTargetId;
    @XmlElement(name = "ProcessDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processDate;
    @XmlElement(name = "ProcessFinishDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processFinishDate;
    @XmlElementRef(name = "ProcessStatus", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processStatus;
    @XmlElement(name = "ReportedNRows")
    protected Long reportedNRows;
    @XmlElementRef(name = "SponsorCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorCode;
    @XmlElementRef(name = "SponsorName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorName;

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
     * Obtiene el valor de la propiedad businessObjectName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessObjectName() {
        return businessObjectName;
    }

    /**
     * Define el valor de la propiedad businessObjectName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessObjectName(JAXBElement<String> value) {
        this.businessObjectName = value;
    }

    /**
     * Obtiene el valor de la propiedad fileError.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFileError() {
        return fileError;
    }

    /**
     * Define el valor de la propiedad fileError.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFileError(Boolean value) {
        this.fileError = value;
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
     * Obtiene el valor de la propiedad insertedNRows.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInsertedNRows() {
        return insertedNRows;
    }

    /**
     * Define el valor de la propiedad insertedNRows.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInsertedNRows(Long value) {
        this.insertedNRows = value;
    }

    /**
     * Obtiene el valor de la propiedad logProcessFileId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogProcessFileId() {
        return logProcessFileId;
    }

    /**
     * Define el valor de la propiedad logProcessFileId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogProcessFileId(Long value) {
        this.logProcessFileId = value;
    }

    /**
     * Obtiene el valor de la propiedad logProcessId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogProcessId() {
        return logProcessId;
    }

    /**
     * Define el valor de la propiedad logProcessId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogProcessId(Long value) {
        this.logProcessId = value;
    }

    /**
     * Obtiene el valor de la propiedad logProcessTargetId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogProcessTargetId() {
        return logProcessTargetId;
    }

    /**
     * Define el valor de la propiedad logProcessTargetId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogProcessTargetId(Long value) {
        this.logProcessTargetId = value;
    }

    /**
     * Obtiene el valor de la propiedad processDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessDate() {
        return processDate;
    }

    /**
     * Define el valor de la propiedad processDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessDate(XMLGregorianCalendar value) {
        this.processDate = value;
    }

    /**
     * Obtiene el valor de la propiedad processFinishDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessFinishDate() {
        return processFinishDate;
    }

    /**
     * Define el valor de la propiedad processFinishDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessFinishDate(XMLGregorianCalendar value) {
        this.processFinishDate = value;
    }

    /**
     * Obtiene el valor de la propiedad processStatus.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessStatus() {
        return processStatus;
    }

    /**
     * Define el valor de la propiedad processStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessStatus(JAXBElement<String> value) {
        this.processStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad reportedNRows.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReportedNRows() {
        return reportedNRows;
    }

    /**
     * Define el valor de la propiedad reportedNRows.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReportedNRows(Long value) {
        this.reportedNRows = value;
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

    /**
     * Obtiene el valor de la propiedad sponsorName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSponsorName() {
        return sponsorName;
    }

    /**
     * Define el valor de la propiedad sponsorName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSponsorName(JAXBElement<String> value) {
        this.sponsorName = value;
    }

}
