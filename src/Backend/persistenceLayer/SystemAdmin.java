package Backend.persistenceLayer;

public class SystemAdmin extends User {


    public SystemAdmin(String name, String password, String email, int userAgencyTravelCode, UserType userType, int userArchived) {
        super(name, password, email, userAgencyTravelCode, userType, userArchived);
    }

    @Override
    public String toString() {
        return "SystemAdmin{}";
    }
}
