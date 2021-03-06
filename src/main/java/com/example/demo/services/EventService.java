package com.example.demo.services;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.EventInsertDTO;
import com.example.demo.dto.EventUpdateDTO;
import com.example.demo.entities.Event;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;
    @Autowired
    private AdminRepository adminrepository;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String description, String emailContact, LocalDate startDate) {
        Page<Event> list = repository.find(pageRequest, name, description, emailContact, startDate);
        return list.map(e -> new EventDTO(e));
    }

    public EventDTO getEventById(Long id) {
        Optional<Event> op = repository.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found by id"));
        return new EventDTO(event);
    }

    
    public EventDTO insertEvent(EventInsertDTO eventInsertDTO) {

        if (eventInsertDTO.getStartDate().compareTo(eventInsertDTO.getEndDate()) > 0) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "The end date should be bigger than the start date!");
        } else {
            Event entity = new Event(eventInsertDTO);
            if(adminrepository.existsById(eventInsertDTO.getIdAdmin())==false)
            entity.setAdmin(null);
            else
            entity.setAdmin(adminrepository.findById(eventInsertDTO.getIdAdmin()).get());
            entity = repository.save(entity);
            return new EventDTO(entity);
        }
    }


    public void deleteEvent(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    public EventDTO updateEvent(Long id, EventUpdateDTO eventUpdateDTO) {
       
        
        if (eventUpdateDTO.getStartDate().compareTo(eventUpdateDTO.getEndDate()) > 0) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "The end date should be bigger than the start date!");
        } else {
        {
            try {
                Event entity = repository.getOne(id);
                entity.setName(eventUpdateDTO.getName());
                entity = repository.save(entity);
                return new EventDTO(entity);
    
            } catch (EntityNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
            }

        }
        
        
    }


}
}
