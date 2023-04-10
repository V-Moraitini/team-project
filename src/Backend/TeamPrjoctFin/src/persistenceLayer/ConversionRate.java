package persistenceLayer;

public class ConversionRate {

    private int conversionId;
    private String conversionCurrency;
    private double conversionRate;
    private int conversionDate;

    public ConversionRate(String conversionCurrency, int conversionRate, int conversionDate) {
        this.conversionCurrency = conversionCurrency;
        this.conversionRate = conversionRate;
        this.conversionDate = conversionDate;
    }

    public String getConversionCurrency() {
        return conversionCurrency;
    }

    public void setConversionCurrency(String conversionCurrency) {
        this.conversionCurrency = conversionCurrency;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(int conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(int conversionDate) {
        this.conversionDate = conversionDate;
    }

    @Override
    public String toString() {
        return "ConversionRate{" +
                "conversionId=" + conversionId +
                ", conversionCurrency='" + conversionCurrency + '\'' +
                ", conversionRate=" + conversionRate +
                ", conversionDate=" + conversionDate +
                '}';
    }
}
