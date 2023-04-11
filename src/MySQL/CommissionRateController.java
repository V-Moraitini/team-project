package MySQL;

import Backend.persistenceLayer.CommissionRate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommissionRateController extends ConfigurationMySQL {

    public CommissionRateController() { }

    /*-------------------------COMMISSION RATE QUERIES START-------------------------*/
    public void createCommission(CommissionRate commissionRate) {
        getConnection();
        //int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO commissionRate " +
                            "(commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived)" +
                            "VALUES (?, ?, ?, ?, 0)", Statement.RETURN_GENERATED_KEYS);
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, 1); //"Terrific Travel" Travel Agency
            stmt.setDouble(2, commissionRate.getCommissionPercentage());
            stmt.setInt(3, commissionRate.getCommissionTicketType());
            stmt.setInt(4, commissionRate.getCommissionDate());

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

    public ArrayList<CommissionRate> getActiveCommissions() {
        getConnection();
        ArrayList<CommissionRate> rates = new ArrayList<CommissionRate>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commissionRate WHERE commissionIsArchived = 0");
            int id = 0;
            int agencyCode = 0;
            double percentage = 0;
            int type = 0;
            int date = 0;
            boolean isArchived = false;
            while( rs.next() ) {
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                id = rs.getInt(1);
                agencyCode = rs.getInt(2);
                percentage = rs.getDouble(3);
                type = rs.getInt(4);
                date = rs.getInt(5);
                isArchived = rs.getBoolean(6);
                rates.add(new CommissionRate(id, agencyCode, percentage, type, date, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rates;
    }

    public ArrayList<CommissionRate> getArchivedCommissions() {
        getConnection();
        ArrayList<CommissionRate> rates = new ArrayList<CommissionRate>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commissionRate WHERE commissionIsArchived = 1");
            int id = 0;
            int agencyCode = 0;
            double percentage = 0;
            int type = 0;
            int date = 0;
            boolean isArchived = false;
            while( rs.next() ) {
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                id = rs.getInt(1);
                agencyCode = rs.getInt(2);
                percentage = rs.getDouble(3);
                type = rs.getInt(4);
                date = rs.getInt(5);
                isArchived = rs.getBoolean(6);
                rates.add(new CommissionRate(id, agencyCode, percentage, type, date, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rates;
    }

    public ArrayList<CommissionRate> getAllCommissions() {
        getConnection();
        ArrayList<CommissionRate> rates = new ArrayList<CommissionRate>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commissionRate");
            int id = 0;
            int agencyCode = 0;
            double percentage = 0;
            int type = 0;
            int date = 0;
            boolean isArchived = false;
            while( rs.next() ) {
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                id = rs.getInt(1);
                agencyCode = rs.getInt(2);
                percentage = rs.getDouble(3);
                type = rs.getInt(4);
                date = rs.getInt(5);
                isArchived = rs.getBoolean(6);
                rates.add(new CommissionRate(id, agencyCode, percentage, type, date, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rates;
    }

    public CommissionRate getCommissionById(int commissionId) {
        getConnection();
        CommissionRate rate = new CommissionRate(0,0,0,0,false);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM commissionRate WHERE commissionId = ?");
            stmt.setInt(1, commissionId);
            ResultSet rs = stmt.executeQuery();

            int agencyCode = 0;
            double percentage = 0;
            int type = 0;
            int date = 0;
            boolean isArchived = false;
            while( rs.next() ) {
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                agencyCode = rs.getInt(2);
                percentage = rs.getDouble(3);
                type = rs.getInt(4);
                date = rs.getInt(5);
                isArchived = rs.getBoolean(6);
                rate = new CommissionRate(commissionId, agencyCode, percentage, type, date, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rate;
    }

    public CommissionRate getActiveCommissionsByTicketType(int type) {
        getConnection();
        CommissionRate rate = new CommissionRate(0,0,type,0,false);
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM commissionRate WHERE commissionTicketType = ? " +
                    "AND commissionIsArchived = 0");
            stmt.setInt(1, type);
            ResultSet rs = stmt.executeQuery();

            int id = 0;
            int agencyCode = 0;
            double percentage = 0;
            int date = 0;
            boolean isArchived = false;
            while( rs.next() ) {
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                agencyCode = rs.getInt(2);
                percentage = rs.getDouble(3);
                //type = rs.getInt(4);
                date = rs.getInt(5);
                isArchived = rs.getBoolean(6);
                rate = new CommissionRate(id, agencyCode, percentage, type, date, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rate;
    }

    public void updateCommissionById(CommissionRate commissionRate) {
        getConnection();
        //int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE commissionRate SET commissionPercentage=?, commissionTicketType=?, " +
                            "commissionDate=? WHERE commissionId = ?");
            stmt.setDouble(1, commissionRate.getCommissionPercentage());
            stmt.setInt(2, commissionRate.getCommissionTicketType());
            stmt.setInt(3, commissionRate.getCommissionDate());
            stmt.setInt(4, commissionRate.getCommissionId());

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

    public void archiveCommission(int id) {
        Boolean isArchived = getCommissionById(id).getCommissionIsArchived();
        String sql;
        String message;
        getConnection();
        try {
            if (!isArchived) {
                sql = "UPDATE commissionRate SET commissionIsArchived = 1 WHERE commissionId = ?";
                message = "Commission is now archived.";
            } else {
                sql = "UPDATE commissionRate SET commissionIsArchived = 0 WHERE commissionId = ?";
                message = "Commission is no longer archived.";
            }
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
            System.out.println(message);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    /*-------------------------COMMISSION RATE QUERIES END-------------------------*/

    public static void main(String[] args) {
        CommissionRateController cr = new CommissionRateController();
        //cr.archiveCommission(1);
    }
}
