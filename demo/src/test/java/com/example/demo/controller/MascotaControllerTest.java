package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Mascota;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(controllers = MascotaController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class MascotaControllerTest {
    
    @Autowired
    private MockMvc mockMvc; // Esto se usa para realizar solicitudes HTTP simuladas a los endpoints del controlador

    @MockBean
    private MascotaService mascotaService; // Esto se usa para simular el servicio de mascotas 

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private TratamientoRepository tratamientoRepository;
    
    // Todas las pruebas tienen 3 pasos: Arrange, Act, Assert
    //otra vez null arreglar import 
    @Test
        public void MascotaController_mostrarInfoMascota_Mascota() throws Exception {
            // Arrange
            when(mascotaService.SearchById(1L)).thenReturn(null);

            // Act & Assert
            mockMvc.perform(get("/api/mascota/find").param("id", "1"))
                    .andExpect(status().isNotFound());
        }

        @Test
        public void MascotaController_mostrarMasocotas_NotEmptyList() throws Exception {
            // Arrange
            List<Mascota> listaMascotas = Arrays.asList(
                    new Mascota("Nala", "Poodle", 12, 28.0F, "Moquillo", 
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg", 
                        false, new Cliente()),
                    new Mascota("Simba", "Golden Retriever", 8, 35.5F, "Parvovirus", 
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Golden_Retriever.jpg/375px-Golden_Retriever.jpg", 
                        true, new Cliente())
            );
        
            when(mascotaService.SearchAll()).thenReturn(listaMascotas);
        
            // Act & Assert
            mockMvc.perform(get("/api/mascota/admin/todas"))
                    .andExpect(status().isOk()) // Verificamos que la respuesta sea 200 OK
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Verificamos que el tipo de contenido sea JSON
                    .andExpect(jsonPath("$").isArray()) // Verificamos que la respuesta sea un arreglo
                    .andExpect(jsonPath("$.length()").value(2)) // Verificamos que haya 2 elementos en la lista
                    .andExpect(jsonPath("$[0].nombre").value("Nala")) // Verificamos que el nombre de la primera mascota sea "Nala"
                    .andExpect(jsonPath("$[1].nombre").value("Simba")); // Verificamos que el nombre de la segunda mascota sea "Simba"
        }
        

    @Test
    public void MascotaController_agregarMascota_Admin() throws Exception {
        // Arrange
        Mascota mascota = new Mascota("Nala", "Poodle", 12, 28.0F, "Moquillo", 
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg", 
            false, new Cliente());

        Cliente cliente = new Cliente();
        cliente.setCedula(123L);

        when(clienteService.obtenerClientePorCedula(123L)).thenReturn(cliente);
        when(mascotaService.add(any(Mascota.class))).thenReturn(mascota); 
        when(clienteService.agregarMascota(eq(123L), any(Mascota.class))).thenReturn(true); 

        String mascotaJson = new ObjectMapper().writeValueAsString(mascota);

        // Act & Assert
        mockMvc.perform(post("/api/mascota/admin/agregar")
                .param("idCliente", "123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mascotaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("Mascota agregada exitosamente"))
                .andExpect(jsonPath("$.mascota.nombre").value("Nala"));
    }




    @Test
    public void MascotaController_actualizarMascota_Mascota() throws Exception {
        // Arrange
        Mascota mascotaActualizada = new Mascota("Nala", "Poodle", 13, 30.0F, "Parvovirus", 
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg", 
            false, new Cliente());
        mascotaActualizada.setId(1L);

        when(mascotaService.SearchById(1L)).thenReturn(mascotaActualizada);
        doNothing().when(mascotaService).updateMascota(any(Mascota.class));

        String mascotaJson = new ObjectMapper().writeValueAsString(mascotaActualizada);

        // Act & Assert
        mockMvc.perform(put("/api/mascota/update/ad/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mascotaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("Nala"))
                .andExpect(jsonPath("$.edad").value(13))
                .andExpect(jsonPath("$.peso").value(30.0F))
                .andExpect(jsonPath("$.enfermedad").value("Parvovirus"));
    }


    @Test
    public void MascotaController_eliminarMascota() throws Exception {
        Mascota mascota = new Mascota("Nala", "Poodle", 12, 28.0F, "Moquillo", 
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg", 
            false, new Cliente());
        mascota.setId(1L);

        when(mascotaService.SearchById(1L)).thenReturn(mascota);
        doNothing().when(mascotaService).borrarMascota(1L); 

        // Act & Assert
        mockMvc.perform(delete("/api/mascota/admin/delete/1"))
                .andExpect(status().isOk()); 

        verify(mascotaService, times(1)).borrarMascota(1L);
    }


}
