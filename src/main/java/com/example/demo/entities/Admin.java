package com.example.demo.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.demo.dto.AdminDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_ADMIN")
@PrimaryKeyJoinColumn(name="BASEUSER_ID")
public class Admin extends BaseUser {

	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin")
	private List<Event> events = new ArrayList<>();
	
	public Admin() {
		
	}
	
	public Admin(AdminDTO dto) {
		this.setName(dto.getName());
		this.setEmail(dto.getEmail());
		this.setPhoneNumber(dto.getPhoneNumber());
	}
	
	public Admin(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Admin(String phoneNumber, Long id, String name, String email) {
		super(id,name,email);
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void addEvents(Event event) {
		this.events.add(event);
	}

}