package com.erayalkan.Personal_and_Inventory_Management_App.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long I_id;
    private String type;
    private String brand;
    private String model;
    private int quantity;
    private String serialNumber;
    private Date assignedDate;
    private Date returnDate;
    private boolean active;


    public Inventory() {}
    public Inventory(Long I_id, String type, String brand, String model, int quantity, String serialNumber, Date assignedDate, Date returnDate, Boolean active) {
        this.I_id = I_id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.serialNumber = serialNumber;
        this.assignedDate = assignedDate;
        this.returnDate = returnDate;
        this.active = active;

    }

    //I_id
    public Long getI_id() {
        return I_id;

    }
    public void setI_id(Long I_id) {
        this.I_id = I_id;
    }

    //type
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //brand
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //model
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    //Quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //serialNumber
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    //AssignedDate
    public Date getAssignedDate() {
        return assignedDate;
    }
    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    //ReturnDate
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    //Active?
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }


}
