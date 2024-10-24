package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.service.MascotaService;

@WebMvcTest(controllers = MascotaController.class)
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class MascotaControllerTest {
    
    @Autowired
    private MockMvc mockMvc; // Esto se usa para realizar solicitudes HTTP simuladas a los endpoints del controlador

    @MockBean
    private MascotaService mascotaService; // Esto se usa para simular el servicio de mascotas 
    //Un Mock es un objeto falso que permite simular su comportamiento como si fuera real pero en ningún momento se crea en la DB
    
    // Todas las pruebas tienen 3 pasos: Arrange, Act, Assert
    //otra vez null arreglar import 
    @Test
     public void MascotaController_mostrarInfoMascota_Mascota() throws Exception {
        when(mascotaService.SearchById(anyLong())).thenReturn(null);

        ResultActions response = mockMvc.perform(
           get("/api/mascota/find").param("id", "1") 
        );
    }

    @Test
    public void MascotaController_mostrarMasocotas_NotEmptyList(){

    }

    @Test
    public void MascotaController_agregarMascota_Mascota() {
        Mascota mascota = new Mascota("Nala","Poodle",12,28.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,new Cliente());
    
        //when(mascotaService.add(Mockito.any(Mascota.class))).thenReturn(mascota);


    }

    @Test
    public void MascotaController_actualizarMascota_Mascota(){

    }

    @Test
    public void MascotaController_eliminarMascota(){

    }


}
