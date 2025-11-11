
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
 *         &lt;element name="vl_login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "vlLogin",
    "clave"
})
@XmlRootElement(name = "LOGIN", namespace = "http://tempuri.org/")
public class LOGIN {

    @XmlElement(name = "vl_login", namespace = "http://tempuri.org/")
    protected String vlLogin;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String clave;

    /**
     * Obtiene el valor de la propiedad vlLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVlLogin() {
        return vlLogin;
    }

    /**
     * Define el valor de la propiedad vlLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVlLogin(String value) {
        this.vlLogin = value;
    }

    /**
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

}
