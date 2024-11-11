package com.example.demo.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired 
    private ClienteService clienteService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailService;

    @Autowired 
    private MascotaService mascotaService;

    // Obtener información de una mascota específica del cliente
    @GetMapping("/mascota/{id}")
    public ResponseEntity<Mascota> obtenerInfoMascotaCliente(@PathVariable("id") Long idMascota, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente != null) {
            List<Mascota> mascotasLista = cliente.getMascotas();
            for (Mascota mascota : mascotasLista) {
                if (mascota.getId().equals(idMascota)) {
                    return ResponseEntity.ok(mascota);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Mascota no encontrada
    }

    // Obtener todas las mascotas del cliente autenticado
    @GetMapping("/mascotas")
    public ResponseEntity<List<Mascota>> obtenerTodasMascotasCliente() {
        String correo = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Correo autenticado: " + correo);
        Cliente cliente = clienteService.obtenerClientePorCedula(Long.valueOf(correo));
        if (cliente != null) {
            List<Mascota> mascotas = cliente.getMascotas();
            return ResponseEntity.ok(mascotas);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }



    // Obtener todos los clientes
    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteService.mostrarTodos();
        return ResponseEntity.ok(clientes);
    }

    // Obtener un cliente por su ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.obtenerCliente(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente); // Retorna el cliente encontrado
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Cliente no encontrado
    }

    @GetMapping("/find/cedula/{cedula}")
    public ResponseEntity<Cliente> obtenerClientePOrCedula(@PathVariable("cedula") Long cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
        if (cliente != null) {
            return ResponseEntity.ok(cliente); // Retorna el cliente encontrado
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Cliente no encontrado
    }
    


    // Agregar un nuevo cliente
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.toList()));
        }

        // Verificar si el username ya existe
        if (userRepository.existsByUsername(cliente.getCedula().toString())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El username ya existe");
        }
        
        try {
            Cliente clienteaux = new Cliente(cliente.getCedula(), cliente.getNombre(), cliente.getCorreo(), cliente.getCelular());
            UserEntity userEntity = customUserDetailService.saveCliente(clienteaux);
            clienteaux.setUser(userEntity);

            Cliente newCliente = clienteService.add(clienteaux);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al agregar el cliente: " + e.getMessage());
        }
    }



    // Actualizar información de un cliente (admin)
    @PutMapping("/update/admin/{id}")
    public ResponseEntity<Cliente> actualizarInfoClienteAdmin(@PathVariable("id") Long identificacion, @RequestBody Cliente cliente) {
        Cliente existingCliente = clienteService.obtenerCliente(identificacion);
        if (existingCliente != null) {
            // Verificar si la cédula ya pertenece a otro cliente
            Cliente clienteConMismaCedula = clienteService.obtenerClientePorCedula(cliente.getCedula());
            if (clienteConMismaCedula != null && !clienteConMismaCedula.getId().equals(existingCliente.getId())) {
                throw new ClientUpdatingException(cliente.getCedula());
            }

            existingCliente.setCelular(cliente.getCelular());
            existingCliente.setCorreo(cliente.getCorreo());
            existingCliente.setNombre(cliente.getNombre());

            clienteService.update(existingCliente);

            List<Mascota> mascotas = existingCliente.getMascotas();
            for (Mascota mascota : mascotas) {
                mascota.setCliente(existingCliente);
                mascotaService.updateMascota(mascota);
            }

            return ResponseEntity.ok(existingCliente); // Cliente actualizado exitosamente
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Cliente no encontrado
    }

    // Actualizar información de un cliente (vet)
    @PutMapping("/update/vet/{id}")
    public ResponseEntity<Cliente> actualizarInfoClienteVet(@PathVariable("id") Long identificacion, @RequestBody Cliente cliente) {
        Cliente existingCliente = clienteService.obtenerCliente(identificacion);
        if (existingCliente != null) {
            existingCliente.setCedula(cliente.getCedula());
            existingCliente.setCelular(cliente.getCelular());
            existingCliente.setCorreo(cliente.getCorreo());
            existingCliente.setNombre(cliente.getNombre());

            clienteService.update(existingCliente);

            List<Mascota> mascotas = existingCliente.getMascotas();
            for (Mascota mascota : mascotas) {
                mascota.setCliente(existingCliente);
                mascotaService.updateMascota(mascota);
            }

            return ResponseEntity.ok(existingCliente); // Cliente actualizado exitosamente
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Cliente no encontrado
    }

    // Eliminar un cliente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> borrarCliente(@PathVariable("id") Long identificacion) {
        // Buscar el cliente en la base de datos
        Cliente cliente = clienteService.obtenerClientePorCedula(identificacion);

        // Verificar si el cliente existe
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Cliente no encontrado, devolver 404
        }

        try {
            clienteService.eliminarCliente(identificacion);

            if (clienteService.obtenerClientePorCedula(identificacion)==null) {
                return ResponseEntity.noContent().build(); // Cliente eliminado exitosamente
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Falló la eliminación
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante la eliminación
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Error al eliminar
        }
    }

}
