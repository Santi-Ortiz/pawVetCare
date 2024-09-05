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
import com.example.demo.service.MascotaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired 
    private ClienteService clienteService;

    @Autowired 
    private MascotaService mascotaService;

    // http://localhost:8090/cliente/mascota/{id}
    @GetMapping("/mascota/{id}")
    public String mostrarInfoMascotaAdmin(@PathVariable("id") Long idMascota, HttpSession session, Model model) {
    Cliente cliente = (Cliente) session.getAttribute("cliente");
        //if(cliente != null){
        List<Mascota> mascotasLista = cliente.getMascotas();
        for(Mascota mascota : mascotasLista){
            if(mascota.getId().equals(idMascota)){
                model.addAttribute("mascota", mascota);
                model.addAttribute("cliente", cliente);
                return "cliente_MostrarMascotas";
            }else{
                continue;
            }
        }
        return "errorClienteNoEncontrado";
    }

    // http://localhost:8090/cliente/mascotas/{id}
    @GetMapping("/mascotas/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") Long identificacion){
        model.addAttribute("cliente", clienteService.obtenerCliente(identificacion));
        return "cliente_mostrarTodasMascotas";
    }

    // http://localhost:8090/cliente/todos
    @GetMapping("/todos")
    public String mostrarClientes(Model model){
       model.addAttribute("clientes", clienteService.mostrarTodos());
       model.addAttribute("cliente", new Cliente());
       return "admin_mostrarTodosClientes";
    }

    // http://localhost:8090/cliente/add
    @GetMapping("/add")
    public String agregarCliente(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "admin_mostrarTodosClientes";
    }

    // http://localhost:8090/cliente/agregar
    @PostMapping("/agregar")
      public String mostrar_agregar_cliente(@ModelAttribute("cliente") Cliente cliente) {
         clienteService.add(cliente);
         return "redirect:/cliente/todos";
    }

    // http://localhost:8090/mascota/update/{id}
    @GetMapping("/update/{id}")
    public String actualizarInfoCliente(@PathVariable("id") Long identificacion, Model model) {

        Cliente cliente = clienteService.obtenerCliente(identificacion);
        model.addAttribute("cliente", cliente);
        return "admin_MostrarInfoCliente";
    }

    // http://localhost:8090/mascota/update/{id}
    @PostMapping("/update/ad/{id}")
    public String actualizarCliente(@PathVariable("id") Long  identificacion, @ModelAttribute("cliente") Cliente cliente) {
        Cliente existingCliente = clienteService.obtenerClientePorCedula(identificacion);
        if(existingCliente != null){

            existingCliente.setCedula(cliente.getCedula());
            existingCliente.setCelular(cliente.getCelular());
            existingCliente.setCorreo(cliente.getCorreo());
            existingCliente.setNombre(cliente.getNombre()); 

            clienteService.update(existingCliente);

            List<Mascota> mascotas = existingCliente.getMascotas();

            for (Mascota mascota : mascotas) {
                mascota.setIdCliente(existingCliente); 
                mascotaService.updateMascota(mascota);
            }

        }
        
        return "redirect:/admin/clientes";
    }

    // http://localhost:8090/mascota/update/{id}
    @PostMapping("/update/vet/{id}")
    public String actualizarClienteVet(@PathVariable("id") Long  identificacion, @ModelAttribute("mascota") Cliente cliente) {
        Cliente existingCliente = clienteService.obtenerClientePorCedula(identificacion);
        if(existingCliente != null){

            existingCliente.setCedula(cliente.getCedula());
            existingCliente.setCelular(cliente.getCelular());
            existingCliente.setCorreo(cliente.getCorreo());
            existingCliente.setNombre(cliente.getNombre()); 

            clienteService.update(existingCliente);

            List<Mascota> mascotas = existingCliente.getMascotas();

            for (Mascota mascota : mascotas) {
                mascota.setIdCliente(existingCliente); 
                mascotaService.updateMascota(mascota);
            }

        }
        return "redirect:/veterinario/clientes";
    }

    // http://localhost:8090/cliente/delete/{id}
    @GetMapping("/delete/{id}")
     public String borrarCliente(@PathVariable("id") Long identificacion){
        clienteService.eliminarCliente(identificacion);
        return "redirect:/cliente/todos";
     }
    
}
