/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;

import Restaurant.DTO.CategoryDTO;
import Restaurant.Database.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author asjad
 */

// Data Access Object for Customers
public class CategoryDAO {
    Connection conn = null;
    PreparedStatement prepStatement= null;
    Statement statement = null;
    ResultSet resultSet = null;

    public CategoryDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Methods to add new Category
    public void addCategoryDAO(CategoryDTO categoryDTO) {
        try {
            String query = "SELECT * FROM m05menu_category WHERE Cat_Code='"
                    +categoryDTO.getCatCode()
                    + "' AND Category_Name='"
                    +categoryDTO.getCategoryName()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
               JOptionPane.showMessageDialog(null, "Category already exists.");
            }
            else{
                addFunction(categoryDTO);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
        }
    }
    public void addFunction(CategoryDTO categoryDTO) {
        try {
            String query = "INSERT INTO m05menu_category (Cat_Code, Category_Name, Status) VALUES(?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, categoryDTO.getCatCode());
            prepStatement.setString(2, categoryDTO.getCategoryName());
            prepStatement.setString(3, "A");
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "New Category has been added.");
            
            new GenarateCodeDAO().updateCatCode();
            
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Method to edit existing Category details
    public  void editCategoryDAO(CategoryDTO categoryDTO) {
        try {
            String query = "UPDATE m05menu_category SET Category_Name=? WHERE Cat_Code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, categoryDTO.getCategoryName());
            prepStatement.setString(2, categoryDTO.getCatCode());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Category details have been updated.");
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
    }

    // Method to delete existing Category
    public void deleteCategoryDAO(String catCode) {
        try {
            String query = "UPDATE m05menu_category SET Status=? WHERE Cat_Code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "I");
            prepStatement.setString(2, catCode);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Category Removed.");
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
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
    
    
    // Method to retrieve data set to be display in the Table and Combobox
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT Cat_Code, Category_Name FROM m05menu_category WHERE Status='A' ORDER BY Cat_Code";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        return resultSet;
    }

    
    // Method to set/update Category combo box
    public ComboBoxModel<String> setComboItems(ResultSet queryResult) throws SQLException {
        Vector<String> categoryNames = new Vector<>();
        while (resultSet.next()){
            categoryNames.add(resultSet.getString("Category_Name"));
        }
        return new DefaultComboBoxModel<>(categoryNames);
    }

    
    String catCode;
    public String getCategoryCode(String catName) {
        try {
            String query = "SELECT Cat_Code FROM m05menu_category WHERE Category_Name='" +catName+ "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                catCode = resultSet.getString("Cat_Code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catCode;
    }

    
    // Method to Category List to tha POS Dashboard
    public ArrayList<CategoryDTO> getCategoryList() {
        ArrayList<CategoryDTO> list = new ArrayList<>();
        try {
            String query = "SELECT Cat_Code, Category_Name FROM m05menu_category WHERE Status='A' ORDER BY Category_Name";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                CategoryDTO c = new CategoryDTO();
                c.setCatCode(resultSet.getString("Cat_Code"));
                c.setCategoryName(resultSet.getString("Category_Name"));
                list.add(c);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return list;
    }
    
    
    
    

}
