package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTGenerator;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.VeterinarioService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/sesion")
public class IniciarSesionController {
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private VeterinarioService vetService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTGenerator jwtGenerator;
    
    // localhost:8090/api/sesion/cliente
    @PostMapping("/cliente")
    public ResponseEntity<?> loginCliente(@RequestParam("id") Long id) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(id, "123")
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales erróneas.");
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
    public ResponseEntity<?> sesionVet(@RequestParam("cedula") Long cedula, @RequestParam("password") String password){
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(cedula, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vet no encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales erróneas.");
        }
    }

    // http://localhost:8090/api/sesion/admin
    @PostMapping("/admin")
    public ResponseEntity<?> sesionAdmin(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin no encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales erróneas.");
        }
    }
}