
package cl.blueprintsit.business.authentication.auth;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="inrut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="icclave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="icsession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="icidioma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "inrut",
    "icclave",
    "icsession",
    "icidioma"
})
@XmlRootElement(name = "check_clave", namespace = "http://tempuri.org/")
public class CheckClave {

    @XmlElement(namespace = "http://tempuri.org/")
    protected String inrut;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String icclave;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String icsession;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String icidioma;

    /**
     * Obtiene el valor de la propiedad inrut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInrut() {
        return inrut;
    }

    /**
     * Define el valor de la propiedad inrut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInrut(String value) {
        this.inrut = value;
    }

    /**
     * Obtiene el valor de la propiedad icclave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcclave() {
        return icclave;
    }

    /**
     * Define el valor de la propiedad icclave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcclave(String value) {
        this.icclave = value;
    }

    /**
     * Obtiene el valor de la propiedad icsession.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcsession() {
        return icsession;
    }

    /**
     * Define el valor de la propiedad icsession.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcsession(String value) {
        this.icsession = value;
    }

    /**
     * Obtiene el valor de la propiedad icidioma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcidioma() {
        return icidioma;
    }

    /**
     * Define el valor de la propiedad icidioma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcidioma(String value) {
        this.icidioma = value;
    }

}
