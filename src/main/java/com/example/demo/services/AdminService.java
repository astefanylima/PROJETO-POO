package com.example.demo.services;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import com.example.demo.dto.AdminDTO;
import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository repository;

    public Page<AdminDTO> getAdmin(PageRequest pageRequest) {
        Page<Admin> list = repository.findAll(pageRequest);
        return list.map(e -> new AdminDTO(e));
    }

    public AdminDTO getAdminById(Long id) {
        Optional<Admin> op = repository.findById(id);
        Admin admin = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found by id"));
        return new AdminDTO(admin);
    }

    public AdminDTO insertAdmin(AdminDTO adminDTO) {
        
            Admin entity = new Admin(adminDTO);
            entity = repository.save(entity);
            return new AdminDTO(entity);

    }

    public void deleteAdmin(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }
    }

    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
       
            try {
                Admin entity = repository.getOne(id);
                entity.setName(adminDTO.getName());
                entity.setEmail(adminDTO.getEmail());
                entity.setPhoneNumber(adminDTO.getPhoneNumber());
                entity = repository.save(entity);
                return new AdminDTO(entity);
    
            } catch (EntityNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
            }

        }

}
