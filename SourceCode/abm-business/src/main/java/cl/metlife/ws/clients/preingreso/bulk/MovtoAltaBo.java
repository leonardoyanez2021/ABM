
package cl.metlife.ws.clients.preingreso.bulk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para MovtoAltaBo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MovtoAltaBo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://preingreso.metlife.cl/}MovtoBo">
 *       &lt;sequence>
 *         &lt;element name="FechaInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaTerminoVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovtoAltaBo", propOrder = {
    "fechaInicioVigencia",
    "fechaTerminoVigencia"
})
public class MovtoAltaBo
    extends MovtoBo
{

    @XmlElement(name = "FechaInicioVigencia", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioVigencia;
    @XmlElement(name = "FechaTerminoVigencia", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaTerminoVigencia;

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

}
