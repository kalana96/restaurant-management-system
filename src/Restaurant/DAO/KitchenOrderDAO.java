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
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author asjad
 */

// Data Access Object for Products, Purchase, Stock and Sales
public class KitchenOrderDAO {

    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public KitchenOrderDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    // Products data set Item List for display
    public ResultSet getItemList(String ref) {
        try {
            String query = "SELECT i.Menu_Code, i.Menu_Name, k.Price, k.Qty, k.Total FROM t06resturent_kot k, m06menu_item i WHERE i.Menu_Code=k.Item_Code AND k.Paid='NO' AND k.Status='ACTIVE' AND k.Ref_No= '"+ref+"' ";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resultSet;
    }
    
    
    // Products data set retrieval for display
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT Inv_No, Date, Type, Total_Amount, Service_Charge, Net_Amount, User "
                    + "FROM t10invoice_resturent ORDER BY Date DESC";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resultSet;
    }
    

    
    public Double getSalesAmount() {
        double amount = 0;
        try {
            String query = "SELECT SUM(Net_Amount) as totalNet FROM t10invoice_resturent ";
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
    
    // Search method for sales
    public ResultSet getSalesSearch(SalesDTO salesDTO ) {
        try {
            String query = "SELECT Inv_No, Date, Type, Total_Amount, Service_Charge, Net_Amount, User "
                    + "FROM t10invoice_resturent "
                    + "WHERE Date BETWEEN '"+salesDTO.getDateFrom()+"' AND '"+salesDTO.getDateto()+"' ORDER BY date DESC";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
           e.printStackTrace();
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
