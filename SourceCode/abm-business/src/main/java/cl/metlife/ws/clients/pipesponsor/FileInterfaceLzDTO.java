
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FileInterfaceLzDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FileInterfaceLzDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="FileDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileInterfaceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="InterfaceColumnCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="InterfaceColumnDelimiter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InterfaceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InterfaceNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InterfaceRowFooterCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="InterfaceRowHeaderCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="InterfaceSkipEmptyRows" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="InterfaceTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "FileInterfaceLzDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "fileDefinitionId",
    "fileInterfaceId",
    "interfaceColumnCount",
    "interfaceColumnDelimiter",
    "interfaceName",
    "interfaceNotes",
    "interfaceRowFooterCount",
    "interfaceRowHeaderCount",
    "interfaceSkipEmptyRows",
    "interfaceTypeId",
    "isEnable"
})
public class FileInterfaceLzDTO
    extends Dto
{

    @XmlElement(name = "FileDefinitionId")
    protected Long fileDefinitionId;
    @XmlElement(name = "FileInterfaceId")
    protected Long fileInterfaceId;
    @XmlElement(name = "InterfaceColumnCount")
    protected Integer interfaceColumnCount;
    @XmlElementRef(name = "InterfaceColumnDelimiter", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interfaceColumnDelimiter;
    @XmlElementRef(name = "InterfaceName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interfaceName;
    @XmlElementRef(name = "InterfaceNotes", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interfaceNotes;
    @XmlElement(name = "InterfaceRowFooterCount")
    protected Integer interfaceRowFooterCount;
    @XmlElement(name = "InterfaceRowHeaderCount")
    protected Integer interfaceRowHeaderCount;
    @XmlElement(name = "InterfaceSkipEmptyRows")
    protected Short interfaceSkipEmptyRows;
    @XmlElement(name = "InterfaceTypeId")
    protected Long interfaceTypeId;
    @XmlElement(name = "IsEnable")
    protected Short isEnable;

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
     * Obtiene el valor de la propiedad interfaceColumnCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInterfaceColumnCount() {
        return interfaceColumnCount;
    }

    /**
     * Define el valor de la propiedad interfaceColumnCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInterfaceColumnCount(Integer value) {
        this.interfaceColumnCount = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceColumnDelimiter.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterfaceColumnDelimiter() {
        return interfaceColumnDelimiter;
    }

    /**
     * Define el valor de la propiedad interfaceColumnDelimiter.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterfaceColumnDelimiter(JAXBElement<String> value) {
        this.interfaceColumnDelimiter = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterfaceName() {
        return interfaceName;
    }

    /**
     * Define el valor de la propiedad interfaceName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterfaceName(JAXBElement<String> value) {
        this.interfaceName = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceNotes.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInterfaceNotes() {
        return interfaceNotes;
    }

    /**
     * Define el valor de la propiedad interfaceNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInterfaceNotes(JAXBElement<String> value) {
        this.interfaceNotes = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceRowFooterCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInterfaceRowFooterCount() {
        return interfaceRowFooterCount;
    }

    /**
     * Define el valor de la propiedad interfaceRowFooterCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInterfaceRowFooterCount(Integer value) {
        this.interfaceRowFooterCount = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceRowHeaderCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInterfaceRowHeaderCount() {
        return interfaceRowHeaderCount;
    }

    /**
     * Define el valor de la propiedad interfaceRowHeaderCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInterfaceRowHeaderCount(Integer value) {
        this.interfaceRowHeaderCount = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceSkipEmptyRows.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getInterfaceSkipEmptyRows() {
        return interfaceSkipEmptyRows;
    }

    /**
     * Define el valor de la propiedad interfaceSkipEmptyRows.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setInterfaceSkipEmptyRows(Short value) {
        this.interfaceSkipEmptyRows = value;
    }

    /**
     * Obtiene el valor de la propiedad interfaceTypeId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterfaceTypeId() {
        return interfaceTypeId;
    }

    /**
     * Define el valor de la propiedad interfaceTypeId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterfaceTypeId(Long value) {
        this.interfaceTypeId = value;
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
