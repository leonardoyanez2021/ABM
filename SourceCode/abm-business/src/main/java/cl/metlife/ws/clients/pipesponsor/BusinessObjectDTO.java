
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para BusinessObjectDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BusinessObjectDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="BusinessObjectId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ColumnsCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsProcess" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ObjectDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ObjectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessObjectDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObjectId",
    "columnsCount",
    "isEnable",
    "isProcess",
    "objectDescription",
    "objectName"
})
public class BusinessObjectDTO
    extends Dto
{

    @XmlElement(name = "BusinessObjectId")
    protected Long businessObjectId;
    @XmlElement(name = "ColumnsCount")
    protected Integer columnsCount;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElement(name = "IsProcess")
    protected Boolean isProcess;
    @XmlElementRef(name = "ObjectDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> objectDescription;
    @XmlElementRef(name = "ObjectName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> objectName;

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
     * Obtiene el valor de la propiedad columnsCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getColumnsCount() {
        return columnsCount;
    }

    /**
     * Define el valor de la propiedad columnsCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnsCount(Integer value) {
        this.columnsCount = value;
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
     * Obtiene el valor de la propiedad isProcess.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsProcess() {
        return isProcess;
    }

    /**
     * Define el valor de la propiedad isProcess.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsProcess(Boolean value) {
        this.isProcess = value;
    }

    /**
     * Obtiene el valor de la propiedad objectDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getObjectDescription() {
        return objectDescription;
    }

    /**
     * Define el valor de la propiedad objectDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setObjectDescription(JAXBElement<String> value) {
        this.objectDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad objectName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getObjectName() {
        return objectName;
    }

    /**
     * Define el valor de la propiedad objectName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setObjectName(JAXBElement<String> value) {
        this.objectName = value;
    }

}
