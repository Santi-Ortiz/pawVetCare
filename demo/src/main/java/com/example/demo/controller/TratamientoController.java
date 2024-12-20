package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.TratamientoRequestDTO;
import com.example.demo.service.TratamientoService;


@RestController
@RequestMapping("/api/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/tratamientos-ultimo-mes")
    public ResponseEntity<Long> getTratamientosUltimoMes() {
        long totalTratamientos = tratamientoService.obtenerTotalTratamientosMesActual();
        return ResponseEntity.ok(totalTratamientos);
    }

    @GetMapping("/top3")
    public ResponseEntity<List<Tratamiento>> getTop3Tratamientos() {
        List<Tratamiento> top3 = tratamientoService.obtenerTop3Tratamientos();
        return ResponseEntity.ok(top3);
    }
    

    @PostMapping("/dar")
    public ResponseEntity<Map<String, Object>> darTratamiento(@RequestBody TratamientoRequestDTO data) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Verificar que los objetos no sean nulos
            if (data.getMascota() == null || data.getVeterinario() == null || data.getMedicamento() == null) {
                throw new RuntimeException("Datos incompletos: mascota, veterinario o medicamento es nulo.");
            } else if(!data.getMascota().getEstado()){
                throw new RuntimeException("La mascota no se encuentra activa.");
            }

            // Imprimir los datos recibidos (opcional)
            System.out.println("Mascota: " + data.getMascota().getNombre());
            System.out.println("Veterinario: " + data.getVeterinario().getNombre());
            System.out.println("Medicamento: " + data.getMedicamento().getNombre());
            System.out.println("Cantidad: " + data.getCantidad());

            // Ejecutar la lógica del tratamiento
            Medicamento medicamento = data.getMedicamento();
            Tratamiento tratamiento = new Tratamiento(
                Date.valueOf(LocalDate.now()), 
                data.getVeterinario(), 
                data.getMascota()
            );
            // Se agrega un tratamiento a la base de datos
            tratamientoService.agregarTratamiento(tratamiento, medicamento, data.getCantidad());

            response.put("message", "Tratamiento registrado exitosamente.");
            response.put("status", HttpStatus.OK.value());
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            // Preparar la respuesta de error específico
            response.put("error", e.getMessage());
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

        } catch (Exception e) {
            // Preparar la respuesta de error general
            response.put("error", "Ocurrió un error al registrar el tratamiento.");
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }





    
}
