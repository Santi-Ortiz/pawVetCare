package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Cliente;

@Controller
//@RequestMapping("")
public class LandingController {
    
    // localhost:8090/
    @GetMapping("/")
    public String home(){
        return "landingPage";
    }

    // localhost:8090/contacto
    @GetMapping("/contacto")
    public String contacto(){
        return "contacto";
    }

    // localhost:8090/equipo
    @GetMapping("/equipo")
    public String equipo(){
        return "equipo";
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model){
        return "loginCliente";
    }

    // localhost:8090/registro
    @GetMapping("/registro")
    public String registro(Model model){
        model.addAttribute("cliente", new Cliente());
        return "registro";
    }
}
