package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.TratamientoMedicamento;

@Repository
public interface TratamientoMedicamentoRepository extends JpaRepository<TratamientoMedicamento, Long> {
  
    // Consulta para obtener el número de tratamientos que usaron un tipo de medicamento en el último mes
    @Query("SELECT tm.tratamiento, COUNT(tm.medicamento) " +
       "FROM TratamientoMedicamento tm " +
       "WHERE tm.tratamiento.fecha BETWEEN :inicioMes AND :diaActual " +
       "GROUP BY tm.tratamiento " +
       "ORDER BY COUNT(tm.medicamento) DESC")
    Collection<Object[]> encontrarTratamientosPorMedicamentos(@Param("inicioMes") Date inicioMes, @Param("diaActual") Date diaActual);
}
