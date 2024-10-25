/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DAO;

import Restaurant.DTO.RoomDTO;
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
public class RoomDAO {
    Connection conn = null;
    PreparedStatement prepStatement= null;
    Statement statement = null;
    ResultSet resultSet = null;

    public RoomDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Methods to add new ROom
    public void addRoomDAO(RoomDTO roomDTO) {
        try {
            String query = "SELECT Room_code, Name FROM m02rooms_master WHERE Room_code='"
                    +roomDTO.getRoomCode()
                    + "' AND Name='"
                    +roomDTO.getRoomName()
                    + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
               JOptionPane.showMessageDialog(null, "Room already exists.");
            }
            else{
                addFunction(roomDTO);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
        }
    }
    public void addFunction(RoomDTO roomDTO) {
        try {
            String query = "INSERT INTO m02rooms_master (Room_code, Name, FB, HB, BB, Room_Only, Status) VALUES(?,?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, roomDTO.getRoomCode());
            prepStatement.setString(2, roomDTO.getRoomName());
            prepStatement.setDouble(3, roomDTO.getFBPrice());
            prepStatement.setDouble(4, roomDTO.getHBPrice());
            prepStatement.setDouble(5, roomDTO.getBBPrice());
            prepStatement.setDouble(6, roomDTO.getROPrice());
            prepStatement.setString(7, "A");
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "New Room has been added.");
            
            // Methods to Update the Item Code
            new GenarateCodeDAO().updateRoomCode();
            
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Method to edit existing Room details
    public  void editRoomDAO(RoomDTO roomDTO) {
        try {
            String query = "UPDATE m02rooms_master SET Name=?, FB=?, HB=?, BB=?, Room_Only=? WHERE Room_Code=? ";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, roomDTO.getRoomName());
            prepStatement.setDouble(2, roomDTO.getFBPrice());
            prepStatement.setDouble(3, roomDTO.getHBPrice());
            prepStatement.setDouble(4, roomDTO.getBBPrice());
            prepStatement.setDouble(5, roomDTO.getROPrice());
            prepStatement.setString(6, roomDTO.getRoomCode());
            prepStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Room has been Edited.");
                        
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Method to delete existing Room
    public void deleteRoomDAO(String Code) {
        try {
            String query = "UPDATE m02rooms_master SET Status=? WHERE Room_Code=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, "I");
            prepStatement.setString(2, Code);
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Room Removed.");
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

        }
    }

    // Method to retrieve data set to be displayed in the Table
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT Room_code, Name, FB, HB, BB, Room_Only FROM m02rooms_master WHERE Status='A' ORDER BY Room_code ;";
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
