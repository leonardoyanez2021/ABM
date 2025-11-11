
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LogProcessFileDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LogProcessFileDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="ErrMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorsFound" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="FileOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InsertedNRows" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessDatas" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfLogProcessDataDTO" minOccurs="0"/>
 *         &lt;element name="LogProcessFileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ProcessFilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportedNRows" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogProcessFileDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "errMessage",
    "errorsFound",
    "fileOrgName",
    "insertedNRows",
    "logProcessDatas",
    "logProcessFileId",
    "logProcessId",
    "processFilePath",
    "reportedNRows"
})
public class LogProcessFileDTO
    extends Dto
{

    @XmlElementRef(name = "ErrMessage", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errMessage;
    @XmlElement(name = "ErrorsFound")
    protected Short errorsFound;
    @XmlElementRef(name = "FileOrgName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileOrgName;
    @XmlElement(name = "InsertedNRows")
    protected Long insertedNRows;
    @XmlElementRef(name = "LogProcessDatas", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfLogProcessDataDTO> logProcessDatas;
    @XmlElement(name = "LogProcessFileId")
    protected Long logProcessFileId;
    @XmlElement(name = "LogProcessId")
    protected Long logProcessId;
    @XmlElementRef(name = "ProcessFilePath", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processFilePath;
    @XmlElement(name = "ReportedNRows")
    protected Long reportedNRows;

    /**
     * Obtiene el valor de la propiedad errMessage.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrMessage() {
        return errMessage;
    }

    /**
     * Define el valor de la propiedad errMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrMessage(JAXBElement<String> value) {
        this.errMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad errorsFound.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getErrorsFound() {
        return errorsFound;
    }

    /**
     * Define el valor de la propiedad errorsFound.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setErrorsFound(Short value) {
        this.errorsFound = value;
    }

    /**
     * Obtiene el valor de la propiedad fileOrgName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileOrgName() {
        return fileOrgName;
    }

    /**
     * Define el valor de la propiedad fileOrgName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileOrgName(JAXBElement<String> value) {
        this.fileOrgName = value;
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
     * Obtiene el valor de la propiedad logProcessDatas.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessDataDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLogProcessDataDTO> getLogProcessDatas() {
        return logProcessDatas;
    }

    /**
     * Define el valor de la propiedad logProcessDatas.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessDataDTO }{@code >}
     *     
     */
    public void setLogProcessDatas(JAXBElement<ArrayOfLogProcessDataDTO> value) {
        this.logProcessDatas = value;
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
     * Obtiene el valor de la propiedad processFilePath.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessFilePath() {
        return processFilePath;
    }

    /**
     * Define el valor de la propiedad processFilePath.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessFilePath(JAXBElement<String> value) {
        this.processFilePath = value;
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

}
