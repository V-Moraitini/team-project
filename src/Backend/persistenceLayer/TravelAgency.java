package Backend.persistenceLayer;

public class TravelAgency {

    private int agencyTravelCode;
    private String agencyName;
    private String agencyAddress;

    public TravelAgency(String agencyName, String agencyAddress) {
        this.agencyName = agencyName;
        this.agencyAddress = agencyAddress;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "agencyTravelCode=" + agencyTravelCode +
                ", agencyName='" + agencyName + '\'' +
                ", agencyAddress='" + agencyAddress + '\'' +
                '}';
    }
}
