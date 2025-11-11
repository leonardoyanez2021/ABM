
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para WsSolicitudBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WsSolicitudBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FechaSolicitud" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaRecepcionCorredor" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MovimientoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Movimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PortalRut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PortalUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lote" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Movimientos" type="{http://preingreso.metlife.cl/}ArrayOfDetalle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsSolicitudBo", propOrder = {
    "id",
    "fechaSolicitud",
    "fechaRecepcionCorredor",
    "tipo",
    "movimientoId",
    "movimiento",
    "usuario",
    "portalRut",
    "portalUsuario",
    "estado",
    "lote",
    "movimientos"
})
public class WsSolicitudBo {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "FechaSolicitud", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSolicitud;
    @XmlElement(name = "FechaRecepcionCorredor", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRecepcionCorredor;
    @XmlElement(name = "Tipo")
    protected String tipo;
    @XmlElement(name = "MovimientoId")
    protected int movimientoId;
    @XmlElement(name = "Movimiento")
    protected String movimiento;
    @XmlElement(name = "Usuario")
    protected String usuario;
    @XmlElement(name = "PortalRut")
    protected String portalRut;
    @XmlElement(name = "PortalUsuario")
    protected String portalUsuario;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "Lote")
    protected long lote;
    @XmlElement(name = "Movimientos")
    protected ArrayOfDetalle movimientos;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Define el valor de la propiedad fechaSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaSolicitud(XMLGregorianCalendar value) {
        this.fechaSolicitud = value;
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
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad movimientoId.
     * 
     */
    public int getMovimientoId() {
        return movimientoId;
    }

    /**
     * Define el valor de la propiedad movimientoId.
     * 
     */
    public void setMovimientoId(int value) {
        this.movimientoId = value;
    }

    /**
     * Obtiene el valor de la propiedad movimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovimiento() {
        return movimiento;
    }

    /**
     * Define el valor de la propiedad movimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovimiento(String value) {
        this.movimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad portalRut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalRut() {
        return portalRut;
    }

    /**
     * Define el valor de la propiedad portalRut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalRut(String value) {
        this.portalRut = value;
    }

    /**
     * Obtiene el valor de la propiedad portalUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalUsuario() {
        return portalUsuario;
    }

    /**
     * Define el valor de la propiedad portalUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalUsuario(String value) {
        this.portalUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad lote.
     * 
     */
    public long getLote() {
        return lote;
    }

    /**
     * Define el valor de la propiedad lote.
     * 
     */
    public void setLote(long value) {
        this.lote = value;
    }

    /**
     * Obtiene el valor de la propiedad movimientos.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDetalle }
     *     
     */
    public ArrayOfDetalle getMovimientos() {
        return movimientos;
    }

    /**
     * Define el valor de la propiedad movimientos.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDetalle }
     *     
     */
    public void setMovimientos(ArrayOfDetalle value) {
        this.movimientos = value;
    }

}
