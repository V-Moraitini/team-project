package Backend.persistenceLayer;

public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private int userAgencyTravelCode;
    private UserType userType;
    private int userArchived;


    public User(int id, String username, String password, String email, int userAgencyTravelCode, UserType userType, int userArchived) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userAgencyTravelCode = userAgencyTravelCode;
        this.userType = userType;
        this.userArchived = userArchived;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserAgencyTravelCode() {
        return userAgencyTravelCode;
    }

    public void setUserAgencyTravelCode(int userAgencyTravelCode) {
        this.userAgencyTravelCode = userAgencyTravelCode;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getUserArchived() {
        return userArchived;
    }

    public void setUserArchived(int userArchived) {
        this.userArchived = userArchived;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userAgencyTravelCode=" + userAgencyTravelCode +
                ", userType=" + userType +
                ", userArchived=" + userArchived +
                '}';
    }
}
