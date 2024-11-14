package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.MedicamentoRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.VeterinarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TratamientoServiceTestNaive {

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Test
    public void TratamientoService_agregarTratamiento_Tratamiento() {

        Veterinario veterinario = new Veterinario(789456L, "2345", "foto", "Erick Prydz", true, null);
        veterinarioRepository.save(veterinario);
        Mascota mascota = new Mascota("Tobias", "Bulldog", 2, 10.5f, "pulgas", "foto", true, null);
        mascotaRepository.save(mascota);
        Tratamiento tratamiento = new Tratamiento(java.sql.Date.valueOf("2024-10-10"), veterinario, mascota);
        tratamientoRepository.save(tratamiento);
        Medicamento medicamento = new Medicamento("Genoprasol", 20.5, 25.0, 10, 15);
        medicamentoRepository.save(medicamento);

        Tratamiento nuevoTratamiento = tratamientoService.agregarTratamiento(tratamiento, medicamento, 5);
        tratamientoRepository.save(nuevoTratamiento);

        Assertions.assertThat(nuevoTratamiento).isNotNull();
        Assertions.assertThat(nuevoTratamiento.getFecha()).isEqualTo(java.sql.Date.valueOf("2024-10-10"));
    }

    @Test
    public void TratamientoService_findById_Tratamiento() {

        Veterinario veterinario = new Veterinario(123456L, "2345", "foto", "Pablo Perez", true, null);
        veterinarioRepository.save(veterinario);

        Mascota mascota = new Mascota("Firulais", "Bulldog", 2, 10.5f, "Deficiencia renal", "foto", true, null);
        mascotaRepository.save(mascota);
        Tratamiento tratamiento = new Tratamiento(java.sql.Date.valueOf("2024-09-10"), veterinario, mascota);
        tratamientoRepository.save(tratamiento);

        Tratamiento tratamientoBuscado = tratamientoService.findById(tratamiento.getId());
        tratamientoRepository.save(tratamiento);

        Assertions.assertThat(tratamientoBuscado).isNotNull();
        Assertions.assertThat(tratamientoBuscado.getFecha()).isEqualTo(java.sql.Date.valueOf("2024-09-10"));
    }

    @Test
    public void TratamientoService_findAll_NoEmptyList() {
        Veterinario veterinario = new Veterinario(9999999L, "2345", "foto", "Pablo Perez", true, null);
        veterinarioRepository.save(veterinario);
        Mascota mascota = new Mascota("Firulais", "Bulldog", 2, 10.5f, "Deficiencia renal", "foto", true, null);
        mascotaRepository.save(mascota);
        Tratamiento tratamiento = new Tratamiento(java.sql.Date.valueOf("2024-09-10"), veterinario, mascota);
        tratamientoRepository.save(tratamiento);

        tratamientoService.agregarTratamiento(tratamiento, new Medicamento("Genoprasol", 20.5, 25.0, 10, 15), 5);

        Assertions.assertThat(tratamientoService.obtenerTratamientos()).isNotEmpty();
    }

    @Test
    public void TratamientoService_eliminarTratamiento() {

        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(1L);
        tratamientoRepository.save(tratamiento);

        tratamientoService.eliminarTratamiento(1L);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            tratamientoService.findById(1L);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("Tratamiento no encontrado");
    }

    @Test
    public void TratamientoService_obtenerTotalTratamientosMesActual() {

        Tratamiento tratamiento1 = new Tratamiento(java.sql.Date.valueOf("2024-10-01"), null,
                null);
        tratamientoRepository.save(tratamiento1);
        Tratamiento tratamiento2 = new Tratamiento(java.sql.Date.valueOf("2024-10-15"), null, null);
        tratamientoRepository.save(tratamiento2);
        Tratamiento tratamiento3 = new Tratamiento(java.sql.Date.valueOf("2024-10-18"), null,null);
        tratamientoRepository.save(tratamiento3); 

        Medicamento medicamento = new Medicamento("Genoprasol", 20.5, 25.0, 10, 15);

        tratamientoService.agregarTratamiento(tratamiento1, medicamento, 0);
        tratamientoService.agregarTratamiento(tratamiento2, medicamento, 0);
        tratamientoService.agregarTratamiento(tratamiento3, medicamento, 0);

        long totalTratamientos = tratamientoService.obtenerTotalTratamientosMesActual();

        Assertions.assertThat(totalTratamientos).isNotZero();
        Assertions.assertThat(totalTratamientos).isEqualTo(4);
    }

    @Test
    public void TratamientoService_ErrorSinSuficientesUnidades() {
        Tratamiento tratamiento = new Tratamiento();
        Medicamento medicamento = new Medicamento("Antibiótico A", 25.5D, 20.5D, 5, 50); // Solo 5 unidades disponibles
        int cantidad = 10; // Se solicita más de lo disponible

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            tratamientoService.agregarTratamiento(tratamiento, medicamento, cantidad);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("No hay suficientes unidades del medicamento Antibiótico A");
    }
                

}
