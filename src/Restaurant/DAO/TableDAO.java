/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;

import Restaurant.DTO.CategoryDTO;
import Restaurant.DTO.TableDTO;
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

// Data Access Object for Table
public class TableDAO {
    Connection conn = null;
    PreparedStatement prepStatement= null;
    Statement statement = null;
    ResultSet resultSet = null;

    public TableDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Methods to add new Table
    public void addTableDAO(TableDTO tableDTO) {
        try {
            String query = "SELECT code, Name FROM m03table WHERE Code='"
                    +tableDTO.getTableCode()
                    + "' AND Name='"
                    +tableDTO.getTableName()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
               JOptionPane.showMessageDialog(null, "This Table already exists.");
            }
            else{
                addFunction(tableDTO);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
        }
    }
    public void addFunction(TableDTO tableDTO) {
        try {
            String query = "INSERT INTO m03table (Code, Name, Status) VALUES(?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, tableDTO.getTableCode());
            prepStatement.setString(2, tableDTO.getTableName());
            prepStatement.setString(3, "A");
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "New Table has been added.");
            
            new GenarateCodeDAO().updateTableCode();
            
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Method to edit existing Table details
    public  void editTableDAO(TableDTO tableDTO) {
        try {
            String query = "UPDATE m03table SET Name=? WHERE Code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, tableDTO.getTableName());
            prepStatement.setString(2, tableDTO.getTableCode());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Table details have been updated.");
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
    }

    // Method to delete existing Table
    public void deleteTableDAO(String Code) {
        try {
            String query = "UPDATE m03table SET Status=? WHERE Code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "I");
            prepStatement.setString(2, Code);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Table Removed.");
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
    }

    // Method to retrieve data set to be displayed
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT Code, Name FROM m03table WHERE Status='A' ";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
        return resultSet;
    }

    // Method to retrieve search data
//    public ResultSet getCategorySearch(String text) {
//        try {
//            String query = "SELECT Cat_Code, Name FROM m05menu_category WHERE WHERE Status='A' and Name LIKE '%"+text+"%' ";
//            resultSet = statement.executeQuery(query);
//        } catch (SQLException e) {
////            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, e);
//
//        }
//        return resultSet;
//    }


    // Method to display data set in tabular form
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
