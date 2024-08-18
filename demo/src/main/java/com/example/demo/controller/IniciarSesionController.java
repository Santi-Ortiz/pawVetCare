package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IniciarSesionController {
    
    // localhost:8090/iniciarSesion
    @GetMapping("/iniciarSesion")
    public String home(){
        return "iniciarSesion";
    }

}