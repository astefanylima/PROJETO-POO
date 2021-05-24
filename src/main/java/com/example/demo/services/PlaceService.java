package com.example.demo.services;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import com.example.demo.dto.PlaceDTO;
import com.example.demo.entities.Place;
import com.example.demo.repositories.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository repository;

    public Page<PlaceDTO> getPlace(PageRequest pageRequest) {
        Page<Place> list = repository.findAll(pageRequest);
        return list.map(e -> new PlaceDTO(e));
    }

    public PlaceDTO getPlaceById(Long id) {
        Optional<Place> op = repository.findById(id);
        Place place = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found by id"));
        return new PlaceDTO(place);
    }

    public PlaceDTO insertPlace(PlaceDTO placeDTO) {
        
            Place entity = new Place(placeDTO);
            entity = repository.save(entity);
            return new PlaceDTO(entity);
    }

    public void deletePlace(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
        }
    }

    public PlaceDTO updatePlace(Long id, PlaceDTO placeDTO) {
       
            try {
                Place entity = repository.getOne(id);
                entity.setName(placeDTO.getName());
                entity.setAddress(placeDTO.getAddress());
                entity = repository.save(entity);
                return new PlaceDTO(entity);
    
            } catch (EntityNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
            }
        }
}
