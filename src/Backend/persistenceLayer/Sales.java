package Backend.persistenceLayer;

import java.util.Date;

public class Sales {

    private int saleId;
    private double transactionAmount;
    private String paymentType;
    private int datePaid;
    private String advisorName;
    private int ticketID;
    private int AdvisorUserId;
    private int saleCustomerId;
    private int salecommissionId;
    private int salecommissionAmount;
    private int saleConversionId;


    public Sales(int saleBlankId, int advisorUserId, int saleCustomerId, int salecommissionId, int salecommissionAmount,
                 int saleConversionId, String advisorName, int ticketID, String paymentType, int transactionAmount, int datePaid) {
        this.ticketID = saleBlankId;
        AdvisorUserId = advisorUserId;
        this.saleCustomerId = saleCustomerId;
        this.salecommissionId = salecommissionId;
        this.salecommissionAmount = salecommissionAmount;
        this.saleConversionId = saleConversionId;
        this.advisorName = advisorName;
    }

    public int getSaleBlankId() {
        return ticketID;
    }

    public void setSaleBlankId(int saleBlankId) {
        this.ticketID = saleBlankId;
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

    public String getAdvisorName() {return advisorName;}

    public void setAdvisorName(String advisorName) {this.advisorName = advisorName;}


    public double getTransactionAmount() {return transactionAmount;}

    public void setTransactionAmount(double transactionAmount) {this.transactionAmount = transactionAmount;}

    public String getPaymentType() {return paymentType;}

    public void setPaymentType(String paymentType) {this.paymentType = paymentType;}

    public void setSaleId(int saleId) {this.saleId = saleId;}

    public int getDatePaid() {return datePaid;}

    public void setDatePaid(int datePaid) {this.datePaid = datePaid;}

    public int getTicketID() {return ticketID;}

    public void setTicketID(int ticketID) {this.ticketID = ticketID;}


    @Override
    public String toString() {
        return "Sales{" +
                "saleId=" + saleId +
                ", saleBlankId=" + ticketID +
                ", AdvisorUserId=" + AdvisorUserId +
                ", saleCustomerId=" + saleCustomerId +
                ", salecommissionId=" + salecommissionId +
                ", salecommissionAmount=" + salecommissionAmount +
                ", saleConversionId=" + saleConversionId +
                ", saleId=" + saleId +
                ", transactionAmount" + transactionAmount +
                ", paymentType" + paymentType +
                ", datePaid" + datePaid +
                '}';
    }
    public static void main(String[] args) {
        Sales sale1 = new Sales(1234, 1, 2, 3, 100,
                4, "John", 122, "card", 2000,230409);
        sale1.setSaleId(1);
        sale1.setTransactionAmount(500.0);
        sale1.setPaymentType("Credit Card");
        sale1.setDatePaid(sale1.datePaid);

        System.out.println(sale1);
    }
}
