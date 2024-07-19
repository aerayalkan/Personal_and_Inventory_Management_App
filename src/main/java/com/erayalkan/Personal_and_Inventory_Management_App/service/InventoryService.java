package com.erayalkan.Personal_and_Inventory_Management_App.service;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Inventory;
import com.erayalkan.Personal_and_Inventory_Management_App.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }

    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }
}
