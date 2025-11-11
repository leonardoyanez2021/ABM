
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WsInfoMovimientosResponseBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WsInfoMovimientosResponseBo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://preingreso.metlife.cl/}WsErrorBo">
 *       &lt;sequence>
 *         &lt;element name="CantidadMovimientos" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MovimientosError" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MovimientosOk" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Solicitud" type="{http://preingreso.metlife.cl/}WsSolicitudBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsInfoMovimientosResponseBo", propOrder = {
    "cantidadMovimientos",
    "movimientosError",
    "movimientosOk",
    "solicitud"
})
public class WsInfoMovimientosResponseBo
    extends WsErrorBo
{

    @XmlElement(name = "CantidadMovimientos")
    protected long cantidadMovimientos;
    @XmlElement(name = "MovimientosError")
    protected int movimientosError;
    @XmlElement(name = "MovimientosOk")
    protected int movimientosOk;
    @XmlElement(name = "Solicitud")
    protected WsSolicitudBo solicitud;

    /**
     * Obtiene el valor de la propiedad cantidadMovimientos.
     * 
     */
    public long getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    /**
     * Define el valor de la propiedad cantidadMovimientos.
     * 
     */
    public void setCantidadMovimientos(long value) {
        this.cantidadMovimientos = value;
    }

    /**
     * Obtiene el valor de la propiedad movimientosError.
     * 
     */
    public int getMovimientosError() {
        return movimientosError;
    }

    /**
     * Define el valor de la propiedad movimientosError.
     * 
     */
    public void setMovimientosError(int value) {
        this.movimientosError = value;
    }

    /**
     * Obtiene el valor de la propiedad movimientosOk.
     * 
     */
    public int getMovimientosOk() {
        return movimientosOk;
    }

    /**
     * Define el valor de la propiedad movimientosOk.
     * 
     */
    public void setMovimientosOk(int value) {
        this.movimientosOk = value;
    }

    /**
     * Obtiene el valor de la propiedad solicitud.
     * 
     * @return
     *     possible object is
     *     {@link WsSolicitudBo }
     *     
     */
    public WsSolicitudBo getSolicitud() {
        return solicitud;
    }

    /**
     * Define el valor de la propiedad solicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link WsSolicitudBo }
     *     
     */
    public void setSolicitud(WsSolicitudBo value) {
        this.solicitud = value;
    }

}
