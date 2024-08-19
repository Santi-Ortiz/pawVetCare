package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Mascota;
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
        return "mascotasCliente";
    }

    @GetMapping("/mascota/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long identificacion){
        model.addAttribute("mascota", clienteService.buscarMascotaPorID(identificacion));
        return "mostrarMascotaCliente";
    }

    // http://localhost:8090/mascota/todas
    @GetMapping("/todos")
    public String mostrarClientes(Model model){
       model.addAttribute("clientes", clienteService.SearchAll());
       return "mascotasAdmin";
    }
    
    // http://localhost:8090/cliente/agregar
      @PostMapping("/agregar")
      public String mostrar_agregar_mascota(@ModelAttribute("cliente") Mascota cliente) {
         clienteService.add(cliente);
         return "redirect:/cliente/todos";
     }
    
}
