
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
 *         &lt;element name="NewInterfaceFilterResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}InterfaceFilterLzDTO" minOccurs="0"/>
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
    "newInterfaceFilterResult"
})
@XmlRootElement(name = "NewInterfaceFilterResponse")
public class NewInterfaceFilterResponse {

    @XmlElementRef(name = "NewInterfaceFilterResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<InterfaceFilterLzDTO> newInterfaceFilterResult;

    /**
     * Obtiene el valor de la propiedad newInterfaceFilterResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InterfaceFilterLzDTO }{@code >}
     *     
     */
    public JAXBElement<InterfaceFilterLzDTO> getNewInterfaceFilterResult() {
        return newInterfaceFilterResult;
    }

    /**
     * Define el valor de la propiedad newInterfaceFilterResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InterfaceFilterLzDTO }{@code >}
     *     
     */
    public void setNewInterfaceFilterResult(JAXBElement<InterfaceFilterLzDTO> value) {
        this.newInterfaceFilterResult = value;
    }

}
