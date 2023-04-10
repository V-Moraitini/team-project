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

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getCon() {return con;}


    /*-------------------------MAIN START-------------------------*/
    public static void main(String args[]) throws SQLException {
        ConfigurationMySQL a = new ConfigurationMySQL();
        try {
            //a.getUsers();
            //a.getUserById(1);
            //a.updateUserById(1, "Todd Jenkins", "tod123", "Office Manager");
            //a.archiveUser(1);
            //a.getStocks();
            //a.getActiveCommissions();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            a.closeConnection();
        }

    }
    /*-------------------------MAIN END-------------------------*/
}