package Backend.persistenceLayer;

public class SystemAdmin extends User {


    public SystemAdmin(String username, String password, String email, int userAgencyTravelCode, int userArchived) {
        super(username, password, email, userAgencyTravelCode, UserType.SystemAdmin, userArchived);
    }

    @Override
    public String toString() {
        return "SystemAdmin{}";
    }
}
