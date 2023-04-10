package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommissionRate extends ConfigurationMySQL {
    ConfigurationMySQL config;

    public CommissionRate() { }

    /*-------------------------COMMISSION RATE QUERIES START-------------------------*/
    public void createCommission(Backend.persistenceLayer.CommissionRate commissionRate) {
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

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Backend.persistenceLayer.CommissionRate> getActiveCommissions() {
        getConnection();
        ArrayList<Backend.persistenceLayer.CommissionRate> rates = new ArrayList<Backend.persistenceLayer.CommissionRate>();
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
                rates.add(new Backend.persistenceLayer.CommissionRate(id, agencyCode, percentage, type, date, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rates;
    }

    public ArrayList<Backend.persistenceLayer.CommissionRate> getArchivedCommissions() {
        getConnection();
        ArrayList<Backend.persistenceLayer.CommissionRate> rates = new ArrayList<Backend.persistenceLayer.CommissionRate>();
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
                rates.add(new Backend.persistenceLayer.CommissionRate(id, agencyCode, percentage, type, date, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rates;
    }

    public ArrayList<Backend.persistenceLayer.CommissionRate> getAllCommissions() {
        getConnection();
        ArrayList<Backend.persistenceLayer.CommissionRate> rates = new ArrayList<Backend.persistenceLayer.CommissionRate>();
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
                rates.add(new Backend.persistenceLayer.CommissionRate(id, agencyCode, percentage, type, date, isArchived));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rates;
    }

    public Backend.persistenceLayer.CommissionRate getCommissionById(int commissionId) {
        getConnection();
        Backend.persistenceLayer.CommissionRate rate = new Backend.persistenceLayer.CommissionRate(0,0,0,0,false);
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM commissionRate WHERE commissionId = ?");
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
                rate = new Backend.persistenceLayer.CommissionRate(commissionId, agencyCode, percentage, type, date, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rate;
    }

    public Backend.persistenceLayer.CommissionRate getActiveCommissionsByTicketType(int type) {
        getConnection();
        Backend.persistenceLayer.CommissionRate rate = new Backend.persistenceLayer.CommissionRate(0,0,type,0,false);
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
                rate = new Backend.persistenceLayer.CommissionRate(id, agencyCode, percentage, type, date, isArchived);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rate;
    }

    public void updateCommissionById(Backend.persistenceLayer.CommissionRate commissionRate) {
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
        getConnection();
        try {
            PreparedStatement isArchived = con.prepareStatement(
                    "SELECT commissionIsArchived FROM commissionRate WHERE commissionId = ?");
            isArchived.setInt(1, id);
            ResultSet rsArchived = isArchived.executeQuery();
            while (rsArchived.next()) {
                if (rsArchived.getInt(1) == 0) {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE commissionRate SET commissionIsArchived = 1 WHERE commissionId = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("Commission is now archived.");
                } else {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE commissionRate SET commissionIsArchived = 0 WHERE commissionId = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("Commission is no longer archived.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    /*-------------------------COMMISSION RATE QUERIES END-------------------------*/
}
