package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.service.ClienteService;

@Controller
@RequestMapping("/registrame")
public class RegistroController {

    @Autowired
    ClienteService clienteService;

    // localhost:8090/registrame/form

    /*@GetMapping("/form")
    public String mostrarFormularioRegistro(Model model) {
            
        return "registro";  
    }*/

    @PostMapping("/form")
    public String registrarme(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.add(cliente);  
        return "redirect:/login"; 
    }

}
