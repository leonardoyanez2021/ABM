
package cl.blueprintsit.ws.bulkPreingreso;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SetBo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EstadoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MovtoAltas" type="{http://preingreso.metlife.cl/}ArrayOfMovtoAltaBo" minOccurs="0"/>
 *         &lt;element name="MovtoBajas" type="{http://preingreso.metlife.cl/}ArrayOfMovtoBajaBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetBo", propOrder = {
    "id",
    "estadoId",
    "movtoAltas",
    "movtoBajas"
})
public class SetBo {

    @XmlElement(name = "Id", required = true, type = Integer.class, nillable = true)
    protected Integer id;
    @XmlElement(name = "EstadoId", required = true, type = Integer.class, nillable = true)
    protected Integer estadoId;
    @XmlElement(name = "MovtoAltas")
    protected ArrayOfMovtoAltaBo movtoAltas;
    @XmlElement(name = "MovtoBajas")
    protected ArrayOfMovtoBajaBo movtoBajas;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the estadoId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEstadoId() {
        return estadoId;
    }

    /**
     * Sets the value of the estadoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEstadoId(Integer value) {
        this.estadoId = value;
    }

    /**
     * Gets the value of the movtoAltas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMovtoAltaBo }
     *     
     */
    public ArrayOfMovtoAltaBo getMovtoAltas() {
        return movtoAltas;
    }

    /**
     * Sets the value of the movtoAltas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMovtoAltaBo }
     *     
     */
    public void setMovtoAltas(ArrayOfMovtoAltaBo value) {
        this.movtoAltas = value;
    }

    /**
     * Gets the value of the movtoBajas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMovtoBajaBo }
     *     
     */
    public ArrayOfMovtoBajaBo getMovtoBajas() {
        return movtoBajas;
    }

    /**
     * Sets the value of the movtoBajas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMovtoBajaBo }
     *     
     */
    public void setMovtoBajas(ArrayOfMovtoBajaBo value) {
        this.movtoBajas = value;
    }

}
