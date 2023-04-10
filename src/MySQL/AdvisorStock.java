package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdvisorStock extends ConfigurationMySQL {
    //ConfigurationMySQL config;

    public AdvisorStock() {
        //this.config = new ConfigurationMySQL();
    }

    /*-------------------------ADVISOR STOCK QUERIES START-------------------------*/
    public void createStock(persistenceLayer.AdvisorStock advisorStock) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO advisorStock " +
                            "(stockAdvisorUserId)" +
                            "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, advisorStock.getStockAdvisorUserId()); //when do we set the id in the object?

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

    public ArrayList<persistenceLayer.AdvisorStock> getStocks() {
        ArrayList<persistenceLayer.AdvisorStock> stocks = new ArrayList<persistenceLayer.AdvisorStock>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advisorStock");

            int stockId = 0;
            int stockAdvisorUserId = 0;
            while( rs.next() )
                stockId = rs.getInt(1);
                stockAdvisorUserId = rs.getInt(2);
                stocks.add(new persistenceLayer.AdvisorStock(stockId, stockAdvisorUserId)); //id where aaa
                //stockID, stockAdvisorUserID
                //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return stocks;
    }

    public persistenceLayer.AdvisorStock getStockById(int stockId) {
        persistenceLayer.AdvisorStock stock = new persistenceLayer.AdvisorStock(0);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockId = ?");
            stmt.setInt(1, stockId);
            ResultSet rs = stmt.executeQuery();
            int stockAdvisorUserId = 0;
            while( rs.next() ) {
                //stockID, stockAdvisorUserID
                stockAdvisorUserId = rs.getInt(2);
                stock.setStockAdvisorUserId(stockAdvisorUserId);
                //stock = new persistenceLayer.AdvisorStock(stockAdvisorUserId); //id where aaa
                //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return stock;
    }

    public persistenceLayer.AdvisorStock getStockByAdvisorId(int advisorId) {
        persistenceLayer.AdvisorStock stock = new persistenceLayer.AdvisorStock(0);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockAdvisorUserId = ?");
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<persistenceLayer.AdvisorStock> stocks = new ArrayList<persistenceLayer.AdvisorStock>();
            int stockId = 0;
            while( rs.next() ) {
                //stockID, stockAdvisorUserID
                stockId = rs.getInt(1);
                stocks.add(new persistenceLayer.AdvisorStock(advisorId)); //id where aaa
                //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
        return stock;
    }

    /*-------------------------ADVISOR STOCK QUERIES END-------------------------*/

    public static void main(String[] args) {
        AdvisorStock a = new AdvisorStock();
        try {
            a.getStocks();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            a.closeConnection();
        }
    }
}
