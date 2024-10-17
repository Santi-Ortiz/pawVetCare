package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.TratamientoMedicamento;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Medicamento;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.MedicamentoRepository;
import com.example.demo.repository.TratamientoMedicamentoRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.VeterinarioRepository;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;
    @Autowired
    private TratamientoMedicamentoRepository  tratamientoMedicamentoRepository;
    @Autowired
    private MedicamentoRepository medicamentoRepository;
    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private MascotaRepository mascotaRepository;

    @Transactional
  public Tratamiento agregarTratamiento(Tratamiento tratamiento, Medicamento medicamento, int cantidad) {
      // Guardar el tratamiento principal en la base de datos
      Tratamiento savedTratamiento = tratamientoRepository.save(tratamiento);

      // Verificar si hay suficientes unidades del medicamento
      if (medicamento.getUnidades_disponibles() < cantidad) {
          throw new RuntimeException("No hay suficientes unidades del medicamento " + medicamento.getNombre());
      }

      // Actualizar las unidades disponibles del medicamento
      medicamento.setUnidades_disponibles(medicamento.getUnidades_disponibles() - cantidad);
      medicamento.setUnidades_vendidas(cantidad);
      medicamentoRepository.save(medicamento);

      // Crear la instancia de la tabla intermedia TratamientoMedicamento
      TratamientoMedicamento tratamientoMedicamento = new TratamientoMedicamento();
      tratamientoMedicamento.setTratamiento(savedTratamiento);  // Asociar el tratamiento guardado
      tratamientoMedicamento.setMedicamento(medicamento);        // Asociar el medicamento
      tratamientoMedicamento.setCantidad(cantidad);              // Guardar la cantidad usada

      // Guardar la relación en la tabla intermedia
      tratamientoMedicamentoRepository.save(tratamientoMedicamento);

      // Devolver el tratamiento con sus relaciones actualizadas
      return savedTratamiento;
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