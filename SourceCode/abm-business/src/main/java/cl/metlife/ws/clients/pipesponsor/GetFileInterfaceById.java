
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
 *         &lt;element name="fileIterfaceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "fileIterfaceId"
})
@XmlRootElement(name = "GetFileInterfaceById")
public class GetFileInterfaceById {

    protected Long fileIterfaceId;

    /**
     * Obtiene el valor de la propiedad fileIterfaceId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileIterfaceId() {
        return fileIterfaceId;
    }

    /**
     * Define el valor de la propiedad fileIterfaceId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileIterfaceId(Long value) {
        this.fileIterfaceId = value;
    }

}
