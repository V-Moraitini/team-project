package persistenceLayer;

public class Refund {

    private int refundId;
    private int refundSaleId;
    private int refundCustomerId;
    private int refundCommissionId;
    private int refunDate;
    private int refundAmount;

    public Refund(int refundSaleId, int refundCustomerId, int refundCommissionId, int refunDate, int refundAmount) {
        this.refundSaleId = refundSaleId;
        this.refundCustomerId = refundCustomerId;
        this.refundCommissionId = refundCommissionId;
        this.refunDate = refunDate;
        this.refundAmount = refundAmount;
    }

    public int getRefundSaleId() {
        return refundSaleId;
    }

    public void setRefundSaleId(int refundSaleId) {
        this.refundSaleId = refundSaleId;
    }

    public int getRefundCustomerId() {
        return refundCustomerId;
    }

    public void setRefundCustomerId(int refundCustomerId) {
        this.refundCustomerId = refundCustomerId;
    }

    public int getRefundCommissionId() {
        return refundCommissionId;
    }

    public void setRefundCommissionId(int refundCommissionId) {
        this.refundCommissionId = refundCommissionId;
    }

    public int getRefunDate() {
        return refunDate;
    }

    public void setRefunDate(int refunDate) {
        this.refunDate = refunDate;
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(int refundAmount) {
        this.refundAmount = refundAmount;
    }

    public int getRefundId() {
        return refundId;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "refundId=" + refundId +
                ", refundSaleId=" + refundSaleId +
                ", refundCustomerId=" + refundCustomerId +
                ", refundCommissionId=" + refundCommissionId +
                ", refunDate=" + refunDate +
                ", refundAmount=" + refundAmount +
                '}';
    }
}
