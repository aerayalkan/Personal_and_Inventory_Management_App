package com.erayalkan.Personal_and_Inventory_Management_App.repository;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonelRepository extends JpaRepository<Personal, Long> {

}
