package Backend.persistenceLayer;

public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private int userAgencyTravelCode;
    private UserType userType;
    private boolean isArchived;


    public User(String username, String password, String email, int userAgencyTravelCode, UserType userType, boolean isArchived) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userAgencyTravelCode = userAgencyTravelCode;
        this.userType = userType;
        this.isArchived = isArchived;
    }

    public User(int id, String username, String password, String email, int userAgencyTravelCode, UserType userType, boolean isArchived) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userAgencyTravelCode = userAgencyTravelCode;
        this.userType = userType;
        this.isArchived = isArchived;
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

    public boolean getIsArchived() {
        return this.isArchived;
    }

    public void setIsArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", userArchived=" + isArchived +
                '}';
    }
}