package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento,Long>{
    List<Tratamiento> findByVeterinario(Veterinario veterinario);
    List<Tratamiento> findByMascotaId(Long mascotaId);

    @Query("SELECT COUNT(t) FROM Tratamiento t WHERE t.fecha BETWEEN :inicioMes AND :diaActual")
    long contarTratamientosMesActual(@Param("inicioMes") Date inicioMes, @Param("diaActual") Date diaActual);

    @Query("SELECT t FROM Tratamiento t " +
           "JOIN t.tratamientoMedicamentos tm " +
           "GROUP BY t.id " +
           "ORDER BY COUNT(tm) DESC")
    List<Tratamiento> encontrarTop3Tratamientos();
} 