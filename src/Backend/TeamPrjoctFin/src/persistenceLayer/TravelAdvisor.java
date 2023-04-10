package persistenceLayer;

public class TravelAdvisor extends User{

    public TravelAdvisor(String username, String password, String email, String address, int userAgencyTravelCode, int userArchived) {
        super(username, password, email, address, userAgencyTravelCode, userArchived);
    }

    @Override
    public String toString() {
        return "TravelAdvisor{}";
    }
}
