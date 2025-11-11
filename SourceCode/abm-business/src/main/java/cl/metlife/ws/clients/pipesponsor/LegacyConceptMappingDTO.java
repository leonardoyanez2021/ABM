
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegacyConceptMappingDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LegacyConceptMappingDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LegacyConceptMappingId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LegacySystem" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}LegacySystemDTO" minOccurs="0"/>
 *         &lt;element name="LegacySystemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StandardConcept" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}StandardConceptDTO" minOccurs="0"/>
 *         &lt;element name="StandardConceptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TargetMappingDatas" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfTargetMappingDataDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegacyConceptMappingDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "isEnable",
    "legacyConceptMappingId",
    "legacySystem",
    "legacySystemId",
    "standardConcept",
    "standardConceptId",
    "targetMappingDatas"
})
public class LegacyConceptMappingDTO
    extends Dto
{

    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElement(name = "LegacyConceptMappingId")
    protected Long legacyConceptMappingId;
    @XmlElementRef(name = "LegacySystem", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<LegacySystemDTO> legacySystem;
    @XmlElement(name = "LegacySystemId")
    protected Long legacySystemId;
    @XmlElementRef(name = "StandardConcept", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<StandardConceptDTO> standardConcept;
    @XmlElement(name = "StandardConceptId")
    protected Long standardConceptId;
    @XmlElementRef(name = "TargetMappingDatas", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfTargetMappingDataDTO> targetMappingDatas;

    /**
     * Obtiene el valor de la propiedad isEnable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEnable() {
        return isEnable;
    }

    /**
     * Define el valor de la propiedad isEnable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEnable(Boolean value) {
        this.isEnable = value;
    }

    /**
     * Obtiene el valor de la propiedad legacyConceptMappingId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLegacyConceptMappingId() {
        return legacyConceptMappingId;
    }

    /**
     * Define el valor de la propiedad legacyConceptMappingId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLegacyConceptMappingId(Long value) {
        this.legacyConceptMappingId = value;
    }

    /**
     * Obtiene el valor de la propiedad legacySystem.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LegacySystemDTO }{@code >}
     *     
     */
    public JAXBElement<LegacySystemDTO> getLegacySystem() {
        return legacySystem;
    }

    /**
     * Define el valor de la propiedad legacySystem.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LegacySystemDTO }{@code >}
     *     
     */
    public void setLegacySystem(JAXBElement<LegacySystemDTO> value) {
        this.legacySystem = value;
    }

    /**
     * Obtiene el valor de la propiedad legacySystemId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLegacySystemId() {
        return legacySystemId;
    }

    /**
     * Define el valor de la propiedad legacySystemId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLegacySystemId(Long value) {
        this.legacySystemId = value;
    }

    /**
     * Obtiene el valor de la propiedad standardConcept.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StandardConceptDTO }{@code >}
     *     
     */
    public JAXBElement<StandardConceptDTO> getStandardConcept() {
        return standardConcept;
    }

    /**
     * Define el valor de la propiedad standardConcept.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StandardConceptDTO }{@code >}
     *     
     */
    public void setStandardConcept(JAXBElement<StandardConceptDTO> value) {
        this.standardConcept = value;
    }

    /**
     * Obtiene el valor de la propiedad standardConceptId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStandardConceptId() {
        return standardConceptId;
    }

    /**
     * Define el valor de la propiedad standardConceptId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStandardConceptId(Long value) {
        this.standardConceptId = value;
    }

    /**
     * Obtiene el valor de la propiedad targetMappingDatas.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTargetMappingDataDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTargetMappingDataDTO> getTargetMappingDatas() {
        return targetMappingDatas;
    }

    /**
     * Define el valor de la propiedad targetMappingDatas.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTargetMappingDataDTO }{@code >}
     *     
     */
    public void setTargetMappingDatas(JAXBElement<ArrayOfTargetMappingDataDTO> value) {
        this.targetMappingDatas = value;
    }

}
