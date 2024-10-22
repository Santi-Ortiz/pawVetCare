package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.MascotaService;

@WebMvcTest(controllers = MascotaController.class)
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class MascotaControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MascotaService mascotaService;

    @Test
    public void MascotaController_mostrarInfoMascota_Mascota(){

    }

    @Test
    public void MascotaController_mostrarMasocotas_NotEmptyList(){

    }

    @Test
    public void MascotaController_agregarMascota_Mascota() {

    }

    @Test
    public void MascotaController_actualizarMascota_Mascota(){

    }

    @Test
    public void MascotaController_eliminarMascota(){

    }


}
