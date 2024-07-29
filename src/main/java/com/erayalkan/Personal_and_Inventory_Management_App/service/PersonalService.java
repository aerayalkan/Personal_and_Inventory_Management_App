package com.erayalkan.Personal_and_Inventory_Management_App.service;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Personal;
import com.erayalkan.Personal_and_Inventory_Management_App.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonalService {

    @Autowired
    private PersonelRepository personelRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Personal> getAllPersonal(){
        return personelRepository.findAll();
    }

    public Personal createPersonal(Personal personal) {
        personal.setPassword(passwordEncoder.encode(personal.getPassword())); // Encode the password before saving

        // Rol ataması
        if (personal.getRoles() == null || personal.getRoles().isEmpty()) {
            Set<String> roles = new HashSet<>();
            roles.add("ROLE_USER");
            personal.setRoles(roles);
        }

        return personelRepository.save(personal);
    }

    public Optional<Personal> getPersonalById(long id){
        return personelRepository.findById(id);
    }

    public Personal savePersonal(Personal personal){
        personal.setPassword(passwordEncoder.encode(personal.getPassword())); // Encode the password before saving
        return personelRepository.save(personal);
    }

    public Personal updatePersonal(Long id, Personal personal) {
        Personal existingPersonal = personelRepository.findById(id).orElse(null);
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
            if (personal.getPassword() != null && !personal.getPassword().isEmpty()) {
                existingPersonal.setPassword(passwordEncoder.encode(personal.getPassword())); // Encode the password before updating
            }
            return personelRepository.save(existingPersonal);
        }
        return null;
    }

    public void deletePersonal(long id){
        personelRepository.deleteById(id);
    }

    public List<Personal> searchPersonals(String name, String surname, String tckn, String department) {
        return personelRepository.search(name,surname,tckn,department);
    }

    public boolean existsByEmployeeNumber(String employeeNumber) {
        return personelRepository.existsByEmployeeNumber(employeeNumber);
    }

    public Personal getByEmployeeNumber(String employeeNumber) {
        return personelRepository.findByEmployeeNumber(employeeNumber);
    }
}
