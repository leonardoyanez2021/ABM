
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LogProcessTargetDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LogProcessTargetDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessObjectId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ErrDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InsertedRows" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LogProcessId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessTargetId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogProcessTargetDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObjectId",
    "errDescription",
    "insertedRows",
    "logProcessId",
    "logProcessTargetId"
})
public class LogProcessTargetDTO
    extends Dto
{

    @XmlElement(name = "BusinessObjectId")
    protected Long businessObjectId;
    @XmlElementRef(name = "ErrDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errDescription;
    @XmlElement(name = "InsertedRows")
    protected Integer insertedRows;
    @XmlElement(name = "LogProcessId")
    protected Long logProcessId;
    @XmlElement(name = "LogProcessTargetId")
    protected Long logProcessTargetId;

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
     * Obtiene el valor de la propiedad errDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrDescription() {
        return errDescription;
    }

    /**
     * Define el valor de la propiedad errDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrDescription(JAXBElement<String> value) {
        this.errDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad insertedRows.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInsertedRows() {
        return insertedRows;
    }

    /**
     * Define el valor de la propiedad insertedRows.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInsertedRows(Integer value) {
        this.insertedRows = value;
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

}
