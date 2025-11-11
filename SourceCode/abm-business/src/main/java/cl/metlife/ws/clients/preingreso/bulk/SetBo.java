
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SetBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SetBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EstadoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EstadoNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contratante" type="{http://preingreso.metlife.cl/}ContratanteBo" minOccurs="0"/>
 *         &lt;element name="TipoMovimiento" type="{http://preingreso.metlife.cl/}TipoMovimientoBo" minOccurs="0"/>
 *         &lt;element name="MovtoAltas" type="{http://preingreso.metlife.cl/}ArrayOfMovtoAltaBo" minOccurs="0"/>
 *         &lt;element name="MovtoBajas" type="{http://preingreso.metlife.cl/}ArrayOfMovtoBajaBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetBo", propOrder = {
    "id",
    "folio",
    "estadoId",
    "estadoNombre",
    "contratante",
    "tipoMovimiento",
    "movtoAltas",
    "movtoBajas"
})
public class SetBo {

    @XmlElement(name = "Id", required = true, type = Integer.class, nillable = true)
    protected Integer id;
    @XmlElement(name = "Folio", required = true, type = Integer.class, nillable = true)
    protected Integer folio;
    @XmlElement(name = "EstadoId")
    protected String estadoId;
    @XmlElement(name = "EstadoNombre")
    protected String estadoNombre;
    @XmlElement(name = "Contratante")
    protected ContratanteBo contratante;
    @XmlElement(name = "TipoMovimiento")
    protected TipoMovimientoBo tipoMovimiento;
    @XmlElement(name = "MovtoAltas")
    protected ArrayOfMovtoAltaBo movtoAltas;
    @XmlElement(name = "MovtoBajas")
    protected ArrayOfMovtoBajaBo movtoBajas;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad folio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * Define el valor de la propiedad folio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFolio(Integer value) {
        this.folio = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoId() {
        return estadoId;
    }

    /**
     * Define el valor de la propiedad estadoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoId(String value) {
        this.estadoId = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoNombre() {
        return estadoNombre;
    }

    /**
     * Define el valor de la propiedad estadoNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoNombre(String value) {
        this.estadoNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad contratante.
     * 
     * @return
     *     possible object is
     *     {@link ContratanteBo }
     *     
     */
    public ContratanteBo getContratante() {
        return contratante;
    }

    /**
     * Define el valor de la propiedad contratante.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratanteBo }
     *     
     */
    public void setContratante(ContratanteBo value) {
        this.contratante = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoMovimiento.
     * 
     * @return
     *     possible object is
     *     {@link TipoMovimientoBo }
     *     
     */
    public TipoMovimientoBo getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Define el valor de la propiedad tipoMovimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoMovimientoBo }
     *     
     */
    public void setTipoMovimiento(TipoMovimientoBo value) {
        this.tipoMovimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad movtoAltas.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMovtoAltaBo }
     *     
     */
    public ArrayOfMovtoAltaBo getMovtoAltas() {
        return movtoAltas;
    }

    /**
     * Define el valor de la propiedad movtoAltas.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMovtoAltaBo }
     *     
     */
    public void setMovtoAltas(ArrayOfMovtoAltaBo value) {
        this.movtoAltas = value;
    }

    /**
     * Obtiene el valor de la propiedad movtoBajas.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMovtoBajaBo }
     *     
     */
    public ArrayOfMovtoBajaBo getMovtoBajas() {
        return movtoBajas;
    }

    /**
     * Define el valor de la propiedad movtoBajas.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMovtoBajaBo }
     *     
     */
    public void setMovtoBajas(ArrayOfMovtoBajaBo value) {
        this.movtoBajas = value;
    }

}
