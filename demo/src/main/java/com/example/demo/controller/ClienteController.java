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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.service.ClienteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired 
    private ClienteService clienteService;

    // http://localhost:8090/cliente/login
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "loginCliente"; 
    }

    @PostMapping("/login")
    public String loginCliente(@RequestParam("id") Long id, HttpSession session, Model model) {
        System.out.println("ID recibido: " + id); 
        try {
            Cliente cliente = clienteService.obtenerCliente(id);
            session.setAttribute("cliente", cliente);
            return "redirect:/cliente/inicio";
        } catch (NoSuchElementException e) {
            model.addAttribute("errorMessage", "Cliente no encontrado.");
            return "loginCliente";
        }
    }

    // http://localhost:8090/cliente/inicio
    @GetMapping("/inicio")
    public String inicioCliente(HttpSession session, Model model) { 
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        System.out.println("ID recibido: " + cliente.getId());
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "mascotasCliente";
        }
        return "redirect:/cliente/login";
    }
    
    // http://localhost:8090/cliente/mascota/{id}
    @GetMapping("/mascota/{id}")
    public String mostrarInfoMascotaAdmin(@PathVariable("id") Long idMascota, HttpSession session, Model model) {
    Cliente cliente = (Cliente) session.getAttribute("cliente");
    if (cliente != null) {
        List<Mascota> mascotasLista = cliente.getMascotas();
        Mascota mascotaSeleccionada = mascotasLista.stream()
                                                    .filter(m -> m.getId().equals(idMascota))
                                                    .findFirst()
                                                    .orElse(null);

        if (mascotaSeleccionada != null) {
            model.addAttribute("mascota", mascotaSeleccionada);
            model.addAttribute("cliente", cliente);
            return "mostrarMascotaCliente";
        } else {
            // Manejo de mascota no encontrada
            throw new NotPetFoundException(idMascota);
        }
    } else {
        // Manejo de cliente no encontrado en la sesión
        return "redirect:/cliente/login";
    }
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
       return "clientesAdmin";
    }

    @GetMapping("/add")
    public String agregarCliente(Model model, Cliente cliente){
        model.addAttribute("cliente", cliente);
        return "clientesAdmin";
    }

    // http://localhost:8090/cliente/agregar
    @PostMapping("/agregar")
      public String mostrar_agregar_cliente(@ModelAttribute("cliente") Cliente cliente) {
         clienteService.agregarCliente(cliente);
         return "redirect:/cliente/todos";
    }

    // http://localhost:8090/mascota/update/{id}
    @GetMapping("/update/{id}")
    public String actualizarInfoCliente(@PathVariable("id") Long identificacion, Model model) {
     Cliente cliente = clienteService.obtenerCliente(identificacion);
     model.addAttribute("cliente", cliente);
     return "mostrarClienteAdmin"; // Asegúrate de que esta vista tenga el formulario
  }

    // http://localhost:8090/mascota/update/{id}
    @PostMapping("/update/{id}")
    public String actualizarCliente(@PathVariable("id") Long  identificacion, @ModelAttribute("mascota") Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/cliente/todos";
    }

    @GetMapping("/delete/{id}")
     public String borrarCliente(@PathVariable("id") Long identificacion){
        clienteService.eliminarCliente(identificacion);
        return "redirect:/cliente/todos";
     }
    
}
