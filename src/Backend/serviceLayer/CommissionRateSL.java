package Backend.serviceLayer;

import Backend.persistenceLayer.CommissionRate;

import java.sql.*;

public class CommissionRateSL {

    private Connection conn;

    // constructor to establish database connection
    public CommissionRateSL(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    // method to add a new commission rate
    public void addCommissionRate(CommissionRate commissionRate) throws SQLException {
        String sql = "INSERT INTO CommissionRate (commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, commissionRate.getCommissionAgencyTravelCode());
        statement.setInt(2, commissionRate.getCommissionPercentage());
        statement.setInt(3, commissionRate.getCommissionTicketType());
        statement.setInt(4, commissionRate.getCommissionDate());
        statement.executeUpdate();
    }

    // method to update an existing commission rate
    public void updateCommissionRate(CommissionRate commissionRate) throws SQLException {
        String sql = "UPDATE CommissionRate SET commissionAgencyTravelCode = ?, commissionPercentage = ?, "
                + "commissionTicketType = ?, commissionDate = ? WHERE commissionId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, commissionRate.getCommissionAgencyTravelCode());
        statement.setInt(2, commissionRate.getCommissionPercentage());
        statement.setInt(3, commissionRate.getCommissionTicketType());
        statement.setInt(4, commissionRate.getCommissionDate());
        statement.setInt(5, commissionRate.getCommissionId());
        statement.executeUpdate();
    }

    // method to delete an existing commission rate
    public void deleteCommissionRate(int commissionId) throws SQLException {
        String sql = "DELETE FROM CommissionRate WHERE commissionId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, commissionId);
        statement.executeUpdate();
    }
}

