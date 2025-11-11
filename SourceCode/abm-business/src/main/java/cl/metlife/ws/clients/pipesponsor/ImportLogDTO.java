
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
 * <p>Clase Java para ImportLogDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ImportLogDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessObjectsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FilesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ImportLogId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ImportStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "ImportLogDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObjectsName",
    "filesName",
    "importDate",
    "importLogId",
    "importStatus",
    "sponsorCode"
})
public class ImportLogDTO
    extends Dto
{

    @XmlElementRef(name = "BusinessObjectsName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> businessObjectsName;
    @XmlElementRef(name = "FilesName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filesName;
    @XmlElement(name = "ImportDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar importDate;
    @XmlElement(name = "ImportLogId")
    protected Long importLogId;
    @XmlElement(name = "ImportStatus")
    protected Integer importStatus;
    @XmlElementRef(name = "SponsorCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorCode;

    /**
     * Obtiene el valor de la propiedad businessObjectsName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBusinessObjectsName() {
        return businessObjectsName;
    }

    /**
     * Define el valor de la propiedad businessObjectsName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBusinessObjectsName(JAXBElement<String> value) {
        this.businessObjectsName = value;
    }

    /**
     * Obtiene el valor de la propiedad filesName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFilesName() {
        return filesName;
    }

    /**
     * Define el valor de la propiedad filesName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFilesName(JAXBElement<String> value) {
        this.filesName = value;
    }

    /**
     * Obtiene el valor de la propiedad importDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getImportDate() {
        return importDate;
    }

    /**
     * Define el valor de la propiedad importDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setImportDate(XMLGregorianCalendar value) {
        this.importDate = value;
    }

    /**
     * Obtiene el valor de la propiedad importLogId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getImportLogId() {
        return importLogId;
    }

    /**
     * Define el valor de la propiedad importLogId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setImportLogId(Long value) {
        this.importLogId = value;
    }

    /**
     * Obtiene el valor de la propiedad importStatus.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getImportStatus() {
        return importStatus;
    }

    /**
     * Define el valor de la propiedad importStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImportStatus(Integer value) {
        this.importStatus = value;
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
