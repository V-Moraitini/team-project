package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FlightCoupon {
    ConfigurationMySQL config;

    public FlightCoupon() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------FLIGHT COUPON QUERIES START-------------------------*/
    public void createCoupon(String fromAirport, String toAirport, Boolean isInterline) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO flightCoupon " +
                            "(couponFromAirport, couponToAirport, couponIsInterline)" +
                            "VALUES (?, ?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, fromAirport);
            stmt.setString(2, toAirport);
            stmt.setBoolean(3, isInterline);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCoupons() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM flightCoupon");
            while( rs.next() )
                //couponID, couponFromAirport, couponToAirport, couponIsInterline
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getBoolean(4)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCouponById(int id) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM flightCoupon WHERE couponID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //couponID, couponFromAirport, couponToAirport, couponIsInterline
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getBoolean(4)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCouponById(int id, String fromAirport, String toAirport, Boolean isInterline) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "UPDATE flightCoupon SET couponFromAirport=?, couponToAirport=?, couponIsInterline=? WHERE couponID = ?");
            stmt.setString(1,fromAirport);
            stmt.setString(2, toAirport);
            stmt.setBoolean(3, isInterline);
            stmt.setInt(4, id);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------FLIGHT COUPON QUERIES END-------------------------*/
}
