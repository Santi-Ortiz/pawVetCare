package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.entity.Mascota;
import com.example.demo.service.MascotaService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
          
    // http://localhost:8090/mascota/todas
     @GetMapping("/todas")
     public String mostrarMascotas(Model model){
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mascotasAdmin";
     }

     // http://localhost:8090/mascota/find/
     @GetMapping("/find/{id}")
     public String mostrarInfoMascota(Model model, @PathVariable("id") Long identificacion ){

         Mascota mascota = mascotaService.SearchById(identificacion);

         if(mascota != null){
            model.addAttribute("mascota", mascota); 
         } else {
            throw new NotPetFoundException(identificacion);
         }

         model.addAttribute("mascota", mascotaService.SearchById(identificacion));
         return "mostrarMascotaAdmin";
     }

     // http://localhost:8090/mascota/add
     @GetMapping("/add")
     public String agregarMascota(Model model) {
         Mascota mascota = new Mascota(0L, "", "", 0, 0F, "", "", false, 0L);
         model.addAttribute("mascota", mascota);
         return "mascotasAdmin";
     }

     // http://localhost:8090/mascota/agregar
      @PostMapping("/agregar")
      public String mostrar_agregar_mascota(@ModelAttribute("mascota") Mascota mascota) {
         mascotaService.add(mascota);
         return "redirect:/mascota/todas";
     }
     
    // http://localhost:8090/mascota/delete/1
     @GetMapping("/delete/{id}")
     public String borrarMascota(@PathVariable("id") Long identificacion){
        mascotaService.deleteById(identificacion);
        return "redirect:/mascota/todas";
     }

    // http://localhost:8090/mascota/update/{id}
     @GetMapping("/update/{id}")
     public String actualizarInfoMascota(@PathVariable("id") Long identificacion, Model model) {
      Mascota mascota = mascotaService.SearchById(identificacion);
      model.addAttribute("mascota", mascota);
      return "mostrarMascotaAdmin"; // Asegúrate de que esta vista tenga el formulario
   }

     // http://localhost:8090/mascota/update/{id}
     @PostMapping("/update/{id}")
     public String actualizarMascota(@PathVariable("id") int  identificacion, @ModelAttribute("mascota") Mascota mascota) {
         mascotaService.updateMascota(mascota);
         return "redirect:/mascota/todas";
     }

}
