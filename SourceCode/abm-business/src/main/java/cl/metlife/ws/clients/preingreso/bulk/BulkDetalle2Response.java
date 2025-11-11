
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
 *         &lt;element name="BulkDetalle2Result" type="{http://preingreso.metlife.cl/}BulkDetalleBo" minOccurs="0"/>
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
    "bulkDetalle2Result"
})
@XmlRootElement(name = "BulkDetalle2Response")
public class BulkDetalle2Response {

    @XmlElement(name = "BulkDetalle2Result")
    protected BulkDetalleBo bulkDetalle2Result;

    /**
     * Obtiene el valor de la propiedad bulkDetalle2Result.
     * 
     * @return
     *     possible object is
     *     {@link BulkDetalleBo }
     *     
     */
    public BulkDetalleBo getBulkDetalle2Result() {
        return bulkDetalle2Result;
    }

    /**
     * Define el valor de la propiedad bulkDetalle2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkDetalleBo }
     *     
     */
    public void setBulkDetalle2Result(BulkDetalleBo value) {
        this.bulkDetalle2Result = value;
    }

}
