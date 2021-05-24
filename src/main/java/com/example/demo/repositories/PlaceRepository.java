package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Place;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PlaceRepository extends JpaRepository <Place,Long> {

   public Page<Place> findAll(Pageable pageRequest);

}
