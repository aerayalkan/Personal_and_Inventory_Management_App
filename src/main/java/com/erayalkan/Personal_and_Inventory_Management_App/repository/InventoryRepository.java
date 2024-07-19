package com.erayalkan.Personal_and_Inventory_Management_App.repository;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
