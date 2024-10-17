package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TratamientoMedicamentoService;

@RestController
@RequestMapping("/api/tratamiento-medicamento")
public class TratamientoMedicamentoController {
    
    @Autowired
    private TratamientoMedicamentoService tratamientoMedicamentoService;

    @GetMapping("/tratamientos-por-medicamentos")
    public ResponseEntity<Collection<Object[]>> getTratamientosPorMedicamentos() {
        Collection<Object[]> tratamientosPorMedicamentos = tratamientoMedicamentoService.obtenerTratamientosPorMedicamentos();
        return ResponseEntity.ok(tratamientosPorMedicamentos);
    }
}
