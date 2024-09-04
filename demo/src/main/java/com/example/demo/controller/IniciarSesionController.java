package com.example.demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/iniciarSesion")
public class IniciarSesionController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AdminService adminService;
    
    // localhost:8090/iniciarSesion/form
    @GetMapping("/form")
    public String home(){
        return "loginCliente";
    }

    @PostMapping("/form")
    public String loginCliente(@RequestParam("id") Long id, HttpSession session, Model model) {
        System.out.println("ID recibido: " + id); 
        try {
            Cliente cliente = clienteService.obtenerCliente(id);
            session.setAttribute("cliente", cliente);
            return "redirect:/iniciarSesion/inicio";
        } catch (NoSuchElementException e) {
            model.addAttribute("errorMessage", "Cliente no encontrado.");
            return "loginCliente";
        }
    }

    // http://localhost:8090/cliente/inicio
    @GetMapping("/inicio")
    public String inicioCliente(HttpSession session, Model model) { 
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        System.out.println("ID recibido: " + cliente.getCedula());
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente_mostrarTodasMascotas";
        }
        return "redirect:/iniciarSesion/form";
    }

    // http://localhost:8090/iniciarSesion/veterinario
    @GetMapping("/veterinario")
    public String inicioVeterinario() { 
        
        return "loginVeterinario";
    }

    // http://localhost:8090/iniciarSesion/admin
    @GetMapping("/admin")
    public String loginAdmin() { 
        return "loginAdmin";
    }

    @PostMapping("/adminform")
    public String sesionAdmin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model){
        try {
            Admin admin = adminService.findByUsuario(username);
            if(admin.getContrasena().equals(password)){
                session.setAttribute("admin", admin);
                return "redirect:/admin/mascotas";
            }else{
                model.addAttribute("errorMessage", "Contraseña incorrecta.");
                return "redirect:/iniciarSesion/admin";
            }
        } catch (NoSuchElementException e) {
            model.addAttribute("errorMessage", "Admin no encontrado.");
            return "loginAdmin";
        }
    }

    // http://localhost:8090/cliente/inicio
    @GetMapping("/sesiones")
    public String inicioSesion() { 
        
        return "iniciarSesion";
    }
}
