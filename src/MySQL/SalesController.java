package MySQL;

import Backend.persistenceLayer.Sales;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesController extends ConfigurationMySQL {
    public void createSale(Sales sale) throws SQLException {
        getConnection();
        String sql = "INSERT INTO sale (" +
                "saleBlankId, AdvisorUserId, saleCustomerId, " +
                "saleCommissionId, saleCommissionAmount, saleConversionId, saleConversionAmount" +
                "saleDiscountAmount, saleTaxAmount, saleFlatPrice, saleMethod, saleCardNumber, " +
                "saleOrigin, saleDestination, saleDate, saleIsInterline)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(2, sale.getSaleBlankId());
            stmt.setInt(3, sale.getSaleAdvisorUserId());
            stmt.setInt(4, sale.getSaleCustomerId());
            stmt.setInt(5, sale.getSaleCommissionId());
            stmt.setDouble(6, sale.getSaleCommissionAmount());
            stmt.setInt(7, sale.getSaleConversionId());
            stmt.setDouble(8, sale.getSaleConversionAmount());
            stmt.setDouble(9, sale.getSaleDiscountAmount());
            stmt.setDouble(10, sale.getSaleTaxAmount());
            stmt.setDouble(11, sale.getSaleFlatPrice());
            stmt.setString(12, sale.getSaleMethod().toString());
            stmt.setInt(13, sale.getSaleCardNumber());
            stmt.setString(14, sale.getSaleOrigin());
            stmt.setString(15, sale.getSaleDestination());
            stmt.setInt(16, sale.getSaleDate());
            stmt.setInt(17, sale.getSaleIsInterline());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void updateSale(Sales sale) {
        String sql = "UPDATE Sales SET " +
                "saleBlankId = ?, saleAdvisorUserId = ?, saleCustomerId = ?, " +
                "saleCommissionId = ?, saleCommissionAmount = ?, saleConversionId = ?, saleConversionAmount = ?, " +
                "saleDiscountAmount = ?, saleTaxAmount = ?, saleFlatPrice = ?, saleMethod = ?, saleCardNumber = ?, " +
                "saleOrigin = ?, saleDestination = ?, saleDate = ?, saleIsInterline = ?" +
                "WHERE saleId = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, sale.getSaleBlankId());
            stmt.setInt(2, sale.getSaleAdvisorUserId());
            stmt.setInt(3, sale.getSaleCustomerId());
            stmt.setInt(4, sale.getSaleCommissionId());
            stmt.setDouble(5, sale.getSaleCommissionAmount());
            stmt.setInt(6, sale.getSaleConversionId());
            stmt.setDouble(7, sale.getSaleConversionAmount());
            stmt.setDouble(8, sale.getSaleDiscountAmount());
            stmt.setDouble(9, sale.getSaleTaxAmount());
            stmt.setDouble(10, sale.getSaleFlatPrice());
            stmt.setString(11, sale.getSaleMethod().toString());
            stmt.setInt(12, sale.getSaleCardNumber());
            stmt.setString(13, sale.getSaleOrigin());
            stmt.setString(14, sale.getSaleDestination());
            stmt.setInt(15, sale.getSaleDate());
            stmt.setInt(16, sale.getSaleIsInterline());
            stmt.setInt(17, sale.getSaleId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
