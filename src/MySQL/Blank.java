package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Blank {
    ConfigurationMySQL config;

    public Blank() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------BLANK QUERIES START-------------------------*/
    public void createBlank(int batchId, int type, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO blank " +
                            "(blankBatchID, blankType, blankDateReceived, " +
                            "blankIsValid, blankIsSold, blankIsInterline)" +
                            "VALUES (?, ?, ?, 1, 0, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, batchId);
            stmt.setInt(2, type);
            stmt.setInt(3, date);
            if (type == 444 || type == 440 || type == 420) {
                stmt.setBoolean(4, true);
            } else if (type == 201 || type == 101)
                stmt.setBoolean(4,false);
            else {
                stmt.setBoolean(4, false);
            }
            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
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
            config.getCon().setAutoCommit(false);
            Statement stmt = config.getCon().createStatement();
            for(int i = 0; i <= count; i++) {
                stmt.addBatch(SQL);
            }
            stmt.executeBatch();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getActiveBlanks() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blank WHERE blankIsArchived = 0");
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getArchivedBlanks() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blank WHERE blankIsArchived = 0");
            while( rs.next() )
                //blankID, blankBatchID, blankStockID, blankStockAdvisorID, blankType, blankDateReceived, blankIsValid, blankIsSold, blankIsInterline, blankIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+
                        "  "+rs.getInt(5)+"  "+rs.getInt(6)+
                        "  "+rs.getBoolean(7)+"  "+rs.getBoolean(8)+"  "+rs.getBoolean(9)+"  "+rs.getBoolean(10)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getActiveBlanksByAdvisor(int advisorId) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM blank WHERE blankIsArchived=0 AND blankStockAdvisorID = ?");
            stmt.setInt(1, advisorId);
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

    public void getAvailableBlanksByAdvisor(int advisorId) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM blank WHERE blankIsArchived=0 AND blankIsSold=0 AND blankStockAdvisorID = ?");
            stmt.setInt(1, advisorId);
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

    public void getAllBlanks() {
        try {
            Statement stmt = config.getCon().createStatement();
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
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM blank WHERE blankID = ?");
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
