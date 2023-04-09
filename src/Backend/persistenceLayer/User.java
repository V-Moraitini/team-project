package persistenceLayer;

public class User {

        private int Id;
        private String username;
        private String password;
        private String email;
        private String address;
        private int userAgencyTravelCode;
        private enum userType{TravelAdvisor, OfficeManager, SystemAdmin};
        private int userArchived;


    public User(String username, String password, String email, String address, int userAgencyTravelCode, int userArchived) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.userAgencyTravelCode = userAgencyTravelCode;
        this.userArchived = userArchived;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserAgencyTravelCode() {
        return userAgencyTravelCode;
    }

    public void setUserAgencyTravelCode(int userAgencyTravelCode) {
        this.userAgencyTravelCode = userAgencyTravelCode;
    }

    public int getUserArchived() {
        return userArchived;
    }

    public void setUserArchived(int userArchived) {
        this.userArchived = userArchived;
    }

    public int getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", userAgencyTravelCode=" + userAgencyTravelCode +
                ", userArchived=" + userArchived +
                '}';
    }
}
