package Backend.persistenceLayer;

public class TravelAdvisor extends User {

    public TravelAdvisor(String username, String password, String email, int userAgencyTravelCode, int userArchived) {
        super(username, password, email, userAgencyTravelCode, UserType.TravelAdvisor, userArchived);
    }

    @Override
    public String toString() {
        return "TravelAdvisor{}";
    }
}
