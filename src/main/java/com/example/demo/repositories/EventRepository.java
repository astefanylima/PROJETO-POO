package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EventRepository extends JpaRepository <Event,Long> {

    
}
