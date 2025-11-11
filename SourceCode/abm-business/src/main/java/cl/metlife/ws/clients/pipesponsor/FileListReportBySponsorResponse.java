
package cl.metlife.ws.clients.pipesponsor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="FileListReportBySponsorResult" type="{http://schemas.datacontract.org/2004/07/SmartGear.MetLife.Srp.Application.MainBoundedContext.DTO}ArrayOfFileReportDTO" minOccurs="0"/>
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
    "fileListReportBySponsorResult"
})
@XmlRootElement(name = "FileListReportBySponsorResponse")
public class FileListReportBySponsorResponse {

    @XmlElementRef(name = "FileListReportBySponsorResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFileReportDTO> fileListReportBySponsorResult;

    /**
     * Obtiene el valor de la propiedad fileListReportBySponsorResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFileReportDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFileReportDTO> getFileListReportBySponsorResult() {
        return fileListReportBySponsorResult;
    }

    /**
     * Define el valor de la propiedad fileListReportBySponsorResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFileReportDTO }{@code >}
     *     
     */
    public void setFileListReportBySponsorResult(JAXBElement<ArrayOfFileReportDTO> value) {
        this.fileListReportBySponsorResult = value;
    }

}
