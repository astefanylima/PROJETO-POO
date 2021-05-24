package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.dto.EventInsertDTO;

@Entity
@Table(name = "TB_EVENT")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String emailContact;
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Long priceTicket;
    private Long freeTickectsSelled;
    private Long payedTickectsSelled;

    @ManyToOne
    @JoinColumn(name="ADMIN_BASEUSER_ID")
    private Admin admin;
    
    @ManyToMany
    @JoinTable(
            name="TB_PLACE_EVENT",
            joinColumns =  @JoinColumn(name="EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name="PLACE_ID")
    )
    private List<Place> places = new ArrayList<>();
    
    @OneToMany( cascade = CascadeType.PERSIST)
    @JoinColumn(name="EVENT_ID")
    private List<Ticket> tickets = new ArrayList<>();
    
	public Event() {

    }

    public Event(EventInsertDTO eventInsertDTO) {
        this.description = eventInsertDTO.getDescription();
        this.name = eventInsertDTO.getName();
        this.startDate = eventInsertDTO.getStartDate();
        this.endDate = eventInsertDTO.getEndDate();
        this.startTime = eventInsertDTO.getStartTime();
        this.endTime = eventInsertDTO.getEndTime();
        this.emailContact = eventInsertDTO.getEmailContact();
        this.amountFreeTickets = eventInsertDTO.getAmountFreeTickets();
        this.amountPayedTickets = eventInsertDTO.getAmountPayedTickets();
        this.priceTicket = eventInsertDTO.getPriceTicket();
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
    
    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id != other.id)
            return false;
        return true;
    }

       

}