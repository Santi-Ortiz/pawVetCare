package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EquipoController {
    
    // localhost:8090/equipo
    @GetMapping("/equipo")
    public String home(){
        return "equipo";
    }

}
