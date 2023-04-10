package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAccount {
    ConfigurationMySQL config;

    public UserAccount() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------USER QUERIES START-------------------------*/
    //Create user (with ID)
    public void createUser(int id, String name, String email, String password, String type) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO userAccount VALUES (?, 1, ?, ?, ?, ?, 0)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, type);

            //if the user is a travel advisor, make their stock as well
            if (type.equals("Travel Advisor")) {
                //createStock(id);
            }

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Getting active non-archived users only
    public void getActiveUsers() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE userIsArchived = 0");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    //Getting archived users only
    public void getArchivedUsers() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE userIsArchived = 1");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    //Getting users regardless of whether they are archived or not
    public void getAllUsers() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void getUserById(int id) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM userAccount WHERE userID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void updateUserById(int id, String name, String email, String password, String type) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "UPDATE userAccount SET userName=?, userEmail=?, userPassword=?, userType=? " +
                            "WHERE userID = ?");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, type);
            stmt.setInt(5, id);
            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void archiveUser(int id) {
        try {
            PreparedStatement isArchived = config.getCon().prepareStatement(
                    "SELECT userIsArchived FROM userAccount WHERE userID = ?");
            isArchived.setInt(1, id);
            ResultSet rsArchived = isArchived.executeQuery();
            //System.out.println(rsArchived.next());
            while (rsArchived.next()) {
                if (rsArchived.getInt(1) == 0) {
                    PreparedStatement stmt = config.getCon().prepareStatement(
                            "UPDATE userAccount SET userIsArchived = 1 WHERE userID = ?");
                    stmt.setInt(1, id);
                    config.getCon().setAutoCommit(false);
                    stmt.executeUpdate();
                    config.getCon().commit();
                    config.getCon().setAutoCommit(true);
                    System.out.println("User is now archived.");
                } else {
                    PreparedStatement stmt = config.getCon().prepareStatement(
                            "UPDATE userAccount SET userIsArchived = 0 WHERE userID = ?");
                    stmt.setInt(1, id);
                    config.getCon().setAutoCommit(false);
                    stmt.executeUpdate();
                    config.getCon().commit();
                    config.getCon().setAutoCommit(true);
                    System.out.println("User is no longer archived.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------USER QUERIES END-------------------------*/
}
