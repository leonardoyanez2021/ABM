
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="sesionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="polizaNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="grupo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="titularRut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="titularDv" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="cargaRut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cargaDv" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="codigoFileNet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sesionId",
    "bulkId",
    "polizaNumero",
    "grupo",
    "titularRut",
    "titularDv",
    "cargaRut",
    "cargaDv",
    "codigoFileNet",
    "errorNumero",
    "errorDescripcion"
})
@XmlRootElement(name = "FileNetCodigoGrabar")
public class FileNetCodigoGrabar {

    protected String sesionId;
    protected int bulkId;
    protected int polizaNumero;
    protected int grupo;
    protected int titularRut;
    @XmlSchemaType(name = "unsignedShort")
    protected int titularDv;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cargaRut;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    @XmlSchemaType(name = "unsignedShort")
    protected Integer cargaDv;
    protected String codigoFileNet;
    protected int errorNumero;
    protected String errorDescripcion;

    /**
     * Obtiene el valor de la propiedad sesionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesionId() {
        return sesionId;
    }

    /**
     * Define el valor de la propiedad sesionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesionId(String value) {
        this.sesionId = value;
    }

    /**
     * Obtiene el valor de la propiedad bulkId.
     * 
     */
    public int getBulkId() {
        return bulkId;
    }

    /**
     * Define el valor de la propiedad bulkId.
     * 
     */
    public void setBulkId(int value) {
        this.bulkId = value;
    }

    /**
     * Obtiene el valor de la propiedad polizaNumero.
     * 
     */
    public int getPolizaNumero() {
        return polizaNumero;
    }

    /**
     * Define el valor de la propiedad polizaNumero.
     * 
     */
    public void setPolizaNumero(int value) {
        this.polizaNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad grupo.
     * 
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * Define el valor de la propiedad grupo.
     * 
     */
    public void setGrupo(int value) {
        this.grupo = value;
    }

    /**
     * Obtiene el valor de la propiedad titularRut.
     * 
     */
    public int getTitularRut() {
        return titularRut;
    }

    /**
     * Define el valor de la propiedad titularRut.
     * 
     */
    public void setTitularRut(int value) {
        this.titularRut = value;
    }

    /**
     * Obtiene el valor de la propiedad titularDv.
     * 
     */
    public int getTitularDv() {
        return titularDv;
    }

    /**
     * Define el valor de la propiedad titularDv.
     * 
     */
    public void setTitularDv(int value) {
        this.titularDv = value;
    }

    /**
     * Obtiene el valor de la propiedad cargaRut.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCargaRut() {
        return cargaRut;
    }

    /**
     * Define el valor de la propiedad cargaRut.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCargaRut(Integer value) {
        this.cargaRut = value;
    }

    /**
     * Obtiene el valor de la propiedad cargaDv.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCargaDv() {
        return cargaDv;
    }

    /**
     * Define el valor de la propiedad cargaDv.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCargaDv(Integer value) {
        this.cargaDv = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoFileNet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoFileNet() {
        return codigoFileNet;
    }

    /**
     * Define el valor de la propiedad codigoFileNet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoFileNet(String value) {
        this.codigoFileNet = value;
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
