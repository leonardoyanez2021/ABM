
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TargetMappingDataDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TargetMappingDataDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="DataMappings" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfDataMappingDTO" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LegacyConceptMapping" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}LegacyConceptMappingDTO" minOccurs="0"/>
 *         &lt;element name="LegacyConceptMappingId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TargetCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetMappingDataId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetMappingDataDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "dataMappings",
    "isEnable",
    "legacyConceptMapping",
    "legacyConceptMappingId",
    "targetCode",
    "targetDescription",
    "targetMappingDataId"
})
public class TargetMappingDataDTO
    extends Dto
{

    @XmlElementRef(name = "DataMappings", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDataMappingDTO> dataMappings;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElementRef(name = "LegacyConceptMapping", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<LegacyConceptMappingDTO> legacyConceptMapping;
    @XmlElement(name = "LegacyConceptMappingId")
    protected Long legacyConceptMappingId;
    @XmlElementRef(name = "TargetCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> targetCode;
    @XmlElementRef(name = "TargetDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> targetDescription;
    @XmlElement(name = "TargetMappingDataId")
    protected Long targetMappingDataId;

    /**
     * Obtiene el valor de la propiedad dataMappings.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDataMappingDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDataMappingDTO> getDataMappings() {
        return dataMappings;
    }

    /**
     * Define el valor de la propiedad dataMappings.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDataMappingDTO }{@code >}
     *     
     */
    public void setDataMappings(JAXBElement<ArrayOfDataMappingDTO> value) {
        this.dataMappings = value;
    }

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
     * Obtiene el valor de la propiedad legacyConceptMapping.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LegacyConceptMappingDTO }{@code >}
     *     
     */
    public JAXBElement<LegacyConceptMappingDTO> getLegacyConceptMapping() {
        return legacyConceptMapping;
    }

    /**
     * Define el valor de la propiedad legacyConceptMapping.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LegacyConceptMappingDTO }{@code >}
     *     
     */
    public void setLegacyConceptMapping(JAXBElement<LegacyConceptMappingDTO> value) {
        this.legacyConceptMapping = value;
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
     * Obtiene el valor de la propiedad targetCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetCode() {
        return targetCode;
    }

    /**
     * Define el valor de la propiedad targetCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetCode(JAXBElement<String> value) {
        this.targetCode = value;
    }

    /**
     * Obtiene el valor de la propiedad targetDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetDescription() {
        return targetDescription;
    }

    /**
     * Define el valor de la propiedad targetDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetDescription(JAXBElement<String> value) {
        this.targetDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad targetMappingDataId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetMappingDataId() {
        return targetMappingDataId;
    }

    /**
     * Define el valor de la propiedad targetMappingDataId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetMappingDataId(Long value) {
        this.targetMappingDataId = value;
    }

}
