
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para DmPersonaBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DmPersonaBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Dv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApellidoPaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApellidoMaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Isapre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DmPersonaBo", propOrder = {
    "rut",
    "dv",
    "nombre",
    "apellidoPaterno",
    "apellidoMaterno",
    "sexo",
    "fechaNacimiento",
    "isapre",
    "direccion"
})
@XmlSeeAlso({
    DmTitularBo.class,
    DmCargaBo.class
})
public class DmPersonaBo {

    @XmlElement(name = "Rut", required = true, type = Integer.class, nillable = true)
    protected Integer rut;
    @XmlElement(name = "Dv")
    protected String dv;
    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "ApellidoPaterno")
    protected String apellidoPaterno;
    @XmlElement(name = "ApellidoMaterno")
    protected String apellidoMaterno;
    @XmlElement(name = "Sexo")
    protected String sexo;
    @XmlElement(name = "FechaNacimiento", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaNacimiento;
    @XmlElement(name = "Isapre")
    protected String isapre;
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
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoPaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Define el valor de la propiedad apellidoPaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPaterno(String value) {
        this.apellidoPaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoMaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Define el valor de la propiedad apellidoMaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoMaterno(String value) {
        this.apellidoMaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad sexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Define el valor de la propiedad sexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Define el valor de la propiedad fechaNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad isapre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsapre() {
        return isapre;
    }

    /**
     * Define el valor de la propiedad isapre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsapre(String value) {
        this.isapre = value;
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
