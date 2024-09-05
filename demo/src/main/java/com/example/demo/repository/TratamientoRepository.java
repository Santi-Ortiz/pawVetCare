package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento,Long>{
    
} 