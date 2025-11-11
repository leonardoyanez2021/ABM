package cl.metlife.abm.ws.domain;

import java.util.List;

public class ProcessResult2 {

    public static final String STATUS_ERROR = "Error";
    public static final String STATUS_SUCCESS = "Success";


    private String status;
    private String errorDetail;

    private List<FileErrorDetail> fileErrorDetailList;


    public ProcessResult2() {
    }

    public ProcessResult2(String status, String errorDetail) {
        this.status = status;
        this.errorDetail = errorDetail;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public List<FileErrorDetail> getFileErrorDetailList() {
        return fileErrorDetailList;
    }

    public void setFileErrorDetailList(List<FileErrorDetail> fileErrorDetailList) {
        this.fileErrorDetailList = fileErrorDetailList;
    }
}
