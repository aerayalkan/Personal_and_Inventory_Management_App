package com.erayalkan.Personal_and_Inventory_Management_App.model;

import com.erayalkan.Personal_and_Inventory_Management_App.validator.ValidPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Personal {
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
    @Size(min = 1,max = 1)
    private String gender;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthdayDate;

    @NotNull
    private String maritalStatus;

    @NotNull
    @Size(min=11, max =11)
    @Column(unique = true)
    private String tckn;

    @NotNull
    private int employeeNumber;

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
    private Set<String> roles;

    @NotBlank
    @ValidPassword
    @Column(nullable = false)
    private String password;

    //getters Setters


    public Personal() {
    }
    public Personal(String name, String surname, String gender, Date birthdayDate,String maritalStatus, String tckn, int employeeNumber,
                    String educationalStatus, String department, String position, boolean stillWork, String profilePicture,String password) {
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
        this.roles = roles !=null ? roles : new HashSet<>();
        this.password = password;
    }


    //getters and setters

    //id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //birthdayDate
    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    //maritalStatus
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    //tckn
    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    //employeeNumber
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    //educationalStatus
    public String getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(String educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    //department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //position
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    //stillWork
    public boolean isStillWork() {
        return stillWork;
    }

    public void setStillWork(boolean stillWork) {
        this.stillWork = stillWork;
    }

    //profilePicture
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    //roles
    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles != null ? roles : new HashSet<>();
    }

    //Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}