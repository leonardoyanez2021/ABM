
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DataMappingDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DataMappingDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="DataMappingId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SourceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sponsor" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}SponsorDTO" minOccurs="0"/>
 *         &lt;element name="SponsorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetMappingData" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}TargetMappingDataDTO" minOccurs="0"/>
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
@XmlType(name = "DataMappingDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "dataMappingId",
    "isEnable",
    "sourceCode",
    "sourceDescription",
    "sponsor",
    "sponsorCode",
    "targetMappingData",
    "targetMappingDataId"
})
public class DataMappingDTO
    extends Dto
{

    @XmlElement(name = "DataMappingId")
    protected Long dataMappingId;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;
    @XmlElementRef(name = "SourceCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceCode;
    @XmlElementRef(name = "SourceDescription", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceDescription;
    @XmlElementRef(name = "Sponsor", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<SponsorDTO> sponsor;
    @XmlElementRef(name = "SponsorCode", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sponsorCode;
    @XmlElementRef(name = "TargetMappingData", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", type = JAXBElement.class, required = false)
    protected JAXBElement<TargetMappingDataDTO> targetMappingData;
    @XmlElement(name = "TargetMappingDataId")
    protected Long targetMappingDataId;

    /**
     * Obtiene el valor de la propiedad dataMappingId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDataMappingId() {
        return dataMappingId;
    }

    /**
     * Define el valor de la propiedad dataMappingId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDataMappingId(Long value) {
        this.dataMappingId = value;
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
     * Obtiene el valor de la propiedad sourceCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceCode() {
        return sourceCode;
    }

    /**
     * Define el valor de la propiedad sourceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceCode(JAXBElement<String> value) {
        this.sourceCode = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceDescription.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceDescription() {
        return sourceDescription;
    }

    /**
     * Define el valor de la propiedad sourceDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceDescription(JAXBElement<String> value) {
        this.sourceDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad sponsor.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SponsorDTO }{@code >}
     *     
     */
    public JAXBElement<SponsorDTO> getSponsor() {
        return sponsor;
    }

    /**
     * Define el valor de la propiedad sponsor.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SponsorDTO }{@code >}
     *     
     */
    public void setSponsor(JAXBElement<SponsorDTO> value) {
        this.sponsor = value;
    }

    /**
     * Obtiene el valor de la propiedad sponsorCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSponsorCode() {
        return sponsorCode;
    }

    /**
     * Define el valor de la propiedad sponsorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSponsorCode(JAXBElement<String> value) {
        this.sponsorCode = value;
    }

    /**
     * Obtiene el valor de la propiedad targetMappingData.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TargetMappingDataDTO }{@code >}
     *     
     */
    public JAXBElement<TargetMappingDataDTO> getTargetMappingData() {
        return targetMappingData;
    }

    /**
     * Define el valor de la propiedad targetMappingData.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TargetMappingDataDTO }{@code >}
     *     
     */
    public void setTargetMappingData(JAXBElement<TargetMappingDataDTO> value) {
        this.targetMappingData = value;
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
