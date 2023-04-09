package MySQL;

import java.sql.*;

public class ConfigurationMySQL {
    Connection con;

    public ConfigurationMySQL() {
        try {
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g07", "in2018g07_d", "6KV8dzpF");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection() throws SQLException {
        con.close();
    }

    /*-------------------------USER QUERIES START-------------------------*/
    //Create user (with ID)
    public void createUser(int id, String name, String email, String password, String type) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO userAccount VALUES (?, 1, ?, ?, ?, ?, 0)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, type);

            //if the user is a travel advisor, make their stock as well
            if (type.equals("Travel Advisor")) {
                createStock(id);
            }

            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Getting active non-archived users only
    public void getActiveUsers() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE userIsArchived = 0");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
                //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    //Getting archived users only
    public void getArchivedUsers() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount WHERE userIsArchived = 1");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    //Getting users regardless of whether they are archived or not
    public void getAllUsers() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userAccount");
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
                //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void getUserById(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM userAccount WHERE userID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //userID, userAgencyTravelCode, userName, userEmail, userPassword, userType, userIsArchived
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getInt(6)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void updateUserById(int id, String name, String email, String password, String type) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE userAccount SET userName=?, userEmail=?, userPassword=?, userType=? " +
                    "WHERE userID = ?");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, type);
            stmt.setInt(5, id);
            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void archiveUser(int id) {
        try {
            PreparedStatement isArchived = con.prepareStatement(
                    "SELECT userIsArchived FROM userAccount WHERE userID = ?");
            isArchived.setInt(1, id);
            ResultSet rsArchived = isArchived.executeQuery();
            //System.out.println(rsArchived.next());
            while (rsArchived.next()) {
                if (rsArchived.getInt(1) == 0) {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE userAccount SET userIsArchived = 1 WHERE userID = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("User is now archived.");
                } else {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE userAccount SET userIsArchived = 0 WHERE userID = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("User is no longer archived.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------USER QUERIES END-------------------------*/

    /*-------------------------CUSTOMER QUERIES START-------------------------*/
    public void createCustomer(String name, String alias, String email, int phone, Boolean isValued) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO customer " +
                            "(customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage)" +
                            "VALUES (?, ?, ?, ?, ?, NULL)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);

            con.setAutoCommit(false);
            stmt.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createCustomer(String name, String alias, String email, int phone, Boolean isValued, double fixedDiscount) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO customer " +
                            "(customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage)" +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);
            stmt.setDouble(6, fixedDiscount);
            con.setAutoCommit(false);
            stmt.executeUpdate();
            /*int affectedRows = stmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }*/
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCustomers() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            while( rs.next() )
                //customerID, customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getInt(5)+"  "+rs.getBoolean(6)+"  "+rs.getDouble(7)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void getCustomerById(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer WHERE userID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //customerID, customerName, customerAlias, customerEmail, customerPhone, customerIsValued, customerFixedDiscountPercentage
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "
                        +rs.getInt(5)+"  "+rs.getBoolean(6)+"  "+rs.getDouble(7)+"\n");
            //when objects have been made, use object constructor to make them?

        } catch (Exception e) { System.out.println(e); }
    }

    public void updateCustomerById(int id, String name, String alias, String email, int phone, Boolean isValued) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE customer SET customerName=?, customerAlias=?, customerEmail=?, " +
                            "customerPhone=?, customerIsValued=? WHERE customerID = ?");
            stmt.setString(1, name);
            stmt.setString(2, alias);
            stmt.setString(3, email);
            stmt.setInt(4, phone);
            stmt.setBoolean(5, isValued);
            stmt.setInt(6, id);
            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------CUSTOMER QUERIES END-------------------------*/

    /*-------------------------FLIGHT COUPON QUERIES START-------------------------*/
    public void createCoupon(String fromAirport, String toAirport, Boolean isInterline) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO flightCoupon " +
                            "(couponFromAirport, couponToAirport, couponIsInterline)" +
                            "VALUES (?, ?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, fromAirport);
            stmt.setString(2, toAirport);
            stmt.setBoolean(3, isInterline);

            con.setAutoCommit(false);
            stmt.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCoupons() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM flightCoupon");
            while( rs.next() )
                //couponID, couponFromAirport, couponToAirport, couponIsInterline
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getBoolean(4)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCouponById(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM flightCoupon WHERE couponID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //couponID, couponFromAirport, couponToAirport, couponIsInterline
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getBoolean(4)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCouponById(int id, String fromAirport, String toAirport, Boolean isInterline) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE flightCoupon SET couponFromAirport=?, couponToAirport=?, couponIsInterline=? WHERE couponID = ?");
            stmt.setString(1,fromAirport);
            stmt.setString(2, toAirport);
            stmt.setBoolean(3, isInterline);
            stmt.setInt(4, id);

            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------FLIGHT COUPON QUERIES END-------------------------*/

    /*-------------------------AGENCY BATCH QUERIES START-------------------------*/
    public void createBatch(int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO flightCoupon " +
                            "(batchAgencyTravelCode, batchDate)" +
                            "VALUES (?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, 1); //"Terrific Travel" Travel Agent
            stmt.setInt(2, date);

            con.setAutoCommit(false);
            stmt.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getBatches() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agencyBatch");
            while( rs.next() )
                //batchID, batchAgencyTravelCode, batchDate
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getBatchById(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM agencyBatch WHERE batchID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //batchID, batchAgencyTravelCode, batchDate
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"\n");
            //when objects have been made, use object constructor to make them?
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBatchById(int id, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE agencyBatch SET batchDate=? WHERE batchID = ?");
            stmt.setInt(1, date);
            stmt.setInt(2, id);

            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------AGENCY BATCH QUERIES END-------------------------*/

    /*-------------------------ADVISOR STOCK QUERIES START-------------------------*/
    public void createStock(int advisorId) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO advisorStock " +
                            "(stockAdvisorUserID)" +
                            "VALUES (?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, advisorId);

            con.setAutoCommit(false);
            stmt.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getStocks() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM advisorStock");
            while( rs.next() )
                //stockID, stockAdvisorUserID
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getStockById(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //stockID, stockAdvisorUserID
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getStockByAdvisorId(int advisorId) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM advisorStock WHERE stockAdvisorUserID = ?");
            stmt.setInt(1, advisorId);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //stockID, stockAdvisorUserID
                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*-------------------------ADVISOR STOCK QUERIES END-------------------------*/

    /*-------------------------COMMISSION RATE QUERIES START-------------------------*/
    public void createCommission(double percentage, int type, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO commissionRate " +
                            "(commissionAgencyTravelCode, commissionPercentage, commissionTicketType, commissionDate, commissionIsArchived)" +
                            "VALUES (?, ?, ?, ?, 0)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, 1); //"Terrific Travel" Travel Agency
            stmt.setDouble(2, percentage);
            stmt.setInt(3, type);
            stmt.setInt(4, date);

            con.setAutoCommit(false);
            stmt.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getActiveCommissions() {
        try {
            Statement stmt = con.createStatement();
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
            Statement stmt = con.createStatement();
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
            Statement stmt = con.createStatement();
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM commissionRate WHERE commissionID = ?");
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM commissionRate WHERE commissionTicketType = ? " +
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
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE commissionRate SET commissionPercentage=?, commissionTicketType=?, " +
                            "commissionDate=? WHERE commissionID = ?");
            stmt.setDouble(1, percentage);
            stmt.setInt(2, type);
            stmt.setInt(3, date);
            stmt.setInt(4, id);

            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void archiveCommission(int id) {
        try {
            PreparedStatement isArchived = con.prepareStatement(
                    "SELECT commissionIsArchived FROM commissionRate WHERE commissionID = ?");
            isArchived.setInt(1, id);
            ResultSet rsArchived = isArchived.executeQuery();
            while (rsArchived.next()) {
                if (rsArchived.getInt(1) == 0) {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE commissionRate SET commissionIsArchived = 1 WHERE commissionID = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("Commission is now archived.");
                } else {
                    PreparedStatement stmt = con.prepareStatement(
                            "UPDATE commissionRate SET commissionIsArchived = 0 WHERE commissionID = ?");
                    stmt.setInt(1, id);
                    con.setAutoCommit(false);
                    stmt.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                    System.out.println("Commission is no longer archived.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------COMMISSION RATE QUERIES END-------------------------*/

    /*-------------------------CONVERSION RATE QUERIES START-------------------------*/
    public void createConversion(String currencyName, double rate, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO conversionRate " +
                            "(conversionCurrency, conversionRate, conversionDate)" +
                            "VALUES (?, ?, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setString(1, currencyName);
            stmt.setDouble(2, rate);
            stmt.setInt(3, date);

            con.setAutoCommit(false);
            stmt.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getConversions() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conversionRate");
            while( rs.next() )
                //conversionID, conversionCurrency, conversionRate, conversionDate
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getConversionById(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM conversionRate WHERE conversionID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                //conversionID, conversionCurrency, conversionRate, conversionDate
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3)+
                        "  "+rs.getInt(4)+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateConversionById(int id, String currencyName, double rate, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE conversionRate SET conversionCurrency=?, conversionRate=?, " +
                            "conversionDate=? WHERE conversionID = ?");
            stmt.setString(1, currencyName);
            stmt.setDouble(2, rate);
            stmt.setInt(3, date);
            stmt.setInt(4, id);

            con.setAutoCommit(false);
            stmt.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------CONVERSION RATE QUERIES END-------------------------*/

    /*-------------------------BLANK QUERIES START-------------------------*/
    public void createBlank(int batchId, int type, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO blank " +
                            "(blankBatchID, blankType, blankDateReceived, " +
                            "blankIsValid, blankIsSold, blankIsInterline)" +
                            "VALUES (?, ?, ?, 1, 0, ?)");
            //Statement.RETURN_GENERATED_KEYS for auto generated keys
            stmt.setInt(1, batchId);
            stmt.setInt(2, type);
            stmt.setInt(3, date);
            if (type == 444 || type == 440 || type == 420) {
                stmt.setBoolean(4, true);
            } else if (type == 201 || type == 101)
                stmt.setBoolean(4,false);
            else {
                stmt.setBoolean(4, false);
            }
            con.setAutoCommit(false);
            stmt.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createBlankBatch(int count, int batchId, int type, int day, int month, int year) {
        int date = year*10000 + month*100 + day;
        Boolean isInterline;
        if (type == 444 || type == 440 || type == 420) {
            isInterline = true;
        } else if (type == 201 || type == 101)
            isInterline = false;
        else {
            isInterline = false;
        }
        //createBatch(day, month, year);
        //then probably retrieve the id of the object class?
        String SQL = "INSERT INTO blank " +
                "(blankBatchID, blankType, blankDateReceived, " +
                "blankIsValid, blankIsSold, blankIsInterline)" +
                "VALUES (" +batchId+", "+type+","+date+", 1, 0,"+isInterline+")";
        try {
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            for(int i = 0; i <= count; i++) {
                stmt.addBatch(SQL);
            }
            stmt.executeBatch();

            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /*-------------------------BLANK QUERIES END-------------------------*/

    /*-------------------------MAIN START-------------------------*/
    public static void main(String args[]) throws SQLException {
        ConfigurationMySQL a = new ConfigurationMySQL();
        try {
            //a.getUsers();
            //a.getUserById(1);
            //a.updateUserById(1, "Todd Jenkins", "tod123", "Office Manager");
            //a.archiveUser(1);

            a.getActiveCommissions();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            a.closeConnection();
        }

    }
    /*-------------------------MAIN END-------------------------*/
}