package MySQL;

import Backend.persistenceLayer.ReportInterlineIndividual;
import Backend.persistenceLayer.Sales;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportInterController extends ConfigurationMySQL {

    //create a report of interline reports
    //needs advisorId, date start, date end

    public ArrayList<ReportInterlineIndividual> getAirViaDocsSection(int dateStart, int dateEnd, int advisorId) {
        ArrayList<ReportInterlineIndividual> reportedSales = new ArrayList<>();
        String sql = "SELECT saleBlankId AS `ORIGINAL ISSUED NUMBER`, saleFlatPrice + saleCommissionAmount AS `USD`, conversionRate AS `USDBGL`, saleConversionAmount AS `BGL`, saleTaxAmount AS `LOCAL TAXES`, saleOtherTaxAmount AS `OTHER TAXES`, saleFlatPrice + saleConversionAmount + saleTaxAmount + saleOtherTaxAmount AS `Total Document's Amount` " +
                "FROM sale" +
                "LEFT JOIN conversionRate ON saleConversionId = conversionId" +
                "WHERE saleDate >= ? AND saleDate <= ?" +
                "AND saleAdvisorUserId = ?" +
                "AND saleIsInterline = 1" +
                "ORDER BY saleDate ASC";
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dateStart);
            stmt.setInt(2, dateEnd);
            stmt.setInt(3, advisorId);
            ResultSet rs = stmt.executeQuery();

            int blankId;
            double usd, conversionAmount, localCurrency, localTax, otherTax, totalAmount;
            while (rs.next()) {

                blankId = rs.getInt(1);
                usd = rs.getDouble(2);
                conversionAmount = rs.getDouble(3);
                localCurrency = rs.getDouble(4);
                localTax = rs.getDouble(5);
                otherTax = rs.getDouble(6);
                totalAmount = rs.getDouble(7);
                reportedSales.add(new ReportInterlineIndividual(advisorId, blankId, usd, conversionAmount, localCurrency, localTax, otherTax, totalAmount));
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reportedSales;
    }

    public ArrayList<Double> getCashSection(int dateStart, int dateEnd, int advisorId) {
        ArrayList<Double> salesCash = new ArrayList<Double>();
        String sql = "SELECT saleFlatPrice + saleTaxAmount + saleCommissionAmount AS CASH" +
                "FROM sale" +
                "WHERE saleMethod = 'Cash'" +
                "AND saleDate >= ? AND saleDate <= ?" +
                "AND saleAdvisorUserId = ?" +
                "AND saleIsInterline = 1" +
                "ORDER BY saleDate ASC";
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dateStart);
            stmt.setInt(2, dateEnd);
            stmt.setInt(3, advisorId);
            ResultSet rs = stmt.executeQuery();

            double cash;
            while (rs.next()) {
                cash = rs.getDouble(1);
                salesCash.add(cash);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return salesCash;
    }

    public ArrayList<Double> getCardSection(int dateStart, int dateEnd, int advisorId) {
        ArrayList<Double> salesCard = new ArrayList<Double>();
        String sql = "SELECT saleFlatPrice + saleTaxAmount + saleCommissionAmount AS CASH" +
                "FROM sale" +
                "WHERE saleMethod = 'Cash'" +
                "AND saleDate >= ? AND saleDate <= ?" +
                "AND saleAdvisorUserId = ?" +
                "AND saleIsInterline = 1" +
                "ORDER BY saleDate ASC";
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dateStart);
            stmt.setInt(2, dateEnd);
            stmt.setInt(3, advisorId);
            ResultSet rs = stmt.executeQuery();

            double cash;
            while (rs.next()) {
                cash = rs.getDouble(1);
                salesCard.add(cash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return salesCard;
    }

    public double getTotalAmountsPaidSection(int dateStart, int dateEnd, int advisorId) {
        double total = 0;
        String sql = "SELECT SUM(saleFlatPrice + saleTaxAmount + saleOtherTaxAmount + saleCommissionAmount) AS `TOTAL AMOUNTS PAID`" +
                "FROM sale" +
                "WHERE saleDate >= ? AND saleDate <= ?" +
                "AND saleAdvisorUserId = ?" +
                "AND saleIsInterline = 1" +
                "ORDER BY saleDate ASC";
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dateStart);
            stmt.setInt(2, dateEnd);
            stmt.setInt(3, advisorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return total;
    }

    public ArrayList<Double> getCommissionColumn(int dateStart, int dateEnd, int advisorId, double commissionRate) {
        ArrayList<Double> commissions = new ArrayList<>();
        String sql = "SELECT saleCommissionAmount" +
                "FROM sale " +
                "INNER JOIN commissionRate ON saleCommissionId = commissionId" +
                "WHERE commissionPercentage = ?" +
                "AND saleDate >= ? AND saleDate <= ?" +
                "AND saleAdvisorUserId = ?" +
                "AND saleIsInterline = 1" +
                "ORDER BY saleDate ASC";
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, commissionRate);
            stmt.setInt(2, dateStart);
            stmt.setInt(3, dateEnd);
            stmt.setInt(4, advisorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                commissions.add(rs.getDouble(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return commissions;
    }

    public double getTotalNetAmount(int dateStart, int dateEnd, int advisorId) {
        double sum = 0;
        String sql = "SELECT SUM(saleFlatPrice + saleTaxAmount + saleOtherTaxAmount)" +
                "FROM sale" +
                "WHERE saleDate >= ? AND saleDate <= ?" +
                "AND saleAdvisorUserId = ?" +
                "AND saleIsInterline = 1" +
                "ORDER BY saleDate ASC";
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dateStart);
            stmt.setInt(2, dateEnd);
            stmt.setInt(3, advisorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                sum = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return sum;
    }
}