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
    public void createStock(Backend.persistenceLayer.AdvisorStock advisorStock) {
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

    public ArrayList<Backend.persistenceLayer.AdvisorStock> getStocks() {
        ArrayList<Backend.persistenceLayer.AdvisorStock> stocks = new ArrayList<Backend.persistenceLayer.AdvisorStock>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advisorStock");

            int stockId = 0;
            int stockAdvisorUserId = 0;
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
        Backend.persistenceLayer.AdvisorStock stock = new Backend.persistenceLayer.AdvisorStock(0);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockId = ?");
            stmt.setInt(1, stockId);
            ResultSet rs = stmt.executeQuery();
            int stockAdvisorUserId = 0;
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
        Backend.persistenceLayer.AdvisorStock stock = new Backend.persistenceLayer.AdvisorStock(0);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockAdvisorUserId = ?");
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Backend.persistenceLayer.AdvisorStock> stocks = new ArrayList<Backend.persistenceLayer.AdvisorStock>();
            int stockId = 0;
            while( rs.next() ) {
                //stockID, stockAdvisorUserID
                stockId = rs.getInt(1);
                stocks.add(new Backend.persistenceLayer.AdvisorStock(advisorId)); //id where aaa
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
            //ArrayList<Backend.persistenceLayer.AdvisorStock> stocks = a.getStocks();
            //System.out.println(stocks);
            Backend.persistenceLayer.AdvisorStock one = a.getStockById(4);
            System.out.println(one);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            a.closeConnection();
        }
    }
}
