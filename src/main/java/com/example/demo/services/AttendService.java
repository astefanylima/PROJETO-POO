package com.example.demo.services;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import com.example.demo.dto.AttendDTO;
import com.example.demo.entities.Attend;
import com.example.demo.repositories.AttendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendService {
    
    @Autowired
    private AttendRepository repository;

    public Page<AttendDTO> getAttend(PageRequest pageRequest) {
        Page<Attend> list = repository.findAll(pageRequest);
        return list.map(e -> new AttendDTO(e));
    }

    public AttendDTO getAttendById(Long id) {
        Optional<Attend> op = repository.findById(id);
        Attend attend = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found by id"));
        return new AttendDTO (attend);
    }

    public AttendDTO insertAttend(AttendDTO attendDTO) {
        
            Attend entity = new Attend(attendDTO);
            entity = repository.save(entity);
            return new AttendDTO(entity);

    }

    public void deleteAttend(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        }
    }

    public AttendDTO updateAttend(Long id, AttendDTO attendDTO) {
       
            try {
                Attend entity = repository.getOne(id);
                entity.setName(attendDTO.getName());
                entity.setEmail(attendDTO.getEmail());
                entity.setBalance(attendDTO.getBalance());
                entity = repository.save(entity);
                return new AttendDTO(entity);
    
            } catch (EntityNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
            }

        }
}
