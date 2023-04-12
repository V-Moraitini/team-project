package Backend.persistenceLayer;

public class Sales {

    private int saleId;
    private int saleBlankId;
    private int saleAdvisorUserId;
    private int saleCustomerId;
    private int saleCommissionId;
    private double saleCommissionAmount;
    private int saleConversionId;
    private double saleConversionAmount;
    private double saleDiscountAmount;
    private double saleTaxAmount;
    private double saleOtherTaxAmount;
    private double saleFlatPrice;
    private SaleMethod saleMethod;
    private int saleCardNumber;
    private String saleOrigin;
    private String saleDestination;
    private int saleDate;
    private Boolean saleIsInterline;

    public Sales(int saleBlankId, int saleAdvisorUserId, int saleCustomerId, int saleCommissionId, double saleCommissionAmount, int saleConversionId, double saleConversionAmount, double saleDiscountAmount, double saleTaxAmount, double saleOtherTaxAmount, double saleFlatPrice, SaleMethod saleMethod, int saleCardNumber, String saleOrigin, String saleDestination, int saleDate, Boolean saleIsInterline) {
        this.saleBlankId = saleBlankId;
        this.saleAdvisorUserId = saleAdvisorUserId;
        this.saleCustomerId = saleCustomerId;
        this.saleCommissionId = saleCommissionId;
        this.saleCommissionAmount = saleCommissionAmount;
        this.saleConversionId = saleConversionId;
        this.saleConversionAmount = saleConversionAmount;
        this.saleDiscountAmount = saleDiscountAmount;
        this.saleTaxAmount = saleTaxAmount;
        this.saleOtherTaxAmount = saleOtherTaxAmount;
        this.saleFlatPrice = saleFlatPrice;
        this.saleMethod = saleMethod;
        this.saleCardNumber = saleCardNumber;
        this.saleOrigin = saleOrigin;
        this.saleDestination = saleDestination;
        this.saleDate = saleDate;
        this.saleIsInterline = saleIsInterline;
    }

    public Sales(int saleId, int saleBlankId, int saleAdvisorUserId, int saleCustomerId, int saleCommissionId, double saleCommissionAmount, int saleConversionId, double saleConversionAmount, double saleDiscountAmount, double saleTaxAmount, double saleOtherTaxAmount, double saleFlatPrice, SaleMethod saleMethod, int saleCardNumber, String saleOrigin, String saleDestination, int saleDate, Boolean saleIsInterline) {
        this.saleId = saleId;
        this.saleBlankId = saleBlankId;
        this.saleAdvisorUserId = saleAdvisorUserId;
        this.saleCustomerId = saleCustomerId;
        this.saleCommissionId = saleCommissionId;
        this.saleCommissionAmount = saleCommissionAmount;
        this.saleConversionId = saleConversionId;
        this.saleConversionAmount = saleConversionAmount;
        this.saleDiscountAmount = saleDiscountAmount;
        this.saleTaxAmount = saleTaxAmount;
        this.saleOtherTaxAmount = saleOtherTaxAmount;
        this.saleFlatPrice = saleFlatPrice;
        this.saleMethod = saleMethod;
        this.saleCardNumber = saleCardNumber;
        this.saleOrigin = saleOrigin;
        this.saleDestination = saleDestination;
        this.saleDate = saleDate;
        this.saleIsInterline = saleIsInterline;
    }

    //Domestic Sales: missing conversionId, conversionAmount, otherTaxAmount
    /*public Sales(int saleBlankId, int saleAdvisorUserId, int saleCustomerId, int saleCommissionId, double saleCommissionAmount, double saleDiscountAmount, double saleTaxAmount, double saleFlatPrice, SaleMethod saleMethod, int saleCardNumber, String saleOrigin, String saleDestination, int saleDate, Boolean saleIsInterline) {
        this.saleBlankId = saleBlankId;
        this.saleAdvisorUserId = saleAdvisorUserId;
        this.saleCustomerId = saleCustomerId;
        this.saleCommissionId = saleCommissionId;
        this.saleCommissionAmount = saleCommissionAmount;
        this.saleDiscountAmount = saleDiscountAmount;
        this.saleTaxAmount = saleTaxAmount;
        this.saleFlatPrice = saleFlatPrice;
        this.saleMethod = saleMethod;
        this.saleCardNumber = saleCardNumber;
        this.saleOrigin = saleOrigin;
        this.saleDestination = saleDestination;
        this.saleDate = saleDate;
        this.saleIsInterline = saleIsInterline;
    }*/

    /*public Sales(int saleId, int saleBlankId, int saleAdvisorUserId, int saleCustomerId, int saleCommissionId, double saleCommissionAmount, double saleDiscountAmount, double saleTaxAmount, double saleFlatPrice, SaleMethod saleMethod, int saleCardNumber, String saleOrigin, String saleDestination, int saleDate, Boolean saleIsInterline) {
        this.saleId = saleId;
        this.saleBlankId = saleBlankId;
        this.saleAdvisorUserId = saleAdvisorUserId;
        this.saleCustomerId = saleCustomerId;
        this.saleCommissionId = saleCommissionId;
        this.saleCommissionAmount = saleCommissionAmount;
        this.saleDiscountAmount = saleDiscountAmount;
        this.saleTaxAmount = saleTaxAmount;
        this.saleFlatPrice = saleFlatPrice;
        this.saleMethod = saleMethod;
        this.saleCardNumber = saleCardNumber;
        this.saleOrigin = saleOrigin;
        this.saleDestination = saleDestination;
        this.saleDate = saleDate;
        this.saleIsInterline = saleIsInterline;
    }*/

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) { this.saleId = saleId; }

    public int getSaleBlankId() {
        return saleBlankId;
    }

    public void setSaleBlankId(int saleBlankId) {
        this.saleBlankId = saleBlankId;
    }

    public int getSaleAdvisorUserId() {
        return saleAdvisorUserId;
    }

    public void setSaleAdvisorUserId(int saleAdvisorUserId) {
        this.saleAdvisorUserId = saleAdvisorUserId;
    }

    public int getSaleCustomerId() {
        return saleCustomerId;
    }

    public void setSaleCustomerId(int saleCustomerId) {
        this.saleCustomerId = saleCustomerId;
    }

    public int getSaleCommissionId() {
        return saleCommissionId;
    }

    public void setSaleCommissionId(int saleCommissionId) {
        this.saleCommissionId = saleCommissionId;
    }

    public double getSaleCommissionAmount() {
        return saleCommissionAmount;
    }

    public void setSaleCommissionAmount(double saleCommissionAmount) {
        this.saleCommissionAmount = saleCommissionAmount;
    }

    public int getSaleConversionId() {
        return saleConversionId;
    }

    public void setSaleConversionId(int saleConversionId) {
        this.saleConversionId = saleConversionId;
    }

    public double getSaleConversionAmount() {
        return saleConversionAmount;
    }

    public void setSaleConversionAmount(double saleConversionAmount) {
        this.saleConversionAmount = saleConversionAmount;
    }

    public double getSaleDiscountAmount() {
        return saleDiscountAmount;
    }

    public void setSaleDiscountAmount(double saleDiscountAmount) {
        this.saleDiscountAmount = saleDiscountAmount;
    }

    public double getSaleTaxAmount() {
        return saleTaxAmount;
    }

    public void setSaleTaxAmount(double saleTaxAmount) {
        this.saleTaxAmount = saleTaxAmount;
    }

    public double getSaleOtherTaxAmount() {
        return saleOtherTaxAmount;
    }

    public void setSaleOtherTaxAmount(double saleOtherTaxAmount) {
        this.saleTaxAmount = saleOtherTaxAmount;
    }

    public double getSaleFlatPrice() {
        return saleFlatPrice;
    }

    public void setSaleFlatPrice(double saleFlatPrice) {
        this.saleFlatPrice = saleFlatPrice;
    }

    public int getSaleCardNumber() {
        return saleCardNumber;
    }

    public void setSaleCardNumber(int saleCardNumber) {
        this.saleCardNumber = saleCardNumber;
    }

    public SaleMethod getSaleMethod() { return saleMethod; }

    public void setSaleMethod(SaleMethod saleMethod) { this.saleMethod = saleMethod; }

    public String getSaleOrigin() { return saleOrigin; }

    public void setSaleOrigin(String saleOrigin) { this.saleOrigin = saleOrigin; }

    public String getSaleDestination() { return saleDestination; }

    public void setSaleDestination(String saleDestination) { this.saleDestination = saleDestination; }

    public int getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(int saleDate) {
        this.saleDate = saleDate;
    }

    public Boolean getSaleIsInterline() {
        return saleIsInterline;
    }

    public void setSaleIsInterline(Boolean saleIsInterline) {
        this.saleIsInterline = saleIsInterline;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "saleId=" + saleId +
                ", saleBlankId=" + saleBlankId +
                ", saleAdvisorUserId=" + saleAdvisorUserId +
                ", saleCustomerId=" + saleCustomerId +
                ", saleCommissionId=" + saleCommissionId +
                ", saleCommissionAmount=" + saleCommissionAmount +
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
