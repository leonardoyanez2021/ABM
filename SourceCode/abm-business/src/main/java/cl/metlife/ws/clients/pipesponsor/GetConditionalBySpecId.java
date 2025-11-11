
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="conditionalEspecsId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "conditionalEspecsId"
})
@XmlRootElement(name = "GetConditionalBySpecId")
public class GetConditionalBySpecId {

    protected Long conditionalEspecsId;

    /**
     * Obtiene el valor de la propiedad conditionalEspecsId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getConditionalEspecsId() {
        return conditionalEspecsId;
    }

    /**
     * Define el valor de la propiedad conditionalEspecsId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setConditionalEspecsId(Long value) {
        this.conditionalEspecsId = value;
    }

}
