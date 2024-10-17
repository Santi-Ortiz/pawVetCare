package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    long count();

    Long countByEstadoTrue();

    Long countByEstadoFalse();

    public Mascota findByNombre(String nombre);
    
    List<Mascota> findByNombreContainingIgnoreCase(String nombre);

}