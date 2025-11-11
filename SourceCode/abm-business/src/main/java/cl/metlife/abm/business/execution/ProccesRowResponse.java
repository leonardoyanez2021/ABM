package cl.metlife.abm.business.execution;

public class ProccesRowResponse {
    private boolean response;
    private long bulkId;


    public ProccesRowResponse(boolean response, long bulkId) {
        this.response = response;
        this.bulkId = bulkId;
    }

    public ProccesRowResponse(boolean response) {
        this.response = response;
        this.bulkId=Long.MIN_VALUE;
    }

    public long getBulkId() {
        return bulkId;
    }

    public void setBulkId(long bulkId) {
        this.bulkId = bulkId;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
