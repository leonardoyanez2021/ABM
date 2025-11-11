
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FileRelationshipDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FileRelationshipDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.Seedwork}Dto">
 *       &lt;sequence>
 *         &lt;element name="ColumnDefinitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ColumnRelatedId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileMappingId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FileRelationshipId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileRelationshipDTO", namespace = "http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO", propOrder = {
    "columnDefinitionId",
    "columnRelatedId",
    "fileMappingId",
    "fileRelationshipId",
    "isEnable"
})
public class FileRelationshipDTO
    extends Dto
{

    @XmlElement(name = "ColumnDefinitionId")
    protected Long columnDefinitionId;
    @XmlElement(name = "ColumnRelatedId")
    protected Long columnRelatedId;
    @XmlElement(name = "FileMappingId")
    protected Long fileMappingId;
    @XmlElement(name = "FileRelationshipId")
    protected Long fileRelationshipId;
    @XmlElement(name = "IsEnable")
    protected Boolean isEnable;

    /**
     * Obtiene el valor de la propiedad columnDefinitionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getColumnDefinitionId() {
        return columnDefinitionId;
    }

    /**
     * Define el valor de la propiedad columnDefinitionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setColumnDefinitionId(Long value) {
        this.columnDefinitionId = value;
    }

    /**
     * Obtiene el valor de la propiedad columnRelatedId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getColumnRelatedId() {
        return columnRelatedId;
    }

    /**
     * Define el valor de la propiedad columnRelatedId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setColumnRelatedId(Long value) {
        this.columnRelatedId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileMappingId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileMappingId() {
        return fileMappingId;
    }

    /**
     * Define el valor de la propiedad fileMappingId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileMappingId(Long value) {
        this.fileMappingId = value;
    }

    /**
     * Obtiene el valor de la propiedad fileRelationshipId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileRelationshipId() {
        return fileRelationshipId;
    }

    /**
     * Define el valor de la propiedad fileRelationshipId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileRelationshipId(Long value) {
        this.fileRelationshipId = value;
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

}
