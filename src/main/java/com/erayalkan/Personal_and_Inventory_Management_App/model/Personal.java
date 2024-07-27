package com.erayalkan.Personal_and_Inventory_Management_App.model;

import com.erayalkan.Personal_and_Inventory_Management_App.validator.ValidPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "personal")
public class Personal implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 50)
    private String surname;

    @NotNull
    @Size(min = 1, max = 1)
    private String gender;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthdayDate;

    @NotNull
    private String maritalStatus;

    @Column(nullable = false, unique = true)
    private String tckn;

    @NotNull
    private String employeeNumber;

    private String educationalStatus;

    @NotNull
    private String department;

    @NotNull
    private String position;

    @NotNull
    private boolean stillWork;

    private String profilePicture;

    @NotNull
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new HashSet<>();

    @NotBlank
    @ValidPassword
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Token> tokens = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return tckn;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors

    public Personal() {
    }

    public Personal(String name, String surname, String gender, Date birthdayDate, String maritalStatus, String tckn,
                    String employeeNumber, String educationalStatus, String department, String position, boolean stillWork,
                    String profilePicture, String password, Set<String> roles) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthdayDate = birthdayDate;
        this.maritalStatus = maritalStatus;
        this.tckn = tckn;
        this.employeeNumber = employeeNumber;
        this.educationalStatus = educationalStatus;
        this.department = department;
        this.position = position;
        this.stillWork = stillWork;
        this.profilePicture = profilePicture;
        this.password = password;
        this.roles = roles != null ? roles : new HashSet<>();
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(String educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isStillWork() {
        return stillWork;
    }

    public void setStillWork(boolean stillWork) {
        this.stillWork = stillWork;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles != null ? roles : new HashSet<>();
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
