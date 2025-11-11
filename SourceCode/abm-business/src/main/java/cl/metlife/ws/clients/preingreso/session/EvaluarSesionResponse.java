
package cl.metlife.ws.clients.preingreso.session;

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
 *         &lt;element name="EvaluarSesionResult" type="{http://preingreso.metlife.cl/}SesionBo" minOccurs="0"/>
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
    "evaluarSesionResult"
})
@XmlRootElement(name = "EvaluarSesionResponse")
public class EvaluarSesionResponse {

    @XmlElement(name = "EvaluarSesionResult")
    protected SesionBo evaluarSesionResult;

    /**
     * Obtiene el valor de la propiedad evaluarSesionResult.
     * 
     * @return
     *     possible object is
     *     {@link SesionBo }
     *     
     */
    public SesionBo getEvaluarSesionResult() {
        return evaluarSesionResult;
    }

    /**
     * Define el valor de la propiedad evaluarSesionResult.
     * 
     * @param value
     *     allowed object is
     *     {@link SesionBo }
     *     
     */
    public void setEvaluarSesionResult(SesionBo value) {
        this.evaluarSesionResult = value;
    }

}
