/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;

import Restaurant.DTO.UserDTO;
import Restaurant.Database.ConnectionFactory;
//import Restaurant.UI.UsersPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author asjad
 */

// Data Access Object class for Users

public class UserDAO {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    // Constructor method
    public UserDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // Methods to add new user
    public void addUserDAO(UserDTO userDTO) {
        try {
            String query = "SELECT * FROM users WHERE Name='"
                    +userDTO.getUserName()
                    +"' AND Password='"
                    +userDTO.getPassword()
                    +"'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
                JOptionPane.showMessageDialog(null, "User already exists");
            else
                addFunction(userDTO);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void addFunction(UserDTO userDTO) {
        try {
//            String username = null;
//            String password = null;
//            String oldUsername = null;
//            String resQuery = "SELECT * FROM users";
//            resultSet = statement.executeQuery(resQuery);
//
//            if(!resultSet.next()){
//                username = "root";
//                password = "root";
//            }
//            else {
//                String resQuery2 = "SELECT * FROM users ORDER BY id DESC";
//                resultSet = statement.executeQuery(resQuery2);
//
//                if(resultSet.next()){
//                    oldUsername = resultSet.getString("username");
//                    Integer uCode = Integer.parseInt(oldUsername.substring(4));
//                    uCode++;
//                    username = "user" + uCode;
//                    password = "user" + uCode;
//                }
//            }

            String query = "INSERT INTO users (User_ID, Name, Password, User_Type, Status) " +
                    "VALUES(?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, userDTO.getUserID());
            prepStatement.setString(2, userDTO.getUserName());
            prepStatement.setString(3, userDTO.getPassword());
            prepStatement.setString(4, userDTO.getUserType());
            prepStatement.setString(5, "A");
            prepStatement.executeUpdate();

            if("ADMIN".equals(userDTO.getUserType())){
                JOptionPane.showMessageDialog(null, "New Administrator added.");
            }else{ 
                JOptionPane.showMessageDialog(null, "New Cashier added.");
            }
            
            new GenarateCodeDAO().updateUserCode();
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // Method to edit existing user
    public void editUserDAO(UserDTO userDTO) {

        try {
            String query = "UPDATE users SET Name=?,Password=?,User_Type=? WHERE User_ID=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, userDTO.getUserName());
            prepStatement.setString(2, userDTO.getPassword());
            prepStatement.setString(3, userDTO.getUserType());
            prepStatement.setString(4, userDTO.getUserID());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "User Updated Successfully.");

        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, throwables);
        }
    }

    // Method to delete existing user
    public void deleteUserDAO(String code) {
        try {
            String query = "DELETE FROM users WHERE User_ID=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, code);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "User Deleted.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        new UsersPage().loadDataSet();
    }

    // Method to retrieve data set to display in table
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT User_ID, Name, Password, User_Type FROM users";
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getUserDAO(String username) {
        try {
            String query = "SELECT * FROM users WHERE username='" +username+ "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }
    
    
//    public void getFullName(UserDTO userDTO, String username) {
//        try {
//            String query = "SELECT * FROM users WHERE Name='" +username+ "' LIMIT 1";
//            resultSet = statement.executeQuery(query);
//            String fullName = null;
//            if(resultSet.next()) fullName = resultSet.getString(2);
//            userDTO.setFullName(fullName);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

//    public ResultSet getUserLogsDAO() {
//        try {
//            String query = "SELECT users.name,userlogs.username,in_time,out_time,location FROM userlogs" +
//                    " INNER JOIN users on userlogs.username=users.username";
//            resultSet = statement.executeQuery(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resultSet;
//    }
    
//    public void addUserLogin(UserDTO userDTO) {
//        try {
//            String query = "INSERT INTO userlogs (username, in_time, out_time) values(?,?,?)";
//            prepStatement = conn.prepareStatement(query);
//            prepStatement.setString(1, userDTO.getUsername());
//            prepStatement.setString(2, userDTO.getInTime());
//            prepStatement.setString(3, userDTO.getOutTime());
//
//            prepStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public ResultSet getPassDAO(String username, String password){
//        try {
//            String query = "SELECT password FROM users WHERE username='"
//                    +username
//                    + "' AND password='"
//                    +password
//                    +"'";
//            resultSet = statement.executeQuery(query);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return resultSet;
//    }

//    public void changePass(String username, String password) {
//        try {
//            String query = "UPDATE users SET password=? WHERE username='" +username+ "'";
//            prepStatement = (PreparedStatement) conn.prepareStatement(query);
//            prepStatement.setString(1, password);
//            prepStatement.setString(2, username);
//            prepStatement.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Password has been changed.");
//        } catch (SQLException ex){
//            ex.printStackTrace();
//        }
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
