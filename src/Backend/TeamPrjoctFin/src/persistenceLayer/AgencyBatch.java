package persistenceLayer;

public class AgencyBatch {

    private int batchID;
    private int batchAgencyTravelCode;
    private int batchDate;

    public AgencyBatch(int batchAgencyTravelCode, int batchDate) {
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

    public int getBatchID() {
        return batchID;
    }

    @Override
    public String toString() {
        return "AgencyBatch{" +
                "batchID=" + batchID +
                ", batchAgencyTravelCode=" + batchAgencyTravelCode +
                ", batchDate=" + batchDate +
                '}';
    }
}
