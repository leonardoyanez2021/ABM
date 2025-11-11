
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para DetalleBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DetalleBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Correlativo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PolizaNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Grupo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaTerminoVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Titular" type="{http://preingreso.metlife.cl/}TitularBo" minOccurs="0"/>
 *         &lt;element name="Carga" type="{http://preingreso.metlife.cl/}CargaBo" minOccurs="0"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Estado" type="{http://preingreso.metlife.cl/}EstadoBo" minOccurs="0"/>
 *         &lt;element name="CodigoBarra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileNetCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MetlifeCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaRecepcionCorredor" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaEstado" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Corredor" type="{http://preingreso.metlife.cl/}CorredorBo" minOccurs="0"/>
 *         &lt;element name="Errores" type="{http://preingreso.metlife.cl/}ArrayOfErrorBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetalleBo", propOrder = {
    "bulkId",
    "correlativo",
    "polizaNumero",
    "grupo",
    "fechaInicioVigencia",
    "fechaTerminoVigencia",
    "titular",
    "carga",
    "lote",
    "estado",
    "codigoBarra",
    "fileNetCodigo",
    "metlifeCodigo",
    "fechaRecepcionCorredor",
    "fechaEstado",
    "corredor",
    "errores"
})
public class DetalleBo {

    @XmlElement(name = "BulkId", required = true, type = Integer.class, nillable = true)
    protected Integer bulkId;
    @XmlElement(name = "Correlativo", required = true, type = Integer.class, nillable = true)
    protected Integer correlativo;
    @XmlElement(name = "PolizaNumero", required = true, type = Integer.class, nillable = true)
    protected Integer polizaNumero;
    @XmlElement(name = "Grupo", required = true, type = Integer.class, nillable = true)
    protected Integer grupo;
    @XmlElement(name = "FechaInicioVigencia", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioVigencia;
    @XmlElement(name = "FechaTerminoVigencia", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaTerminoVigencia;
    @XmlElement(name = "Titular")
    protected TitularBo titular;
    @XmlElement(name = "Carga")
    protected CargaBo carga;
    @XmlElement(name = "Lote", required = true, type = Integer.class, nillable = true)
    protected Integer lote;
    @XmlElement(name = "Estado")
    protected EstadoBo estado;
    @XmlElement(name = "CodigoBarra")
    protected String codigoBarra;
    @XmlElement(name = "FileNetCodigo")
    protected String fileNetCodigo;
    @XmlElement(name = "MetlifeCodigo")
    protected String metlifeCodigo;
    @XmlElement(name = "FechaRecepcionCorredor", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRecepcionCorredor;
    @XmlElement(name = "FechaEstado", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEstado;
    @XmlElement(name = "Corredor")
    protected CorredorBo corredor;
    @XmlElement(name = "Errores")
    protected ArrayOfErrorBo errores;

    /**
     * Obtiene el valor de la propiedad bulkId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBulkId() {
        return bulkId;
    }

    /**
     * Define el valor de la propiedad bulkId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBulkId(Integer value) {
        this.bulkId = value;
    }

    /**
     * Obtiene el valor de la propiedad correlativo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCorrelativo() {
        return correlativo;
    }

    /**
     * Define el valor de la propiedad correlativo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCorrelativo(Integer value) {
        this.correlativo = value;
    }

    /**
     * Obtiene el valor de la propiedad polizaNumero.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPolizaNumero() {
        return polizaNumero;
    }

    /**
     * Define el valor de la propiedad polizaNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPolizaNumero(Integer value) {
        this.polizaNumero = value;
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
     * Obtiene el valor de la propiedad fechaInicioVigencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    /**
     * Define el valor de la propiedad fechaInicioVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicioVigencia(XMLGregorianCalendar value) {
        this.fechaInicioVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaTerminoVigencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaTerminoVigencia() {
        return fechaTerminoVigencia;
    }

    /**
     * Define el valor de la propiedad fechaTerminoVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaTerminoVigencia(XMLGregorianCalendar value) {
        this.fechaTerminoVigencia = value;
    }

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
     * Obtiene el valor de la propiedad lote.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLote() {
        return lote;
    }

    /**
     * Define el valor de la propiedad lote.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLote(Integer value) {
        this.lote = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoBo }
     *     
     */
    public EstadoBo getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoBo }
     *     
     */
    public void setEstado(EstadoBo value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoBarra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * Define el valor de la propiedad codigoBarra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBarra(String value) {
        this.codigoBarra = value;
    }

    /**
     * Obtiene el valor de la propiedad fileNetCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileNetCodigo() {
        return fileNetCodigo;
    }

    /**
     * Define el valor de la propiedad fileNetCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileNetCodigo(String value) {
        this.fileNetCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad metlifeCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetlifeCodigo() {
        return metlifeCodigo;
    }

    /**
     * Define el valor de la propiedad metlifeCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetlifeCodigo(String value) {
        this.metlifeCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRecepcionCorredor.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRecepcionCorredor() {
        return fechaRecepcionCorredor;
    }

    /**
     * Define el valor de la propiedad fechaRecepcionCorredor.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRecepcionCorredor(XMLGregorianCalendar value) {
        this.fechaRecepcionCorredor = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEstado.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEstado() {
        return fechaEstado;
    }

    /**
     * Define el valor de la propiedad fechaEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEstado(XMLGregorianCalendar value) {
        this.fechaEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad corredor.
     * 
     * @return
     *     possible object is
     *     {@link CorredorBo }
     *     
     */
    public CorredorBo getCorredor() {
        return corredor;
    }

    /**
     * Define el valor de la propiedad corredor.
     * 
     * @param value
     *     allowed object is
     *     {@link CorredorBo }
     *     
     */
    public void setCorredor(CorredorBo value) {
        this.corredor = value;
    }

    /**
     * Obtiene el valor de la propiedad errores.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfErrorBo }
     *     
     */
    public ArrayOfErrorBo getErrores() {
        return errores;
    }

    /**
     * Define el valor de la propiedad errores.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErrorBo }
     *     
     */
    public void setErrores(ArrayOfErrorBo value) {
        this.errores = value;
    }

}
