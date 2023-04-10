package Backend.persistenceLayer;

public class CommissionRate {

    private int commissionId;
    private int commissionAgencyTravelCode;
    private int commissionPercentage;
    private int commissionTicketType;
    private int commissionDate;
    private int commissionIsArchived;

    public CommissionRate(int commissionAgencyTravelCode, int commissionPercentage, int commissionTicketType, int commissionDate, int commissionIsarchived) {
        this.commissionAgencyTravelCode = commissionAgencyTravelCode;
        this.commissionPercentage = commissionPercentage;
        this.commissionTicketType = commissionTicketType;
        this.commissionDate = commissionDate;
        this.commissionIsArchived = commissionIsarchived;
    }

    public int getCommissionAgencyTravelCode() {
        return commissionAgencyTravelCode;
    }

    public void setCommissionAgencyTravelCode(int commissionAgencyTravelCode) {
        this.commissionAgencyTravelCode = commissionAgencyTravelCode;
    }

    public int getCommissionPercentage() {
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

    public int getCommissionIsArchived() {
        return commissionIsArchived;
    }

    public void setCommissionIsArchived(int commissionIsArchived) {
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
