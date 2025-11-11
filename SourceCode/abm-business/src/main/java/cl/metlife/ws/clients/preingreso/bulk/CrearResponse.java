
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
 *         &lt;element name="CrearResult" type="{http://preingreso.metlife.cl/}BulkBo" minOccurs="0"/>
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
    "crearResult"
})
@XmlRootElement(name = "CrearResponse")
public class CrearResponse {

    @XmlElement(name = "CrearResult")
    protected BulkBo crearResult;

    /**
     * Obtiene el valor de la propiedad crearResult.
     * 
     * @return
     *     possible object is
     *     {@link BulkBo }
     *     
     */
    public BulkBo getCrearResult() {
        return crearResult;
    }

    /**
     * Define el valor de la propiedad crearResult.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkBo }
     *     
     */
    public void setCrearResult(BulkBo value) {
        this.crearResult = value;
    }

}
