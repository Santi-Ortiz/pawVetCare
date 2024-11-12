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
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.VeterinarioDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.EspecialidadService;
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

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailService;

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
    public ResponseEntity<List<VeterinarioDTO>> obtenerTodosLosVeterinarios() {
        List<VeterinarioDTO> veterinariosDTO = veterinarioService.mostrarTodosConDTO();
        return ResponseEntity.ok(veterinariosDTO);
    }

    // Se obtiene un veterinario por su cedula
    @GetMapping("/find/{cedula}")
    public ResponseEntity<VeterinarioDTO> obtenerVetPorCedula(@PathVariable("cedula") Long cedula) {
        VeterinarioDTO veterinario = veterinarioService.obtenerVeterinarioPorCedula(cedula);
        if (veterinario != null) {
            return ResponseEntity.ok(veterinario);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
    }
    

    // Se obtiene un veterinario por su ID
    @GetMapping("/findID/{id}")
    public ResponseEntity<VeterinarioDTO> obtenerVetPorID(@PathVariable("id") Long id) {
        VeterinarioDTO veterinario = veterinarioService.obtenerPorID(id);
        if (veterinario != null) {
            return ResponseEntity.ok(veterinario);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
    }


    // Se agrega un veterinario nuevo
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarVet(@RequestBody Veterinario veterinario) {
        System.out.println("nombre:" + veterinario.getNombre());
        try {
            // Verificar si el veterinario ya existe por la cédula (username)
            if (userRepository.existsByUsername(veterinario.getCedula().toString())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: La cédula ya está en uso.");
            }

            // Crear el usuario asociado al veterinario
            UserEntity userEntity = customUserDetailService.saveVet(veterinario);
            veterinario.setUser(userEntity);


            // Guardar el veterinario en la base de datos
            Veterinario auxVet = new Veterinario(veterinario.getCedula(), veterinario.getContrasena(), veterinario.getFoto(), veterinario.getNombre(), veterinario.getEstado(), veterinario.getEspecialidad());
            Veterinario newVeterinario = veterinarioService.agregarVet(auxVet);

            if (newVeterinario == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: No se pudo guardar el veterinario.");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(newVeterinario);
        } catch (Exception ex) {
            // Manejar errores generales y devolver un mensaje genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Ocurrió un error al guardar el veterinario: " + ex.getMessage());
        }
    }


    @PutMapping("/update/{cedula}")
    public ResponseEntity<VeterinarioDTO> actualizarInfoVet(@PathVariable("cedula") Long cedula, @RequestBody VeterinarioDTO veterinarioActualizado) {
        Veterinario existingVet = veterinarioService.buscarVetPorCedula(cedula);
        
        if (existingVet != null) {
            // Verificar si la cédula ya pertenece a otro veterinario
            Veterinario vetConMismaCedula = veterinarioService.buscarVetPorCedula(veterinarioActualizado.getCedula());
            if (vetConMismaCedula != null && !vetConMismaCedula.getId().equals(existingVet.getId())) {
                // Si la cédula ya está en uso por otro veterinario, retornar error
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null); 
            }

            // Guardar cambios
            veterinarioService.actualizarVet(veterinarioActualizado);

            return ResponseEntity.ok(veterinarioActualizado);
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

