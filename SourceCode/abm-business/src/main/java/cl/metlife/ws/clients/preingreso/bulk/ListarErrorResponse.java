
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
 *         &lt;element name="ListarErrorResult" type="{http://preingreso.metlife.cl/}ArrayOfMovtoErrorBo" minOccurs="0"/>
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
    "listarErrorResult"
})
@XmlRootElement(name = "ListarErrorResponse")
public class ListarErrorResponse {

    @XmlElement(name = "ListarErrorResult")
    protected ArrayOfMovtoErrorBo listarErrorResult;

    /**
     * Obtiene el valor de la propiedad listarErrorResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMovtoErrorBo }
     *     
     */
    public ArrayOfMovtoErrorBo getListarErrorResult() {
        return listarErrorResult;
    }

    /**
     * Define el valor de la propiedad listarErrorResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMovtoErrorBo }
     *     
     */
    public void setListarErrorResult(ArrayOfMovtoErrorBo value) {
        this.listarErrorResult = value;
    }

}
