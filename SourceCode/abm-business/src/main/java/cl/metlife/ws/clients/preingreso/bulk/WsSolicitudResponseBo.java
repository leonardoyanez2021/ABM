
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WsSolicitudResponseBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WsSolicitudResponseBo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://preingreso.metlife.cl/}WsErrorBo">
 *       &lt;sequence>
 *         &lt;element name="Solicitud" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Sets" type="{http://preingreso.metlife.cl/}ArrayOfSet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsSolicitudResponseBo", propOrder = {
    "solicitud",
    "lote",
    "sets"
})
public class WsSolicitudResponseBo
    extends WsErrorBo
{

    @XmlElement(name = "Solicitud")
    protected long solicitud;
    @XmlElement(name = "Lote")
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
