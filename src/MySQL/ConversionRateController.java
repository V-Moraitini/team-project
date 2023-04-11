package MySQL;

import Backend.persistenceLayer.ConversionRate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConversionRateController extends ConfigurationMySQL {

    public ConversionRateController() { }

    /*-------------------------CONVERSION RATE QUERIES START-------------------------*/
    public void createConversion(ConversionRate conversionRate) {
        getConnection();
        //int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO conversionRate " +
                            "(conversionCurrency, conversionRate, conversionDate)" +
                            "VALUES (?, ?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, conversionRate.getConversionCurrency());
            stmt.setDouble(2, conversionRate.getConversionRate());
            stmt.setInt(3, conversionRate.getConversionDate());

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

    public ArrayList<ConversionRate> getConversions() {
        getConnection();
        ArrayList<ConversionRate> conversions = new ArrayList<ConversionRate>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conversionRate");
            int id;
            String currencyName;
            double rate;
            int date;
            while( rs.next() ) {
                //conversionID, conversionCurrency, conversionRate, conversionDate
                id = rs.getInt(1);
                currencyName = rs.getString(2);
                rate = rs.getDouble(3);
                date = rs.getInt(4);

                conversions.add(new ConversionRate(id, currencyName,rate,date)); //id???
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return conversions;
    }

    public ConversionRate getConversionById(int id) {
        ConversionRate conversion = new ConversionRate("", 0, 0);
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM conversionRate WHERE conversionId = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            String currencyName;
            double rate;
            int date;
            while( rs.next() ) {
                //conversionID, conversionCurrency, conversionRate, conversionDate
                currencyName = rs.getString(2);
                rate = rs.getDouble(3);
                date = rs.getInt(4);

                conversion = new ConversionRate(id, currencyName, rate, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return conversion;
    }

    public void updateConversionById(ConversionRate conversionRate, int id) {
        getConnection();
        //int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE conversionRate SET conversionCurrency=?, conversionRate=?, " +
                            "conversionDate=? WHERE conversionId = ?");
            stmt.setString(1, conversionRate.getConversionCurrency());
            stmt.setDouble(2, conversionRate.getConversionRate());
            stmt.setInt(3, conversionRate.getConversionDate());
            stmt.setInt(4, id);

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
    /*-------------------------CONVERSION RATE QUERIES END-------------------------*/
}
