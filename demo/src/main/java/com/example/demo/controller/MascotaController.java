package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.MascotaDTO;
import com.example.demo.service.MascotaService;
import com.example.demo.service.ClienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
   
    @Autowired
    ClienteService clienteService;

    // Obtener todas las mascotas (Administradores)
    @GetMapping("/admin/todas")
    public ResponseEntity<List<Mascota>> mostrarMascotas() {
        List<Mascota> mascotas = mascotaService.SearchAll();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener todas las mascotas (Veterinarios)
    @GetMapping("/vet/todas")
    public ResponseEntity<List<Mascota>> mostrarMascotasVet() {
        List<Mascota> mascotas = mascotaService.SearchAll();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener una mascota por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<MascotaDTO> mostrarInfoMascota(@PathVariable("id") Long identificacion) {
        Mascota mascota = mascotaService.SearchById(identificacion);
        if (mascota != null) {
            // Mapear la entidad Mascota a MascotaDTO
            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(mascota.getId());
            mascotaDTO.setNombre(mascota.getNombre());
            mascotaDTO.setRaza(mascota.getRaza());
            mascotaDTO.setEdad(mascota.getEdad());
            mascotaDTO.setPeso(mascota.getPeso());
            mascotaDTO.setEnfermedad(mascota.getEnfermedad());
            mascotaDTO.setFoto(mascota.getFoto());
            mascotaDTO.setEstado(mascota.getEstado());
            mascotaDTO.setCedulaCliente(mascota.getCliente() != null ? mascota.getCliente().getCedula() : null);
            // Convertir los tratamientos si es necesario

            return ResponseEntity.ok(mascotaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // Agregar una nueva mascota (Administrador)
    @PostMapping("/admin/agregar")
    public ResponseEntity<Map<String, Object>> agregarMascota(@RequestBody Mascota mascota, @RequestParam("idCliente") Long cedula) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
            if (cliente != null) {
                mascota.setCliente(cliente);
                mascotaService.add(mascota);
                clienteService.agregarMascota(cliente.getCedula(), mascota);
                
                response.put("mensaje", "Mascota agregada exitosamente");
                response.put("mascota", mascota);
                return ResponseEntity.ok(response);
            } else {
                response.put("mensaje", "Cliente no encontrado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al agregar la mascota");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



    // Agregar una nueva mascota (Veterinario)
    @PostMapping("/vet/agregar")
    public ResponseEntity<String> agregarMascotaVet(@RequestBody Mascota mascota, @RequestParam("idCliente") Long cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
        if (cliente != null) {
            mascota.setCliente(cliente);
            mascotaService.add(mascota);
            clienteService.agregarMascota(cliente.getCedula(), mascota);
            return ResponseEntity.ok("Mascota agregada exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    // Eliminar una mascota (Administrador)
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Map<String, String>> borrarMascota(@PathVariable("id") Long identificacion) {
        mascotaService.borrarMascota(identificacion);
    
        Map<String, String> response = new HashMap<>();
        response.put("message", "Mascota eliminada exitosamente");
    
        return ResponseEntity.ok(response);
    }

    // Eliminar una mascota (Veterinario)
    @DeleteMapping("/vet/delete/{id}")
    public ResponseEntity<String> borrarMascotaVet(@PathVariable("id") Long identificacion) {
        mascotaService.borrarMascota(identificacion);
        return ResponseEntity.ok("Mascota eliminada exitosamente");
    }

    // Actualizar una mascota (Veterinario)
    @PutMapping("/update/vet/{id}")
    public ResponseEntity<MascotaDTO> actualizarMascotaVet(@PathVariable("id") Long identificacion, @RequestBody Mascota nuevaMascota) {
        Mascota mascotaExistente = mascotaService.SearchById(identificacion);
        if (mascotaExistente != null) {
            mascotaExistente.setNombre(nuevaMascota.getNombre());
            mascotaExistente.setRaza(nuevaMascota.getRaza());
            mascotaExistente.setEdad(nuevaMascota.getEdad());
            mascotaExistente.setPeso(nuevaMascota.getPeso());
            mascotaExistente.setEnfermedad(nuevaMascota.getEnfermedad());
            mascotaExistente.setEstado(nuevaMascota.getEstado());
            mascotaExistente.setFoto(nuevaMascota.getFoto());

            mascotaService.updateMascota(mascotaExistente);

            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(mascotaExistente.getId());
            mascotaDTO.setNombre(mascotaExistente.getNombre());
            mascotaDTO.setRaza(mascotaExistente.getRaza());
            mascotaDTO.setEdad(mascotaExistente.getEdad());
            mascotaDTO.setPeso(mascotaExistente.getPeso());
            mascotaDTO.setEnfermedad(mascotaExistente.getEnfermedad());
            mascotaDTO.setFoto(mascotaExistente.getFoto());
            mascotaDTO.setEstado(mascotaExistente.getEstado());
            mascotaDTO.setCedulaCliente(mascotaExistente.getCliente().getCedula());

            return ResponseEntity.ok(mascotaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Actualizar una mascota (Administrador)
    @PutMapping("/update/ad/{id}")
    public ResponseEntity<MascotaDTO> actualizarMascotaAdmin(@PathVariable("id") Long identificacion, @RequestBody Mascota nuevaMascota) {
        Mascota mascotaExistente = mascotaService.SearchById(identificacion);
        if (mascotaExistente != null) {
            mascotaExistente.setNombre(nuevaMascota.getNombre());
            mascotaExistente.setRaza(nuevaMascota.getRaza());
            mascotaExistente.setEdad(nuevaMascota.getEdad());
            mascotaExistente.setPeso(nuevaMascota.getPeso());
            mascotaExistente.setEnfermedad(nuevaMascota.getEnfermedad());
            mascotaExistente.setEstado(nuevaMascota.getEstado());
            mascotaExistente.setFoto(nuevaMascota.getFoto());

            mascotaService.updateMascota(mascotaExistente);

            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(mascotaExistente.getId());
            mascotaDTO.setNombre(mascotaExistente.getNombre());
            mascotaDTO.setRaza(mascotaExistente.getRaza());
            mascotaDTO.setEdad(mascotaExistente.getEdad());
            mascotaDTO.setPeso(mascotaExistente.getPeso());
            mascotaDTO.setEnfermedad(mascotaExistente.getEnfermedad());
            mascotaDTO.setFoto(mascotaExistente.getFoto());
            mascotaDTO.setEstado(mascotaExistente.getEstado());
            mascotaDTO.setCedulaCliente(mascotaExistente.getCliente().getCedula());

            return ResponseEntity.ok(mascotaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/activas")
    public ResponseEntity<Long> contarMascotasActivas() {
        long count = mascotaService.contarMascotasActivas();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/cantidad")
    public ResponseEntity<Long> contarMascotas(){
        long count = mascotaService.contarMascotas();
        return ResponseEntity.ok(count);
    }
    

}


