package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgencyBatch {
    ConfigurationMySQL config;

    public AgencyBatch() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------AGENCY BATCH QUERIES START-------------------------*/
    public void createBatch(int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO agencyBatch (batchAgencyTravelCode, batchDate)" +
                            "VALUES (?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, 1); //"Terrific Travel" Travel Agent
            stmt.setInt(2, date);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getBatches() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agencyBatch");
            while( rs.next() )
                //batchID, batchAgencyTravelCode, batchDate
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getBatchById(int id) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM agencyBatch WHERE batchID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //batchID, batchAgencyTravelCode, batchDate
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBatchById(int id, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "UPDATE agencyBatch SET batchDate=? WHERE batchID = ?");
            stmt.setInt(1, date);
            stmt.setInt(2, id);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------AGENCY BATCH QUERIES END-------------------------*/
}
