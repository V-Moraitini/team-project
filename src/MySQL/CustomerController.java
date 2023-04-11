package MySQL;

import Backend.persistenceLayer.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerController extends ConfigurationMySQL {

    public CustomerController() { }

    /*-------------------------CUSTOMER QUERIES START-------------------------*/
    public void createCustomer(Customer customer) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO customer " +
                            "(customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage)" +
                            "VALUES (?, ?, ?, ?, ?, NULL)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getCustomerAlias());
            stmt.setString(3, customer.getCustomerEmail());
            stmt.setInt(4, customer.getCustomerPhone());
            stmt.setBoolean(5, customer.getCustomerIsValued());

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

    /*public void createCustomer(String name, String alias, String email, int phone, Boolean isValued, double fixedDiscount) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO customer " +
                            "(customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage)" +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);
            stmt.setDouble(6, fixedDiscount);
            con.setAutoCommit(false);
            stmt.executeUpdate();
            /*int affectedRows = stmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }*/

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

            int id;
            String name;
            String alias;
            String email;
            int phone;
            Boolean isValued;
            float fixedDiscount;
            while( rs.next() ) {
                //customerID, customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage
                id = rs.getInt(1);
                name = rs.getString(2);
                alias = rs.getString(3);
                email = rs.getString(4);
                phone = rs.getInt(5);
                isValued = rs.getBoolean(6);
                fixedDiscount = (float) rs.getDouble(7);
                customers.add(new Customer(name, alias, email, phone, isValued, fixedDiscount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return customers;
    }

    public Customer getCustomerById(int id) {
        Customer customer = new Customer("","","",0, false,0);
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer WHERE userId = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            String name;
            String alias;
            String email;
            int phone;
            Boolean isValued;
            float fixedDiscount;
            while( rs.next() ) {
                //customerID, customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage
                name = rs.getString(2);
                alias = rs.getString(3);
                email = rs.getString(4);
                phone = rs.getInt(5);
                isValued = rs.getBoolean(6);
                fixedDiscount = (float) rs.getDouble(7);
                customer = new Customer(name, alias, email, phone, isValued, fixedDiscount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return customer;
    }

    public void updateCustomerById(Customer customer) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE customer SET customerName=?, customerAlias=?, customerEmail=?, " +
                            "customerPhone=?, customerIsValued=? WHERE customerId = ?");
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getCustomerAlias());
            stmt.setString(3, customer.getCustomerEmail());
            stmt.setInt(4, customer.getCustomerPhone());
            stmt.setBoolean(5, customer.getCustomerIsValued());
            stmt.setInt(6, customer.getCustomerID());

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

    /*-------------------------CUSTOMER QUERIES END-------------------------*/
}
