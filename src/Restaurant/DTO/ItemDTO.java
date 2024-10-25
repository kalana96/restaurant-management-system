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

public class ItemDTO {

    private String itemCode, categoryCode, itemName;
    private Double  costPrice, retailPrice, uberPrice, takePrice;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    
    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getUberPrice() {
        return uberPrice;
    }

    public void setUberPrice(Double uberPrice) {
        this.uberPrice = uberPrice;
    }

    public Double getTakePrice() {
        return takePrice;
    }

    public void setTakePrice(Double takePrice) {
        this.takePrice = takePrice;
    }

    

}
