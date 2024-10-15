package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.MascotaDTO;
import com.example.demo.service.MascotaService;
import com.example.demo.service.ClienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*@Controller
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
     /*@GetMapping("/find/{id}")
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
            throw new NotClientIdExistInPet();
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

}*/
@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
   
    @Autowired
    ClienteService clienteService;

    // Obtener todas las mascotas (Administradores)
    @GetMapping("/admin/todas")
    public ResponseEntity<List<Mascota>> mostrarMascotas() {
        List<Mascota> mascotas = mascotaService.SearchAll();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener todas las mascotas (Veterinarios)
    @GetMapping("/vet/todas")
    public ResponseEntity<List<Mascota>> mostrarMascotasVet() {
        List<Mascota> mascotas = mascotaService.SearchAll();
        return ResponseEntity.ok(mascotas);
    }

    // Obtener una mascota por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<MascotaDTO> mostrarInfoMascota(@PathVariable("id") Long identificacion) {
        Mascota mascota = mascotaService.SearchById(identificacion);
        if (mascota != null) {
            // Mapear la entidad Mascota a MascotaDTO
            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(mascota.getId());
            mascotaDTO.setNombre(mascota.getNombre());
            mascotaDTO.setRaza(mascota.getRaza());
            mascotaDTO.setEdad(mascota.getEdad());
            mascotaDTO.setPeso(mascota.getPeso());
            mascotaDTO.setEnfermedad(mascota.getEnfermedad());
            mascotaDTO.setFoto(mascota.getFoto());
            mascotaDTO.setEstado(mascota.getEstado());
            mascotaDTO.setCedulaCliente(mascota.getCliente() != null ? mascota.getCliente().getCedula() : null);
            // Convertir los tratamientos si es necesario

            return ResponseEntity.ok(mascotaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // Agregar una nueva mascota (Administrador)
    @PostMapping("/admin/agregar")
    public ResponseEntity<Map<String, Object>> agregarMascota(@RequestBody Mascota mascota, @RequestParam("idCliente") Long cedula) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
            if (cliente != null) {
                mascota.setCliente(cliente);
                mascotaService.add(mascota);
                clienteService.agregarMascota(cliente.getCedula(), mascota);
                
                response.put("mensaje", "Mascota agregada exitosamente");
                response.put("mascota", mascota);
                return ResponseEntity.ok(response);
            } else {
                response.put("mensaje", "Cliente no encontrado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al agregar la mascota");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



    // Agregar una nueva mascota (Veterinario)
    @PostMapping("/vet/agregar")
    public ResponseEntity<String> agregarMascotaVet(@RequestBody Mascota mascota, @RequestParam("idCliente") Long cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);
        if (cliente != null) {
            mascota.setCliente(cliente);
            mascotaService.add(mascota);
            clienteService.agregarMascota(cliente.getCedula(), mascota);
            return ResponseEntity.ok("Mascota agregada exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    // Eliminar una mascota (Administrador)
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Map<String, String>> borrarMascota(@PathVariable("id") Long identificacion) {
        mascotaService.borrarMascota(identificacion);
    
        Map<String, String> response = new HashMap<>();
        response.put("message", "Mascota eliminada exitosamente");
    
        return ResponseEntity.ok(response);
    }

    // Eliminar una mascota (Veterinario)
    @DeleteMapping("/vet/delete/{id}")
    public ResponseEntity<String> borrarMascotaVet(@PathVariable("id") Long identificacion) {
        mascotaService.borrarMascota(identificacion);
        return ResponseEntity.ok("Mascota eliminada exitosamente");
    }

    // Actualizar una mascota (Veterinario)
    @PutMapping("/update/vet/{id}")
    public ResponseEntity<MascotaDTO> actualizarMascotaVet(@PathVariable("id") Long identificacion, @RequestBody Mascota nuevaMascota) {
        Mascota mascotaExistente = mascotaService.SearchById(identificacion);
        if (mascotaExistente != null) {
            mascotaExistente.setNombre(nuevaMascota.getNombre());
            mascotaExistente.setRaza(nuevaMascota.getRaza());
            mascotaExistente.setEdad(nuevaMascota.getEdad());
            mascotaExistente.setPeso(nuevaMascota.getPeso());
            mascotaExistente.setEnfermedad(nuevaMascota.getEnfermedad());
            mascotaExistente.setEstado(nuevaMascota.getEstado());
            mascotaExistente.setFoto(nuevaMascota.getFoto());

            mascotaService.updateMascota(mascotaExistente);

            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(mascotaExistente.getId());
            mascotaDTO.setNombre(mascotaExistente.getNombre());
            mascotaDTO.setRaza(mascotaExistente.getRaza());
            mascotaDTO.setEdad(mascotaExistente.getEdad());
            mascotaDTO.setPeso(mascotaExistente.getPeso());
            mascotaDTO.setEnfermedad(mascotaExistente.getEnfermedad());
            mascotaDTO.setFoto(mascotaExistente.getFoto());
            mascotaDTO.setEstado(mascotaExistente.getEstado());
            mascotaDTO.setCedulaCliente(mascotaExistente.getCliente().getCedula());

            return ResponseEntity.ok(mascotaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Actualizar una mascota (Administrador)
    @PutMapping("/update/ad/{id}")
    public ResponseEntity<MascotaDTO> actualizarMascotaAdmin(@PathVariable("id") Long identificacion, @RequestBody Mascota nuevaMascota) {
        Mascota mascotaExistente = mascotaService.SearchById(identificacion);
        if (mascotaExistente != null) {
            mascotaExistente.setNombre(nuevaMascota.getNombre());
            mascotaExistente.setRaza(nuevaMascota.getRaza());
            mascotaExistente.setEdad(nuevaMascota.getEdad());
            mascotaExistente.setPeso(nuevaMascota.getPeso());
            mascotaExistente.setEnfermedad(nuevaMascota.getEnfermedad());
            mascotaExistente.setEstado(nuevaMascota.getEstado());
            mascotaExistente.setFoto(nuevaMascota.getFoto());

            mascotaService.updateMascota(mascotaExistente);

            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(mascotaExistente.getId());
            mascotaDTO.setNombre(mascotaExistente.getNombre());
            mascotaDTO.setRaza(mascotaExistente.getRaza());
            mascotaDTO.setEdad(mascotaExistente.getEdad());
            mascotaDTO.setPeso(mascotaExistente.getPeso());
            mascotaDTO.setEnfermedad(mascotaExistente.getEnfermedad());
            mascotaDTO.setFoto(mascotaExistente.getFoto());
            mascotaDTO.setEstado(mascotaExistente.getEstado());
            mascotaDTO.setCedulaCliente(mascotaExistente.getCliente().getCedula());

            return ResponseEntity.ok(mascotaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/activas")
    public ResponseEntity<Long> contarMascotasActivas() {
        long count = mascotaService.contarMascotasActivas();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/cantidad")
    public ResponseEntity<Long> contarMascotas(){
        long count = mascotaService.contarMascotas();
        return ResponseEntity.ok(count);
    }
    

}


