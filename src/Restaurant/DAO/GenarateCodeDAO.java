/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;

import Restaurant.Database.ConnectionFactory;
//import Restaurant.UI.UsersPage;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author asjad
 */

// Data Access Object class for Users

public class GenarateCodeDAO {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    // Constructor method
    public GenarateCodeDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    
    public int getCatCode() {
        int num = 0;
        try {
            String query = "SELECT LastNo FROM p01parameter WHERE Code='CAT' ";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                num =resultSet.getInt("LastNo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return num;
    }
    

    public void updateCatCode() {
        try {
            String query = "UPDATE p01parameter SET LastNo=LastNo+1 WHERE code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "CAT");
            prepStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    
    public int getTableCode() {
        int num = 0;
        try {
            String query = "SELECT LastNo FROM p01parameter WHERE Code='TBL' ";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                num =resultSet.getInt("LastNo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return num;
    }
    

    public void updateTableCode() {
        try {
            String query = "UPDATE p01parameter SET LastNo=LastNo+1 WHERE code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "TBL");
            prepStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public int getItemCode() {
        int num = 0;
        try {
            String query = "SELECT LastNo FROM p01parameter WHERE Code='ITM' ";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                num =resultSet.getInt("LastNo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return num;
    }
    

    public void updateItemCode() {
        try {
            String query = "UPDATE p01parameter SET LastNo=LastNo+1 WHERE code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "ITM");
            prepStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    public int getRoomCode() {
        int num = 0;
        try {
            String query = "SELECT LastNo FROM p01parameter WHERE Code='RM' ";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                num =resultSet.getInt("LastNo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return num;
    }
    
    
    public void updateRoomCode() {
        try {
            String query = "UPDATE p01parameter SET LastNo=LastNo+1 WHERE code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "RM");
            prepStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getExpenseCode() {
        int num = 0;
        try {
            String query = "SELECT LastNo FROM p01parameter WHERE Code='EX' ";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                num =resultSet.getInt("LastNo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return num;
    }

    void updateExpenseCode() {
        try {
            String query = "UPDATE p01parameter SET LastNo=LastNo+1 WHERE code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "EX");
            prepStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getUserCode() {
        int num = 0;
        try {
            String query = "SELECT LastNo FROM p01parameter WHERE Code='U' ";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                num =resultSet.getInt("LastNo");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return num;
    }
    
    void updateUserCode() {
        try {
            String query = "UPDATE p01parameter SET LastNo=LastNo+1 WHERE code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "U");
            prepStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    

}
