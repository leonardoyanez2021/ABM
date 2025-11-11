
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
 *         &lt;element name="GetImportConfigPagedResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}PagedListDTOOfImportLogDTOTg3ItwTH" minOccurs="0"/>
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
    "getImportConfigPagedResult"
})
@XmlRootElement(name = "GetImportConfigPagedResponse")
public class GetImportConfigPagedResponse {

    @XmlElementRef(name = "GetImportConfigPagedResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PagedListDTOOfImportLogDTOTg3ItwTH> getImportConfigPagedResult;

    /**
     * Obtiene el valor de la propiedad getImportConfigPagedResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfImportLogDTOTg3ItwTH }{@code >}
     *     
     */
    public JAXBElement<PagedListDTOOfImportLogDTOTg3ItwTH> getGetImportConfigPagedResult() {
        return getImportConfigPagedResult;
    }

    /**
     * Define el valor de la propiedad getImportConfigPagedResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PagedListDTOOfImportLogDTOTg3ItwTH }{@code >}
     *     
     */
    public void setGetImportConfigPagedResult(JAXBElement<PagedListDTOOfImportLogDTOTg3ItwTH> value) {
        this.getImportConfigPagedResult = value;
    }

}
