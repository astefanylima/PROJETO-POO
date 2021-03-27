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

    @Query("SELECT table FROM Event table " +  
    "WHERE " +
    "LOWER(table.name)          LIKE    LOWER(CONCAT('%', :name, '%')) AND " +
    "LOWER(table.description)   LIKE    LOWER(CONCAT('%', :description, '%')) AND " +
    "LOWER(table.place)         LIKE    LOWER(CONCAT('%', :place, '%')) AND " +
    "table.startDate            >       :startDate"
)
public Page<Event> find(Pageable pageRequest, String name, String description, String place, LocalDate startDate);

}
