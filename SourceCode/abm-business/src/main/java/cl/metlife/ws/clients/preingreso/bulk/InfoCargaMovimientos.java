
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
 *         &lt;element name="solicitud" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lote" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Sets" type="{http://preingreso.metlife.cl/}ArrayOfSet" minOccurs="0"/>
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
    "solicitud",
    "lote",
    "sets"
})
@XmlRootElement(name = "InfoCargaMovimientos")
public class InfoCargaMovimientos {

    protected long solicitud;
    protected long lote;
    @XmlElement(name = "Sets")
    protected ArrayOfSet sets;

    /**
     * Obtiene el valor de la propiedad solicitud.
     * 
     */
    public long getSolicitud() {
        return solicitud;
    }

    /**
     * Define el valor de la propiedad solicitud.
     * 
     */
    public void setSolicitud(long value) {
        this.solicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad lote.
     * 
     */
    public long getLote() {
        return lote;
    }

    /**
     * Define el valor de la propiedad lote.
     * 
     */
    public void setLote(long value) {
        this.lote = value;
    }

    /**
     * Obtiene el valor de la propiedad sets.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSet }
     *     
     */
    public ArrayOfSet getSets() {
        return sets;
    }

    /**
     * Define el valor de la propiedad sets.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSet }
     *     
     */
    public void setSets(ArrayOfSet value) {
        this.sets = value;
    }

}
