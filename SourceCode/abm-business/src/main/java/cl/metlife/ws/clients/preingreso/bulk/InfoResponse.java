
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
 *         &lt;element name="InfoResult" type="{http://preingreso.metlife.cl/}BulkBo" minOccurs="0"/>
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
    "infoResult"
})
@XmlRootElement(name = "InfoResponse")
public class InfoResponse {

    @XmlElement(name = "InfoResult")
    protected BulkBo infoResult;

    /**
     * Obtiene el valor de la propiedad infoResult.
     * 
     * @return
     *     possible object is
     *     {@link BulkBo }
     *     
     */
    public BulkBo getInfoResult() {
        return infoResult;
    }

    /**
     * Define el valor de la propiedad infoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkBo }
     *     
     */
    public void setInfoResult(BulkBo value) {
        this.infoResult = value;
    }

}
