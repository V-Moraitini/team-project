package Backend.persistenceLayer;

public class Blank {

    private int blankId;
    private int blankBatchId;
    private int blankStockId;
    private int blankStockAdvisorUserId;
    private int blankType;
    private int blankDateReceived;
    private int blankIsValid;
    private int blankIsSold;
    private int blankIsInterline;
    private int blankIsArchived;

    public Blank(int blankId,int blankBatchId, int blankStockId, int blankStockAdvisorUserId, int blankType, int blankDateReceived, int blankIsValid, int blankIsSold, int blankIsInterline, int blankIsArchived) {
       this.blankId = blankId;
        this.blankBatchId = blankBatchId;
        this.blankStockId = blankStockId;
        this.blankStockAdvisorUserId = blankStockAdvisorUserId;
        this.blankType = blankType;
        this.blankDateReceived = blankDateReceived;
        this.blankIsValid = blankIsValid;
        this.blankIsSold = blankIsSold;
        this.blankIsInterline = blankIsInterline;
        this.blankIsArchived = blankIsArchived;
    }

    public int getBlankId() {
        return blankId;
    }

    public void setBlankId(int blankId){
        this.blankId=blankId;
    }

    public int getBlankBatchId() {
        return blankBatchId;
    }

    public void setBlankBatchId(int blankBatchId) {
        this.blankBatchId = blankBatchId;
    }

    public int getBlankStockId() {
        return blankStockId;
    }

    public void setBlankStockId(int blankStockId) {
        this.blankStockId = blankStockId;
    }

    public int getBlankStockAdvisorUserId() {
        return blankStockAdvisorUserId;
    }

    public void setBlankStockAdvisorUserId(int blankStockAdvisorUserId) {
        this.blankStockAdvisorUserId = blankStockAdvisorUserId;
    }

    public int getBlankType() {
        return blankType;
    }

    public void setBlankType(int blankType) {
        this.blankType = blankType;
    }

    public int getBlankDateReceived() {
        return blankDateReceived;
    }

    public void setBlankDateReceived(int blankDateReceived) {
        this.blankDateReceived = blankDateReceived;
    }

    public int getBlankIsValid() {
        return blankIsValid;
    }

    public void setBlankIsValid(int blankIsValid) {
        this.blankIsValid = blankIsValid;
    }

    public int getBlankIsSold() {
        return blankIsSold;
    }

    public void setBlankIsSold(int blankIsSold) {
        this.blankIsSold = blankIsSold;
    }

    public int getBlankIsInterline() {
        return blankIsInterline;
    }

    public void setBlankIsInterline(int blankIsInterline) {
        this.blankIsInterline = blankIsInterline;
    }

    public int getBlankIsArchived() {
        return blankIsArchived;
    }

    public void setBlankIsArchived(int blankIsArchived) {
        this.blankIsArchived = blankIsArchived;
    }

    @Override
    public String toString() {
        return "blank{" +
                "blankId=" + blankId +
                ", blankBatchId=" + blankBatchId +
                ", blankStockId=" + blankStockId +
                ", blankStockAdvisorUserId=" + blankStockAdvisorUserId +
                ", blankType=" + blankType +
                ", blankDateReceived=" + blankDateReceived +
                ", blankIsValid=" + blankIsValid +
                ", blankIsSold=" + blankIsSold +
                ", blankIsArchived=" + blankIsArchived +
                '}';
    }
}
