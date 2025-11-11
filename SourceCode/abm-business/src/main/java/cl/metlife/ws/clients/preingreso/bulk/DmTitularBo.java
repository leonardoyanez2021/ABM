
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DmTitularBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DmTitularBo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://preingreso.metlife.cl/}DmPersonaBo">
 *       &lt;sequence>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CuentaDeposito" type="{http://preingreso.metlife.cl/}DmCuentaDepositoBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DmTitularBo", propOrder = {
    "email",
    "cuentaDeposito"
})
public class DmTitularBo
    extends DmPersonaBo
{

    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "CuentaDeposito")
    protected DmCuentaDepositoBo cuentaDeposito;

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
     * Obtiene el valor de la propiedad cuentaDeposito.
     * 
     * @return
     *     possible object is
     *     {@link DmCuentaDepositoBo }
     *     
     */
    public DmCuentaDepositoBo getCuentaDeposito() {
        return cuentaDeposito;
    }

    /**
     * Define el valor de la propiedad cuentaDeposito.
     * 
     * @param value
     *     allowed object is
     *     {@link DmCuentaDepositoBo }
     *     
     */
    public void setCuentaDeposito(DmCuentaDepositoBo value) {
        this.cuentaDeposito = value;
    }

}
