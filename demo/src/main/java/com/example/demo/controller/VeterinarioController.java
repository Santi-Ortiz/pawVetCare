package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.MascotaService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private MascotaService MascotaService;
    
    @GetMapping("/mascotas")
     public String mostrarMascotas(Model model){
        model.addAttribute("mascotas", MascotaService.SearchAll());
        return "mascotasAdmin";
     }
}
