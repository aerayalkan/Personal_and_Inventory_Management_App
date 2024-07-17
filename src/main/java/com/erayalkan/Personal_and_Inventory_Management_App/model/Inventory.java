package com.erayalkan.Personal_and_Inventory_Management_App.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String model;
    private int quantity;
    private String serialNumber;
    private Date assignedDate;
    private Date returnDate;
    private boolean active;

}
