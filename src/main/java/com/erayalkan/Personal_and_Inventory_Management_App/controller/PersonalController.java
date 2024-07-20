package com.erayalkan.Personal_and_Inventory_Management_App.controller;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Personal;
import com.erayalkan.Personal_and_Inventory_Management_App.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalService.getAllPersonal();
    }

    @GetMapping("/{id}")
    public Optional<Personal> getPersonalById(@PathVariable Long id) {
        return personalService.getPersonalById(id);
    }

    @PostMapping
    public Personal createPersonal(@RequestBody Personal personal) {
        return personalService.savePersonal(personal);
    }

    @PutMapping("/{id}")
    public Personal updatePersonal(@PathVariable Long id, @RequestBody Personal personal) {
        personal.setId(id);
        return personalService.savePersonal(personal);
    }

    @DeleteMapping("/{id}")
    public void deletePersonal(@PathVariable Long id) {
        personalService.deletePersonal(id);
    }

    @GetMapping("/search")
    public List<Personal> searchPersonal(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String tckn,
            @RequestParam(required = false) String department) {
        return personalService.searchPersonals(name,surname,tckn,department);
    }


}
