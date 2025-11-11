
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="owner" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}OutputConnectionDTO" minOccurs="0"/>
 *         &lt;element name="tableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "owner",
    "tableName"
})
@XmlRootElement(name = "GetTableScript")
public class GetTableScript {

    @XmlElementRef(name = "owner", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<OutputConnectionDTO> owner;
    @XmlElementRef(name = "tableName", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tableName;

    /**
     * Obtiene el valor de la propiedad owner.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OutputConnectionDTO }{@code >}
     *     
     */
    public JAXBElement<OutputConnectionDTO> getOwner() {
        return owner;
    }

    /**
     * Define el valor de la propiedad owner.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OutputConnectionDTO }{@code >}
     *     
     */
    public void setOwner(JAXBElement<OutputConnectionDTO> value) {
        this.owner = value;
    }

    /**
     * Obtiene el valor de la propiedad tableName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTableName() {
        return tableName;
    }

    /**
     * Define el valor de la propiedad tableName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTableName(JAXBElement<String> value) {
        this.tableName = value;
    }

}
