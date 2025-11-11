
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SponsorRemoteFiles complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SponsorRemoteFiles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileBuffer" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="FileDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InsertedNRows" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ReportedNRows" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SponsorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SponsorRemoteFiles", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.DistributedServices.MainBoundedContext", propOrder = {
    "extension",
    "fileBuffer",
    "fileDefinitionId",
    "fileName",
    "fileOrgName",
    "insertedNRows",
    "reportedNRows",
    "sponsorCode",
    "userMail"
})
public class SponsorRemoteFiles {

    @XmlElementRef(name = "Extension", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.DistributedServices.MainBoundedContext", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extension;
    @XmlElementRef(name = "FileBuffer", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.DistributedServices.MainBoundedContext", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> fileBuffer;
    @XmlElement(name = "FileDefinitionId")
    protected Long fileDefinitionId;
    @XmlElementRef(name = "FileName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.DistributedServices.MainBoundedContext", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileName;
    @XmlElementRef(name = "FileOrgName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.DistributedServices.MainBoundedContext", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileOrgName;
    @XmlElement(name = "InsertedNRows")
    protected Long insertedNRows;
    @XmlElement(name = "ReportedNRows")
    protected Long reportedNRows;
    @XmlElementRef(name = "SponsorCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.DistributedServices.MainBoundedContext", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorCode;
    @XmlElementRef(name = "UserMail", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.DistributedServices.MainBoundedContext", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userMail;

    /**
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExtension() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtension(JAXBElement<String> value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad fileBuffer.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getFileBuffer() {
        return fileBuffer;
    }

    /**
     * Define el valor de la propiedad fileBuffer.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setFileBuffer(JAXBElement<byte[]> value) {
        this.fileBuffer = value;
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
     * Obtiene el valor de la propiedad userMail.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserMail() {
        return userMail;
    }

    /**
     * Define el valor de la propiedad userMail.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserMail(JAXBElement<String> value) {
        this.userMail = value;
    }

}
