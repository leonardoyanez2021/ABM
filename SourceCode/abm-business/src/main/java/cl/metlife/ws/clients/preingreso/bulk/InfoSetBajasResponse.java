
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
 *         &lt;element name="InfoSetBajasResult" type="{http://preingreso.metlife.cl/}ArrayOfMovtoBajaBo" minOccurs="0"/>
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
    "infoSetBajasResult"
})
@XmlRootElement(name = "InfoSetBajasResponse")
public class InfoSetBajasResponse {

    @XmlElement(name = "InfoSetBajasResult")
    protected ArrayOfMovtoBajaBo infoSetBajasResult;

    /**
     * Obtiene el valor de la propiedad infoSetBajasResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMovtoBajaBo }
     *     
     */
    public ArrayOfMovtoBajaBo getInfoSetBajasResult() {
        return infoSetBajasResult;
    }

    /**
     * Define el valor de la propiedad infoSetBajasResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMovtoBajaBo }
     *     
     */
    public void setInfoSetBajasResult(ArrayOfMovtoBajaBo value) {
        this.infoSetBajasResult = value;
    }

}
