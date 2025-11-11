package cl.metlife.abm.ws.domain;

import java.util.List;

public class ProcessResult {

    public static final String STATUS_ERROR = "Error";
    public static final String STATUS_SUCCESS = "Success";


    private String status;
    private String errorDetail;

    private List<FileErrorDetail> fileErrorDetailList;

    private long bulkId;

    public ProcessResult() {
    }

    public ProcessResult(String status, String errorDetail) {
        this.status = status;
        this.errorDetail = errorDetail;
    }
    public ProcessResult(String status, String errorDetail, long builkid){
        this.status = status;
        this.errorDetail = errorDetail;
        this.bulkId = builkid;
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

    public long getBulkId() {
        return bulkId;
    }

    public void setBulkId(long builkId) {
        this.bulkId = builkId;
    }

    @Override
    public String toString() {
        return "ProcessResult{" +
                "status='" + status + '\'' +
                ", errorDetail='" + errorDetail + '\'' +
                ", builkId=" + bulkId +
                '}';
    }
}
