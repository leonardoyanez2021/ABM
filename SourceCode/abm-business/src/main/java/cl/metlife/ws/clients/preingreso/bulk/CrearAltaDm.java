
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
 *         &lt;element name="sesionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MovtoAlta" type="{http://preingreso.metlife.cl/}DmMovtoAltaBo" minOccurs="0"/>
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
    "sesionId",
    "movtoAlta"
})
@XmlRootElement(name = "CrearAltaDm")
public class CrearAltaDm {

    protected String sesionId;
    @XmlElement(name = "MovtoAlta")
    protected DmMovtoAltaBo movtoAlta;

    /**
     * Obtiene el valor de la propiedad sesionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesionId() {
        return sesionId;
    }

    /**
     * Define el valor de la propiedad sesionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesionId(String value) {
        this.sesionId = value;
    }

    /**
     * Obtiene el valor de la propiedad movtoAlta.
     * 
     * @return
     *     possible object is
     *     {@link DmMovtoAltaBo }
     *     
     */
    public DmMovtoAltaBo getMovtoAlta() {
        return movtoAlta;
    }

    /**
     * Define el valor de la propiedad movtoAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link DmMovtoAltaBo }
     *     
     */
    public void setMovtoAlta(DmMovtoAltaBo value) {
        this.movtoAlta = value;
    }

}
