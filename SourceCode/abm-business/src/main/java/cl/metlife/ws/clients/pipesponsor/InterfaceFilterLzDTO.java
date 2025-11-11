
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InterfaceFilterLzDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InterfaceFilterLzDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="ColumnDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileInterfaceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FilterFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FilterValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InterfaceFilterId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterfaceFilterLzDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "columnDefinitionId",
    "fileInterfaceId",
    "filterFormat",
    "filterValue",
    "interfaceFilterId",
    "isEnable"
})
public class InterfaceFilterLzDTO
    extends Dto
{

    @XmlElement(name = "ColumnDefinitionId")
    protected Long columnDefinitionId;
    @XmlElement(name = "FileInterfaceId")
    protected Long fileInterfaceId;
    @XmlElementRef(name = "FilterFormat", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filterFormat;
    @XmlElementRef(name = "FilterValue", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filterValue;
    @XmlElement(name = "InterfaceFilterId")
    protected Long interfaceFilterId;
    @XmlElement(name = "IsEnable")
    protected Short isEnable;

    /**
     * Obtiene el valor de la propiedad columnDefinitionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getColumnDefinitionId() {
        return columnDefinitionId;
    }

    /**
     * Define el valor de la propiedad columnDefinitionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setColumnDefinitionId(Long value) {
        this.columnDefinitionId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileInterfaceId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileInterfaceId() {
        return fileInterfaceId;
    }

    /**
     * Define el valor de la propiedad fileInterfaceId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileInterfaceId(Long value) {
        this.fileInterfaceId = value;
    }

    /**
     * Obtiene el valor de la propiedad filterFormat.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFilterFormat() {
        return filterFormat;
    }

    /**
     * Define el valor de la propiedad filterFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFilterFormat(JAXBElement<String> value) {
        this.filterFormat = value;
    }

    /**
     * Obtiene el valor de la propiedad filterValue.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFilterValue() {
        return filterValue;
    }

    /**
     * Define el valor de la propiedad filterValue.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFilterValue(JAXBElement<String> value) {
        this.filterValue = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceFilterId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterfaceFilterId() {
        return interfaceFilterId;
    }

    /**
     * Define el valor de la propiedad interfaceFilterId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterfaceFilterId(Long value) {
        this.interfaceFilterId = value;
    }

    /**
     * Obtiene el valor de la propiedad isEnable.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIsEnable() {
        return isEnable;
    }

    /**
     * Define el valor de la propiedad isEnable.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIsEnable(Short value) {
        this.isEnable = value;
    }

}
