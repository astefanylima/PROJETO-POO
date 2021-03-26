package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface EventRepository extends JpaRepository <Event,Long> {

    @Query("SELECT table FROM Event table ")
    public Page<Event> find(Pageable pageRequest);
    
}
