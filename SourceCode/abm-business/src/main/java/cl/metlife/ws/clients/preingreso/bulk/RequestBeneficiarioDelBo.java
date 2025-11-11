
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para RequestBeneficiarioDelBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RequestBeneficiarioDelBo">
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
 *         &lt;element name="FchEliminacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoBarraFormulario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBeneficiarioDelBo", propOrder = {
    "bulkId",
    "poliza",
    "grupo",
    "titularRut",
    "titularDv",
    "beneficiarioRut",
    "beneficiarioDv",
    "fchEliminacion",
    "lote",
    "codigoBarraFormulario"
})
public class RequestBeneficiarioDelBo {

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
    @XmlElement(name = "FchEliminacion", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fchEliminacion;
    @XmlElement(name = "Lote")
    protected String lote;
    @XmlElement(name = "CodigoBarraFormulario")
    protected String codigoBarraFormulario;

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
     * Obtiene el valor de la propiedad fchEliminacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFchEliminacion() {
        return fchEliminacion;
    }

    /**
     * Define el valor de la propiedad fchEliminacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFchEliminacion(XMLGregorianCalendar value) {
        this.fchEliminacion = value;
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

}
