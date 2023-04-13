package Backend.persistenceLayer;

public class ReportInterlineIndividual {
    //Needs advisor name, advisor id, blank id, local currency, USD, conversion rate, local tax, other tax, total amount, payment details, total amount, commission rate
    //differentiate between payments made in cash and card (?)
    private int advisorId;
    private int blankId;

    private double localCurrency;
    private double usd;
    private double conversionAmount;
    private double localTax;
    private double otherTax;
    private double totalAmount;
    private int commissionId;
    //start date and end date

    public ReportInterlineIndividual(int advisorId, int blankId, double localCurrency, double usd, double conversionAmount, double localTax, double otherTax, double totalAmount) {
        this.advisorId = advisorId;
        this.blankId = blankId;
        this.localCurrency = localCurrency;
        this.usd = usd;
        this.conversionAmount = conversionAmount;
        this.localTax = localTax;
        this.otherTax = otherTax;
        this.totalAmount = totalAmount;
    }

    public int getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(int advisorId) {
        this.advisorId = advisorId;
    }

    public int getBlankId() {
        return blankId;
    }

    public void setBlankId(int blankId) {
        this.blankId = blankId;
    }

    public double getLocalCurrency() {
        return localCurrency;
    }

    public void setLocalCurrency(double localCurrency) {
        this.localCurrency = localCurrency;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getConversionAmount() {
        return conversionAmount;
    }

    public void setConversionAmount(double conversionAmount) {
        this.conversionAmount = conversionAmount;
    }

    public double getLocalTax() {
        return localTax;
    }

    public void setLocalTax(double localTax) {
        this.localTax = localTax;
    }

    public double getOtherTax() {
        return otherTax;
    }

    public void setOtherTax(double otherTax) {
        this.otherTax = otherTax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(int commissionId) {
        this.commissionId = commissionId;
    }
}
