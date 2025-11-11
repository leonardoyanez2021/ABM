
package cl.blueprintsit.business.authentication.auth;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="ROLES_PERSONA_RUT_APLICResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "rolespersonarutaplicResult"
})
@XmlRootElement(name = "ROLES_PERSONA_RUT_APLICResponse", namespace = "http://tempuri.org/")
public class ROLESPERSONARUTAPLICResponse {

    @XmlElement(name = "ROLES_PERSONA_RUT_APLICResult", namespace = "http://tempuri.org/")
    protected ROLESPERSONARUTAPLICResponse.ROLESPERSONARUTAPLICResult rolespersonarutaplicResult;

    /**
     * Obtiene el valor de la propiedad rolespersonarutaplicResult.
     *
     * @return
     *     possible object is
     *     {@link ROLESPERSONARUTAPLICResponse.ROLESPERSONARUTAPLICResult }
     *
     */
    public ROLESPERSONARUTAPLICResponse.ROLESPERSONARUTAPLICResult getROLESPERSONARUTAPLICResult() {
        return rolespersonarutaplicResult;
    }

    /**
     * Define el valor de la propiedad rolespersonarutaplicResult.
     *
     * @param value
     *     allowed object is
     *     {@link ROLESPERSONARUTAPLICResponse.ROLESPERSONARUTAPLICResult }
     *
     */
    public void setROLESPERSONARUTAPLICResult(ROLESPERSONARUTAPLICResponse.ROLESPERSONARUTAPLICResult value) {
        this.rolespersonarutaplicResult = value;
    }


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
     *         &lt;any/>
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
        "content"
    })
    public static class ROLESPERSONARUTAPLICResult {

        @XmlMixed
        @XmlAnyElement(lax = true)
        protected List<Object> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link Object }
         * 
         * 
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<Object>();
            }
            return this.content;
        }

    }

}
