
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
 *         &lt;element name="FindBusinessObjectFieldByObjectLzResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfBusinessObjectFieldLzDTO" minOccurs="0"/>
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
    "findBusinessObjectFieldByObjectLzResult"
})
@XmlRootElement(name = "FindBusinessObjectFieldByObjectLzResponse")
public class FindBusinessObjectFieldByObjectLzResponse {

    @XmlElementRef(name = "FindBusinessObjectFieldByObjectLzResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBusinessObjectFieldLzDTO> findBusinessObjectFieldByObjectLzResult;

    /**
     * Obtiene el valor de la propiedad findBusinessObjectFieldByObjectLzResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBusinessObjectFieldLzDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBusinessObjectFieldLzDTO> getFindBusinessObjectFieldByObjectLzResult() {
        return findBusinessObjectFieldByObjectLzResult;
    }

    /**
     * Define el valor de la propiedad findBusinessObjectFieldByObjectLzResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBusinessObjectFieldLzDTO }{@code >}
     *     
     */
    public void setFindBusinessObjectFieldByObjectLzResult(JAXBElement<ArrayOfBusinessObjectFieldLzDTO> value) {
        this.findBusinessObjectFieldByObjectLzResult = value;
    }

}
