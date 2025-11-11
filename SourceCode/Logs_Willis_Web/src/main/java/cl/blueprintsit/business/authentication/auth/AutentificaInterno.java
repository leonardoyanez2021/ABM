
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
 *         &lt;element name="ID_Aplicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "idAplicacion",
    "login",
    "clave"
})
@XmlRootElement(name = "Autentifica_Interno", namespace = "http://tempuri.org/")
public class AutentificaInterno {

    @XmlElement(name = "ID_Aplicacion", namespace = "http://tempuri.org/")
    protected String idAplicacion;
    @XmlElement(name = "Login", namespace = "http://tempuri.org/")
    protected String login;
    @XmlElement(name = "Clave", namespace = "http://tempuri.org/")
    protected String clave;

    /**
     * Obtiene el valor de la propiedad idAplicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDAplicacion() {
        return idAplicacion;
    }

    /**
     * Define el valor de la propiedad idAplicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDAplicacion(String value) {
        this.idAplicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad login.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define el valor de la propiedad login.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
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
