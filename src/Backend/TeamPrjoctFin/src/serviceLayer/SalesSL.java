package serviceLayer;

import persistenceLayer.Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesSL {
    private Connection connection;

    public SalesSL(Connection connection) {
        this.connection = connection;
    }

    public void addSale(Sales sale) throws SQLException {
        String sql = "INSERT INTO Sales (saleId, saleBlankId, AdvisorUserId, saleCustomerId, salecommissionId, salecommissionAmount, saleConversionId) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, sale.getSaleId());
            stmt.setInt(2, sale.getSaleBlankId());
            stmt.setInt(3, sale.getAdvisorUserId());
            stmt.setInt(4, sale.getSaleCustomerId());
            stmt.setInt(5, sale.getSalecommissionId());
            stmt.setInt(6, sale.getSalecommissionAmount());
            stmt.setInt(7, sale.getSaleConversionId());

            stmt.executeUpdate();
        }
    }

    public void updateSale(Sales sale) throws SQLException {
        String sql = "UPDATE Sales SET saleBlankId = ?, AdvisorUserId = ?, saleCustomerId = ?, salecommissionId = ?, salecommissionAmount = ?, saleConversionId = ? WHERE saleId = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, sale.getSaleBlankId());
            stmt.setInt(2, sale.getAdvisorUserId());
            stmt.setInt(3, sale.getSaleCustomerId());
            stmt.setInt(4, sale.getSalecommissionId());
            stmt.setInt(5, sale.getSalecommissionAmount());
            stmt.setInt(6, sale.getSaleConversionId());
            stmt.setInt(7, sale.getSaleId());

            stmt.executeUpdate();
        }
    }

    public void deleteSale(int saleId) throws SQLException {
        String sql = "DELETE FROM Sales WHERE saleId = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, saleId);

            stmt.executeUpdate();
        }
    }
}

