package MySQL;

import Backend.persistenceLayer.AgencyBatch;
import Backend.persistenceLayer.Blank;
import Backend.persistenceLayer.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            for(int i = 0; i < count; i++) {
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

    private ArrayList<Blank> getSomeBlanks(String sql) {
        ArrayList<Blank> blanks = new ArrayList<>();

        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int id, batchId, stockId, advisorId, type, date, isValid, isSold, isInterline, isArchived;
            while( rs.next() ) {
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                id = rs.getInt(1);
                batchId = rs.getInt(2);
                stockId = rs.getInt(3);
                advisorId = rs.getInt(4);
                type = rs.getInt(5);
                date = rs.getInt(6);
                isValid = rs.getInt(7);
                isSold = rs.getInt(8);
                isInterline = rs.getInt(9);
                isArchived = rs.getInt(10);
                blanks.add(new Blank(id, batchId, stockId, advisorId, type, date, isValid, isSold, isInterline, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return blanks;
    }

    public ArrayList<Blank> getActiveBlanks() {
        return getSomeBlanks("SELECT * FROM blank WHERE blankIsArchived = 0");
    }

    public ArrayList<Blank> getArchivedBlanks() {
        return getSomeBlanks("SELECT * FROM blank WHERE blankIsArchived = 1");
    }

    private ArrayList<Blank> getSomeBlanksByAdvisor(String sql, int advisorId) {
        ArrayList<Blank> blanks = new ArrayList<>();
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();

            int id, batchId, stockId, type, date, isValid, isSold, isInterline, isArchived;
            while( rs.next() ) {
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                id = rs.getInt(1);
                batchId = rs.getInt(2);
                stockId = rs.getInt(3);
                type = rs.getInt(5);
                date = rs.getInt(6);
                isValid = rs.getInt(7);
                isSold = rs.getInt(8);
                isInterline = rs.getInt(9);
                isArchived = rs.getInt(10);
                blanks.add(new Blank(id, batchId, stockId, advisorId, type, date, isValid, isSold, isInterline, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return blanks;
    }

    public ArrayList<Blank> getActiveBlanksByAdvisor(int advisorId) {
        return getSomeBlanksByAdvisor("SELECT * FROM blank WHERE blankIsArchived = 0 AND blankStockAdvisorID = ?", advisorId);
    }

    public ArrayList<Blank> getAvailableBlanksByAdvisor(int advisorId) {
        return getSomeBlanksByAdvisor("SELECT * FROM blank WHERE blankIsArchived = 0 AND blankIsSold = 0 AND blankStockAdvisorID = ?", advisorId);
    }

    public ArrayList<Blank> getAllBlanks() {
        return getSomeBlanks("SELECT * FROM blank");
    }

    public Blank getBlankById(int id) {
        Blank blank = new Blank(0,0,0,0,0,0,0,0,0,0);
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM blank WHERE blankID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            int batchId, stockId, advisorId, type, date, isValid, isSold, isInterline, isArchived;
            while( rs.next() ) {
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                batchId = rs.getInt(2);
                stockId = rs.getInt(3);
                advisorId = rs.getInt(4);
                type = rs.getInt(5);
                date = rs.getInt(6);
                isValid = rs.getInt(7);
                isSold = rs.getInt(8);
                isInterline = rs.getInt(9);
                isArchived = rs.getInt(10);
                blank = new Blank(id, batchId, stockId, advisorId, type, date, isValid, isSold, isInterline, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return blank;
    }

    private void updateColumnInBlankById(String sql, Blank blank, String column) {
        //blankBatchID, blankType, blankDateReceived, " +
        //                "blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            switch (column) {
                case "blankIsSold":
                    stmt.setInt(1, blank.getBlankIsSold());
                    stmt.setInt(2, blank.getBlankId());
                case "blankIsValid":
                    stmt.setInt(1, blank.getBlankIsValid());
                    stmt.setInt(2, blank.getBlankId());
                case "blankStockId":
                    stmt.setInt(1, blank.getBlankStockId());
                    stmt.setInt(2, blank.getBlankStockAdvisorUserId());
                    stmt.setInt(3, blank.getBlankId());
                default:
                    stmt.setInt(1, blank.getBlankId());
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

    public void updateBlankSoldById(Blank blank) {
        updateColumnInBlankById("UPDATE blank SET blankIsSold = ? WHERE blankId = ?", blank, "blankIsSold");
    }

    public void updateBlankValidById(Blank blank) {
        updateColumnInBlankById("UPDATE blank SET blankIsValid = ? WHERE blankId = ?", blank, "blankIsValid");
    }

    public void updateBlankAssignedById(Blank blank) {
        updateColumnInBlankById("UPDATE blank SET blankStockId = ? blankStockAdvisorUserId = ? WHERE blankId = ?", blank, "blankStockId");
    }

    public void archiveBlank(int id) {
        Boolean isArchived = getBlankById(id).getBlankIsArchived() == 1;

        getConnection();
        try {
            String sql = "UPDATE blank SET blankIsArchived = ? WHERE blankId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, !isArchived);
            stmt.setInt(2, id);

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
    /*-------------------------BLANK QUERIES END-------------------------*/

    public static void main(String[] args) {
        //AgencyBatchController a = new AgencyBatchController();
        //a.createBatch(new AgencyBatch(1, 20190103));
        //BlankController b = new BlankController();
        //b.createBlankBatch(2, new Blank(0, 0, 0, 440, 20190101, 1, 0, 0));
    }
}
