
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
 *         &lt;element name="fileRelationshipId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "fileRelationshipId"
})
@XmlRootElement(name = "GetFileRelationshipById")
public class GetFileRelationshipById {

    protected Long fileRelationshipId;

    /**
     * Obtiene el valor de la propiedad fileRelationshipId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileRelationshipId() {
        return fileRelationshipId;
    }

    /**
     * Define el valor de la propiedad fileRelationshipId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileRelationshipId(Long value) {
        this.fileRelationshipId = value;
    }

}
