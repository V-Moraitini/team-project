package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AgencyBatch extends ConfigurationMySQL {

    public AgencyBatch() { }

    /*-------------------------AGENCY BATCH QUERIES START-------------------------*/
    public void createBatch(Backend.persistenceLayer.AgencyBatch agencyBatch) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO agencyBatch (batchAgencyTravelCode, batchDate)" +
                            "VALUES (?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, agencyBatch.getBatchAgencyTravelCode()); //"Terrific Travel" Travel Agent id:1
            stmt.setInt(2, agencyBatch.getBatchDate());

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

    public ArrayList<Backend.persistenceLayer.AgencyBatch> getBatches() {
        ArrayList<Backend.persistenceLayer.AgencyBatch> batches = new ArrayList<>();
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agencyBatch");

            int id;
            int agencyTravelCode = 1;
            int date;
            while( rs.next() ) {
                //batchID, batchAgencyTravelCode, batchDate
                id = rs.getInt(1);
                agencyTravelCode = rs.getInt(2);
                date = rs.getInt(3);
                batches.add(new Backend.persistenceLayer.AgencyBatch(id, agencyTravelCode, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return batches;
    }

    public Backend.persistenceLayer.AgencyBatch getBatchById(int batchId) {
        Backend.persistenceLayer.AgencyBatch batch = new Backend.persistenceLayer.AgencyBatch(0,0);
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM agencyBatch WHERE batchId = ?");
            stmt.setInt(1, batchId);
            ResultSet rs = stmt.executeQuery();

            int travelCode;
            int date;
            while( rs.next() ) {
                //batchID, batchAgencyTravelCode, batchDate
                travelCode = rs.getInt(2);
                date = rs.getInt(3);
                batch =  new Backend.persistenceLayer.AgencyBatch(batchId, travelCode, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return batch;
    }

    public void updateBatchById(Backend.persistenceLayer.AgencyBatch batch) {
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE agencyBatch SET batchDate=? WHERE batchId = ?");
            stmt.setInt(1, batch.getBatchDate());
            stmt.setInt(2, batch.getBatchId());

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

    /*-------------------------AGENCY BATCH QUERIES END-------------------------*/
}
