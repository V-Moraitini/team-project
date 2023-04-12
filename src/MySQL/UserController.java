package MySQL;

import Backend.persistenceLayer.AdvisorStock;
import Backend.persistenceLayer.User;
import Backend.persistenceLayer.UserType;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserController extends ConfigurationMySQL {

    public UserController() {
    }

    /*-------------------------USER QUERIES START-------------------------*/
    //Create user
    public void createUser(User user) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO userAccount (userId, userAgencyTravelCode, username, email, password, type, isArchived)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, user.getId()); // assuming this is the userId
            stmt.setInt(2, user.getUserAgencyTravelCode()); // assuming this is the userAgencyTravelCode
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getUserType().toString());
            stmt.setBoolean(7, user.getIsArchived());

            con.setAutoCommit(false);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }

            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
    //Getting active non-archived users only
    public ArrayList<User> getActiveUsers() {
        ArrayList<User> users = new ArrayList<>();
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE isArchived = 0");

            int id;
            int agencyTravelCode = 1;
            String name;
            String email;
            String password;
            UserType type;
            int isArchived;
            while (rs.next()) {
                //userId userAgencyTravelCode, username, email, password, type, isArchived
                id = rs.getInt(1);
                agencyTravelCode = rs.getInt(2);
                name = rs.getString(3);
                email = rs.getString(4);
                password = rs.getString(5);
                type = UserType.valueOf(rs.getString(6));
                isArchived = rs.getInt(7);
                users.add(new User(id, name, password, email, agencyTravelCode, type, isArchived));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return users;
    }

    //Getting archived users only
    public ArrayList<User> getArchivedUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE isArchived = 1");

            int id;
            int agencyTravelCode = 1;
            String name;
            String email;
            String password;
            UserType type;
            int isArchived;
            while (rs.next()) {
                //userId userAgencyTravelCode, username, email, password, type, isArchived
                id = rs.getInt(1);
                agencyTravelCode = rs.getInt(2);
                name = rs.getString(3);
                email = rs.getString(4);
                password = rs.getString(5);
                type = UserType.valueOf(rs.getString(6));
                isArchived = rs.getInt(7);
                users.add(new User(id, name, password, email, agencyTravelCode, type, isArchived));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return users;
    }

    //Getting users regardless of whether they are archived or not
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount");

            int id;
            int agencyTravelCode = 1;
            String name;
            String email;
            String password;
            UserType type;
            int isArchived;
            while (rs.next()) {
                //userId userAgencyTravelCode, username, email, password, type, isArchived
                id = rs.getInt(1);
                agencyTravelCode = rs.getInt(2);
                name = rs.getString(3);
                email = rs.getString(4);
                password = rs.getString(5);
                type = UserType.valueOf(rs.getString(6));
                isArchived = rs.getInt(7);
                users.add(new User(id, name, password, email, agencyTravelCode, type, isArchived));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return users;
    }

    public Backend.persistenceLayer.User getUserById(int id) {
        getConnection();
        Backend.persistenceLayer.User user = new User("", "", "", 0, UserType.TravelAdvisor, false);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE userId = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            int agencyTravelCode = 1;
            String name;
            String email;
            String password;
            UserType type;
            int isArchived; //change into Boolean later
            while (rs.next()) {
                //userId userAgencyTravelCode, username, email, password, type, isArchived
                agencyTravelCode = rs.getInt(2);
                name = rs.getString(3);
                email = rs.getString(4);
                password = rs.getString(5);
                type = UserType.valueOf(rs.getString(6));
                isArchived = rs.getInt(7);
                user = new User(id, name, password, email, agencyTravelCode, type, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }

    public Backend.persistenceLayer.User getUserByEmail(String email) {
        getConnection();
        Backend.persistenceLayer.User user = new User("", "", "", 0, UserType.TravelAdvisor, false);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            int id;
            int agencyTravelCode = 1;
            String name;
            String password;
            UserType type;
            int isArchived; //change into Boolean later
            while (rs.next()) {
                //userId userAgencyTravelCode, username, email, password, type, isArchived
                id = rs.getInt(1);
                agencyTravelCode = rs.getInt(2);
                name = rs.getString(3);
                password = rs.getString(5);
                type = UserType.valueOf(rs.getString(6));
                isArchived = rs.getInt(7);
                user = new User(id, name, password, email, agencyTravelCode, type, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }

    public void updateUser(User user) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE userAccount SET username=?, email=?, password=?, type=? " +
                            "WHERE userId = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getUserType().toString());
            stmt.setInt(5, user.getId());
            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void archiveUser(int id) {
        getConnection();
        try {
            String sql = "UPDATE userAccount SET isArchived = 1 WHERE userId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }}