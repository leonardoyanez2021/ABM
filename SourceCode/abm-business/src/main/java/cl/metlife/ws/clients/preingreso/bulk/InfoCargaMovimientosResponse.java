
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
 *         &lt;element name="InfoCargaMovimientosResult" type="{http://preingreso.metlife.cl/}WsInfoMovimientosResponseBo" minOccurs="0"/>
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
    "infoCargaMovimientosResult"
})
@XmlRootElement(name = "InfoCargaMovimientosResponse")
public class InfoCargaMovimientosResponse {

    @XmlElement(name = "InfoCargaMovimientosResult")
    protected WsInfoMovimientosResponseBo infoCargaMovimientosResult;

    /**
     * Obtiene el valor de la propiedad infoCargaMovimientosResult.
     * 
     * @return
     *     possible object is
     *     {@link WsInfoMovimientosResponseBo }
     *     
     */
    public WsInfoMovimientosResponseBo getInfoCargaMovimientosResult() {
        return infoCargaMovimientosResult;
    }

    /**
     * Define el valor de la propiedad infoCargaMovimientosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link WsInfoMovimientosResponseBo }
     *     
     */
    public void setInfoCargaMovimientosResult(WsInfoMovimientosResponseBo value) {
        this.infoCargaMovimientosResult = value;
    }

}
