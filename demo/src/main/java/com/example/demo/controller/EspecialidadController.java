package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Especialidad;
import com.example.demo.service.AdminService;
import com.example.demo.service.EspecialidadService;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {
    
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/all")
    public ResponseEntity<List<Especialidad>> obtenerTodasEspecialidades() {
        List<Especialidad> especialidades = especialidadService.obtenerTodasEspecialidades();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

}
