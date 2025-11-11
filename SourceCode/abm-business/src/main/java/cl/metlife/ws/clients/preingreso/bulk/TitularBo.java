
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TitularBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TitularBo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://preingreso.metlife.cl/}PersonaBo">
 *       &lt;sequence>
 *         &lt;element name="Capital" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Renta" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Celular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CuentaDeposito" type="{http://preingreso.metlife.cl/}CuentaDepositoBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TitularBo", propOrder = {
    "capital",
    "renta",
    "email",
    "celular",
    "cuentaDeposito"
})
public class TitularBo
    extends PersonaBo
{

    @XmlElement(name = "Capital", required = true, type = Double.class, nillable = true)
    protected Double capital;
    @XmlElement(name = "Renta", required = true, type = Double.class, nillable = true)
    protected Double renta;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Celular")
    protected String celular;
    @XmlElement(name = "CuentaDeposito")
    protected CuentaDepositoBo cuentaDeposito;

    /**
     * Obtiene el valor de la propiedad capital.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCapital() {
        return capital;
    }

    /**
     * Define el valor de la propiedad capital.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCapital(Double value) {
        this.capital = value;
    }

    /**
     * Obtiene el valor de la propiedad renta.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRenta() {
        return renta;
    }

    /**
     * Define el valor de la propiedad renta.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRenta(Double value) {
        this.renta = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad celular.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Define el valor de la propiedad celular.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCelular(String value) {
        this.celular = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaDeposito.
     * 
     * @return
     *     possible object is
     *     {@link CuentaDepositoBo }
     *     
     */
    public CuentaDepositoBo getCuentaDeposito() {
        return cuentaDeposito;
    }

    /**
     * Define el valor de la propiedad cuentaDeposito.
     * 
     * @param value
     *     allowed object is
     *     {@link CuentaDepositoBo }
     *     
     */
    public void setCuentaDeposito(CuentaDepositoBo value) {
        this.cuentaDeposito = value;
    }

}
