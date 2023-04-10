package persistenceLayer;

public class SystemAdmin extends User{


    public SystemAdmin(String username, String password, String email, String address, int userAgencyTravelCode, int userArchived) {
        super(username, password, email, address, userAgencyTravelCode, userArchived);
    }

    @Override
    public String toString() {
        return "SystemAdmin{}";
    }
}
