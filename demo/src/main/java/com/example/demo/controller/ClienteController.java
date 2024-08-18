package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ClienteService;

@RequestMapping("/cliente")
public class ClienteController {

    @Autowired 
    private ClienteService ClienteService;

    @GetMapping("/PagInicio_Clientes")
    public String mostrarPaginaInicio(Model model){
        return "clientesPagInicio";
    }
    
}
