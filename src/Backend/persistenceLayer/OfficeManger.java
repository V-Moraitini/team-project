package Backend.persistenceLayer;

public class OfficeManger extends User {


    public OfficeManger(String username, String password, String email, String address, int userAgencyTravelCode, int userArchived) {
        super(username, password, email, address, userAgencyTravelCode, userArchived);
    }

    @Override
    public String toString() {
        return "OfficeManger{}";
    }
}
