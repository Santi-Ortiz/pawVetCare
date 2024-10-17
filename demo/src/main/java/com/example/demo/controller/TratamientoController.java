package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tratamiento;
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

    @GetMapping("/top3")
    public ResponseEntity<List<Tratamiento>> getTop3Tratamientos() {
        List<Tratamiento> top3 = tratamientoService.obtenerTop3Tratamientos();
        return ResponseEntity.ok(top3);
    }
}
