package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Attend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AttendRepository extends JpaRepository <Attend,Long> {

   public Page<Attend> findAll(Pageable pageRequest);
}
