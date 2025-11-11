
package cl.metlife.ws.clients.preingreso.session;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LogBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LogBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Transacciones" type="{http://preingreso.metlife.cl/}ArrayOfTransaccionBo" minOccurs="0"/>
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
@XmlType(name = "LogBo", propOrder = {
    "transacciones",
    "error"
})
public class LogBo {

    @XmlElement(name = "Transacciones")
    protected ArrayOfTransaccionBo transacciones;
    @XmlElement(name = "Error")
    protected ErrorBo error;

    /**
     * Obtiene el valor de la propiedad transacciones.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransaccionBo }
     *     
     */
    public ArrayOfTransaccionBo getTransacciones() {
        return transacciones;
    }

    /**
     * Define el valor de la propiedad transacciones.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransaccionBo }
     *     
     */
    public void setTransacciones(ArrayOfTransaccionBo value) {
        this.transacciones = value;
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
