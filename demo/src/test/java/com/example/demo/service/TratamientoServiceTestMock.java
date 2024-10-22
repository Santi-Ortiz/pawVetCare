package com.example.demo.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.repository.TratamientoRepository;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock {

    @InjectMocks // Esta es la clase que se va a probar por eso se usa esta anotación
    private TratamientoService tratamientoService;

    @Mock // Se usa mock para crear un objeto falso del tratamiento y realizar las pruebas sobre ese objeto
    private TratamientoRepository tratamientoRepository;


    @BeforeEach
    public void init() { }

    // TODO: Hacer pruebas de integración
    // TODO: Hacer pruebas con mocks de los repositorios

    @Test
    public void TratamientoService_darTratamiento_Tratamiento(){
        // Esto es con mocks
    } 

    
}
