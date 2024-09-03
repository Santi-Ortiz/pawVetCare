package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.Cliente;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ClienteService clienteService;

    // http://localhost:8090/admin/mascotas
    @GetMapping("/mascotas")
    public String mostrarMascotasAdmin(Model model){
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("mascotas", adminService.SearchAllPets());
        return "admin_mostrarTodasMascotas";
        //mascotaController.mostrarMascotas(model);
    }

      // http://localhost:8090/admin/mascotas/todas
      @GetMapping("/mascotas/todas")
      public String mostraradmin_mostrarTodasLasMascotas(Model model){
          model.addAttribute("mascota", new Mascota());
          model.addAttribute("mascotas", adminService.SearchAllPets());
          return "admin_MascotasTodas";
          //mascotaController.mostrarMascotas(model);
      }

    // Método para redirigir al ID específico
    @GetMapping("/busqueda")
    public String redirectToMascota(@RequestParam("id") Long id) {
        return "redirect:/admin/mascotas/" + id;
 
    }

    // http://localhost:8090/admin/mascotas/{id}
    @GetMapping("/mascotas/{id}")
    public String mostrarInfoMascotaAdmin(Model model, @PathVariable("id") Long identificacion){

        Mascota mascota = adminService.SearchPetById(identificacion);

        if(mascota != null){
            model.addAttribute("mascota", mascota); 
        } else {
            throw new NotPetFoundException(identificacion);
        } 

        return "admin_mostrarInfo1Mascota";
    }

    // http://localhost:8090/admin/clientes
    @GetMapping("/clientes")
    public String mostrarClientesAdmin(Model model){
        model.addAttribute("clientes", adminService.SearchAllClients());
        model.addAttribute("cliente", new Cliente());
        return "admin_mostrarTodosClientes";
    }

    // http://localhost:8090/admin/cliente/{id}
    @GetMapping("/cliente/{cedula}")
    public String mostrarCliente(Model model, @PathVariable("cedula") Long cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);

        if(cliente != null){
           model.addAttribute("cliente", cliente); 
        } else {
           throw new NotPetFoundException(cedula);
        }

        return "admin_MostrarInfoCliente";
    }
 
}
