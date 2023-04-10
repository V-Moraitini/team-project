package Backend.serviceLayer;

import Backend.persistenceLayer.AdvisorStock;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdvisorStockSL {

    public void insertAdvisorStock(AdvisorStock advisorStock) throws SQLException {
        String sql = "INSERT INTO AdvisorStock (stockAdvisorUserId) VALUES (?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");

             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, advisorStock.getStockAdvisorUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error while inserting AdvisorStock: " + e.getMessage());
        }
    }

    public void updateAdvisorStock(AdvisorStock advisorStock) throws SQLException {
        String sql = "UPDATE AdvisorStock SET stockAdvisorUserId = ? WHERE stockId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, advisorStock.getStockAdvisorUserId());
            pstmt.setInt(2, advisorStock.getStockId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error while updating AdvisorStock: " + e.getMessage());
        }
    }


    public void deleteAdvisorStock(int stockId) throws SQLException {
        String sql = "DELETE FROM AdvisorStock WHERE stockId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07","in2018g07_d","6KV8dzpF");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stockId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error while deleting AdvisorStock: " + e.getMessage());
        }
    }




}
