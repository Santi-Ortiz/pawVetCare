package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Mascota;
import com.example.demo.service.AdminService;
import com.example.demo.service.MascotaService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private MascotaService MascotaService;
    @Autowired
    private AdminService adminService;
    
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
}
