
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DmTerceroBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DmTerceroBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Dv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreCompleto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Direccion" type="{http://preingreso.metlife.cl/}DmDireccionBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DmTerceroBo", propOrder = {
    "rut",
    "dv",
    "nombreCompleto",
    "direccion"
})
public class DmTerceroBo {

    @XmlElement(name = "Rut", required = true, type = Integer.class, nillable = true)
    protected Integer rut;
    @XmlElement(name = "Dv")
    protected String dv;
    @XmlElement(name = "NombreCompleto")
    protected String nombreCompleto;
    @XmlElement(name = "Direccion")
    protected DmDireccionBo direccion;

    /**
     * Obtiene el valor de la propiedad rut.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRut() {
        return rut;
    }

    /**
     * Define el valor de la propiedad rut.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRut(Integer value) {
        this.rut = value;
    }

    /**
     * Obtiene el valor de la propiedad dv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDv() {
        return dv;
    }

    /**
     * Define el valor de la propiedad dv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDv(String value) {
        this.dv = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCompleto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Define el valor de la propiedad nombreCompleto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCompleto(String value) {
        this.nombreCompleto = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link DmDireccionBo }
     *     
     */
    public DmDireccionBo getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link DmDireccionBo }
     *     
     */
    public void setDireccion(DmDireccionBo value) {
        this.direccion = value;
    }

}
