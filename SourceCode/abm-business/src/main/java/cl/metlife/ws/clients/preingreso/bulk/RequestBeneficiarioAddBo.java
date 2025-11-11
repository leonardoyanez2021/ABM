
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para RequestBeneficiarioAddBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RequestBeneficiarioAddBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Poliza" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Grupo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TitularRut" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TitularDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiarioRut" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="BeneficiarioDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiarioNombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiarioPaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiarioMaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiarioRelacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiarioFchNacimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="BeneficiarioSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Porcentaje" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="BeneficiarioTipoPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeneficiarioTipoB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Renta" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoBarraFormulario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaVigenciaDesde" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBeneficiarioAddBo", propOrder = {
    "bulkId",
    "poliza",
    "grupo",
    "titularRut",
    "titularDv",
    "beneficiarioRut",
    "beneficiarioDv",
    "beneficiarioNombres",
    "beneficiarioPaterno",
    "beneficiarioMaterno",
    "beneficiarioRelacion",
    "beneficiarioFchNacimiento",
    "beneficiarioSexo",
    "porcentaje",
    "beneficiarioTipoPersona",
    "beneficiarioTipoB",
    "renta",
    "lote",
    "codigoBarraFormulario",
    "fechaVigenciaDesde"
})
public class RequestBeneficiarioAddBo {

    @XmlElement(name = "BulkId")
    protected int bulkId;
    @XmlElement(name = "Poliza", required = true, type = Long.class, nillable = true)
    protected Long poliza;
    @XmlElement(name = "Grupo", required = true, type = Integer.class, nillable = true)
    protected Integer grupo;
    @XmlElement(name = "TitularRut", required = true, type = Long.class, nillable = true)
    protected Long titularRut;
    @XmlElement(name = "TitularDv")
    protected String titularDv;
    @XmlElement(name = "BeneficiarioRut", required = true, type = Long.class, nillable = true)
    protected Long beneficiarioRut;
    @XmlElement(name = "BeneficiarioDv")
    protected String beneficiarioDv;
    @XmlElement(name = "BeneficiarioNombres")
    protected String beneficiarioNombres;
    @XmlElement(name = "BeneficiarioPaterno")
    protected String beneficiarioPaterno;
    @XmlElement(name = "BeneficiarioMaterno")
    protected String beneficiarioMaterno;
    @XmlElement(name = "BeneficiarioRelacion")
    protected String beneficiarioRelacion;
    @XmlElement(name = "BeneficiarioFchNacimiento", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar beneficiarioFchNacimiento;
    @XmlElement(name = "BeneficiarioSexo")
    protected String beneficiarioSexo;
    @XmlElement(name = "Porcentaje", required = true, type = Double.class, nillable = true)
    protected Double porcentaje;
    @XmlElement(name = "BeneficiarioTipoPersona")
    protected String beneficiarioTipoPersona;
    @XmlElement(name = "BeneficiarioTipoB")
    protected String beneficiarioTipoB;
    @XmlElement(name = "Renta", required = true, type = Double.class, nillable = true)
    protected Double renta;
    @XmlElement(name = "Lote")
    protected String lote;
    @XmlElement(name = "CodigoBarraFormulario")
    protected String codigoBarraFormulario;
    @XmlElement(name = "FechaVigenciaDesde", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaVigenciaDesde;

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
     * Obtiene el valor de la propiedad poliza.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPoliza() {
        return poliza;
    }

    /**
     * Define el valor de la propiedad poliza.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPoliza(Long value) {
        this.poliza = value;
    }

    /**
     * Obtiene el valor de la propiedad grupo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGrupo() {
        return grupo;
    }

    /**
     * Define el valor de la propiedad grupo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGrupo(Integer value) {
        this.grupo = value;
    }

    /**
     * Obtiene el valor de la propiedad titularRut.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTitularRut() {
        return titularRut;
    }

    /**
     * Define el valor de la propiedad titularRut.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTitularRut(Long value) {
        this.titularRut = value;
    }

    /**
     * Obtiene el valor de la propiedad titularDv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitularDv() {
        return titularDv;
    }

    /**
     * Define el valor de la propiedad titularDv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitularDv(String value) {
        this.titularDv = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioRut.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBeneficiarioRut() {
        return beneficiarioRut;
    }

    /**
     * Define el valor de la propiedad beneficiarioRut.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBeneficiarioRut(Long value) {
        this.beneficiarioRut = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioDv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioDv() {
        return beneficiarioDv;
    }

    /**
     * Define el valor de la propiedad beneficiarioDv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioDv(String value) {
        this.beneficiarioDv = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioNombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioNombres() {
        return beneficiarioNombres;
    }

    /**
     * Define el valor de la propiedad beneficiarioNombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioNombres(String value) {
        this.beneficiarioNombres = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioPaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioPaterno() {
        return beneficiarioPaterno;
    }

    /**
     * Define el valor de la propiedad beneficiarioPaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioPaterno(String value) {
        this.beneficiarioPaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioMaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioMaterno() {
        return beneficiarioMaterno;
    }

    /**
     * Define el valor de la propiedad beneficiarioMaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioMaterno(String value) {
        this.beneficiarioMaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioRelacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioRelacion() {
        return beneficiarioRelacion;
    }

    /**
     * Define el valor de la propiedad beneficiarioRelacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioRelacion(String value) {
        this.beneficiarioRelacion = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioFchNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeneficiarioFchNacimiento() {
        return beneficiarioFchNacimiento;
    }

    /**
     * Define el valor de la propiedad beneficiarioFchNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeneficiarioFchNacimiento(XMLGregorianCalendar value) {
        this.beneficiarioFchNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioSexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioSexo() {
        return beneficiarioSexo;
    }

    /**
     * Define el valor de la propiedad beneficiarioSexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioSexo(String value) {
        this.beneficiarioSexo = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentaje.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPorcentaje() {
        return porcentaje;
    }

    /**
     * Define el valor de la propiedad porcentaje.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPorcentaje(Double value) {
        this.porcentaje = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioTipoPersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioTipoPersona() {
        return beneficiarioTipoPersona;
    }

    /**
     * Define el valor de la propiedad beneficiarioTipoPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioTipoPersona(String value) {
        this.beneficiarioTipoPersona = value;
    }

    /**
     * Obtiene el valor de la propiedad beneficiarioTipoB.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiarioTipoB() {
        return beneficiarioTipoB;
    }

    /**
     * Define el valor de la propiedad beneficiarioTipoB.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiarioTipoB(String value) {
        this.beneficiarioTipoB = value;
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
     * Obtiene el valor de la propiedad lote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLote() {
        return lote;
    }

    /**
     * Define el valor de la propiedad lote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLote(String value) {
        this.lote = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoBarraFormulario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBarraFormulario() {
        return codigoBarraFormulario;
    }

    /**
     * Define el valor de la propiedad codigoBarraFormulario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBarraFormulario(String value) {
        this.codigoBarraFormulario = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVigenciaDesde.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaVigenciaDesde() {
        return fechaVigenciaDesde;
    }

    /**
     * Define el valor de la propiedad fechaVigenciaDesde.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaVigenciaDesde(XMLGregorianCalendar value) {
        this.fechaVigenciaDesde = value;
    }

}
