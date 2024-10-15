package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MedicamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public ResponseEntity<Medicamento> obtenerMedicamentoPorId(@RequestParam Long id) {
        Medicamento medicamento = medicamentoService.SearchById(id);
        return ResponseEntity.ok(medicamento);
    }
    

}
