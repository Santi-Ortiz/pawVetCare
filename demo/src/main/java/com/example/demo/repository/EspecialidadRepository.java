package com.example.demo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Long>{
    public Optional<Especialidad> findByNombreEspecialidad(String nombreEspecialidad);
} 

