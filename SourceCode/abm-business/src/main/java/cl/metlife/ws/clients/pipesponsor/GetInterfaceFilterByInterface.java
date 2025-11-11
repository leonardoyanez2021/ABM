
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
 *         &lt;element name="interfaceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "interfaceId"
})
@XmlRootElement(name = "GetInterfaceFilterByInterface")
public class GetInterfaceFilterByInterface {

    protected Long interfaceId;

    /**
     * Obtiene el valor de la propiedad interfaceId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterfaceId() {
        return interfaceId;
    }

    /**
     * Define el valor de la propiedad interfaceId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterfaceId(Long value) {
        this.interfaceId = value;
    }

}
