package MySQL;

import Backend.persistenceLayer.AgencyBatch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AgencyBatchController extends ConfigurationMySQL {

    public AgencyBatchController() { }

    /*-------------------------AGENCY BATCH QUERIES START-------------------------*/
    public void createBatch(AgencyBatch agencyBatch) {
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

    public ArrayList<AgencyBatch> getBatches() {
        ArrayList<AgencyBatch> batches = new ArrayList<>();
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
                batches.add(new AgencyBatch(id, agencyTravelCode, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return batches;
    }

    public AgencyBatch getBatchById(int batchId) {
        AgencyBatch batch = new AgencyBatch(0,0);
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
                batch =  new AgencyBatch(batchId, travelCode, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return batch;
    }

    public void updateBatchById(AgencyBatch batch) {
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
