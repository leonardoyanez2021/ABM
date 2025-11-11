
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SessionLogDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SessionLogDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="RolDefinedList" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="SessionLogId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SessionLogRolList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SessionLogSponsorList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SessionLogUsrMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SponsorDefinedList" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SessionLogDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "rolDefinedList",
    "sessionLogId",
    "sessionLogRolList",
    "sessionLogSponsorList",
    "sessionLogUsrMail",
    "sponsorDefinedList"
})
public class SessionLogDTO
    extends Dto
{

    @XmlElementRef(name = "RolDefinedList", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> rolDefinedList;
    @XmlElement(name = "SessionLogId")
    protected Long sessionLogId;
    @XmlElementRef(name = "SessionLogRolList", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sessionLogRolList;
    @XmlElementRef(name = "SessionLogSponsorList", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sessionLogSponsorList;
    @XmlElementRef(name = "SessionLogUsrMail", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sessionLogUsrMail;
    @XmlElementRef(name = "SponsorDefinedList", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> sponsorDefinedList;

    /**
     * Obtiene el valor de la propiedad rolDefinedList.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getRolDefinedList() {
        return rolDefinedList;
    }

    /**
     * Define el valor de la propiedad rolDefinedList.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setRolDefinedList(JAXBElement<ArrayOfstring> value) {
        this.rolDefinedList = value;
    }

    /**
     * Obtiene el valor de la propiedad sessionLogId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSessionLogId() {
        return sessionLogId;
    }

    /**
     * Define el valor de la propiedad sessionLogId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSessionLogId(Long value) {
        this.sessionLogId = value;
    }

    /**
     * Obtiene el valor de la propiedad sessionLogRolList.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSessionLogRolList() {
        return sessionLogRolList;
    }

    /**
     * Define el valor de la propiedad sessionLogRolList.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSessionLogRolList(JAXBElement<String> value) {
        this.sessionLogRolList = value;
    }

    /**
     * Obtiene el valor de la propiedad sessionLogSponsorList.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSessionLogSponsorList() {
        return sessionLogSponsorList;
    }

    /**
     * Define el valor de la propiedad sessionLogSponsorList.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSessionLogSponsorList(JAXBElement<String> value) {
        this.sessionLogSponsorList = value;
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
     * Obtiene el valor de la propiedad sponsorDefinedList.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getSponsorDefinedList() {
        return sponsorDefinedList;
    }

    /**
     * Define el valor de la propiedad sponsorDefinedList.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setSponsorDefinedList(JAXBElement<ArrayOfstring> value) {
        this.sponsorDefinedList = value;
    }

}
