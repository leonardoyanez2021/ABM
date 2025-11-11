
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PagedListDTOOfSponsorProcessLogDTOTg3ItwTH complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PagedListDTOOfSponsorProcessLogDTOTg3ItwTH">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="DataList" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfSponsorProcessLogDTO" minOccurs="0"/>
 *         &lt;element name="TotalItems" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagedListDTOOfSponsorProcessLogDTOTg3ItwTH", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "dataList",
    "totalItems"
})
public class PagedListDTOOfSponsorProcessLogDTOTg3ItwTH
    extends Dto
{

    @XmlElementRef(name = "DataList", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSponsorProcessLogDTO> dataList;
    @XmlElement(name = "TotalItems")
    protected Integer totalItems;

    /**
     * Obtiene el valor de la propiedad dataList.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSponsorProcessLogDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSponsorProcessLogDTO> getDataList() {
        return dataList;
    }

    /**
     * Define el valor de la propiedad dataList.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSponsorProcessLogDTO }{@code >}
     *     
     */
    public void setDataList(JAXBElement<ArrayOfSponsorProcessLogDTO> value) {
        this.dataList = value;
    }

    /**
     * Obtiene el valor de la propiedad totalItems.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalItems() {
        return totalItems;
    }

    /**
     * Define el valor de la propiedad totalItems.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalItems(Integer value) {
        this.totalItems = value;
    }

}
