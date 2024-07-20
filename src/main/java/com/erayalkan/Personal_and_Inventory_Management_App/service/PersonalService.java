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
    private PersonelRepository PersonelRepository;

    public List<Personal> getAllPersonal(){
        return PersonelRepository.findAll();
    }


    public Personal createPersonal(Personal personal) {
        return PersonelRepository.save(personal);
    }

    public Optional<Personal> getPersonalById(long id){
        return PersonelRepository.findById(id);
    }

    public Personal savePersonal(Personal personal){
        return PersonelRepository.save(personal);
    }

    public Personal updatePersonal(Long id, Personal personal) {
        Personal existingPersonal = PersonelRepository.findById(id).orElse(null);
        if (existingPersonal != null) {
            existingPersonal.setName(personal.getName());
            existingPersonal.setSurname(personal.getSurname());
            existingPersonal.setGender(personal.getGender());
            existingPersonal.setBirthdayDate(personal.getBirthdayDate());
            existingPersonal.setMaritalStatus(personal.getMaritalStatus());
            existingPersonal.setTckn(personal.getTckn());
            existingPersonal.setEmployeeNumber(personal.getEmployeeNumber());
            existingPersonal.setEducationalStatus(personal.getEducationalStatus());
            existingPersonal.setDepartment(personal.getDepartment());
            existingPersonal.setPosition(personal.getPosition());
            existingPersonal.setStillWork(personal.isStillWork());
            existingPersonal.setRoles(personal.getRoles());
            return PersonelRepository.save(existingPersonal);
        }
        return null;
    }

    public void deletePersonal(long id){
        PersonelRepository.deleteById(id);
    }

    public List<Personal> searchPersonals(String name, String surname, String tckn, String department) {
        return PersonelRepository.search(name,surname,tckn,department);
    }

}
