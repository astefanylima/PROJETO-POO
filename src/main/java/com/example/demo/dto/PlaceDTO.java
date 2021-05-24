package com.example.demo.dto;

import com.example.demo.entities.Place;


public class PlaceDTO {

    private Long id;
    private String name;
    private String address;

    public PlaceDTO()
    {

    }
    
    public PlaceDTO(Long id, String name, String address)
    {
        setId(id);
        setName(name);
        setAddress(address);
    }
    
    public PlaceDTO(Place place)
    {
        setId(place.getId());
        setName(place.getName());
        setAddress(place.getAddress());
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

}
