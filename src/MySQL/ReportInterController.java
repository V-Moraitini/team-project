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
        String sql = "SELECT saleBlankId AS `ORIGINAL ISSUED NUMBER`, saleFlatPrice + saleCommissionAmount AS `USD`, conversionRate AS `USDBGL`, saleConversionAmount AS `BGL`, saleTaxAmount AS `LOCAL TAXES`, saleOtherTaxAmount AS `OTHER TAXES`, saleFlatPrice + saleConversionAmount + saleTaxAmount +saleOtherTaxAmount AS `Total Document's Amount` " +
                "FROM sale" +
                "LEFT JOIN conversionRate ON saleConversionId = conversionId" +
                "WHERE saleDate >= ? AND saleDate <= ?" +
                "AND saleAdvisorUserID = ?" +
                "AND saleIsInterline = 1" +
                "ORDER BY saleDate ASC";
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


}
