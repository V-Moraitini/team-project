package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConversionRate {
    ConfigurationMySQL config;

    public ConversionRate() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------CONVERSION RATE QUERIES START-------------------------*/
    public void createConversion(persistenceLayer.ConversionRate conversionRate, String currencyName, double rate, int day, int month, int year) {
        //int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO conversionRate " +
                            "(conversionCurrency, conversionRate, conversionDate)" +
                            "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, conversionRate.getConversionCurrency());
            stmt.setDouble(2, conversionRate.getConversionRate());
            stmt.setInt(3, conversionRate.getConversionDate());

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<persistenceLayer.ConversionRate> getConversions() throws SQLException {
        ArrayList<persistenceLayer.ConversionRate> rates = new ArrayList<persistenceLayer.ConversionRate>();
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conversionRate");
            int id = 0;
            String currencyName = "";
            //double rate = 0;
            int rate = 0;
            int date = 0;
            while( rs.next() ) {
                id = rs.getInt(1);
                currencyName = rs.getString(2);
                //rate = rs.getDouble(3);
                rate = rs.getInt(3);
                date = rs.getInt(4);

                rates.add(new persistenceLayer.ConversionRate(currencyName,rate,date)); //id???
                //conversionID, conversionCurrency, conversionRate, conversionDate
                /*System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"\n");*/
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            config.getCon().close();
            return rates;
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
