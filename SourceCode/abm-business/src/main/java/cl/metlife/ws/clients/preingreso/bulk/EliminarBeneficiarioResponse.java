
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
 *         &lt;element name="EliminarBeneficiarioResult" type="{http://preingreso.metlife.cl/}ResultBeneficiarioBo" minOccurs="0"/>
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
    "eliminarBeneficiarioResult"
})
@XmlRootElement(name = "EliminarBeneficiarioResponse")
public class EliminarBeneficiarioResponse {

    @XmlElement(name = "EliminarBeneficiarioResult")
    protected ResultBeneficiarioBo eliminarBeneficiarioResult;

    /**
     * Obtiene el valor de la propiedad eliminarBeneficiarioResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultBeneficiarioBo }
     *     
     */
    public ResultBeneficiarioBo getEliminarBeneficiarioResult() {
        return eliminarBeneficiarioResult;
    }

    /**
     * Define el valor de la propiedad eliminarBeneficiarioResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultBeneficiarioBo }
     *     
     */
    public void setEliminarBeneficiarioResult(ResultBeneficiarioBo value) {
        this.eliminarBeneficiarioResult = value;
    }

}
