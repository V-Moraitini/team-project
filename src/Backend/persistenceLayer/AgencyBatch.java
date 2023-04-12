package Backend.persistenceLayer;

public class AgencyBatch {

    private int batchId;
    private int batchAgencyTravelCode;
    private int batchDate;

    public AgencyBatch(int batchAgencyTravelCode, int batchDate) {
        this.batchAgencyTravelCode = batchAgencyTravelCode;
        this.batchDate = batchDate;
    }

    public AgencyBatch(int batchId, int batchAgencyTravelCode, int batchDate) {
        this.batchId = batchId;
        this.batchAgencyTravelCode = batchAgencyTravelCode;
        this.batchDate = batchDate;
    }

    public int getBatchAgencyTravelCode() {
        return batchAgencyTravelCode;
    }

    public void setBatchAgencyTravelCode(int batchAgencyTravelCode) {
        this.batchAgencyTravelCode = batchAgencyTravelCode;
    }

    public int getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(int batchDate) {
        this.batchDate = batchDate;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) { this.batchId = batchId; }

    @Override
    public String toString() {
        return "AgencyBatch{" +
                "batchId=" + batchId +
                ", batchAgencyTravelCode=" + batchAgencyTravelCode +
                ", batchDate=" + batchDate +
                '}';
    }
}
