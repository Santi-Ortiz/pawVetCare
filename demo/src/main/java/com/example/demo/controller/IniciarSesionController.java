package com.example.demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.VeterinarioService;

import jakarta.servlet.http.HttpSession;

/*@Controller
@RequestMapping("/iniciarSesion")
public class IniciarSesionController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private VeterinarioService vetService;
    
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

    // http://localhost:8090/iniciarSesion/adminform
    @PostMapping("/veterinarioform")
    public String sesionVet(@RequestParam("cedula") Long cedula, @RequestParam("password") String password, HttpSession session, Model model){
        try {
            Veterinario vet = vetService.buscarVet(cedula);
            if(vet.getContrasena().equals(password)){
                session.setAttribute("vet", vet);
                return "redirect:/veterinario/mascotas";
            }else{
                model.addAttribute("errorMessage", "Contraseña incorrecta.");
                return "redirect:/iniciarSesion/veterinario";
            }
        } catch (NoSuchElementException e) {
            model.addAttribute("errorMessage", "Veterinario no encontrado.");
            return "loginVeterinario";
        }
    }

    // http://localhost:8090/iniciarSesion/admin
    @GetMapping("/admin")
    public String loginAdmin() { 
        return "loginAdmin";
    }

    // http://localhost:8090/iniciarSesion/adminform
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
}*/
@RestController
@RequestMapping("/api/sesion")
public class IniciarSesionController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private VeterinarioService vetService;
    
    // localhost:8090/api/sesion/cliente
    @PostMapping("/cliente")
    public ResponseEntity<?> loginCliente(@RequestParam("id") Long id, HttpSession session) {
        try {
            Cliente cliente = clienteService.obtenerCliente(id);
            session.setAttribute("cliente", cliente);
            return ResponseEntity.ok(cliente);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
        }
    }

    // http://localhost:8090/api/sesion/cliente/inicio
    @GetMapping("/cliente/inicio")
    public ResponseEntity<?> inicioCliente(HttpSession session) { 
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente != null) {
            return ResponseEntity.ok(cliente); 
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No hay sesión activa.");
    }

    // http://localhost:8090/api/sesion/veterinario
    @PostMapping("/veterinario")
    public ResponseEntity<?> sesionVet(@RequestParam("cedula") Long cedula, @RequestParam("password") String password, HttpSession session){
        try {

            Veterinario vet = vetService.buscarVetPorCedula(1234L);
            System.out.println(vet.getNombre());
            if (vet.getContrasena().equals(password)) {
                session.setAttribute("vet", vet);
                return ResponseEntity.ok(vet); 
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta.");
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinario no encontrado.");
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<?> sesionAdmin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        try {
            Admin admin = adminService.findByUsuario(username);
            if (admin.getContrasena().equals(password)) {
                session.setAttribute("admin", admin);
                return ResponseEntity.ok(admin);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta.");
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin no encontrado.");
        }
    }

}

