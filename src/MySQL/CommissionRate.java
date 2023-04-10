package MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommissionRate {
    ConfigurationMySQL config;

    public CommissionRate() {
        this.config = new ConfigurationMySQL();
    }

    /*-------------------------COMMISSION RATE QUERIES START-------------------------*/
    public void createCommission(double percentage, int type, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "INSERT INTO commissionRate " +
                            "(commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived)" +
                            "VALUES (?, ?, ?, ?, 0)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, 1); //"Terrific Travel" Travel Agency
            stmt.setDouble(2, percentage);
            stmt.setInt(3, type);
            stmt.setInt(4, date);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();

            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getActiveCommissions() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commissionRate WHERE commissionIsArchived = 0");
            while( rs.next() )
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"  "+rs.getInt(5)+"  "+rs.getBoolean(6)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getArchivedCommissions() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commissionRate WHERE commissionIsArchived = 1");
            while( rs.next() )
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"  "+rs.getInt(5)+"  "+rs.getBoolean(6)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getAllCommissions() {
        try {
            Statement stmt = config.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commissionRate");
            while( rs.next() )
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"  "+rs.getInt(5)+"  "+rs.getBoolean(6)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCommissionById(int id) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM commissionRate WHERE commissionID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"  "+rs.getInt(5)+"  "+rs.getBoolean(6)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getActiveCommissionByTicketType(int type) {
        try {
            PreparedStatement stmt = config.getCon().prepareStatement("SELECT * FROM commissionRate WHERE commissionTicketType = ? " +
                    "AND commissionIsArchived = 0");
            stmt.setInt(1, type);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //commissionID, commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"  "+rs.getInt(5)+"  "+rs.getBoolean(6)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCommissionById(int id, double percentage, int type, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = config.getCon().prepareStatement(
                    "UPDATE commissionRate SET commissionPercentage=?, commissionTicketType=?, " +
                            "commissionDate=? WHERE commissionID = ?");
            stmt.setDouble(1, percentage);
            stmt.setInt(2, type);
            stmt.setInt(3, date);
            stmt.setInt(4, id);

            config.getCon().setAutoCommit(false);
            stmt.executeUpdate();
            config.getCon().commit();
            config.getCon().setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void archiveCommission(int id) {
        try {
            PreparedStatement isArchived = config.getCon().prepareStatement(
                    "SELECT commissionIsArchived FROM commissionRate WHERE commissionID = ?");
            isArchived.setInt(1, id);
            ResultSet rsArchived = isArchived.executeQuery();
            while (rsArchived.next()) {
                if (rsArchived.getInt(1) == 0) {
                    PreparedStatement stmt = config.getCon().prepareStatement(
                            "UPDATE commissionRate SET commissionIsArchived = 1 WHERE commissionID = ?");
                    stmt.setInt(1, id);
                    config.getCon().setAutoCommit(false);
                    stmt.executeUpdate();
                    config.getCon().commit();
                    config.getCon().setAutoCommit(true);
                    System.out.println("Commission is now archived.");
                } else {
                    PreparedStatement stmt = config.getCon().prepareStatement(
                            "UPDATE commissionRate SET commissionIsArchived = 0 WHERE commissionID = ?");
                    stmt.setInt(1, id);
                    config.getCon().setAutoCommit(false);
                    stmt.executeUpdate();
                    config.getCon().commit();
                    config.getCon().setAutoCommit(true);
                    System.out.println("Commission is no longer archived.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------COMMISSION RATE QUERIES END-------------------------*/
}
