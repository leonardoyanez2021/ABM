
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="ListarSetResult" type="{http://preingreso.metlife.cl/}ArrayOfSetBo" minOccurs="0"/>
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
    "listarSetResult"
})
@XmlRootElement(name = "ListarSetResponse")
public class ListarSetResponse {

    @XmlElement(name = "ListarSetResult")
    protected ArrayOfSetBo listarSetResult;

    /**
     * Obtiene el valor de la propiedad listarSetResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSetBo }
     *     
     */
    public ArrayOfSetBo getListarSetResult() {
        return listarSetResult;
    }

    /**
     * Define el valor de la propiedad listarSetResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSetBo }
     *     
     */
    public void setListarSetResult(ArrayOfSetBo value) {
        this.listarSetResult = value;
    }

}
