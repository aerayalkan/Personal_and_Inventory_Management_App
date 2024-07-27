package com.erayalkan.Personal_and_Inventory_Management_App.service;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Personal;
import com.erayalkan.Personal_and_Inventory_Management_App.repository.PersonelRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonelRepository personelRepository;

    public CustomUserDetailsService(PersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String tckn) throws UsernameNotFoundException {
        Personal personal = personelRepository.findByTckn(tckn)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with TCKN: " + tckn));
        return personal;
    }
}
