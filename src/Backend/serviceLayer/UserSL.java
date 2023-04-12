package Backend.serviceLayer;



import Backend.persistenceLayer.UserType;

import java.sql.PreparedStatement;
import java.sql.*;
import MySQL.ConfigurationMySQL;

public class UserSL extends ConfigurationMySQL {

    public void login(String email, String password, UserType userType) {
        getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE email = ? and password = ? and type = ?");

            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, String.valueOf(userType));



            con.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery();
            con.commit();
            con.setAutoCommit(true);

            while (rs.next())
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  "
                        + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getInt(7) + "\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }

    }

    public static void main(String args[]) throws SQLException {
        UserSL userSl = new UserSL();
        userSl.login("todd.jenkins@AirVia.com", "tod123", UserType.OfficeManager);
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




