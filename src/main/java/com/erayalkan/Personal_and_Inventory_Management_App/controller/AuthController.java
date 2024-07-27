/*
package com.erayalkan.Personal_and_Inventory_Management_App.controller;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Personal;
import com.erayalkan.Personal_and_Inventory_Management_App.repository.PersonelRepository;
import com.erayalkan.Personal_and_Inventory_Management_App.service.CustomUserDetailsService;
import com.erayalkan.Personal_and_Inventory_Management_App.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PersonelRepository personalRepository;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmployeeNumber(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid employee number or password", e);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getEmployeeNumber());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @PostMapping("/register")
    public Personal register(@RequestBody Personal personal) throws Exception {
        return personalRepository.save(personal);
    }
}

class AuthRequest {
    private String employeeNumber;
    private String password;

    // Getter and Setter for employeeNumber
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

 */
