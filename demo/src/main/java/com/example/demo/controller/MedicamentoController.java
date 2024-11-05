package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MedicamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Medicamento;


@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {
    
    @Autowired
    private MedicamentoService medicamentoService;

    // Obtener todos los medicamentos
    @GetMapping("/todos")
    public ResponseEntity<List<Medicamento>> obtenerTodosMedicamentos() {
        List<Medicamento> medicamentos = medicamentoService.SearchAll();
        return ResponseEntity.ok(medicamentos);
    }

    // Obtener medicamento por id
    @GetMapping("/find/{id}")
    public ResponseEntity<Medicamento> obtenerMedicamentoPorId(@PathVariable("id") Long id) {
        Optional<Medicamento> medicamento = Optional.ofNullable(medicamentoService.SearchById(id));
        return medicamento.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Se extraen las ventas totales de la veterinaria
    @GetMapping("/ventas-totales")
    public ResponseEntity<Double> obtenerVentasTotales(){
        Double ventas = medicamentoService.calcularVentasTotales();
        return ResponseEntity.ok(ventas);
    }

    // Se extraen las ganancias netas de la veterinaria
    @GetMapping("/ganancias-totales")
    public ResponseEntity<Double> obtenerGananciasTotales(){
        Double gananciasTotales = medicamentoService.calcularGananciasTotales();
        return ResponseEntity.ok(gananciasTotales); 
    }

    // Se extraen los costos totales de la veterinaria
    @GetMapping("/costos-totales")
    public ResponseEntity<Double> obtenerCostosTotales(){
        Double costosTotales = medicamentoService.calcularCostosTotales();
        return ResponseEntity.ok(costosTotales);
    }
    

}
