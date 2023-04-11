package Backend.persistenceLayer;

public class User {

    private int id;
    private String name;
    private String password;
    private String email;
    private int userAgencyTravelCode;
    private UserType userType;
    private int userArchived;


    public User(String name, String password, String email, int userAgencyTravelCode, UserType userType, int userArchived) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userAgencyTravelCode = userAgencyTravelCode;
        this.userType = userType;
        this.userArchived = userArchived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userAgencyTravelCode=" + userAgencyTravelCode +
                ", userType=" + userType +
                ", userArchived=" + userArchived +
                '}';
    }
}
