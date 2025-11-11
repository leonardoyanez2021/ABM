
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
 *         &lt;element name="columnList" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfColumnDefinitionLzDTO" minOccurs="0"/>
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
    "columnList"
})
@XmlRootElement(name = "UpdateColumnsBulk")
public class UpdateColumnsBulk {

    @XmlElementRef(name = "columnList", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfColumnDefinitionLzDTO> columnList;

    /**
     * Obtiene el valor de la propiedad columnList.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfColumnDefinitionLzDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfColumnDefinitionLzDTO> getColumnList() {
        return columnList;
    }

    /**
     * Define el valor de la propiedad columnList.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfColumnDefinitionLzDTO }{@code >}
     *     
     */
    public void setColumnList(JAXBElement<ArrayOfColumnDefinitionLzDTO> value) {
        this.columnList = value;
    }

}
