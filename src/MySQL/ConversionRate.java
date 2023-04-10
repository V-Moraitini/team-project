package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConversionRate {
    ConfigurationMySQL config;

    public ConversionRate() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------CONVERSION RATE QUERIES START-------------------------*/
    public void createConversion(String currencyName, double rate, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO conversionRate " +
                            "(conversionCurrency, conversionRate, conversionDate)" +
                            "VALUES (?, ?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, currencyName);
            stmt.setDouble(2, rate);
            stmt.setInt(3, date);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getConversions() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conversionRate");
            while( rs.next() )
                //conversionID, conversionCurrency, conversionRate, conversionDate
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getConversionById(int id) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM conversionRate WHERE conversionID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //conversionID, conversionCurrency, conversionRate, conversionDate
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateConversionById(int id, String currencyName, double rate, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "UPDATE conversionRate SET conversionCurrency=?, conversionRate=?, " +
                            "conversionDate=? WHERE conversionID = ?");
            stmt.setString(1, currencyName);
            stmt.setDouble(2, rate);
            stmt.setInt(3, date);
            stmt.setInt(4, id);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------CONVERSION RATE QUERIES END-------------------------*/
}
