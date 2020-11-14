package com.g2academy.jsonbasic01.domain;


import java.time.LocalDate;

public class People {


    private Integer Id;
    private String Name;
    private LocalDate dob;
    private String Address;
    private String email;
    private String description;

    public People(Integer id, String name, LocalDate dob, String address, String email, String description) {
        Id = id;
        Name = name;
        this.dob = dob;
        Address = address;
        this.email = email;
        this.description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public String toString() {
        return "People{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", dob=" + dob +
                ", Address='" + Address + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
