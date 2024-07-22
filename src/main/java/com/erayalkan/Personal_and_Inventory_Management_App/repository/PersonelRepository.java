package com.erayalkan.Personal_and_Inventory_Management_App.repository;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface PersonelRepository extends JpaRepository<Personal, Long> {

    @Query("SELECT p FROM Personal p WHERE " +
            "(?1 IS NULL OR p.name LIKE %?1%) AND " +
            "(?2 IS NULL OR p.surname LIKE %?2%) AND " +
            "(?3 IS NULL OR p.tckn = ?3) AND " +
            "(?4 IS NULL OR p.department = ?4)")
    List<Personal> search(String name, String surname, String tckn, String department);
    Personal findByEmployeeNumber(String employeeNumber);
    boolean existsByEmployeeNumber(String employeeNumber);
}
