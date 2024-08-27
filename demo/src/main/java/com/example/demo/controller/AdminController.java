package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.Cliente;
import com.example.demo.service.AdminService;
import com.example.demo.service.ClienteService;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ClienteService clienteService;

    // http://localhost:8090/admin/mascotas
    @GetMapping("/mascotas")
    public String mostraradmin_mostrarTodasMascotas(Model model){
        model.addAttribute("mascotas", adminService.SearchAllPets());
        return "admin_mostrarTodasMascotas";
        //mascotaController.mostrarMascotas(model);
    }

      // http://localhost:8090/admin/mascotas/todas
      @GetMapping("/mascotas/todas")
      public String mostraradmin_mostrarTodasLasMascotas(Model model){
          model.addAttribute("mascotas", adminService.SearchAllPets());
          return "admin_MascotasTodas";
          //mascotaController.mostrarMascotas(model);
      }

    // http://localhost:8090/admin/mascotas/{id}
    @GetMapping("/mascotas/{id}")
    public String mostrarInfoMascotaAdmin(Model model, @PathVariable("id") Long identificacion){

        Mascota mascota = adminService.SearchPetById(identificacion);

        if(mascota != null){
            model.addAttribute("mascota", mascota); 
        } else {
            throw new NotPetFoundException(identificacion);
        } 

        model.addAttribute("mascota", adminService.SearchPetById(identificacion)); 
        return "admin_mostrarInfo1Mascota";
    }

    // http://localhost:8090/admin/clientes
    @GetMapping("/clientes")
    public String mostraradmin_mostrarTodosClientes(Model model){
        model.addAttribute("clientes", adminService.SearchAllClients());
        return "admin_mostrarTodosClientes";
    }

    // http://localhost:8090/admin/cliente/{id}
    @GetMapping("/cliente/{cedula}")
    public String mostrarCliente(Model model, @PathVariable("cedula") Integer cedula) {
        Cliente cliente = clienteService.obtenerClientePorCedula(cedula);

        if(cliente != null){
           model.addAttribute("cliente", cliente); 
        } else {
           //throw new NotPetFoundException(identificacion);
        }

        model.addAttribute("cliente", clienteService.obtenerClientePorCedula(cedula));
        return "admin_MostrarInfoCliente";

    }
 
}
