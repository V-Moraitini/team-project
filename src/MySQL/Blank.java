package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Blank extends ConfigurationMySQL {

    public Blank() { }

    /*-------------------------BLANK QUERIES START-------------------------*/
    public void createBlank(Backend.persistenceLayer.Blank blank, int batchId, int type, int day, int month, int year) {
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
            if (type == 444 || type == 440 || type == 420) {
                stmt.setBoolean(4, true);
            } else if (type == 201 || type == 101)
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

    public void createBlankBatch(int count, int batchId, int type, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        Boolean isInterline;
        if (type == 444 || type == 440 || type == 420) {
            isInterline = true;
        } else if (type == 201 || type == 101)
            isInterline = false;
        else {
            isInterline = false;
        }
        //createBatch(day, month, year);
        //then probably retrieve the id of the object class?
        String SQL = "INSERT INTO blank " +
                "(blankBatchID, blankType, blankDateReceived, " +
                "blankIsValid, blankIsSold, blankIsInterline)" +
                "VALUES (" +batchId+", "+type+","+date+", 1, 0,"+isInterline+")";
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
}
