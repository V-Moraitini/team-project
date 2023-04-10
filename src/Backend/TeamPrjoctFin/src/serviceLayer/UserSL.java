package serviceLayer;

import persistenceLayer.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class UserSL {


    public class UserDAO {


        private static final String INSERT_USER_SQL = "INSERT INTO users" +
                " (username, password, email, address, agency_code, user_type)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        private static final String UPDATE_USER_SQL = "UPDATE users" +
                " SET username = ?, password = ?, email = ?, address = ?," +
                " agency_code = ?, user_type = ? WHERE id = ?";
        private static final String DELETE_USER_SQL = "DELETE FROM users WHERE id = ?";

        // Insert new user record
        public void insertUser(User user) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
                 PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_SQL)) {

                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getAddress());
                pstmt.setInt(5, user.getUserAgencyTravelCode());


                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Update existing user record
        public void updateUser(User user) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
                 PreparedStatement pstmt = conn.prepareStatement(UPDATE_USER_SQL)) {

                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getAddress());
                pstmt.setInt(5, user.getUserAgencyTravelCode());

                pstmt.setInt(7, user.getId());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Delete existing user record by ID
        public void deleteUser(int id) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
                 PreparedStatement pstmt = conn.prepareStatement(DELETE_USER_SQL)) {

                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
