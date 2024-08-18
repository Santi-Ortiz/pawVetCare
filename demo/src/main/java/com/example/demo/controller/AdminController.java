package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/mascotas")
    public String mostrarMascotasAdmin(Model model){
        model.addAttribute("mascotas", adminService.SearchAllPets());
        return "mascotasAdmin";
        //mascotaController.mostrarMascotas(model);
    }

    @GetMapping("/mascotas/{id}")
    public String mostrarInfoMascotaAdmin(Model model, @PathVariable("id") Long identificacion){
        model.addAttribute("mascota", adminService.SearchPetById(identificacion)); 
        return "mostrarMascotaAdmin";
    }
    
}
