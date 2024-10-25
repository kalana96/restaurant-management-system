/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;
import Restaurant.DTO.SalesDTO;
import Restaurant.Database.ConnectionFactory;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author asjad
 */

// Data Access Object for Products, Purchase, Stock and Sales
public class SalesDAO {

    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    DateTimeFormatter dtTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    LocalDateTime now = LocalDateTime.now();
    String date = dtf.format(now);
    String time = dtTime.format(now);
    
    YearMonth ym = YearMonth.now();
    LocalDate firstOfThisMonth = ym.atDay( 1 ) ;
    LocalDate firstOfNextMonth = ym.plusMonths( 1 ).atDay( 1 ) ;;
   

    public SalesDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
            conn.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
     // Methods to add a new Sales Invoice
    public boolean addSalesDAO(SalesDTO salesDTO) {
        boolean flag = false;
        try {
            String query = "SELECT * FROM t10invoice_resturent WHERE Inv_No= '"+salesDTO.getInvoiceNo()+"' ";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                flag = false;
                JOptionPane.showMessageDialog(null, "This Sale already exist");
            }
            else{
                flag = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return flag;
    }
    
    public void addInvoice(SalesDTO salesDTO) {
        try {
            String query = "INSERT INTO t10invoice_resturent (Inv_No, Ref_No, Date, Time, Trans_Type, Table_No, Payment_Method, Total_Amount, Service_Charge, Net_Amount, Cash, Balance, User, Status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, salesDTO.getInvoiceNo());
            prepStatement.setString(2, salesDTO.getRefNo());
            prepStatement.setString(3, date);
            prepStatement.setString(4, time);
            prepStatement.setString(5, salesDTO.getTransType());
            prepStatement.setString(6, salesDTO.getOrderTo());
            prepStatement.setString(7, salesDTO.getPaymentMethod());
            prepStatement.setDouble(8, salesDTO.getTotalAmount());
            prepStatement.setDouble(9, salesDTO.getServiceCharge());
            prepStatement.setDouble(10, salesDTO.getNetAmount());
            prepStatement.setDouble(11, salesDTO.getCashAmount());
            prepStatement.setDouble(12, salesDTO.getBalance());
            prepStatement.setString(13, salesDTO.getUser());
            prepStatement.setString(14, "A");
            prepStatement.executeUpdate();     
                        
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, throwables);
        }
    }
    
    public void addInvoiceFlutter(SalesDTO salesDTO) {
        try {
            String query = "INSERT INTO t11invo_restorent_fluter (Inv_No, Item_Code, Rate, Qty, Total_Price, Status ) VALUES(?,?,?,?,?,?)";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, salesDTO.getInvoiceNo());
            prepStatement.setString(2, salesDTO.getItemCode());
            prepStatement.setDouble(3, salesDTO.getPrice());
            prepStatement.setDouble(4, salesDTO.getQty());
            prepStatement.setDouble(5, salesDTO.getTotal());
            prepStatement.setString(6, "A");
            prepStatement.executeUpdate();
                        
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, throwables);
        }  
    }
    
    public void updateKOTStatus(SalesDTO salesDTO) {
        try {
            String query = "UPDATE t06resturent_kot SET Paid=? WHERE Status='ACTIVE' AND Ref_No=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "YES");
            prepStatement.setString(2, salesDTO.getRefNo());
            prepStatement.executeUpdate();
            
//            JOptionPane.showMessageDialog(null, "KOT Updated");
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, throwables);
        } 
    }
    
    
    // Sales data set retrieval for display Sales Report
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT Inv_No, Date, User, Trans_Type, Total_Amount, Service_Charge, Net_Amount "
                    + "FROM t10invoice_resturent WHERE Status='A' ORDER BY Date DESC";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resultSet;
    }
    

    //Get Total Sale for Sales Report
    public Double getSalesAmount() {
        double amount = 0;
        try {
            String query = "SELECT SUM(Net_Amount) as totalNet FROM t10invoice_resturent WHERE Status='A' ";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                amount = resultSet.getDouble("totalNet");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return amount;
    }
    
    //Get Total Sale for Monthly Sales Report
    public Double getMonthlySales() {
        double amount = 0;
        try {
            String query = "SELECT SUM(Net_Amount) as totalNet FROM t10invoice_resturent WHERE Status='A' and Date >= '"+firstOfThisMonth+"' AND Date < '"+firstOfNextMonth+"' ";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                amount = resultSet.getDouble("totalNet");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return amount;
    }
    
//        public ResultSet getSalesSearch(java.util.Date dateFrom, java.util.Date dateTo) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
    
    // Search method for Sales Report
    public ResultSet getSalesSearch(SalesDTO salesDTO ) {
        try {
            String query = "SELECT Inv_No, Date, User, Trans_Type, Total_Amount, Service_Charge, Net_Amount "
                    + "FROM t10invoice_resturent "
                    + "WHERE Status='A' AND Date BETWEEN '"+salesDTO.getDateFrom()+"' AND '"+salesDTO.getDateto()+"' ORDER BY date DESC";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
        return resultSet;
    }


    // Method to display product-related data set in tabular form
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int colCount = metaData.getColumnCount();

        for (int col=1; col <= colCount; col++){
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int col=1; col<=colCount; col++) {
                vector.add(resultSet.getObject(col));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }








}
