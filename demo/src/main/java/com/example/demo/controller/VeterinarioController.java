package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.example.demo.service.VeterinarioService;


@RestController
@RequestMapping("/api/veterinario")
public class VeterinarioController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

    // Obtener todas las mascotas (Veterinario)
    @GetMapping("/mascotas")
    public ResponseEntity<List<Mascota>> mostrarMascotas() {
        List<Mascota> mascotas = mascotaService.SearchAll();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener la información de una mascota por su ID (Veterinario)
    @GetMapping("/mascotas/{id}")
    public ResponseEntity<Mascota> mostrarInfoMascotaVet(@PathVariable("id") Long identificacion) {
        Mascota mascota = adminService.SearchPetById(identificacion);
        if (mascota != null) {
            return ResponseEntity.ok(mascota);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
    }

    // Redirigir a una mascota por su ID (Redirección por parte del cliente)
    @GetMapping("/busqueda/mascota")
    public ResponseEntity<String> redirectToMascota(@RequestParam("id") Long id) {
        // En lugar de redirigir, retornamos la URL que el frontend puede usar para la redirección
        String redirectUrl = "/api/veterinario/mascotas/" + id;
        return ResponseEntity.ok(redirectUrl);
    }

    // Obtener todas las mascotas (Veterinario, admin compartido)
    @GetMapping("/mascotas/todas")
    public ResponseEntity<List<Mascota>> mostrarTodasLasMascotas() {
        List<Mascota> mascotas = adminService.SearchAllPets();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener todos los clientes (Veterinario)
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> mostrarClientesVet() {
        List<Cliente> clientes = adminService.SearchAllClients();
        return ResponseEntity.ok(clientes);
    }

    // Obtener todos los clientes (Veterinario, admin compartido)
    @GetMapping("/clientes/todos")
    public ResponseEntity<List<Cliente>> mostrarClientesTodosVet() {
        List<Cliente> clientes = adminService.SearchAllClients();
        return ResponseEntity.ok(clientes);
    }

    // Obtener la información de un cliente por su cédula (Veterinario)
    @GetMapping("/cliente/{cedula}")
    public ResponseEntity<Cliente> mostrarCliente(@PathVariable("cedula") Long cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
    }

    // Se obtienen todos los veterinarios registrados
    @GetMapping("/todos")
    public ResponseEntity<List<Veterinario>> obtenerTodosLosVets() {
        List<Veterinario> veterinarios = (List<Veterinario>) veterinarioService.mostrarTodos();
        return ResponseEntity.ok(veterinarios);
    }

    // Se obtiene un veterinario por su ID
    @GetMapping("/find/{cedula}")
    public ResponseEntity<Veterinario> obtenerVetPorId(@PathVariable("cedula") Long cedula) {
        Veterinario veterinario = veterinarioService.buscarVetPorCedula(cedula);
        if (veterinario != null) {
            return ResponseEntity.ok(veterinario);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
    }

    // Se agrega un veterinario nuevo
    @PostMapping("/agregar")
    public ResponseEntity<Veterinario> agregarVet(@RequestBody Veterinario veterinario) {
        veterinarioService.agregarVet(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/update/{cedula}")
public ResponseEntity<Veterinario> actualizarInfoVet(@PathVariable("cedula") Long cedula, @RequestBody Veterinario veterinarioActualizado) {
    Veterinario existingVet = veterinarioService.buscarVet(cedula);
    
    if (existingVet != null) {
        // Verificar si la cédula ya pertenece a otro veterinario
        Veterinario vetConMismaCedula = veterinarioService.buscarVetPorCedula(veterinarioActualizado.getCedula());
        if (vetConMismaCedula != null && !vetConMismaCedula.getId().equals(existingVet.getId())) {
            // Si la cédula ya está en uso por otro veterinario, retornar error
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); 
        }

        // Actualizar datos del veterinario
        existingVet.setCedula(veterinarioActualizado.getCedula());
        existingVet.setContrasena(veterinarioActualizado.getContrasena());
        existingVet.setFoto(veterinarioActualizado.getFoto());
        existingVet.setNombre(veterinarioActualizado.getNombre());
        existingVet.setEspecialidad(veterinarioActualizado.getEspecialidad());

        // Guardar cambios
        veterinarioService.actualizarVet(existingVet);

        return ResponseEntity.ok(existingVet);
    } else {
        // Veterinario no encontrado
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}

    // Se elimina un veterinario por su cédula
    @DeleteMapping("/delete/{cedula}")
    public ResponseEntity<Void> borrarVet(@PathVariable("cedula") Long cedula) {
        Veterinario existingVet = veterinarioService.buscarVetPorCedula(cedula);
        if (existingVet != null) {
            veterinarioService.eliminarVet(cedula);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/activos")
    public ResponseEntity<Long> contarVeterinariosActivos() {
        long count = veterinarioService.contarVeterinariosActivos();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<Long> contarVeterinariosInactivos() {
        long count = veterinarioService.contarVeterinariosInactivos();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/total")
    public ResponseEntity<Long> contarVeterinarios() {
        long count = veterinarioService.contarVeterinarios  ();
        return ResponseEntity.ok(count);
    }
    
     
}

