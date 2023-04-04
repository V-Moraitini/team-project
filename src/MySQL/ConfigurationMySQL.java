package MySQL;

import java.sql.*;

public class ConfigurationMySQL {
    Connection con;

    public ConfigurationMySQL() {
        try {
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07", "in2018g07_d", "6KV8dzpF");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void closeConnection() throws SQLException {
        con.close();
    }

    public void getUsers() {
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void archiveUser(int id) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE userAccount SET userName=?, userPassword=?, userType=? " +
                            "WHERE userID = ?");

            stmt.setInt(4, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userAddress, userEmail, userPassword, userType, userIsArchived
                //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                //        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getInt(8)+"/n");
                //when objects have been made, use object constructor to make them?
                con.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) throws SQLException {
        ConfigurationMySQL a = new ConfigurationMySQL();
        try {
            a.getUsers();
            a.getUserById(1);
            a.updateUserById(1, "Max Jenkins", "tod123", "Office Manager");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            a.closeConnection();
        }

    }
}