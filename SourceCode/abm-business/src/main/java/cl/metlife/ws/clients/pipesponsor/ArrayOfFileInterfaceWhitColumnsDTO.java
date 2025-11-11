
package cl.metlife.ws.clients.pipesponsor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfFileInterfaceWhitColumnsDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFileInterfaceWhitColumnsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileInterfaceWhitColumnsDTO" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}FileInterfaceWhitColumnsDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFileInterfaceWhitColumnsDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "fileInterfaceWhitColumnsDTO"
})
public class ArrayOfFileInterfaceWhitColumnsDTO {

    @XmlElement(name = "FileInterfaceWhitColumnsDTO", nillable = true)
    protected List<FileInterfaceWhitColumnsDTO> fileInterfaceWhitColumnsDTO;

    /**
     * Gets the value of the fileInterfaceWhitColumnsDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileInterfaceWhitColumnsDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileInterfaceWhitColumnsDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileInterfaceWhitColumnsDTO }
     * 
     * 
     */
    public List<FileInterfaceWhitColumnsDTO> getFileInterfaceWhitColumnsDTO() {
        if (fileInterfaceWhitColumnsDTO == null) {
            fileInterfaceWhitColumnsDTO = new ArrayList<FileInterfaceWhitColumnsDTO>();
        }
        return this.fileInterfaceWhitColumnsDTO;
    }

}
