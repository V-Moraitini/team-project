package Backend.persistenceLayer;

public class OfficeManager extends User {


    public OfficeManager(int id, String username, String password, String email, int userAgencyTravelCode, UserType userType, int userArchived) {
        super(id, username, password, email, userAgencyTravelCode, userType, userArchived);
    }

    @Override
    public String toString() {
        return "OfficeManger{}";
    }
}
