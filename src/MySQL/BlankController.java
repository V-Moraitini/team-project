package MySQL;

import Backend.persistenceLayer.AgencyBatch;
import Backend.persistenceLayer.Blank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BlankController extends ConfigurationMySQL {

    public BlankController() { }

    /*-------------------------BLANK QUERIES START-------------------------*/
    public void createBlank(Blank blank) {
        getConnection();
        //int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO blank " +
                            "(blankBatchID, blankType, blankDateReceived, " +
                            "blankIsValid, blankIsSold, blankIsInterline)" +
                            "VALUES (?, ?, ?, 1, 0, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, blank.getBlankBatchId());
            stmt.setInt(2, blank.getBlankType());
            stmt.setInt(3, blank.getBlankDateReceived());
            if (blank.getBlankType() == 444 || blank.getBlankType() == 440 || blank.getBlankType() == 420) {
                stmt.setBoolean(4, true);
            } else if (blank.getBlankType() == 201 || blank.getBlankType() == 101)
                stmt.setBoolean(4,false);
            else {
                stmt.setBoolean(4, false);
            }
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

    public void createBlankBatch(int count, Blank blank) {
        //make a batch first
        AgencyBatchController agencyBatchController = new AgencyBatchController();
        AgencyBatch agencyBatch = new AgencyBatch(1, blank.getBlankDateReceived());
        agencyBatchController.createBatch(agencyBatch);
        int batchId = agencyBatch.getBatchId();

        getConnection();

        //is it interline?
        Boolean isInterline;
        if (blank.getBlankType() == 444 || blank.getBlankType() == 440 || blank.getBlankType() == 420) {
            isInterline = true;
        } else if (blank.getBlankType() == 201 || blank.getBlankType() == 101)
            isInterline = false;
        else {
            isInterline = false;
        }
        //createBatch(day, month, year);
        //then probably retrieve the id of the object class?
        String SQL = "INSERT INTO blank " +
                "(blankBatchID, blankType, blankDateReceived, " +
                "blankIsValid, blankIsSold, blankIsInterline, blankIsArchived)" +
                "VALUES (" +batchId+", "+blank.getBlankType()+","+blank.getBlankDateReceived()+", 1, 0,"+isInterline+",0)";
        try {
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            for(int i = 0; i <= count; i++) {
                stmt.addBatch(SQL);
            }
            stmt.executeBatch();

            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void getActiveBlanks() {
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blank WHERE blankIsArchived = 0");
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void getArchivedBlanks() {
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blank WHERE blankIsArchived = 0");
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void getActiveBlanksByAdvisor(int advisorId) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM blank WHERE blankIsArchived=0 AND blankStockAdvisorID = ?");
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void getAvailableBlanksByAdvisor(int advisorId) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM blank WHERE blankIsArchived=0 AND blankIsSold=0 AND blankStockAdvisorID = ?");
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void getAllBlanks() {
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blank");
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getBlankById(int id) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM blank WHERE blankID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------BLANK QUERIES END-------------------------*/

    public static void main(String[] args) {
        BlankController b = new BlankController();
        b.createBlankBatch(2, new Blank(0, 0, 0, 440, 20190101, 1, 0, 0));
    }
}
