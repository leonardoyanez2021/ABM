
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LogProcessDataDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LogProcessDataDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="ErrDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LogProcessDataId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LogProcessFileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ProcessDataCol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessDataRow" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogProcessDataDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "errDescription",
    "errMessage",
    "logProcessDataId",
    "logProcessFileId",
    "processDataCol",
    "processDataRow"
})
public class LogProcessDataDTO
    extends Dto
{

    @XmlElementRef(name = "ErrDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errDescription;
    @XmlElementRef(name = "ErrMessage", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errMessage;
    @XmlElement(name = "LogProcessDataId")
    protected Long logProcessDataId;
    @XmlElement(name = "LogProcessFileId")
    protected Long logProcessFileId;
    @XmlElementRef(name = "ProcessDataCol", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> processDataCol;
    @XmlElement(name = "ProcessDataRow")
    protected Integer processDataRow;

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
     * Obtiene el valor de la propiedad logProcessDataId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLogProcessDataId() {
        return logProcessDataId;
    }

    /**
     * Define el valor de la propiedad logProcessDataId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLogProcessDataId(Long value) {
        this.logProcessDataId = value;
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
     * Obtiene el valor de la propiedad processDataCol.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProcessDataCol() {
        return processDataCol;
    }

    /**
     * Define el valor de la propiedad processDataCol.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProcessDataCol(JAXBElement<String> value) {
        this.processDataCol = value;
    }

    /**
     * Obtiene el valor de la propiedad processDataRow.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProcessDataRow() {
        return processDataRow;
    }

    /**
     * Define el valor de la propiedad processDataRow.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProcessDataRow(Integer value) {
        this.processDataRow = value;
    }

}
