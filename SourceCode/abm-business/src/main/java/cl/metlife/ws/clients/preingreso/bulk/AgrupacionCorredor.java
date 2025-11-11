
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AgrupacionCorredor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AgrupacionCorredor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RutDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgrupacionCorredor", propOrder = {
    "rutDv",
    "nombre"
})
public class AgrupacionCorredor {

    @XmlElement(name = "RutDv")
    protected String rutDv;
    @XmlElement(name = "Nombre")
    protected String nombre;

    /**
     * Obtiene el valor de la propiedad rutDv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutDv() {
        return rutDv;
    }

    /**
     * Define el valor de la propiedad rutDv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutDv(String value) {
        this.rutDv = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

}
