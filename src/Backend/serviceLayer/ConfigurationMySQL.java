package serviceLayer;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigurationMySQL {

    public static void getUsers() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userAddress, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getInt(8)+"\n");
            //when objects have been made, use object constructor to make them?
            con.close();
        } catch (Exception e) { System.out.println("ERORR: " + e); }
    }

    public static void getUserById(int id) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE userID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userAddress, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getInt(8)+"\n");
            //when objects have been made, use object constructor to make them?
            con.close();
        } catch (Exception e) { System.out.println(e); }
    }

    public static void updateUserById(int id, String name, String address, String email, String password, String type) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE userAccount SET userName=?, userAddress=?, userEmail=?, userPassword=?, userType=? " +
                            "WHERE userID = ?");
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, type);
            stmt.setInt(6, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
               // userID, userAgencyTravelCode, userName, userAddress, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getInt(8)+"/n");
                //when objects have been made, use object constructor to make them?
                con.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String args[]){
        getUsers();
//        getUserById(1);
    }
}


