
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
 *         &lt;element name="CrearBajaResult" type="{http://preingreso.metlife.cl/}ErrorBo" minOccurs="0"/>
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
    "crearBajaResult"
})
@XmlRootElement(name = "CrearBajaResponse")
public class CrearBajaResponse {

    @XmlElement(name = "CrearBajaResult")
    protected ErrorBo crearBajaResult;

    /**
     * Obtiene el valor de la propiedad crearBajaResult.
     * 
     * @return
     *     possible object is
     *     {@link ErrorBo }
     *     
     */
    public ErrorBo getCrearBajaResult() {
        return crearBajaResult;
    }

    /**
     * Define el valor de la propiedad crearBajaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorBo }
     *     
     */
    public void setCrearBajaResult(ErrorBo value) {
        this.crearBajaResult = value;
    }

}
