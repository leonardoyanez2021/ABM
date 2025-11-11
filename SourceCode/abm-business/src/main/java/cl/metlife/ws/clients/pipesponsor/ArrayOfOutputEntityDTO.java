
package cl.metlife.ws.clients.pipesponsor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfOutputEntityDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOutputEntityDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputEntityDTO" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}OutputEntityDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOutputEntityDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "outputEntityDTO"
})
public class ArrayOfOutputEntityDTO {

    @XmlElement(name = "OutputEntityDTO", nillable = true)
    protected List<OutputEntityDTO> outputEntityDTO;

    /**
     * Gets the value of the outputEntityDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputEntityDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputEntityDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputEntityDTO }
     * 
     * 
     */
    public List<OutputEntityDTO> getOutputEntityDTO() {
        if (outputEntityDTO == null) {
            outputEntityDTO = new ArrayList<OutputEntityDTO>();
        }
        return this.outputEntityDTO;
    }

}
