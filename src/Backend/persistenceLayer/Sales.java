package persistenceLayer;

public class Sales {

    private int saleId;
    private int saleBlankId;
    private int AdvisorUserId;
    private int saleCustomerId;
    private int salecommissionId;
    private int salecommissionAmount;
    private int saleConversionId;

    public Sales(int saleBlankId, int advisorUserId, int saleCustomerId, int salecommissionId, int salecommissionAmount, int saleConversionId) {
        this.saleBlankId = saleBlankId;
        AdvisorUserId = advisorUserId;
        this.saleCustomerId = saleCustomerId;
        this.salecommissionId = salecommissionId;
        this.salecommissionAmount = salecommissionAmount;
        this.saleConversionId = saleConversionId;
    }

    public int getSaleBlankId() {
        return saleBlankId;
    }

    public void setSaleBlankId(int saleBlankId) {
        this.saleBlankId = saleBlankId;
    }

    public int getAdvisorUserId() {
        return AdvisorUserId;
    }

    public void setAdvisorUserId(int advisorUserId) {
        AdvisorUserId = advisorUserId;
    }

    public int getSaleCustomerId() {
        return saleCustomerId;
    }

    public void setSaleCustomerId(int saleCustomerId) {
        this.saleCustomerId = saleCustomerId;
    }

    public int getSalecommissionId() {
        return salecommissionId;
    }

    public void setSalecommissionId(int salecommissionId) {
        this.salecommissionId = salecommissionId;
    }

    public int getSalecommissionAmount() {
        return salecommissionAmount;
    }

    public void setSalecommissionAmount(int salecommissionAmount) {
        this.salecommissionAmount = salecommissionAmount;
    }

    public int getSaleConversionId() {
        return saleConversionId;
    }

    public void setSaleConversionId(int saleConversionId) {
        this.saleConversionId = saleConversionId;
    }

    public int getSaleId() {
        return saleId;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "saleId=" + saleId +
                ", saleBlankId=" + saleBlankId +
                ", AdvisorUserId=" + AdvisorUserId +
                ", saleCustomerId=" + saleCustomerId +
                ", salecommissionId=" + salecommissionId +
                ", salecommissionAmount=" + salecommissionAmount +
                ", saleConversionId=" + saleConversionId +
                '}';
    }
}
