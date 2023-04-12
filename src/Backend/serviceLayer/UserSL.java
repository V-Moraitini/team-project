package Backend.serviceLayer;
import MySQL.ConfigurationMySQL;


import Backend.persistenceLayer.UserType;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class UserSL extends ConfigurationMySQL {

    public boolean login(String email, String password, UserType userType) {
        boolean success = false;
        getConnection();
        ConfigurationMySQL config = new ConfigurationMySQL();

        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM userAccount WHERE userEmail = ? and userPassword = ? and userType = ?");

            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, String.valueOf(userType));

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  "
                        + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getInt(7) + "\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) {
            System.out.println(e);
        }
        return success;
    }
}



//        private static final String INSERT_USER_SQL = "INSERT INTO users" +
//                " (username, password, email, address, agency_code, user_type)" +
//                " VALUES (?, ?, ?, ?, ?, ?)";
//        private static final String UPDATE_USER_SQL = "UPDATE users" +
//                " SET username = ?, password = ?, email = ?, address = ?," +
//                " agency_code = ?, user_type = ? WHERE id = ?";
//        private static final String DELETE_USER_SQL = "DELETE FROM users WHERE id = ?";
//
//        // Insert new user record
//        public void insertUser(User user) {
//            try (Connection conn = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
//                 PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_SQL)) {
//
//                pstmt.setString(1, user.getName());
//                pstmt.setString(2, user.getPassword());
//                pstmt.setString(3, user.getEmail());
//                pstmt.setString(4, user.getAddress());
//                pstmt.setInt(5, user.getUserAgencyTravelCode());
//
//
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Update existing user record
//        public void updateUser(User user) {
//            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
//                 PreparedStatement pstmt = conn.prepareStatement(UPDATE_USER_SQL)) {
//
//                pstmt.setString(1, user.getName());
//                pstmt.setString(2, user.getPassword());
//                pstmt.setString(3, user.getEmail());
//                pstmt.setString(4, user.getAddress());
//                pstmt.setInt(5, user.getUserAgencyTravelCode());
//
//                pstmt.setInt(7, user.getId());
//
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Delete existing user record by ID
//        public void deleteUser(int id) {
//            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
//                 PreparedStatement pstmt = conn.prepareStatement(DELETE_USER_SQL)) {
//
//                pstmt.setInt(1, id);
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }




