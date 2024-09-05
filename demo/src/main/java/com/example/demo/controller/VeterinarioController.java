package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

@Controller
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
        System.out.println("ID recibido: " + mascota.getIdCliente().getCedula());

        if(mascota != null){
            model.addAttribute("mascota", mascota); 
            model.addAttribute("clienteCedula", mascota.getIdCliente().getCedula());
        } else {
            throw new NotPetFoundException(identificacion);
        } 

        return "vet_mostrarInfo1Mascota";
    }

    // Método para redirigir al ID específico
    @GetMapping("/busqueda")
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
}
