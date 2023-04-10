package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
    ConfigurationMySQL config;

    public Customer() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------CUSTOMER QUERIES START-------------------------*/
    public void createCustomer(String name, String alias, String email, int phone, Boolean isValued) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO customer " +
                            "(customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage)" +
                            "VALUES (?, ?, ?, ?, ?, NULL)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createCustomer(String name, String alias, String email, int phone, Boolean isValued, double fixedDiscount) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
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
            config.getCon().setAutoCommit(false);
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
            }*/
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCustomers() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            while( rs.next() )
                //customerID, customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getInt(5)+"  "+rs.getBoolean(6)+"  "+rs.getDouble(7)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void getCustomerById(int id) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM customer WHERE userID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //customerID, customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getInt(5)+"  "+rs.getBoolean(6)+"  "+rs.getDouble(7)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void updateCustomerById(int id, String name, String alias, String email, int phone, Boolean isValued) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "UPDATE customer SET customerName=?, customerAlias=?, customerEmail=?, " +
                            "customerPhone=?, customerIsValued=? WHERE customerID = ?");
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);
            stmt.setInt(6, id);
            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------CUSTOMER QUERIES END-------------------------*/
}
