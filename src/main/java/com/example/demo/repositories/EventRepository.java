package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import com.example.demo.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EventRepository extends JpaRepository <Event,Long> {

        @Query("SELECT e FROM Event e " + 
           "WHERE " +
           " LOWER(e.name)               LIKE   LOWER(CONCAT('%', :name, '%')) AND " +
           " LOWER(e.description)        LIKE   LOWER(CONCAT('%', :description, '%')) AND " +
           " e.startDate                  >     :startDate                       AND " +
           " LOWER(e.emailContact)      LIKE   LOWER(CONCAT('%', :emailContact, '%'))")

        public Page<Event> find(Pageable pageRequest, 
                                String name,
                                String description,
                                String emailContact,
                                LocalDate startDate
                                );

}
