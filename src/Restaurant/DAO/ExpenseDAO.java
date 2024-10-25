/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;

import Restaurant.DTO.ExpenseDTO;
import Restaurant.DTO.SalesDTO;
import Restaurant.Database.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author asjad
 */

// Data Access Object for Item
public class ExpenseDAO {
    Connection conn = null;
    PreparedStatement prepStatement= null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    YearMonth ym = YearMonth.now();
    LocalDate firstOfThisMonth = ym.atDay( 1 ) ;
    LocalDate firstOfNextMonth = ym.plusMonths( 1 ).atDay( 1 ) ;;

    public ExpenseDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Methods to add new Expense
    public void addExpenseDAO(ExpenseDTO expenseDTO) {
        try {
            String query = "SELECT Code FROM t16expense WHERE Code='"
                    +expenseDTO.getExpenseCode()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
               JOptionPane.showMessageDialog(null, "Expense code already exists.");
            }
            else{
                addFunction(expenseDTO);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
        }
    }
    public void addFunction(ExpenseDTO expenseDTO) {
        try {
            String query = "INSERT INTO t16expense (Code, Description, Expense_Date, Amount, Status) VALUES(?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, expenseDTO.getExpenseCode());
            prepStatement.setString(2, expenseDTO.getDescription());
            prepStatement.setString(3, expenseDTO.getExpenseDate());
            prepStatement.setDouble(4, expenseDTO.getExpenseAmount());
            prepStatement.setString(5, "A");
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "New Expense has been added.");
            
            // Methods to Update the Expense Code
            new GenarateCodeDAO().updateExpenseCode();
            
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Method to edit existing Expense details
    public  void editExpenseDAO(ExpenseDTO expenseDTO) {
        try {
            String query = "UPDATE t16expense SET Description=?, Expense_Date=?, Amount=? WHERE Code=? ";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, expenseDTO.getDescription());
            prepStatement.setString(2, expenseDTO.getExpenseDate());
            prepStatement.setDouble(3, expenseDTO.getExpenseAmount());
            prepStatement.setString(4, expenseDTO.getExpenseCode());
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Expense has been Edited.");
                        
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Method to delete existing Expense
    public void deleteExpenseDAO(String Code) {
        try {
            String query = "UPDATE t16expense SET Status=? WHERE Code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "I");
            prepStatement.setString(2, Code);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Expense Removed.");
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
    }

    // Method to retrieve data set to be displayed in the Table
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT Code, Expense_Date, Description, Amount FROM t16expense WHERE Status='A' ORDER BY Expense_Date DESC ;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
        return resultSet;
    }
    
    
    //Get Total Expense for Expense Report
    public Double getTotalExpense() {
        double amount = 0;
        try {
            String query = "SELECT SUM(Amount) as totalExpense FROM t16expense WHERE Status = 'A' ";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                amount = resultSet.getDouble("totalExpense");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return amount;
    }
    
    
    //Get Monthly Expense for Expense Report
    public Double getMonthlyExpense() {
        double amount = 0;
        try {
            String query = "SELECT SUM(Amount) as totalExpense FROM t16expense WHERE Status = 'A' AND Expense_Date >= '"+firstOfThisMonth+"' AND Expense_Date < '"+firstOfNextMonth+"' ";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                amount = resultSet.getDouble("totalExpense");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return amount;
    }
    
    
    //Get Date Filter  Expense  for Expense Report
    public Double getTotalExpenseByDate(SalesDTO salesDTO) {
        double amount = 0;
        try {
            String query = "SELECT SUM(Amount) as totalExpense FROM t16expense WHERE Expense_Date BETWEEN '"+salesDTO.getDateFrom()+"' AND '"+salesDTO.getDateto()+"' ORDER BY Expense_Date DESC ";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                amount = resultSet.getDouble("totalExpense");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return amount;
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
    

    // Search method for Expense Report
    public ResultSet getExpenseSearch(ExpenseDTO expenseDTO) {
        try {
            String query = "SELECT Code, Expense_Date, Description, Amount "
                    + "FROM t16expense "
                    + "WHERE Status='A' AND Expense_Date BETWEEN '"+expenseDTO.getFromDate()+"' AND '"+expenseDTO.getToDate()+"' ORDER BY Expense_Date DESC";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return resultSet;
    }



}
