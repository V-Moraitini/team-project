package Backend.persistenceLayer;

public class OfficeManager extends User {


    public OfficeManager(String username, String password, String email, int userAgencyTravelCode, int userArchived) {
        super(username, password, email, userAgencyTravelCode, UserType.OfficeManager, userArchived);
    }

    @Override
    public String toString() {
        return "OfficeManger{}";
    }
}
