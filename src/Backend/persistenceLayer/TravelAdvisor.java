package Backend.persistenceLayer;

public class TravelAdvisor extends User {


    public TravelAdvisor(int id, String username, String password, String email, int userAgencyTravelCode, UserType userType, boolean userArchived) {
        super(id, username, password, email, userAgencyTravelCode, userType, userArchived);
    }

}
