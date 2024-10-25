/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.Database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author asjad
 */

//Class to retrieve connection for database and login verfication.
public class ConnectionFactory {

    InputStream input;
    static final String driver = "com.mysql.cj.jdbc.Driver";
//    static final String driver = "com.mysql.jdbc.Driver";
    static String url = null;
    static String username;
    static String password;

    Properties prop;

    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public ConnectionFactory(){

        url = getProperties.getProperty("connection");
        username = getProperties.getProperty("username");
        password = getProperties.getProperty("password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public Connection getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("Connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
               JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }

    //Login verification method
    public String checkLogin(String username, String password){
        String uType = null;
        String query = " SELECT User_Type FROM users WHERE Name = '"+username+"' AND Password = '"+password+"' LIMIT 1";
        try {
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                uType = resultSet.getString("User_Type");
//                return true;
            }else{
                uType = "No";
//                return true;
            }
        } catch (SQLException ex) {
//            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
//        return false;
        return uType;
    }
}
