
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TypeListDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TypeListDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ItemCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SponsorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeListDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeListId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="TypeListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeListDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "isEnable",
    "itemCount",
    "sponsorCode",
    "typeListDescription",
    "typeListId",
    "typeListName"
})
public class TypeListDTO
    extends Dto
{

    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElement(name = "ItemCount")
    protected Integer itemCount;
    @XmlElementRef(name = "SponsorCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorCode;
    @XmlElementRef(name = "TypeListDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> typeListDescription;
    @XmlElement(name = "TypeListId")
    protected Integer typeListId;
    @XmlElementRef(name = "TypeListName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> typeListName;

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
     * Obtiene el valor de la propiedad itemCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getItemCount() {
        return itemCount;
    }

    /**
     * Define el valor de la propiedad itemCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setItemCount(Integer value) {
        this.itemCount = value;
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
     * Obtiene el valor de la propiedad typeListDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTypeListDescription() {
        return typeListDescription;
    }

    /**
     * Define el valor de la propiedad typeListDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTypeListDescription(JAXBElement<String> value) {
        this.typeListDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad typeListId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTypeListId() {
        return typeListId;
    }

    /**
     * Define el valor de la propiedad typeListId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTypeListId(Integer value) {
        this.typeListId = value;
    }

    /**
     * Obtiene el valor de la propiedad typeListName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTypeListName() {
        return typeListName;
    }

    /**
     * Define el valor de la propiedad typeListName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTypeListName(JAXBElement<String> value) {
        this.typeListName = value;
    }

}
