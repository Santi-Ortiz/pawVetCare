package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired 
    private ClienteService clienteService;

    // http://localhost:8090/cliente/login
    @GetMapping("/login")
    public String loginCliente(){
        return "loginCliente";
    }

    // http://localhost:8090/cliente/mascotas
    @GetMapping("/mascotas")
    public String mostrarMascotas(Model model){
        model.addAttribute("mascotas", clienteService.buscarMascotas());
        return "mostrarMascotasCliente";
    }

    @GetMapping("/mascota/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long identificacion){
        model.addAttribute("mascota", clienteService.buscarMascotaPorID(identificacion));
        return "mostrarMascotaClienteId";
    }
    
    
}
