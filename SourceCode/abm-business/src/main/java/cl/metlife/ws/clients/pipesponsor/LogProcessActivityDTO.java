
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
 * <p>Clase Java para LogProcessActivityDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LogProcessActivityDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="FinishTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="IsException" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LogProcessActivityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ProcessStep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="StepNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StepResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogProcessActivityDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "finishTime",
    "isException",
    "logProcessActivityId",
    "logProcessId",
    "processStep",
    "startTime",
    "stepNumber",
    "stepResult"
})
public class LogProcessActivityDTO
    extends Dto
{

    @XmlElement(name = "FinishTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar finishTime;
    @XmlElement(name = "IsException")
    protected Boolean isException;
    @XmlElement(name = "LogProcessActivityId")
    protected Long logProcessActivityId;
    @XmlElement(name = "LogProcessId")
    protected Long logProcessId;
    @XmlElementRef(name = "ProcessStep", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processStep;
    @XmlElement(name = "StartTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElementRef(name = "StepNumber", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stepNumber;
    @XmlElementRef(name = "StepResult", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stepResult;

    /**
     * Obtiene el valor de la propiedad finishTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinishTime() {
        return finishTime;
    }

    /**
     * Define el valor de la propiedad finishTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinishTime(XMLGregorianCalendar value) {
        this.finishTime = value;
    }

    /**
     * Obtiene el valor de la propiedad isException.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsException() {
        return isException;
    }

    /**
     * Define el valor de la propiedad isException.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsException(Boolean value) {
        this.isException = value;
    }

    /**
     * Obtiene el valor de la propiedad logProcessActivityId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogProcessActivityId() {
        return logProcessActivityId;
    }

    /**
     * Define el valor de la propiedad logProcessActivityId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogProcessActivityId(Long value) {
        this.logProcessActivityId = value;
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
     * Obtiene el valor de la propiedad processStep.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessStep() {
        return processStep;
    }

    /**
     * Define el valor de la propiedad processStep.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessStep(JAXBElement<String> value) {
        this.processStep = value;
    }

    /**
     * Obtiene el valor de la propiedad startTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Define el valor de la propiedad startTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Obtiene el valor de la propiedad stepNumber.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStepNumber() {
        return stepNumber;
    }

    /**
     * Define el valor de la propiedad stepNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStepNumber(JAXBElement<String> value) {
        this.stepNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad stepResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStepResult() {
        return stepResult;
    }

    /**
     * Define el valor de la propiedad stepResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStepResult(JAXBElement<String> value) {
        this.stepResult = value;
    }

}
