package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.Cliente;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ClienteService clienteService;

    // Obtener todas las mascotas
    @GetMapping("/mascotas")
    public ResponseEntity<List<Mascota>> obtenerTodasMascotas() {
        List<Mascota> mascotas = adminService.SearchAllPets();
        return ResponseEntity.ok(mascotas); // Retorna lista de mascotas
    }

    // Obtener todas las mascotas - otra ruta
    @GetMapping("/mascotas/todas")
    public ResponseEntity<List<Mascota>> obtenerMascotasTodas() {
        List<Mascota> mascotas = adminService.SearchAllPets();
        return ResponseEntity.ok(mascotas); // Retorna lista de mascotas
    }

    // Redirigir a una mascota específica por ID
    @GetMapping("/busqueda/mascota")
    public ResponseEntity<Mascota> redirigirAMascota(@RequestParam("id") Long id) {
        Mascota mascota = adminService.SearchPetById(id);
        if (mascota != null) {
            return ResponseEntity.ok(mascota);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Mascota no encontrada
        }
    }

    // Obtener mascota por ID
    @GetMapping("/mascotas/{id}")
    public ResponseEntity<Mascota> obtenerMascotaPorId(@PathVariable("id") Long id) {
        Mascota mascota = adminService.SearchPetById(id);
        if (mascota != null) {
            return ResponseEntity.ok(mascota);
        } else {
            throw new NotPetFoundException(id);
        }
    }

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosClientes() {
        List<Cliente> clientes = adminService.SearchAllClients();
        return ResponseEntity.ok(clientes);
    }

    // Obtener todos los clientes - otra ruta
    @GetMapping("/clientes/todos")
    public ResponseEntity<List<Cliente>> obtenerClientesTodos() {
        List<Cliente> clientes = adminService.SearchAllClients();
        return ResponseEntity.ok(clientes);
    }

    // Obtener cliente por cédula
    @GetMapping("/cliente/{cedula}")
    public ResponseEntity<Cliente> obtenerClientePorCedula(@PathVariable("cedula") Long cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            throw new NotPetFoundException(cedula);
        }
    }

    // Obtener todos los veterinarios
    @GetMapping("/veterinarios")
    public ResponseEntity<List<Mascota>> obtenerTodosVeterinarios() {
        List<Mascota> mascotas = adminService.SearchAllPets();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener todos los veterinarios - otra ruta
    @GetMapping("/veterinarios/todos")
    public ResponseEntity<List<Mascota>> obtenerVeterinariosTodos() {
        List<Mascota> mascotas = adminService.SearchAllPets();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener veterinario por ID
    @GetMapping("/veterinarios/{id}")
    public ResponseEntity<Mascota> obtenerVeterinarioPorId(@PathVariable("id") Long id) {
        Mascota mascota = adminService.SearchPetById(id);
        if (mascota != null) {
            return ResponseEntity.ok(mascota);
        } else {
            throw new NotPetFoundException(id);
        }
    }

    // Obtener dashboard (Este puede ser una lista de estadísticas o similar)
    @GetMapping("/dashboard")
    public ResponseEntity<String> obtenerDashboard() {
        return ResponseEntity.ok("Datos del dashboard del administrador");
    }

    // Inicialización (este método parece estático, devolver datos aquí)
    @GetMapping("/inicializacion")
    public ResponseEntity<String> obtenerInicializacion() {
        return ResponseEntity.ok("Datos de inicialización del administrador");
    }

}


