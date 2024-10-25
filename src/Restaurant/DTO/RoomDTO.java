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

// Data Transfer Object (DTO) class for Customers

public class RoomDTO {

    private String roomCode, roomName, roomType, description;
    private Double  FBPrice, HBPrice, BBPrice, ROPrice;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFBPrice() {
        return FBPrice;
    }

    public void setFBPrice(Double FBPrice) {
        this.FBPrice = FBPrice;
    }

    public Double getHBPrice() {
        return HBPrice;
    }

    public void setHBPrice(Double HBPrice) {
        this.HBPrice = HBPrice;
    }

    public Double getBBPrice() {
        return BBPrice;
    }

    public void setBBPrice(Double BBPrice) {
        this.BBPrice = BBPrice;
    }

    public Double getROPrice() {
        return ROPrice;
    }

    public void setROPrice(Double ROPrice) {
        this.ROPrice = ROPrice;
    }



    

}
