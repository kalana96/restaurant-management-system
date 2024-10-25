/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant.DTO;

/**
 *
 * @author asjad
 */

// Data Transfer Object (DTO) class for Users

public class UserDTO {


    private String userID, userName, password, userType, InTime, OutTime;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getInTime() {
        return InTime;
    }

    public void setInTime(String InTime) {
        this.InTime = InTime;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String OutTime) {
        this.OutTime = OutTime;
    }





}
