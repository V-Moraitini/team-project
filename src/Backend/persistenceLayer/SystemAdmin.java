package Backend.persistenceLayer;

public class SystemAdmin extends User {


    public SystemAdmin(int id, String username, String password, String email, int userAgencyTravelCode, UserType userType, int userArchived) {
        super(id, username, password, email, userAgencyTravelCode, userType, userArchived);
    }
}
