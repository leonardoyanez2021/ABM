
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MovtoErrorBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MovtoErrorBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Titular" type="{http://preingreso.metlife.cl/}TitularBo" minOccurs="0"/>
 *         &lt;element name="Carga" type="{http://preingreso.metlife.cl/}CargaBo" minOccurs="0"/>
 *         &lt;element name="Error" type="{http://preingreso.metlife.cl/}ErrorBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovtoErrorBo", propOrder = {
    "titular",
    "carga",
    "error"
})
public class MovtoErrorBo {

    @XmlElement(name = "Titular")
    protected TitularBo titular;
    @XmlElement(name = "Carga")
    protected CargaBo carga;
    @XmlElement(name = "Error")
    protected ErrorBo error;

    /**
     * Obtiene el valor de la propiedad titular.
     * 
     * @return
     *     possible object is
     *     {@link TitularBo }
     *     
     */
    public TitularBo getTitular() {
        return titular;
    }

    /**
     * Define el valor de la propiedad titular.
     * 
     * @param value
     *     allowed object is
     *     {@link TitularBo }
     *     
     */
    public void setTitular(TitularBo value) {
        this.titular = value;
    }

    /**
     * Obtiene el valor de la propiedad carga.
     * 
     * @return
     *     possible object is
     *     {@link CargaBo }
     *     
     */
    public CargaBo getCarga() {
        return carga;
    }

    /**
     * Define el valor de la propiedad carga.
     * 
     * @param value
     *     allowed object is
     *     {@link CargaBo }
     *     
     */
    public void setCarga(CargaBo value) {
        this.carga = value;
    }

    /**
     * Obtiene el valor de la propiedad error.
     * 
     * @return
     *     possible object is
     *     {@link ErrorBo }
     *     
     */
    public ErrorBo getError() {
        return error;
    }

    /**
     * Define el valor de la propiedad error.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorBo }
     *     
     */
    public void setError(ErrorBo value) {
        this.error = value;
    }

}
