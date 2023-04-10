package MySQL;

import Backend.persistenceLayer.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAccount extends ConfigurationMySQL {

    public UserAccount() {
    }

    /*-------------------------USER QUERIES START-------------------------*/
    //Create user (with ID)
    public void createUser(int id, String name, String email, String password, String type) {
        try {
            PreparedStatement stmt = con.prepareStatement(
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

            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Getting active non-archived users only
    public void getActiveUsers() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE isArchived = 0");
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
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE isArchived = 1");
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
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public Backend.persistenceLayer.User getUserById(int id) {
        getConnection();
        Backend.persistenceLayer.User user = new User("", "", "", 0, false);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE userId = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            int agencyTravelCode = 1;
            String name;
            String email;
            String password;
            String type;
            Boolean isArchived;
            while( rs.next() ) {
                //userID, userAgencyTravelCode, username, email, password, type, isArchived
                agencyTravelCode = rs.getInt(2);
                name = rs.getString(3);
                email = rs.getString(4);
                password = rs.getString(5);
                type = rs.getString(6);
                isArchived = rs.getBoolean(7);
                user = new User(name, password, email, agencyTravelCode, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }

    public void updateUserById(int id, String name, String email, String password, String type) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE userAccount SET username=?, email=?, password=?, type=? " +
                            "WHERE userId = ?");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, type);
            stmt.setInt(5, id);
            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void archiveUser(int id) {
        try {
            PreparedStatement isArchived = con.prepareStatement(
                    "SELECT isArchived FROM userAccount WHERE userId = ?");
            isArchived.setInt(1, id);
            ResultSet rsArchived = isArchived.executeQuery();
            //System.out.println(rsArchived.next());
            while (rsArchived.next()) {
                if (rsArchived.getInt(1) == 0) {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE userAccount SET isArchived = 1 WHERE userId = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("User is now archived.");
                } else {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE userAccount SET userIsArchived = 0 WHERE userID = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("User is no longer archived.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------USER QUERIES END-------------------------*/
}
