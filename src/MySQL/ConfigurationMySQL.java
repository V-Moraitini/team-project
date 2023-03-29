import java.sql.*;
import java.util.*;
import java.io.*;


class ConfigurationMySQL {
    public String dbms;
    public String jarFile;
    public String dbName;
    public String userName;
    public String password;
    public String urlString;

    private String driver;
    private String serverName;
    private int portNumber;
    private Properties prop;

    public static void getWarningFromStatement(Statement stm) throws SQLException {
        ConfigurationMySQL.printWarnings(stm.getWarnings());
    }

    public static void printWarnings(SQLWarning warning) throws SQLException {
        if (warning != null) {
            System.out.println("\n---Warning---\n");
            while (warning != null) {
                System.out.println("Message: " + warning.getMessage());
                System.out.println("SQLState: " + warning.getSQLState());
                System.out.println("Vendor error code: " + warning.getErrorCode());
                System.out.println("");
                warning = warning.getNextWarning();
            }
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("in2018g07_d", this.userName);
        connectionProps.put("6KV8dzpF", this.password);

        String currentUrlString = "jdbc:mysql://" + this.serverName + ":" + this.portNumber + "/";

        conn = DriverManager.getConnection(
                currentUrlString, connectionProps);
        this.urlString = currentUrlString + ":" + this.dbName;


    }

    public static void main(String args[]){
        ConfigurationMySQL myConfigurationMySQL;
        Connection myConnection = null;
        if (args[0] == null) {
            System.err.println("Properties file not specified at command line");
            return;
        } else {
            try {
                System.out.println("Reading properties file " + args[0]);
                myConfigurationMySQL = new ConfigurationMySQL(args[0]);
            } catch(Exception e) {
                System.err.println("Problem reading properties file " + args[0]);
                e.printStackTrace();
                return;
            }
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver);
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/in2018g07","in2018g07_d","6KV8dzpF");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userAddress, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getInt(8)+"/n");
            con.close();
        } catch (Exception e) { System.out.println(e); }
    }
}