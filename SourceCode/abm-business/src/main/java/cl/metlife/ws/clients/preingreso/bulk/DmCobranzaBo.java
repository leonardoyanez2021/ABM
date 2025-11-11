
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DmCobranzaBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DmCobranzaBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Dia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Mes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Llave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DmCobranzaBo", propOrder = {
    "dia",
    "mes",
    "llave"
})
public class DmCobranzaBo {

    @XmlElement(name = "Dia", required = true, type = Integer.class, nillable = true)
    protected Integer dia;
    @XmlElement(name = "Mes", required = true, type = Integer.class, nillable = true)
    protected Integer mes;
    @XmlElement(name = "Llave")
    protected String llave;

    /**
     * Obtiene el valor de la propiedad dia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDia() {
        return dia;
    }

    /**
     * Define el valor de la propiedad dia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDia(Integer value) {
        this.dia = value;
    }

    /**
     * Obtiene el valor de la propiedad mes.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * Define el valor de la propiedad mes.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMes(Integer value) {
        this.mes = value;
    }

    /**
     * Obtiene el valor de la propiedad llave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLlave() {
        return llave;
    }

    /**
     * Define el valor de la propiedad llave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLlave(String value) {
        this.llave = value;
    }

}
