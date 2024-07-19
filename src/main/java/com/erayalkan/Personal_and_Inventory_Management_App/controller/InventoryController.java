package com.erayalkan.Personal_and_Inventory_Management_App.controller;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Inventory;
import com.erayalkan.Personal_and_Inventory_Management_App.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Inventory")
public class InventoryController {

    @Autowired
    private InventoryService InventoryService;

    @GetMapping
    public List<Inventory> getAllInventory() {
        return InventoryService.getAllInventory();
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory Inventory) {
        return InventoryService.saveInventory(Inventory);
    }

}
