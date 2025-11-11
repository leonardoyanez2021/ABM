
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
 *         &lt;element name="ModificarBeneficiarioResult" type="{http://preingreso.metlife.cl/}ResultBeneficiarioBo" minOccurs="0"/>
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
    "modificarBeneficiarioResult"
})
@XmlRootElement(name = "ModificarBeneficiarioResponse")
public class ModificarBeneficiarioResponse {

    @XmlElement(name = "ModificarBeneficiarioResult")
    protected ResultBeneficiarioBo modificarBeneficiarioResult;

    /**
     * Obtiene el valor de la propiedad modificarBeneficiarioResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultBeneficiarioBo }
     *     
     */
    public ResultBeneficiarioBo getModificarBeneficiarioResult() {
        return modificarBeneficiarioResult;
    }

    /**
     * Define el valor de la propiedad modificarBeneficiarioResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultBeneficiarioBo }
     *     
     */
    public void setModificarBeneficiarioResult(ResultBeneficiarioBo value) {
        this.modificarBeneficiarioResult = value;
    }

}
