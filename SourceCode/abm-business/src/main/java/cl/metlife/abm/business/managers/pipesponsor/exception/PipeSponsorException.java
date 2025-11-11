package cl.metlife.abm.business.managers.pipesponsor.exception;

import cl.metlife.abm.ws.domain.FileErrorDetail;

import java.util.List;

public class PipeSponsorException extends Exception{

    private List<FileErrorDetail> fileErrorDetails;
    public PipeSponsorException(String message) {
        super(message);
    }

    public PipeSponsorException(String message, List<FileErrorDetail> fileErrorDetails) {
        super(message);
        this.fileErrorDetails = fileErrorDetails;
    }



    public PipeSponsorException(String message, Throwable cause) {
        super(message, cause);
    }

    public List<FileErrorDetail> getFileErrorDetails() {
        return fileErrorDetails;
    }
}
