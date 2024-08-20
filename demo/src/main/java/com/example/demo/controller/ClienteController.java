package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.service.ClienteService;

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
    
    // http://localhost:8090/cliente/mascotas/{id_cliente}
    @GetMapping("/mascota/{id}")
    public String mostrarInfoMascotaAdmin(Model model, @PathVariable("id") Long identificacion){

        Cliente cliente = clienteService.obtenerCliente(identificacion);
        List<Mascota> mascotasLista = cliente.getMascotas();
        
        if(mascotasLista != null){
            model.addAttribute("mascota", mascotasLista); 
            model.addAttribute("cliente", cliente); 
        } else {
            throw new NotPetFoundException(identificacion);
        } 

        model.addAttribute("mascota", mascotasLista); 
        return "mostrarMascotaCliente";
    }

    // http://localhost:8090/cliente/mascotas/{id}
    @GetMapping("/mascotas/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") Long identificacion){
        model.addAttribute("cliente", clienteService.obtenerCliente(identificacion));
        return "mascotasCliente";
    }

    // http://localhost:8090/cliente/todos
    @GetMapping("/todos")
    public String mostrarClientes(Model model){
       model.addAttribute("clientes", clienteService.mostrarTodos());
       return "mascotasAdmin";
    }
    
    // http://localhost:8090/cliente/agregar
      @PostMapping("/agregar")
      public String mostrar_agregar_cliente(@ModelAttribute("cliente") Cliente cliente) {
         clienteService.agregarCliente(cliente);
         return "redirect:/cliente/todos";
     }
    
}
