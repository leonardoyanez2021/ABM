
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
 * <p>Clase Java para LogProcessDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LogProcessDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="LogProcessFiles" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfLogProcessFileDTO" minOccurs="0"/>
 *         &lt;element name="LogProcessId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LogProcessTargets" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfLogProcessTargetDTO" minOccurs="0"/>
 *         &lt;element name="SessionLogUsrMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "LogProcessDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "logProcessFiles",
    "logProcessId",
    "logProcessStartDate",
    "logProcessTargets",
    "sessionLogUsrMail",
    "sponsorCode"
})
public class LogProcessDTO
    extends Dto
{

    @XmlElementRef(name = "LogProcessFiles", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfLogProcessFileDTO> logProcessFiles;
    @XmlElement(name = "LogProcessId")
    protected Long logProcessId;
    @XmlElement(name = "LogProcessStartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar logProcessStartDate;
    @XmlElementRef(name = "LogProcessTargets", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfLogProcessTargetDTO> logProcessTargets;
    @XmlElementRef(name = "SessionLogUsrMail", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sessionLogUsrMail;
    @XmlElementRef(name = "SponsorCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorCode;

    /**
     * Obtiene el valor de la propiedad logProcessFiles.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessFileDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLogProcessFileDTO> getLogProcessFiles() {
        return logProcessFiles;
    }

    /**
     * Define el valor de la propiedad logProcessFiles.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessFileDTO }{@code >}
     *     
     */
    public void setLogProcessFiles(JAXBElement<ArrayOfLogProcessFileDTO> value) {
        this.logProcessFiles = value;
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
     * Obtiene el valor de la propiedad logProcessStartDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLogProcessStartDate() {
        return logProcessStartDate;
    }

    /**
     * Define el valor de la propiedad logProcessStartDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLogProcessStartDate(XMLGregorianCalendar value) {
        this.logProcessStartDate = value;
    }

    /**
     * Obtiene el valor de la propiedad logProcessTargets.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessTargetDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLogProcessTargetDTO> getLogProcessTargets() {
        return logProcessTargets;
    }

    /**
     * Define el valor de la propiedad logProcessTargets.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLogProcessTargetDTO }{@code >}
     *     
     */
    public void setLogProcessTargets(JAXBElement<ArrayOfLogProcessTargetDTO> value) {
        this.logProcessTargets = value;
    }

    /**
     * Obtiene el valor de la propiedad sessionLogUsrMail.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSessionLogUsrMail() {
        return sessionLogUsrMail;
    }

    /**
     * Define el valor de la propiedad sessionLogUsrMail.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSessionLogUsrMail(JAXBElement<String> value) {
        this.sessionLogUsrMail = value;
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
