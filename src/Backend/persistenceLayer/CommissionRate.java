package Backend.persistenceLayer;

public class CommissionRate {

    private int commissionId;
    private int commissionAgencyTravelCode;
    private double commissionPercentage;
    private int commissionTicketType;
    private int commissionDate;
    private Boolean commissionIsArchived;

    public CommissionRate(int commissionAgencyTravelCode, double commissionPercentage, int commissionTicketType, int commissionDate, Boolean commissionIsArchived) {
        this.commissionAgencyTravelCode = commissionAgencyTravelCode;
        this.commissionPercentage = commissionPercentage;
        this.commissionTicketType = commissionTicketType;
        this.commissionDate = commissionDate;
        this.commissionIsArchived = commissionIsArchived;
    }

    public CommissionRate(int commissionId, int commissionAgencyTravelCode, double commissionPercentage, int commissionTicketType, int commissionDate, Boolean commissionIsArchived) {
        this.commissionId = commissionId;
        this.commissionAgencyTravelCode = commissionAgencyTravelCode;
        this.commissionPercentage = commissionPercentage;
        this.commissionTicketType = commissionTicketType;
        this.commissionDate = commissionDate;
        this.commissionIsArchived = commissionIsArchived;
    }

    public int getCommissionAgencyTravelCode() {
        return commissionAgencyTravelCode;
    }

    public void setCommissionAgencyTravelCode(int commissionAgencyTravelCode) {
        this.commissionAgencyTravelCode = commissionAgencyTravelCode;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(int commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public int getCommissionTicketType() {
        return commissionTicketType;
    }

    public void setCommissionTicketType(int commissionTicketType) {
        this.commissionTicketType = commissionTicketType;
    }

    public int getCommissionDate() {
        return commissionDate;
    }

    public void setCommissionDate(int commissionDate) {
        this.commissionDate = commissionDate;
    }

    public Boolean getCommissionIsArchived() {
        return commissionIsArchived;
    }

    public void setCommissionIsArchived(Boolean commissionIsArchived) {
        this.commissionIsArchived = commissionIsArchived;
    }

    public int getCommissionId() {
        return commissionId;
    }

    @Override
    public String toString() {
        return "CommissionRate{" +
                "commissionId=" + commissionId +
                ", commissionAgencyTravelCode=" + commissionAgencyTravelCode +
                ", commissionPercentage=" + commissionPercentage +
                ", commissionTicketType=" + commissionTicketType +
                ", commissionDate=" + commissionDate +
                ", commissionIsArchived=" + commissionIsArchived +
                '}';
    }
}
