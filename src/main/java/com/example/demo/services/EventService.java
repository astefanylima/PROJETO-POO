package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.EventInsertDTO;
import com.example.demo.dto.EventUpdateDTO;
import com.example.demo.entities.Event;
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
    private EventRepository repo;

    public List<EventDTO> getEvent() {
        List<Event> list = repo.findAll();
        return toDTOList(list);
    }

    public EventDTO getEventById(Long id) {
        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        return new EventDTO(event);
    }

    public EventDTO insert(EventInsertDTO insertDTO) {
        Event entity = new Event(insertDTO);
        entity = repo.save(entity);
        return new EventDTO(entity);
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    public EventDTO update(Long id, EventUpdateDTO updateDTO) {
        try {
            Event entity = repo.getOne(id);
            entity.setName(updateDTO.getName());
            entity.setDescription(updateDTO.getDescription());
            entity.setPlace(updateDTO.getPlace());
            entity.setStartDate(updateDTO.getStartDate());
            entity.setEndDate(updateDTO.getEndDate());
            entity.setStartTime(updateDTO.getStartTime());
            entity.setEndTime(updateDTO.getEndTime());
            entity.setEmailContact(updateDTO.getEmailContact());
            entity = repo.save(entity);

            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    private List<EventDTO> toDTOList(List<Event> list) {
        List<EventDTO> listDTO = new ArrayList<>();

        for (Event c : list) {
            listDTO.add(new EventDTO(c.getId(), c.getName(), c.getDescription(), c.getPlace(), c.getStartDate(), c.getEndDate(), c.getStartTime(), c.getEndTime(), c.getEmailContact()));
        }
        return listDTO;
    }

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name, String description, String place, LocalDate startDate) {

        Page<Event> list = repo.find(pageRequest, name, description, place, startDate);
        return list.map( c -> new EventDTO(c));
    }


}
