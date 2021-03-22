package com.example.demo.services;

import com.example.demo.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Event client = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        return new EventDTO(event);
    }

}
