
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FileSecurityKeyInfoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FileSecurityKeyInfoDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="FileDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileSecurityKeyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="Pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrivateKeyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicKeyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileSecurityKeyInfoDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "fileDefinitionId",
    "fileSecurityKeyId",
    "isEnable",
    "pass",
    "privateKeyName",
    "publicKeyName"
})
public class FileSecurityKeyInfoDTO
    extends Dto
{

    @XmlElement(name = "FileDefinitionId")
    protected Long fileDefinitionId;
    @XmlElement(name = "FileSecurityKeyId")
    protected Long fileSecurityKeyId;
    @XmlElement(name = "IsEnable")
    protected Short isEnable;
    @XmlElementRef(name = "Pass", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pass;
    @XmlElementRef(name = "PrivateKeyName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> privateKeyName;
    @XmlElementRef(name = "PublicKeyName", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> publicKeyName;

    /**
     * Obtiene el valor de la propiedad fileDefinitionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileDefinitionId() {
        return fileDefinitionId;
    }

    /**
     * Define el valor de la propiedad fileDefinitionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileDefinitionId(Long value) {
        this.fileDefinitionId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileSecurityKeyId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileSecurityKeyId() {
        return fileSecurityKeyId;
    }

    /**
     * Define el valor de la propiedad fileSecurityKeyId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileSecurityKeyId(Long value) {
        this.fileSecurityKeyId = value;
    }

    /**
     * Obtiene el valor de la propiedad isEnable.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIsEnable() {
        return isEnable;
    }

    /**
     * Define el valor de la propiedad isEnable.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIsEnable(Short value) {
        this.isEnable = value;
    }

    /**
     * Obtiene el valor de la propiedad pass.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPass() {
        return pass;
    }

    /**
     * Define el valor de la propiedad pass.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPass(JAXBElement<String> value) {
        this.pass = value;
    }

    /**
     * Obtiene el valor de la propiedad privateKeyName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrivateKeyName() {
        return privateKeyName;
    }

    /**
     * Define el valor de la propiedad privateKeyName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrivateKeyName(JAXBElement<String> value) {
        this.privateKeyName = value;
    }

    /**
     * Obtiene el valor de la propiedad publicKeyName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPublicKeyName() {
        return publicKeyName;
    }

    /**
     * Define el valor de la propiedad publicKeyName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPublicKeyName(JAXBElement<String> value) {
        this.publicKeyName = value;
    }

}
