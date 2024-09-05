package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.service.MascotaService;
import com.example.demo.service.ClienteService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
   
    @Autowired
    ClienteService clienteService;
    // http://localhost:8090/mascota/ad/todas
     @GetMapping("/ad/todas")
     public String mostrarMascotas(Model model){
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("mascotas", mascotaService.SearchAll());
        System.out.println("Mascotas: " + mascotaService.SearchAll());
        return "admin_mostrarTodasMascotas";
     }

     // http://localhost:8090/mascota/vet/todas
     /*@GetMapping("/vet/todas")
     public String mostrarMascotasVet(Model model){
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("mascotas", mascotaService.SearchAll());
        System.out.println("Mascotas: " + mascotaService.SearchAll());
        return "vet_mostrarTodasMascotas";
     }*/

     // http://localhost:8090/mascota/find/
     @GetMapping("/find/{id}")
     public String mostrarInfoMascota(Model model, @PathVariable("id") Long identificacion ){

         Mascota mascota = mascotaService.SearchById(identificacion);
         System.out.println("ID recibido: " + mascota.getCliente().getCedula());

         if(mascota != null){
            model.addAttribute("mascota", mascota); 
            model.addAttribute("clienteCedula", mascota.getCliente().getCedula());
         } else {
            throw new NotPetFoundException(identificacion);
         }

         //model.addAttribute("mascota", mascotaService.SearchById(identificacion));
         return "admin_mostrarInfo1Mascota";
     }

     // http://localhost:8090/mascota/add
     @GetMapping("/add")
     public String agregarMascota(Model model) {
         Mascota mascota = new Mascota ();
         model.addAttribute("mascota", mascota);
         return "admin_mostrarTodasMascotas";
     }

     // http://localhost:8090/mascota/agregar
      @PostMapping("/admin/agregar")
      public String mostrar_agregar_mascota(@ModelAttribute("mascota") Mascota mascota, @RequestParam("idCliente") Long cedula) {
         Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
         if(cliente != null){
            mascota.setCliente(cliente);
            mascotaService.add(mascota); 
            clienteService.agregarMascota(cliente.getCedula(), mascota);
            return "redirect:/admin/mascotas";
         } else {
            return"";
            // throw new NotClientIdExistInPet(cedula);
         }
     }

     // http://localhost:8090/mascota/agregar
     @PostMapping("/vet/agregar")
     public String mostrar_agregar_mascota_vet(@ModelAttribute("mascota") Mascota mascota, @RequestParam("idCliente") Long cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
        if(cliente != null){
           mascota.setCliente(cliente);
           mascotaService.add(mascota); 
           clienteService.agregarMascota(cliente.getCedula(), mascota);
           return "redirect:/veterinario/mascotas";
        } else {
           return"";
           // throw new NotClientIdExistInPet(cedula);
        }
    }
     
    // http://localhost:8090/mascota/ad/delete/1
     @GetMapping("/ad/delete/{id}")
     public String borrarMascota(@PathVariable("id") Long identificacion){
        mascotaService.borrarMascota(identificacion);
        return "redirect:/admin/mascotas";
     }   

     // http://localhost:8090/mascota/delete/1
     @GetMapping("/vet/delete/{id}")
     public String borrarMascotaVet(@PathVariable("id") Long identificacion){
        mascotaService.borrarMascota(identificacion);
        return "redirect:/veterinario/mascotas";
     }

    // http://localhost:8090/mascota/update/{id}
   @GetMapping("/update/{id}")
   public String actualizarInfoMascota(@PathVariable("id") Long identificacion, Model model) {
      Mascota mascota = mascotaService.SearchById(identificacion);

      // Verificación para asegurar que mascota no es null
      if (mascota != null) {
         model.addAttribute("mascota", mascota);
         
         // Verificación para evitar NullPointerException si cliente es null
         if (mascota.getCliente() != null) {
               model.addAttribute("clienteCedula", mascota.getCliente().getCedula());
         } else {
               model.addAttribute("clienteCedula", "No disponible");
         }
      } else {
         // Mascota no encontrada, redirige a una página de error o realiza alguna acción
         return "error_page"; // Cambia por tu página de error
      }

      return "admin_mostrarInfo1Mascota";
   }

   
     //http://localhost:8090/mascota/update/{id}
   @PostMapping("/update/vet/{id}")
   public String actualizarMascotaVet(@PathVariable("id") Long identificacion, @ModelAttribute("mascota") Mascota nuevaMascota) {
      // Cargar la mascota original desde la base de datos
      Mascota mascotaExistente = mascotaService.SearchById(identificacion);
      
      if (mascotaExistente != null) {
         // Actualizar los campos de la mascota existente
         mascotaExistente.setNombre(nuevaMascota.getNombre());
         mascotaExistente.setRaza(nuevaMascota.getRaza());
         mascotaExistente.setEdad(nuevaMascota.getEdad());
         mascotaExistente.setPeso(nuevaMascota.getPeso());
         mascotaExistente.setEnfermedad(nuevaMascota.getEnfermedad());
         mascotaExistente.setEstado(nuevaMascota.getEstado());
         mascotaExistente.setFoto(nuevaMascota.getFoto());

         if (mascotaExistente.getTratamientos() == null) {
            mascotaExistente.setTratamientos(new ArrayList<>());
        }

        mascotaExistente.getTratamientos().clear();
        if (nuevaMascota.getTratamientos() != null) {
            mascotaExistente.getTratamientos().addAll(nuevaMascota.getTratamientos());
        }

         // Guardar los cambios
         mascotaService.updateMascota(mascotaExistente);
      }

      return "redirect:/veterinario/mascotas";
   }

   //http://localhost:8090/mascota/update/{id}
   @PostMapping("/update/ad/{id}")
   public String actualizarMascota(@PathVariable("id") Long identificacion, @ModelAttribute("mascota") Mascota nuevaMascota) {
      
         Mascota mascotaExistente = mascotaService.SearchById(identificacion);
         // Cargar la mascota original desde la base de datos
         if (mascotaExistente != null) {
            // Actualizar los campos de la mascota existente
            mascotaExistente.setNombre(nuevaMascota.getNombre());
            mascotaExistente.setRaza(nuevaMascota.getRaza());
            mascotaExistente.setEdad(nuevaMascota.getEdad());
            mascotaExistente.setPeso(nuevaMascota.getPeso());
            mascotaExistente.setEnfermedad(nuevaMascota.getEnfermedad());
            mascotaExistente.setEstado(nuevaMascota.getEstado());
            mascotaExistente.setFoto(nuevaMascota.getFoto());

               if (mascotaExistente.getTratamientos() == null) {
                  mascotaExistente.setTratamientos(new ArrayList<>());
               }

            mascotaExistente.getTratamientos().clear();

            if (nuevaMascota.getTratamientos() != null) {
                  mascotaExistente.getTratamientos().addAll(nuevaMascota.getTratamientos());
            }

            // Guardar los cambios
            mascotaService.updateMascota(mascotaExistente);
         }
         return "redirect:/admin/mascotas"; 
   }

}
