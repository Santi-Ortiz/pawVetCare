package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TratamientoService;

@RestController
@RequestMapping("/api/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/tratamientos-ultimo-mes")
    public ResponseEntity<Long> getTratamientosUltimoMes() {
        long totalTratamientos = tratamientoService.obtenerTotalTratamientosMesActual();
        return ResponseEntity.ok(totalTratamientos);
    }
    
}
