package Backend.persistenceLayer;

public class User {

    private int id;
    private String name;
    private String password;
    private String email;
    private int userAgencyTravelCode;
    private enum userType{TravelAdvisor, OfficeManager, SystemAdmin};
    private Boolean userArchived;


    public User(String username, String password, String email, int userAgencyTravelCode, Boolean userArchived) {
        this.name = username;
        this.password = password;
        this.email = email;
        this.userAgencyTravelCode = userAgencyTravelCode;
        this.userArchived = userArchived;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getUserArchived() {
        return userArchived;
    }

    public void setUserArchived(Boolean userArchived) {
        this.userArchived = userArchived;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userAgencyTravelCode=" + userAgencyTravelCode +
                ", userArchived=" + userArchived +
                '}';
    }
}
