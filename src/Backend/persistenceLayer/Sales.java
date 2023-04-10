package Backend.persistenceLayer;

public class Sales {

    private int saleId;
    private int saleBlankId;
    private int AdvisorUserId;
    private int saleCustomerId;
    private int salecommissionId;
    private int salecommissionAmount;
    private int saleConversionId;
    private int saleAdvisorUserId;
    private int saleCommissionId;
    private int saleConversionAmount;
    private int saleDiscountAmount;
    private int saleTaxAmount;
    private int saleFlatPrice;
    private enum saleMethod{Cash, CreditCard};
    private int saleCardNumber;
    private int saleDate;
    private int saleIsInterline;

    public Sales(int saleBlankId, int advisorUserId, int saleCustomerId, int salecommissionId, int salecommissionAmount, int saleConversionId, int saleAdvisorUserId, int saleCommissionId, int saleConversionAmount, int saleDiscountAmount, int saleTaxAmount, int saleFlatPrice, int saleCardNumber, int saleDate, int saleIsInterline) {
        this.saleBlankId = saleBlankId;
        AdvisorUserId = advisorUserId;
        this.saleCustomerId = saleCustomerId;
        this.salecommissionId = salecommissionId;
        this.salecommissionAmount = salecommissionAmount;
        this.saleConversionId = saleConversionId;
        this.saleAdvisorUserId = saleAdvisorUserId;
        this.saleCommissionId = saleCommissionId;
        this.saleConversionAmount = saleConversionAmount;
        this.saleDiscountAmount = saleDiscountAmount;
        this.saleTaxAmount = saleTaxAmount;
        this.saleFlatPrice = saleFlatPrice;
        this.saleCardNumber = saleCardNumber;
        this.saleDate = saleDate;
        this.saleIsInterline = saleIsInterline;
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

    public int getSaleAdvisorUserId() {
        return saleAdvisorUserId;
    }

    public void setSaleAdvisorUserId(int saleAdvisorUserId) {
        this.saleAdvisorUserId = saleAdvisorUserId;
    }

    public int getSaleCommissionId() {
        return saleCommissionId;
    }

    public void setSaleCommissionId(int saleCommissionId) {
        this.saleCommissionId = saleCommissionId;
    }

    public int getSaleConversionAmount() {
        return saleConversionAmount;
    }

    public void setSaleConversionAmount(int saleConversionAmount) {
        this.saleConversionAmount = saleConversionAmount;
    }

    public int getSaleDiscountAmount() {
        return saleDiscountAmount;
    }

    public void setSaleDiscountAmount(int saleDiscountAmount) {
        this.saleDiscountAmount = saleDiscountAmount;
    }

    public int getSaleTaxAmount() {
        return saleTaxAmount;
    }

    public void setSaleTaxAmount(int saleTaxAmount) {
        this.saleTaxAmount = saleTaxAmount;
    }

    public int getSaleFlatPrice() {
        return saleFlatPrice;
    }

    public void setSaleFlatPrice(int saleFlatPrice) {
        this.saleFlatPrice = saleFlatPrice;
    }

    public int getSaleCardNumber() {
        return saleCardNumber;
    }

    public void setSaleCardNumber(int saleCardNumber) {
        this.saleCardNumber = saleCardNumber;
    }

    public int getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(int saleDate) {
        this.saleDate = saleDate;
    }

    public int getSaleIsInterline() {
        return saleIsInterline;
    }

    public void setSaleIsInterline(int saleIsInterline) {
        this.saleIsInterline = saleIsInterline;
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
                ", saleAdvisorUserId=" + saleAdvisorUserId +
                ", saleCommissionId=" + saleCommissionId +
                ", saleConversionAmount=" + saleConversionAmount +
                ", saleDiscountAmount=" + saleDiscountAmount +
                ", saleTaxAmount=" + saleTaxAmount +
                ", saleFlatPrice=" + saleFlatPrice +
                ", saleCardNumber=" + saleCardNumber +
                ", saleDate=" + saleDate +
                ", saleIsInterline=" + saleIsInterline +
                '}';
    }
}
