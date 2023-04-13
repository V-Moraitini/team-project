package Backend.serviceLayer;



import Backend.persistenceLayer.Customer;
import Backend.persistenceLayer.Sales;
import Backend.persistenceLayer.User;
import Backend.persistenceLayer.UserType;

import java.sql.PreparedStatement;
import java.sql.*;
import MySQL.ConfigurationMySQL;

public class UserSL extends ConfigurationMySQL {

    public User login(String email, String password, UserType userType) {
        getConnection();

        User user = null;
        System.out.println(email + " " + password + " " + userType);


        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE email = ? and password = ? and type = ?");

            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, String.valueOf(userType));


            con.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery();
            con.commit();
            con.setAutoCommit(true);


            while (rs.next()) {
                user = new User(rs.getString(3), rs.getString(5), rs.getString(4), rs.getInt(2), UserType.valueOf(rs.getString(6)), (boolean) rs.getBoolean(7));
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  "
                        + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getInt(7) + "\n");
                //when objects have been made, use object constructor to make them?
            }


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
            return user;
        }

    }
    public static void main(String args[]) throws SQLException {
        UserSL userSl = new UserSL();
        //userSl.login("todd.jenkins@AirVia.com", "tod123", UserType.OfficeManager);
    }

    public void createCustomer(Customer customer) {
        getConnection();
        String sql = "INSERT INTO customer (" +
                "customerName, customerAlias, customerEmail, " +
                "customerPhone, customerIsValued, customerFixedDiscountPercentage)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getCustomerAlias());
            stmt.setString(3, customer.getCustomerEmail());
            stmt.setInt(4, customer.getCustomerPhone());
            stmt.setBoolean(5, customer.getCustomerIsValued());
            stmt.setFloat(6, customer.getCustomerFixedDiscountPercentage());


            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}