
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CuentaDepositoBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CuentaDepositoBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BancoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BancoNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CuentaDepositoBo", propOrder = {
    "bancoId",
    "bancoNombre",
    "tipo",
    "numero"
})
public class CuentaDepositoBo {

    @XmlElement(name = "BancoId", required = true, type = Integer.class, nillable = true)
    protected Integer bancoId;
    @XmlElement(name = "BancoNombre")
    protected String bancoNombre;
    @XmlElement(name = "Tipo")
    protected String tipo;
    @XmlElement(name = "Numero")
    protected String numero;

    /**
     * Obtiene el valor de la propiedad bancoId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBancoId() {
        return bancoId;
    }

    /**
     * Define el valor de la propiedad bancoId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBancoId(Integer value) {
        this.bancoId = value;
    }

    /**
     * Obtiene el valor de la propiedad bancoNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBancoNombre() {
        return bancoNombre;
    }

    /**
     * Define el valor de la propiedad bancoNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBancoNombre(String value) {
        this.bancoNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

}
