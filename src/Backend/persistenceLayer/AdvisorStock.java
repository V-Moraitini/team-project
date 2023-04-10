package Backend.persistenceLayer;

public class AdvisorStock {

    private int stockId;
    private int stockAdvisorUserId;

    public AdvisorStock(int stockAdvisorUserId) {
        this.stockAdvisorUserId = stockAdvisorUserId;
    }

    public AdvisorStock(int stockId, int stockAdvisorUserId) {
        this.stockId = stockId;
        this.stockAdvisorUserId = stockAdvisorUserId;
    }

    public int getStockAdvisorUserId() {
        return stockAdvisorUserId;
    }

    public void setStockAdvisorUserId(int stockAdvisorUserId) {
        this.stockAdvisorUserId = stockAdvisorUserId;
    }

    public int getStockId() {
        return stockId;
    }

    @Override
    public String toString() {
        return "AdvisorStock{" +
                "stockId=" + stockId +
                ", stockAdvisorUserId=" + stockAdvisorUserId +
                '}';
    }
}
