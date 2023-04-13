package MySQL;

import Backend.persistenceLayer.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalesController extends ConfigurationMySQL {

    public void createSale(Sales sale) {
        getConnection();
        String sql = "INSERT INTO sale (" +
                "saleBlankId, AdvisorUserId, saleCustomerId, " +
                "saleCommissionId, saleCommissionAmount, saleConversionId, saleConversionAmount," +
                "saleDiscountAmount, saleTaxAmount, saleFlatPrice, saleMethod, saleCardNumber, " +
                "saleOrigin, saleDestination, saleDate, saleIsInterline)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //A few validations
        BlankController blankController = new BlankController();
        Blank blank = blankController.getBlankById(sale.getSaleBlankId());
        Boolean isBlankInterline;
        if(blank.getBlankIsInterline() == 0) {
            isBlankInterline = false;
        } else { isBlankInterline = true; }
        //isInterline being different on the blank being sold
        if (!sale.getSaleIsInterline().equals(isBlankInterline)) {
            System.out.println("Blank is interline while sale isn't!");
        }
        //AdvisorId being different
        else if (sale.getSaleAdvisorUserId() == blank.getBlankStockAdvisorUserId()) {
            System.out.println("The travel advisor is different to the one the blank has been assigned!");
        }

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
            stmt.setDouble(11, sale.getSaleOtherTaxAmount());
            stmt.setDouble(12, sale.getSaleFlatPrice());
            stmt.setString(13, sale.getSaleMethod().toString());
            stmt.setInt(14, sale.getSaleCardNumber());
            stmt.setString(15, sale.getSaleOrigin());
            stmt.setString(16, sale.getSaleDestination());
            stmt.setInt(17, sale.getSaleDate());
            stmt.setBoolean(18, sale.getSaleIsInterline());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private ArrayList<Sales> getSomeSales(String sql) {
        ArrayList<Sales> sales = new ArrayList<>();
        getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int id, blankId, advisorId, customerId, commissionId, conversionId;
            double commissionAmount, conversionAmount, discountAmount, taxAmount, otherTaxAmount, flatPrice;
            SaleMethod saleMethod;
            int cardNumber;
            String origin, destination;
            int date;
            Boolean isInterline;
            while (rs.next()) {
                //saleId, saleBlankId, AdvisorUserId, saleCustomerId,
                //saleCommissionId, saleCommissionAmount, saleConversionId, saleConversionAmount,
                //saleDiscountAmount, saleTaxAmount, saleOtherTaxAmount, saleFlatPrice, saleMethod, saleCardNumber,
                //saleOrigin, saleDestination, saleDate, saleIsInterline
                id = rs.getInt(1);
                blankId = rs.getInt(2);
                advisorId = rs.getInt(3);
                customerId = rs.getInt(4);
                commissionId = rs.getInt(5);
                commissionAmount = rs.getDouble(6);
                conversionId = rs.getInt(7);
                conversionAmount = rs.getDouble(8);
                discountAmount = rs.getDouble(9);
                taxAmount = rs.getDouble(10);
                otherTaxAmount = rs.getDouble(11);
                flatPrice = rs.getDouble(12);
                cardNumber = rs.getInt(13);
                origin = rs.getString(14);
                destination = rs.getString(15);
                date = rs.getInt(16);
                saleMethod = SaleMethod.valueOf(rs.getString(17));
                isInterline = rs.getBoolean(18);
                sales.add(new Sales(id, blankId, advisorId, customerId, commissionId, commissionAmount, conversionId, conversionAmount,
                        discountAmount, taxAmount, otherTaxAmount, flatPrice, saleMethod, cardNumber, origin, destination, date, isInterline));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return sales;
    }

    public ArrayList<Sales> getInterlineSales() {
        return getSomeSales("SELECT * FROM sale WHERE saleIsInterline = 1");
    }

    public ArrayList<Sales> getInterlineSalesByDate(int date) {
        return getSomeSales("SELECT * FROM sale WHERE saleIsInterline = 1 AND saleDate = "+date);
    }

    public ArrayList<Sales> getDomesticSales() {
        return getSomeSales("SELECT * FROM sale WHERE saleIsInterline = 0");
    }

    public ArrayList<Sales> getDomesticSalesByDate(int date) {
        return getSomeSales("SELECT * FROM sale WHERE saleIsInterline = 0 AND saleDate = "+date);
    }

    public ArrayList<Sales> getAllSales() {
        return getSomeSales("SELECT * FROM sale");
    }

    public Sales getSaleById(int id) {
        Sales sale = null;
        getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM sale WHERE saleId = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            int blankId, advisorId, customerId, commissionId, conversionId;
            double commissionAmount, conversionAmount, discountAmount, taxAmount, otherTaxAmount, flatPrice;
            SaleMethod saleMethod;
            int cardNumber;
            String origin, destination;
            int date;
            Boolean isInterline;
            while (rs.next()) {
                //saleId, saleBlankId, AdvisorUserId, saleCustomerId,
                //saleCommissionId, saleCommissionAmount, saleConversionId, saleConversionAmount,
                //saleDiscountAmount, saleTaxAmount, saleOtherTaxAmount saleFlatPrice, saleMethod, saleCardNumber,
                //saleOrigin, saleDestination, saleDate, saleIsInterline
                blankId = rs.getInt(2);
                advisorId = rs.getInt(3);
                customerId = rs.getInt(4);
                commissionId = rs.getInt(5);
                commissionAmount = rs.getDouble(6);
                conversionId = rs.getInt(7);
                conversionAmount = rs.getDouble(8);
                discountAmount = rs.getDouble(9);
                taxAmount = rs.getDouble(10);
                otherTaxAmount = rs.getDouble(11);
                flatPrice = rs.getDouble(12);
                cardNumber = rs.getInt(13);
                origin = rs.getString(14);
                destination = rs.getString(15);
                date = rs.getInt(16);
                saleMethod = SaleMethod.valueOf(rs.getString(17));
                isInterline = rs.getBoolean(18);
                sale = new Sales(id, blankId, advisorId, customerId, commissionId, commissionAmount, conversionId, conversionAmount,
                        discountAmount, taxAmount, otherTaxAmount, flatPrice, saleMethod, cardNumber, origin, destination, date, isInterline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return  sale;
    }

    public void updateSale(Sales sale) {
        getConnection();
        String sql = "UPDATE Sales SET " +
                "saleBlankId = ?, saleAdvisorUserId = ?, saleCustomerId = ?, " +
                "saleCommissionId = ?, saleCommissionAmount = ?, saleConversionId = ?, saleConversionAmount = ?, " +
                "saleDiscountAmount = ?, saleTaxAmount = ?, saleOtherTaxAmount = ?, saleFlatPrice = ?, saleMethod = ?, saleCardNumber = ?, " +
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
            stmt.setDouble(10, sale.getSaleOtherTaxAmount());
            stmt.setDouble(11, sale.getSaleFlatPrice());
            stmt.setString(12, sale.getSaleMethod().toString());
            stmt.setInt(13, sale.getSaleCardNumber());
            stmt.setString(14, sale.getSaleOrigin());
            stmt.setString(15, sale.getSaleDestination());
            stmt.setInt(16, sale.getSaleDate());
            stmt.setBoolean(17, sale.getSaleIsInterline());
            stmt.setInt(18, sale.getSaleId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }


}
