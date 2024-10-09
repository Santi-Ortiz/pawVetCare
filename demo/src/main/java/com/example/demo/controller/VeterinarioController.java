package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

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
}

