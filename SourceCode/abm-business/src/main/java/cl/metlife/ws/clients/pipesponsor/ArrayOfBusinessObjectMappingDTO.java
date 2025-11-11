
package cl.metlife.ws.clients.pipesponsor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfBusinessObjectMappingDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBusinessObjectMappingDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusinessObjectMappingDTO" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}BusinessObjectMappingDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBusinessObjectMappingDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "businessObjectMappingDTO"
})
public class ArrayOfBusinessObjectMappingDTO {

    @XmlElement(name = "BusinessObjectMappingDTO", nillable = true)
    protected List<BusinessObjectMappingDTO> businessObjectMappingDTO;

    /**
     * Gets the value of the businessObjectMappingDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessObjectMappingDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessObjectMappingDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusinessObjectMappingDTO }
     * 
     * 
     */
    public List<BusinessObjectMappingDTO> getBusinessObjectMappingDTO() {
        if (businessObjectMappingDTO == null) {
            businessObjectMappingDTO = new ArrayList<BusinessObjectMappingDTO>();
        }
        return this.businessObjectMappingDTO;
    }

}
