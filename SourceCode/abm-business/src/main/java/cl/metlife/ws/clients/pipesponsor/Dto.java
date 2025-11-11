
package cl.metlife.ws.clients.pipesponsor;

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
 * <p>Clase Java para Dto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
    FileDescriptionDTO.class,
    OutputEntityDTO.class,
    ItemListDTO.class,
    BusinessObjectDTO.class,
    TypeListDTO.class,
    LegacySystemDTO.class,
    StandardConceptDTO.class,
    FileMappingDTO.class,
    OutputConnectionDTO.class,
    InterfaceFilterLzDTO.class,
    DataMappingDTO.class,
    BusinessObjectFieldDTO.class,
    BusinessObjectMappingDTO.class,
    ConditionalSpecSummaryDTO.class,
    ColumnMappingDTO.class,
    ColumnDefinitionLzDTO.class,
    FileSecurityKeyDTO.class,
    FileRelationshipDTO.class,
    ConditionalEspecDTO.class,
    PagedListDTOOfSponsorProcessLogDTOTg3ItwTH.class,
    OutputColumnDTO.class,
    SponsorDTO.class,
    ColumnDefinitionDTO.class,
    TargetMappingDataDTO.class,
    PagedListDTOOfImportLogDTOTg3ItwTH.class,
    FileInterfaceLzDTO.class,
    LogProcessDTO.class,
    LegacyConceptMappingDTO.class,
    SessionLogDTO.class,
    FileInterfaceDTO.class,
    PagedListDTOOfErrorDescriptionDTOTg3ItwTH.class,
    FileSecurityKeyInfoDTO.class,
    FileDescriptionLzDTO.class,
    ColumnDataTypeDTO.class,
    ErrorDescriptionDTO.class,
    FileInterfaceWhitColumnsDTO.class,
    FileReportDTO.class,
    ImportLogDTO.class,
    ColumnMappingFullInfoDTO.class,
    FileBusinessObjectReportDTO.class,
    LogProcessDataDTO.class,
    SponsorProcessLogDTO.class,
    LogProcessFileDTO.class,
    FileRelationsReportDTO.class,
    BusinessObjectFieldLzDTO.class,
    FileOutputColumnsReportDTO.class,
    FileRelationshipDescriptorDTO.class,
    BusinessObjectMappingLzDTO.class,
    LogProcessTargetDTO.class,
    FileDTO.class,
    LogProcessActivityDTO.class
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
     * Obtiene el valor de la propiedad id.
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
     * Define el valor de la propiedad id.
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
     * Obtiene el valor de la propiedad ref.
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
     * Define el valor de la propiedad ref.
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
