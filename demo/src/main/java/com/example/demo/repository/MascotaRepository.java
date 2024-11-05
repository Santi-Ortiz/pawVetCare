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

    @Query("SELECT m FROM Mascota m WHERE m.nombre = :nombre")
    List<Mascota> findAllByNombre(@Param("nombre") String nombre);

    @Query("SELECT m FROM Mascota m WHERE m.estado = :estado")
    List<Mascota> findAllByEstado(@Param("estado") Boolean estado);

    @Query("SELECT m FROM Mascota m WHERE m.edad BETWEEN :edadInicio AND :edadFin")
    List<Mascota> findAllByEdadBetween(@Param("edadInicio") Integer edadInicio, @Param("edadFin") Integer edadFin);

}