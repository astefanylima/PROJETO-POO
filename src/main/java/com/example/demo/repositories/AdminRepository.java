package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdminRepository extends JpaRepository <Admin,Long> {

   public Page<Admin> findAll(Pageable pageRequest);



}


