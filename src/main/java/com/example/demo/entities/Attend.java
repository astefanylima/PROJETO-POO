package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.demo.dto.AttendDTO;


@Entity
@Table(name="TB_ATTEND")
@PrimaryKeyJoinColumn(name="BASEUSER_ID")
public class Attend extends BaseUser{
    private static final long serialVersionUID = 1L;
	
	private double balance;
	
	@OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ATTEND_ID")
    private List<Ticket> tickets = new ArrayList<>();
	
	public Attend() {
		
	}
	
	public Attend(AttendDTO dto) {
		this.setName(dto.getName());
		this.setEmail(dto.getEmail());
		this.setBalance(dto.getBalance());
	}

	public Attend(double balance) {
		this.balance = balance;
	}
	
	public Attend(double balance, Long id, String name, String email) {
		super(id,name,email);
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
