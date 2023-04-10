package serviceLayer;

import persistenceLayer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerSL {

    private Connection connection;

    public CustomerSL(Connection connection) {
        this.connection = connection;
    }

    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO Customers (customerName, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getCustomerEmail());
            statement.setInt(3, customer.getCustomerPhone());
            statement.setFloat(5, customer.getCustomerFixedDiscountPercentage());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setCustomerID(generatedKeys.getInt(1));
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE Customers SET customerName = ?, customerEmail = ?, customerPhone = ?, customerIsValued = ?, customerFixedDiscountPercentage = ? WHERE customerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getCustomerEmail());
            statement.setInt(3, customer.getCustomerPhone());
            statement.setFloat(5, customer.getCustomerFixedDiscountPercentage());
            statement.setInt(6, customer.getCustomerID());
            int affectedRows = statement.executeUpdate();
            return (affectedRows > 0);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customers WHERE customerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            int affectedRows = statement.executeUpdate();
            return (affectedRows > 0);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
