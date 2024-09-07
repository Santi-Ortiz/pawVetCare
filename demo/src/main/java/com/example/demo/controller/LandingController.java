package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
