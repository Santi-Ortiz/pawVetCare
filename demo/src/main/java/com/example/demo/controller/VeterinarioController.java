package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

/*@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private MascotaService MascotaService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClienteService clientService;
    
    @GetMapping("/mascotas")
     public String mostrarMascotas(Model model){
         model.addAttribute("mascota", new Mascota());
         model.addAttribute("mascotas", MascotaService.SearchAll());
         return "vet_MostrarTodasMascotas";
     }

     // http://localhost:8090/admin/mascotas/{id}
    @GetMapping("/mascotas/{id}")
    public String mostrarInfoMascotaVet(Model model, @PathVariable("id") Long identificacion){

        Mascota mascota = adminService.SearchPetById(identificacion);
        System.out.println("ID recibido: " + mascota.getCliente().getCedula());

        if(mascota != null){
            model.addAttribute("mascota", mascota); 
            model.addAttribute("clienteCedula", mascota.getCliente().getCedula());
        } else {
            throw new NotPetFoundException(identificacion);
        } 

        return "vet_mostrarInfo1Mascota";
    }

    // Método para redirigir al ID específico
    @GetMapping("/busqueda/mascota")
    public String redirectToMascota(@RequestParam("id") Long id) {
        return "redirect:/veterinario/mascotas/" + id;
 
    }

    // http://localhost:8090/admin/mascotas/todas
    @GetMapping("/mascotas/todas")
    public String mostraradmin_mostrarTodasLasMascotas(Model model){
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("mascotas", adminService.SearchAllPets());
        return "vet_MascotasTodas";
        //mascotaController.mostrarMascotas(model);
    }

    // http://localhost:8090/veterinario/clientes
    @GetMapping("/clientes")
    public String mostrarClientesAdmin(Model model){
        model.addAttribute("clientes", adminService.SearchAllClients());
        model.addAttribute("cliente", new Cliente());
        return "vet_mostrarTodosClientes";
    }

    // http://localhost:8090/veterinario/clientes/todos    
    @GetMapping("/clientes/todos")
    public String mostrarClientesTodosAdmin(Model model){
        model.addAttribute("clientes", adminService.SearchAllClients());
        model.addAttribute("cliente", new Cliente());
        return "vet_ClientesTodos";
    }

    // http://localhost:8090/admin/cliente/{id}
    @GetMapping("/cliente/{cedula}")
    public String mostrarCliente(Model model, @PathVariable("cedula") Long cedula) {
        Cliente cliente = clientService.obtenerClientePorCedula(cedula);

        if(cliente != null){
           model.addAttribute("cliente", cliente); 
        } else {
           throw new NotPetFoundException(cedula);
        }

        return "vet_MostrarInfoCliente";
    }
}*/

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
    @GetMapping("/agregar")
    public ResponseEntity<Veterinario> agregarVet(@RequestBody Veterinario veterinario) {
        veterinarioService.agregarVet(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/update/{cedula}")
    public ResponseEntity<Veterinario> actualizarInfoVet(@PathVariable("cedula") Long cedula) {
        Veterinario existingVet = veterinarioService.buscarVet(cedula);
        if(existingVet != null){
            // Verificar si la cédula ya pertenece a otro veterinario
            Veterinario vetConMismaCedula = veterinarioService.buscarVetPorCedula(existingVet.getCedula());
            if (vetConMismaCedula != null && !vetConMismaCedula.getId().equals(existingVet.getId())) {
                // throw new VetUpdatingException(existingVet.getCedula()); // TODO: Implementar esta excepción cuando se quiera modificar la cédula de un vet y ya exista
                System.out.println("Ya existe un veterinario con la cédula ingresada");
            }

            existingVet.setCedula(existingVet.getCedula());
            existingVet.setContrasena(existingVet.getContrasena());
            existingVet.setFoto(existingVet.getFoto());
            existingVet.setNombre(existingVet.getNombre());
            existingVet.setEspecialidad(existingVet.getEspecialidad()); // TODO: Hacer validación de especialidad existente

            // Se actualiza el veterinario
            veterinarioService.actualizarVet(existingVet);

            return ResponseEntity.ok(existingVet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // El veterinario no existe
        }
    }

    // Se elimina un veterinario por su cédula
    @DeleteMapping("/delete/{cedula}")
    public ResponseEntity<Void> borrarVet(@PathVariable Long cedula){

        Veterinario vet = veterinarioService.buscarVetPorCedula(cedula);
        if(vet == null){
            // El veterinario no se encontró
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            veterinarioService.eliminarVet(cedula);
            if(veterinarioService.buscarVetPorCedula(cedula) == null){
                // Validación que el veterinario fue eliminado
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Error al eliminar
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Error al eliminar

    }
     
}

