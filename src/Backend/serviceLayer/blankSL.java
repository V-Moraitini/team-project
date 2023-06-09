package serviceLayer;

import persistenceLayer.blank;

import java.sql.*;

public class blankSL {
    private Connection connection;

    public blankSL(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void close() throws SQLException {
        connection.close();
    }

    public void addBlank(blank blank) throws SQLException {
        String query = "INSERT INTO Blanks (BlankID, BatchID, StockID, StockAdvisorUserID, Type, DateReceived, IsValid, IsSold) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, blank.getBlankId());
        statement.setInt(2, blank.getBlankBatchId());
        statement.setInt(3, blank.getBlankStockId());
        statement.setInt(4, blank.getBlankStockAdvisorUserId());
        statement.setInt(5, blank.getBlankType());
        statement.setInt(6, blank.getBlankDateReceived());
        statement.setInt(7, blank.getBlankIsValid());
        statement.setInt(8, blank.getBlankIsSold());

        statement.executeUpdate();
    }

    public void updateBlank(blank blank) throws SQLException {
        String query = "UPDATE Blanks SET BatchID=?, StockID=?, StockAdvisorUserID=?, Type=?, DateReceived=?, IsValid=?, IsSold=? WHERE BlankID=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, blank.getBlankBatchId());
        statement.setInt(2, blank.getBlankStockId());
        statement.setInt(3, blank.getBlankStockAdvisorUserId());
        statement.setInt(4, blank.getBlankType());
        statement.setInt(5, blank.getBlankDateReceived());
        statement.setInt(6, blank.getBlankIsValid());
        statement.setInt(7, blank.getBlankIsSold());
        statement.setInt(8, blank.getBlankId());

        statement.executeUpdate();
    }

    public void deleteBlank(int blankId) throws SQLException {
        String query = "DELETE FROM Blanks WHERE BlankID=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, blankId);

        statement.executeUpdate();
    }

    public blank getBlankById(int blankId) throws SQLException {
        String query = "SELECT * FROM Blanks WHERE BlankID=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, blankId);

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            int batchId = rs.getInt("BatchID");
            int stockId = rs.getInt("StockID");
            int stockAdvisorUserId = rs.getInt("StockAdvisorUserID");
            int type = rs.getInt("Type");
            int dateReceived = rs.getInt("DateReceived");
            int isValid = rs.getInt("IsValid");
            int isSold = rs.getInt("IsSold");

            blank blank = new blank(blankId, batchId, stockId, stockAdvisorUserId, type, dateReceived, isValid, isSold);

            return blank;
        }

        return null;
    }
}

