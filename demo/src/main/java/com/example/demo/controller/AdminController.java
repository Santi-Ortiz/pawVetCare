package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Mascota;
import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // http://localhost:8090/admin/mascotas
    @GetMapping("/mascotas")
    public String mostrarMascotasAdmin(Model model){
        model.addAttribute("mascotas", adminService.SearchAllPets());
        return "mascotasAdmin";
        //mascotaController.mostrarMascotas(model);
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

        model.addAttribute("mascota", adminService.SearchPetById(identificacion)); 
        return "mostrarMascotaAdmin";
    }

    // http://localhost:8090/admin/clientes
    @GetMapping("/clientes")
    public String mostrarClientesAdmin(Model model){
        model.addAttribute("clientes", adminService.SearchAllClients());
        return "clientesAdmin";
    }

    // http://localhost:8090/admin/cliente/{id}
    @GetMapping("/cliente/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") Long identificacion) {
        model.addAttribute("cliente", adminService.SearchClientById(identificacion));
        return "mostrarClienteAdmin";
    }
    
}
