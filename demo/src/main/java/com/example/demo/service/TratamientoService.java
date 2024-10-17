package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Medicamento;
import com.example.demo.repository.TratamientoRepository;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Transactional
    public void agregarTratamiento (Date fecha, Veterinario veterinario, Mascota mascota, List<Medicamento> medicamentos){
        tratamientoRepository.save(new Tratamiento(fecha, veterinario, mascota));
    }

    @Transactional
    public void eliminarTratamiento(Long id){
      tratamientoRepository.delete(tratamientoRepository.findById(id).get());
    }

    public long obtenerTotalTratamientosMesActual() {
      // Obtener el primer día del mes actual
      LocalDate inicioMes = LocalDate.now().withDayOfMonth(1);

      // Obtener el día actual
      LocalDate diaActual = LocalDate.now();

      // Convertir LocalDate a java.sql.Date
      Date inicioMesSql = Date.valueOf(inicioMes);
      Date diaActualSql = Date.valueOf(diaActual);

      // Llamar al repositorio con las fechas convertidas
      return tratamientoRepository.contarTratamientosMesActual(inicioMesSql, diaActualSql);
    }

    public List<Tratamiento> obtenerTop3Tratamientos() {
      return tratamientoRepository.encontrarTop3Tratamientos().stream()
              .limit(3)
              .collect(Collectors.toList());
    }

}