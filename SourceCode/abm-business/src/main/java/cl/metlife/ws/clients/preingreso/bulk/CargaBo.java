
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CargaBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CargaBo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://preingreso.metlife.cl/}PersonaBo">
 *       &lt;sequence>
 *         &lt;element name="Relacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CargaBo", propOrder = {
    "relacion"
})
public class CargaBo
    extends PersonaBo
{

    @XmlElement(name = "Relacion")
    protected String relacion;

    /**
     * Obtiene el valor de la propiedad relacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelacion() {
        return relacion;
    }

    /**
     * Define el valor de la propiedad relacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelacion(String value) {
        this.relacion = value;
    }

}
