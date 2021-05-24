package com.example.demo.dto;

import com.example.demo.entities.Admin;

public class AdminDTO {

   public Long id;
   public String phoneNumber;
   public String name;
   public String email;

    public AdminDTO()
    {

    }
    
    public AdminDTO(Long id, String phoneNumber, String name, String email)
    {
        setId(id);
        setPhoneNumber(phoneNumber);
        setName(name);
        setEmail(email);
    }
    
    public AdminDTO(Admin admin)
    {
        setId(admin.getId());
        setPhoneNumber(admin.getPhoneNumber());
        setName(admin.getName());
        setEmail(admin.getEmail());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
