package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EventDTO;
import com.example.demo.dto.EventInsertDTO;
import com.example.demo.entities.Event;
import com.example.demo.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

    private List<EventDTO> toDTOList(List<Event> list) {
        List<EventDTO> listDTO = new ArrayList<>();

        for (Event c : list) {
            listDTO.add(new EventDTO(c.getId(), c.getName(), c.getDescription(), c.getPlace(), c.getStartDate(), c.getEndDate(), c.getStartTime(), c.getEndTime(), c.getEmailContact()));
        }
        return listDTO;
    }



}
