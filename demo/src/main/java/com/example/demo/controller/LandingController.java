package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LandingController {
    
    // localhost:8090/home
    @GetMapping("/home")
    public String home(){
        return "landingPage";
    }

    @GetMapping("/login")
    public String mostrarLogin(Model model){
        return "loginCliente";
    }
}
