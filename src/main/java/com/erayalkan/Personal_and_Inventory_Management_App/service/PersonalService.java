package com.erayalkan.Personal_and_Inventory_Management_App.service;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Personal;
import com.erayalkan.Personal_and_Inventory_Management_App.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {

    @Autowired
    private PersonelRepository personelRepository;

    public List<Personal> getAllPersonal(){
        return personelRepository.findAll();
    }

    public Optional<Personal> getPersonalById(long id){
        return personelRepository.findById(id);
    }

    public Personal savePersonal(Personal personal){
        return personelRepository.save(personal);
    }

    public void deletePersonal(long id){
        personelRepository.deleteById(id);
    }

}
