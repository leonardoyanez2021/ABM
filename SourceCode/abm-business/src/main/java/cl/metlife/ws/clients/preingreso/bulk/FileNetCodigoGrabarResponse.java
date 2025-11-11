
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="FileNetCodigoGrabarResult" type="{http://preingreso.metlife.cl/}ErrorBo" minOccurs="0"/>
 *         &lt;element name="errorNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="errorDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fileNetCodigoGrabarResult",
    "errorNumero",
    "errorDescripcion"
})
@XmlRootElement(name = "FileNetCodigoGrabarResponse")
public class FileNetCodigoGrabarResponse {

    @XmlElement(name = "FileNetCodigoGrabarResult")
    protected ErrorBo fileNetCodigoGrabarResult;
    protected int errorNumero;
    protected String errorDescripcion;

    /**
     * Obtiene el valor de la propiedad fileNetCodigoGrabarResult.
     * 
     * @return
     *     possible object is
     *     {@link ErrorBo }
     *     
     */
    public ErrorBo getFileNetCodigoGrabarResult() {
        return fileNetCodigoGrabarResult;
    }

    /**
     * Define el valor de la propiedad fileNetCodigoGrabarResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorBo }
     *     
     */
    public void setFileNetCodigoGrabarResult(ErrorBo value) {
        this.fileNetCodigoGrabarResult = value;
    }

    /**
     * Obtiene el valor de la propiedad errorNumero.
     * 
     */
    public int getErrorNumero() {
        return errorNumero;
    }

    /**
     * Define el valor de la propiedad errorNumero.
     * 
     */
    public void setErrorNumero(int value) {
        this.errorNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad errorDescripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    /**
     * Define el valor de la propiedad errorDescripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDescripcion(String value) {
        this.errorDescripcion = value;
    }

}
