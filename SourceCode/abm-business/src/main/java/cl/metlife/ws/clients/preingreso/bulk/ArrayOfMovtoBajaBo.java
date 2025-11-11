
package cl.metlife.ws.clients.preingreso.bulk;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfMovtoBajaBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMovtoBajaBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MovtoBajaBo" type="{http://preingreso.metlife.cl/}MovtoBajaBo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMovtoBajaBo", propOrder = {
    "movtoBajaBo"
})
public class ArrayOfMovtoBajaBo {

    @XmlElement(name = "MovtoBajaBo", nillable = true)
    protected List<MovtoBajaBo> movtoBajaBo;

    /**
     * Gets the value of the movtoBajaBo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the movtoBajaBo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMovtoBajaBo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MovtoBajaBo }
     * 
     * 
     */
    public List<MovtoBajaBo> getMovtoBajaBo() {
        if (movtoBajaBo == null) {
            movtoBajaBo = new ArrayList<MovtoBajaBo>();
        }
        return this.movtoBajaBo;
    }

}
