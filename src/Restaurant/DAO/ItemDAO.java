/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;

import Restaurant.DTO.ItemDTO;
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

// Data Access Object for Item
public class ItemDAO {
    Connection conn = null;
    PreparedStatement prepStatement= null;
    Statement statement = null;
    ResultSet resultSet = null;

    public ItemDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Methods to add new Item
    public void addItemDAO(ItemDTO itemDTO) {
        try {
            String query = "SELECT Menu_Code, Menu_Name FROM m06menu_item WHERE Menu_Code='"
                    +itemDTO.getItemCode()
                    + "' AND Menu_Name='"
                    +itemDTO.getItemName()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
               JOptionPane.showMessageDialog(null, "Menu item already exists.");
            }
            else{
                addFunction(itemDTO);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
        }
    }
    public void addFunction(ItemDTO itemDTO) {
        try {
            String query = "INSERT INTO m06menu_item (Menu_Code, Cat_Code, Menu_Name, Retail_Price, Status) VALUES(?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, itemDTO.getItemCode());
            prepStatement.setString(2, itemDTO.getCategoryCode());
            prepStatement.setString(3, itemDTO.getItemName());
            prepStatement.setDouble(4, itemDTO.getRetailPrice());
            prepStatement.setString(5, "A");
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "New item has been added.");
            
            // Methods to Update the Item Code
            new GenarateCodeDAO().updateItemCode();
            
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Method to edit existing Item details
    public  void editItemDAO(ItemDTO itemDTO) {
        try {
            String query = "UPDATE m06menu_item SET Cat_Code=?, Menu_Name=?, Retail_Price=? WHERE Menu_Code=? ";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, itemDTO.getCategoryCode());
            prepStatement.setString(2, itemDTO.getItemName());
            prepStatement.setDouble(3, itemDTO.getRetailPrice());
            prepStatement.setString(4, itemDTO.getItemCode());
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "New item has been Edited.");
                       
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Method to delete existing Item
    public void deleteItemDAO(String Code) {
        try {
            String query = "UPDATE m06menu_item SET Status=? WHERE Item_Code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "I");
            prepStatement.setString(2, Code);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item Removed.");
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
    }

    // Method to retrieve data set to be displayed in the Table
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT item.Menu_Code, category.Category_Name, item.Menu_Name, item.Retail_Price "
                        + "FROM m06menu_item item INNER JOIN m05menu_category category ON item.Cat_Code=category.Cat_Code "
                        + "WHERE item.Status='A' ORDER BY item.Menu_Code ;";
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
