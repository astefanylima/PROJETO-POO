package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Event;
import com.example.demo.entities.Place;
import com.example.demo.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EventDTO {

    private Long id;
    private String name;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime startTime;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime endTime;

    private String emailContact;
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Long priceTicket;
    private Long freeTickectsSelled;
    private Long payedTickectsSelled;

    private Admin admin;
    private List<Place> places = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public EventDTO()
    {

    }
    
    public EventDTO(Long id, String name)
    {
        setId(id);
        setName(name);
    }
    
    public EventDTO(Event event)
    {
        setId(event.getId());
        setName(event.getName());
        setDescription(event.getDescription());
        setStartDate(event.getStartDate());
        setEndDate(event.getEndDate());
        setStartTime(event.getStartTime());
        setEndTime(event.getEndTime());
        setEmailContact(event.getEmailContact());
        setAdmin(event.getAdmin());
        setAmountFreeTickets(event.getAmountFreeTickets());
        setAmountPayedTickets(event.getAmountFreeTickets());
        setPriceTicket(event.getPriceTicket());
        setFreeTickectsSelled(event.getAmountFreeTickets());
        setPlaces(event.getPlaces());
        setTickets(event.getTickets());
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }

    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }

    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }

    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }

    public Long getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Long priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Long getFreeTickectsSelled() {
        return freeTickectsSelled;
    }

    public void setFreeTickectsSelled(Long freeTickectsSelled) {
        this.freeTickectsSelled = freeTickectsSelled;
    }

    public Long getPayedTickectsSelled() {
        return payedTickectsSelled;
    }

    public void setPayedTickectsSelled(Long payedTickectsSelled) {
        this.payedTickectsSelled = payedTickectsSelled;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }  

    
}
