package com.example.demo.controller;

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
    
    // http://localhost:8090/admin/mascotas/{id}
    @GetMapping("/mascota/{id}")
    public String mostrarInfoMascotaAdmin(Model model, @PathVariable("id") Long identificacion){

        Mascota mascota = clienteService.buscarMascotaPorID(identificacion);
        Cliente cliente = clienteService.SearchByCedula(mascota.getIdCliente().intValue());

        if(mascota != null){
            model.addAttribute("mascota", mascota); 
            model.addAttribute("cliente", cliente); 
        } else {
            throw new NotPetFoundException(identificacion);
        } 

        model.addAttribute("mascota", clienteService.buscarMascotaPorID(identificacion)); 
        return "mostrarMascotaCliente";
    }

    @GetMapping("/mascotas/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long identificacion){
        model.addAttribute("cliente", clienteService.SearchById(identificacion));
        return "mascotasCliente";
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
