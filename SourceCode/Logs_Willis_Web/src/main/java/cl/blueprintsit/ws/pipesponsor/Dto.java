
package cl.blueprintsit.ws.pipesponsor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Dto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Dto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://schemas.microsoft.com/2003/10/Serialization/}Id"/>
 *       &lt;attribute ref="{http://schemas.microsoft.com/2003/10/Serialization/}Ref"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dto", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork")
@XmlSeeAlso({
    StandardConceptDTO.class,
    OutputColumnDTO.class,
    ColumnDefinitionLzDTO.class,
    FileDescriptionDTO.class,
    LegacySystemDTO.class,
    SponsorDTO.class,
    FileRelationshipDTO.class,
    TargetMappingDataDTO.class,
    BusinessObjectMappingDTO.class,
    OutputEntityDTO.class,
    DataMappingDTO.class,
    ColumnDefinitionDTO.class,
    FileMappingDTO.class,
    ConditionalEspecDTO.class,
    BusinessObjectDTO.class,
    LegacyConceptMappingDTO.class,
    ColumnMappingDTO.class,
    ConditionalSpecSummaryDTO.class,
    BusinessObjectFieldDTO.class,
    SessionLogDTO.class,
    LogProcessDTO.class,
    ColumnDataTypeDTO.class,
    LogProcessFileDTO.class,
    FileBusinessObjectReportDTO.class,
    FileDescriptionLzDTO.class,
    BusinessObjectFieldLzDTO.class,
    FileReportDTO.class,
    FileDTO.class,
    LogProcessDataDTO.class,
    SponsorProcessLogDTO.class,
    ColumnMappingFullInfoDTO.class,
    FileRelationshipDescriptorDTO.class,
    FileRelationsReportDTO.class,
    FileOutputColumnsReportDTO.class
})
public class Dto {

    @XmlAttribute(name = "Id", namespace = "http://schemas.microsoft.com/2003/10/Serialization/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Ref", namespace = "http://schemas.microsoft.com/2003/10/Serialization/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object ref;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRef(Object value) {
        this.ref = value;
    }

}
