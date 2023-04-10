package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdvisorStock {
    ConfigurationMySQL config;

    public AdvisorStock() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------ADVISOR STOCK QUERIES START-------------------------*/
    public void createStock(persistenceLayer.AdvisorStock advisorStock) throws SQLException {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO advisorStock " +
                            "(stockAdvisorUserID)" +
                            "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, advisorStock.getStockAdvisorUserId()); //when do we set the id in the object?

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            config.getCon().close();
        }
    }

    public void getStocks() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advisorStock");
            ArrayList<persistenceLayer.AdvisorStock> stocks = new ArrayList<persistenceLayer.AdvisorStock>();
            int stockId = 0;
            int stockAdvisorUserId = 0;
            while( rs.next() )
                stockId = rs.getInt(1);
                stockAdvisorUserId = rs.getInt(2);
                stocks.add(new persistenceLayer.AdvisorStock(stockAdvisorUserId)); //id where aaa
                //stockID, stockAdvisorUserID
                //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getStockById(int stockId) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM advisorStock WHERE stockID = ?");
            stmt.setInt(1, stockId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<persistenceLayer.AdvisorStock> stocks = new ArrayList<persistenceLayer.AdvisorStock>();
            int stockAdvisorUserId = 0;
            while( rs.next() )
                //stockID, stockAdvisorUserID
                stockAdvisorUserId = rs.getInt(2);
                stocks.add(new persistenceLayer.AdvisorStock(stockAdvisorUserId)); //id where aaa
                //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getStockByAdvisorId(int advisorId) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM advisorStock WHERE stockAdvisorUserID = ?");
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<persistenceLayer.AdvisorStock> stocks = new ArrayList<persistenceLayer.AdvisorStock>();
            int stockId = 0;
            while( rs.next() )
                //stockID, stockAdvisorUserID
                stockId = rs.getInt(1);
                stocks.add(new persistenceLayer.AdvisorStock(advisorId)); //id where aaa
                //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------ADVISOR STOCK QUERIES END-------------------------*/
}
