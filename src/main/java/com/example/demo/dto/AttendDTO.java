package com.example.demo.dto;

import com.example.demo.entities.Attend;


public class AttendDTO {

    private Long id;
    private String name;
    private String email;
    private Double balance;
   
    public AttendDTO()
    {

    }
    
    public AttendDTO(Long id, String name, String email, Double balance)
    {
        setId(id);
        setName(name);
        setEmail(email);
        setBalance(balance);
    }
    
    public AttendDTO(Attend attend)
    {
        setId(attend.getId());
        setName(attend.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
}
