
package cl.metlife.ws.clients.preingreso.bulk;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfErrorBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfErrorBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorBo" type="{http://preingreso.metlife.cl/}ErrorBo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfErrorBo", propOrder = {
    "errorBo"
})
public class ArrayOfErrorBo {

    @XmlElement(name = "ErrorBo", nillable = true)
    protected List<ErrorBo> errorBo;

    /**
     * Gets the value of the errorBo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorBo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorBo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorBo }
     * 
     * 
     */
    public List<ErrorBo> getErrorBo() {
        if (errorBo == null) {
            errorBo = new ArrayList<ErrorBo>();
        }
        return this.errorBo;
    }

}
