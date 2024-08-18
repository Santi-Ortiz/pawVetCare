package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MascotaService;
@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
          
    // http://localhost:8080/mascota/todas
     @GetMapping("/todas")
     public String mostrarMascotas(Model model){
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mascotasAdmin";
     }

     // http://localhost:8080/mascota/find/
     @GetMapping("/find/{id}")
     public String mostrarInfoMascota(Model model, @PathVariable("id") int identificacion ){
        model.addAttribute("mascota", mascotaService.SearchById(identificacion)); 
        return "mostrarMascotaAdmin";
     }

}
