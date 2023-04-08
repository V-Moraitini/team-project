package MySQL;

import java.sql.*;

public class ConfigurationMySQL {
    Connection con;

    public ConfigurationMySQL() {
        try {
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07", "in2018g07_d", "6KV8dzpF");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection() throws SQLException {
        con.close();
    }

    /*-------------------------USER QUERIES START-------------------------*/
    //Create user (with ID)
    public void createUser(int id, String name, String password, String type) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO userAccount VALUES (?, 1, ?, ?, ?, 0)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, password);
            stmt.setString(4, type);
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE userIsArchived = 0");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getInt(6)+"\n");
                //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    //Getting users regardless of whether they are archived or not
    public void getAllUsers() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getInt(6)+"\n");
                //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void getUserById(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE userID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void updateUserById(int id, String name, String password, String type) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE userAccount SET userName=?, userPassword=?, userType=? " +
                    "WHERE userID = ?");
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, type);
            stmt.setInt(4, id);
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
                    "SELECT userIsArchived FROM userAccount WHERE userID = ?");
            isArchived.setInt(1, id);
            ResultSet rsArchived = isArchived.executeQuery();
            //System.out.println(rsArchived.next());
            while (rsArchived.next()) {
                if (rsArchived.getInt(1) == 0) {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE userAccount SET userIsArchived = 1 WHERE userID = ?");
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

    /*-------------------------CUSTOMER QUERIES START-------------------------*/
    public void createCustomer(String name, String alias, String email, int phone, Boolean isValued) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO customer " +
                            "(customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage)" +
                            "VALUES (?, ?, ?, ?, ?, NULL)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);
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
            }*/
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCustomers() {
        try {
            Statement stmt = con.createStatement();
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer WHERE userID = ?");
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
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE customer SET customerName=?, customerAlias=?, customerEmail=?, " +
                            "customerPhone=?, customerIsValued=?" +
                            "WHERE customerID = ?");
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);
            stmt.setInt(6, id);
            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------CUSTOMER QUERIES END-------------------------*/

    public static void main(String args[]) throws SQLException {
        ConfigurationMySQL a = new ConfigurationMySQL();
        try {
            //a.getUsers();
            //a.getUserById(1);
            //a.updateUserById(1, "Todd Jenkins", "tod123", "Office Manager");
            //a.archiveUser(1);
            //a.createCustomer("Chris Smart", "Chris", "chris.smart@email.com", 7888111, true);
            a.getCustomers();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            a.closeConnection();
        }

    }
}