package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdvisorStock extends ConfigurationMySQL {

    public AdvisorStock() { }

    /*-------------------------ADVISOR STOCK QUERIES START-------------------------*/
    public void createStock(Backend.persistenceLayer.AdvisorStock advisorStock) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO advisorStock " +
                            "(stockAdvisorUserId)" +
                            "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, advisorStock.getStockAdvisorUserId());

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

    public ArrayList<Backend.persistenceLayer.AdvisorStock> getStocks() {
        getConnection();
        ArrayList<Backend.persistenceLayer.AdvisorStock> stocks = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advisorStock");

            int stockId;
            int stockAdvisorUserId;
            while( rs.next() ) {
                stockId = rs.getInt(1);
                stockAdvisorUserId = rs.getInt(2);
                //stockID, stockAdvisorUserID
                stocks.add(new Backend.persistenceLayer.AdvisorStock(stockId, stockAdvisorUserId)); //id where aaa

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return stocks;
    }

    public Backend.persistenceLayer.AdvisorStock getStockById(int stockId) {
        getConnection();
        Backend.persistenceLayer.AdvisorStock stock = new Backend.persistenceLayer.AdvisorStock(0);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockId = ?");
            stmt.setInt(1, stockId);
            ResultSet rs = stmt.executeQuery();

            int stockAdvisorUserId;
            while( rs.next() ) {
                //stockID, stockAdvisorUserID
                stockAdvisorUserId = rs.getInt(2);
                stock = new Backend.persistenceLayer.AdvisorStock(stockId, stockAdvisorUserId);
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

    public Backend.persistenceLayer.AdvisorStock getStockByAdvisorId(int advisorId) {
        getConnection();
        Backend.persistenceLayer.AdvisorStock stock = new Backend.persistenceLayer.AdvisorStock(0);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockAdvisorUserId = ?");
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();
            int stockId;
            while( rs.next() ) {
                //stockID, stockAdvisorUserID
                stockId = rs.getInt(1);
                stock = new Backend.persistenceLayer.AdvisorStock(stockId, advisorId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return stock;
    }

    /*-------------------------ADVISOR STOCK QUERIES END-------------------------*/

    public static void main(String[] args) {
        AdvisorStock a = new AdvisorStock();
        try {
            ArrayList<Backend.persistenceLayer.AdvisorStock> stocks = a.getStocks();
            System.out.println(stocks);
            Backend.persistenceLayer.AdvisorStock one = a.getStockById(4);
            System.out.println(one);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.closeConnection();
        }
    }
}
