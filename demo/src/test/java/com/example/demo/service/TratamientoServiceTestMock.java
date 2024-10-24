package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.TratamientoMedicamento;
import com.example.demo.repository.MedicamentoRepository;
import com.example.demo.repository.TratamientoMedicamentoRepository;
import com.example.demo.repository.TratamientoRepository;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock {

    @InjectMocks // Esta es la clase que se va a probar por eso se usa esta anotación
    private TratamientoService tratamientoService;

    @Mock // Se usa mock para crear un objeto falso del tratamiento y realizar las pruebas sobre ese objeto
    private TratamientoRepository tratamientoRepository;

    @Mock
    private MedicamentoRepository medicamentoRepository;

    @Mock
    private TratamientoMedicamentoRepository tratamientoMedicamentoRepository;

    @BeforeEach
    public void setUp() {}

    @BeforeEach
    public void init() {}
    
    @Test
    public void agregarTratamiento_Exito() {
        // Arrange
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(1L); 
        tratamiento.setFecha(new Date(System.currentTimeMillis()));

        Medicamento medicamento = new Medicamento("Antibiótico A", 25.5D, 20.5D, 10, 50);
        int cantidad = 10;

        when(tratamientoRepository.save(any(Tratamiento.class))).thenReturn(tratamiento);

        // Act
        Tratamiento resultado = tratamientoService.agregarTratamiento(tratamiento, medicamento, cantidad);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals(tratamiento.getFecha(), resultado.getFecha());

        verify(tratamientoMedicamentoRepository, times(1)).save(any(TratamientoMedicamento.class));
    }

    @Test
    public void agregarTratamiento_ErrorSinSuficientesUnidades() {
        // Arrange: Medicamento con menos unidades de las necesarias
        Tratamiento tratamiento = new Tratamiento();
        Medicamento medicamento = new Medicamento("Antibiótico A", 25.5D, 20.5D, 5, 50); // Solo 5 unidades disponibles
        int cantidad = 10; // Se solicita más de lo disponible

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            tratamientoService.agregarTratamiento(tratamiento, medicamento, cantidad);
        });

        // Verificamos que se lanza la excepción con el mensaje esperado
        assertEquals("No hay suficientes unidades del medicamento Antibiótico A", exception.getMessage());

        // Verificamos que NUNCA se llamó a tratamientoRepository.save()
        verify(tratamientoRepository, never()).save(any(Tratamiento.class));
    }


    @Test
    public void eliminarTratamiento_Exito() {
        // Arrange
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(1L);  // Asignamos el ID manualmente

        when(tratamientoRepository.findById(1L)).thenReturn(Optional.of(tratamiento));
        doNothing().when(tratamientoRepository).delete(tratamiento);

        // Act
        tratamientoService.eliminarTratamiento(1L);

        // Assert
        verify(tratamientoRepository, times(1)).delete(tratamiento);
    }

    @Test
    public void obtenerTotalTratamientosMesActual() {
        // Arrange
        Date inicioMes = Date.valueOf(LocalDate.now().withDayOfMonth(1));
        Date diaActual = Date.valueOf(LocalDate.now());

        when(tratamientoRepository.contarTratamientosMesActual(inicioMes, diaActual)).thenReturn(5L);

        // Act
        long total = tratamientoService.obtenerTotalTratamientosMesActual();

        // Assert
        assertEquals(5L, total);
    }

    @Test
    public void obtenerTop3Tratamientos_Exito() {
        // Arrange
        Tratamiento t1 = new Tratamiento();
        t1.setId(1L);  

        Tratamiento t2 = new Tratamiento();
        t2.setId(2L);

        Tratamiento t3 = new Tratamiento();
        t3.setId(3L);

        Tratamiento t4 = new Tratamiento();
        t4.setId(4L);

        List<Tratamiento> tratamientos = Arrays.asList(t1, t2, t3, t4);

        when(tratamientoRepository.encontrarTop3Tratamientos()).thenReturn(tratamientos);

        // Act
        List<Tratamiento> top3 = tratamientoService.obtenerTop3Tratamientos();

        // Assert
        assertEquals(3, top3.size());
        assertEquals(1L, top3.get(0).getId());
        assertEquals(2L, top3.get(1).getId());
        assertEquals(3L, top3.get(2).getId());
    }

}
