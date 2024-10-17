package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TratamientoMedicamentoRepository;

@Service
public class TratamientoMedicamentoService {

    @Autowired
    private TratamientoMedicamentoRepository tratamientoMedicamentoRepository;

    public Collection<Object[]> obtenerTratamientosPorMedicamentos() {

        // Obtener el primer día del mes actual
      LocalDate inicioMes = LocalDate.now().withDayOfMonth(1);

      // Obtener el día actual
      LocalDate diaActual = LocalDate.now();

      // Convertir LocalDate a java.sql.Date
      Date inicioMesSql = Date.valueOf(inicioMes);
      Date diaActualSql = Date.valueOf(diaActual);
        return tratamientoMedicamentoRepository.encontrarTratamientosPorMedicamentos(inicioMesSql,diaActualSql);
    }

}
