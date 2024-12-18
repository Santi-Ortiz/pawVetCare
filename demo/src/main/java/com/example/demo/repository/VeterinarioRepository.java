package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Long>{
    public Veterinario findByCedula(Long cedula);
    long count();
    Long countByEstadoTrue();
    Long countByEstadoFalse();
} 
