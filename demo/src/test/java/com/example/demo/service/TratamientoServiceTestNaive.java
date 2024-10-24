package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entity.Especialidad;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.TratamientoMedicamento;
import com.example.demo.entity.Veterinario;


@SpringBootTest
@ActiveProfiles("test")
public class TratamientoServiceTestNaive {
    
    @Autowired
    private TratamientoService tratamientoService;

    @Test
    public void TratamientoService_agregarTratamiento_Tratamiento(){

        Veterinario veterinario = new Veterinario(789456L, "2345", "foto", "Erick Prydz", true, new Especialidad("cirujia"));
        Mascota mascota = new Mascota("Tobias", "Bulldog", 2, 10.5f, "pulgas", "foto", true, null);
        Tratamiento tratamiento = new Tratamiento(java.sql.Date.valueOf("2024-10-10"),  veterinario, mascota);
        Medicamento medicamento = new Medicamento("Genoprasol", 20.5, 25.0, 10, 15);

        Tratamiento nuevoTratamiento = tratamientoService.agregarTratamiento(tratamiento, medicamento, 5);

        Assertions.assertThat(nuevoTratamiento).isNotNull();
        Assertions.assertThat(nuevoTratamiento.getFecha()).isEqualTo(java.sql.Date.valueOf("2024-10-10"));
        Assertions.assertThat(nuevoTratamiento.getVeterinario()).isEqualTo(veterinario);
    }

    @Test
    public void TratamientoService_findById_Tratamiento(){

        Veterinario veterinario = new Veterinario(123456L, "2345", "foto", "Pablo Perez", true, new Especialidad("Traumatologia"));
        Mascota mascota = new Mascota("Firulais", "Bulldog", 2, 10.5f, "Deficiencia renal", "foto", true, null);
        Tratamiento tratamiento = new Tratamiento(java.sql.Date.valueOf("2024-09-10"),  veterinario, mascota);

        Tratamiento tratamientoBuscado = tratamientoService.findById(tratamiento.getId());

        Assertions.assertThat(tratamientoBuscado).isNotNull();
        Assertions.assertThat(tratamientoBuscado.getFecha()).isEqualTo(java.sql.Date.valueOf("2024-09-10"));
    }

    @Test
    public void TratamientoService_findAll_NoEmptyList(){

        Veterinario veterinario = new Veterinario(123456L, "2345", "foto", "Pablo Perez", true, new Especialidad("Traumatologia"));
        Mascota mascota = new Mascota("Firulais", "Bulldog", 2, 10.5f, "Deficiencia renal", "foto", true, null);
        Tratamiento tratamiento = new Tratamiento(java.sql.Date.valueOf("2024-09-10"),  veterinario, mascota);

        tratamientoService.agregarTratamiento(tratamiento, new Medicamento("Genoprasol", 20.5, 25.0, 10, 15), 5);

        Assertions.assertThat(tratamientoService.obtenerTratamientos()).isNotEmpty();
    }

    @Test
    public void TratamientoService_eliminarTratamiento(){

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(1L);

        tratamientoService.eliminarTratamiento(1L);

        Assertions.assertThat(tratamiento).isNull();
    }

    @Test
    public void TratamientoService_obtenerTotalTratamientosMesActual(){

        Tratamiento tratamiento1 = new Tratamiento(java.sql.Date.valueOf("2024-10-01"),  new Veterinario(), new Mascota());
        Tratamiento tratamiento2 = new Tratamiento(java.sql.Date.valueOf("2024-10-15"),  new Veterinario(), new Mascota());
        Tratamiento tratamiento3 = new Tratamiento(java.sql.Date.valueOf("2024-10-18"),  new Veterinario(), new Mascota());
        Tratamiento tratamiento4 = new Tratamiento(java.sql.Date.valueOf("2024-10-20"),  new Veterinario(), new Mascota());
        tratamientoService.agregarTratamiento(tratamiento1, null, 0);
        tratamientoService.agregarTratamiento(tratamiento2, null, 0);
        tratamientoService.agregarTratamiento(tratamiento3, null, 0);
        tratamientoService.agregarTratamiento(tratamiento4, null, 0);

        long totalTratamientos = tratamientoService.obtenerTotalTratamientosMesActual();

        Assertions.assertThat(totalTratamientos).isNotZero();
        Assertions.assertThat(totalTratamientos).isEqualTo(4);
    }

    @Test
    public void TratamientoService_obtenerTop3Tratamientos(){
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


        List<Tratamiento> top3 = tratamientoService.obtenerTop3Tratamientos();

        Assertions.assertThat(top3).isNotEmpty();
        Assertions.assertThat(top3.size()).isEqualTo(3);
        Assertions.assertThat(top3.size()).isGreaterThan(0);
    }

    @Test
    public void TratamientoService_ErrorSinSuficientesUnidades(){
        Tratamiento tratamiento = new Tratamiento();
        Medicamento medicamento = new Medicamento("Antibiótico A", 25.5D, 20.5D, 5, 50); // Solo 5 unidades disponibles
        int cantidad = 10; // Se solicita más de lo disponible

        tratamientoService.agregarTratamiento(tratamiento, medicamento, cantidad);
        
        Assertions.assertThat(tratamientoService.obtenerTratamientos()).isEmpty();
    }


}
