package Backend.persistenceLayer;

public class TravelAdvisor extends User {


    public TravelAdvisor(String name, String password, String email, int userAgencyTravelCode, UserType userType, int userArchived) {
        super(name, password, email, userAgencyTravelCode, userType, userArchived);
    }

    @Override
    public String toString() {
        return "TravelAdvisor{}";
    }
}
