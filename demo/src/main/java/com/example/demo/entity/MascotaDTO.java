package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {
    private Long id;
    private String nombre;
    private String raza;
    private Integer edad;
    private Float peso;
    private String enfermedad;
    private String foto;
    private Boolean estado;
    private Long cedulaCliente;

    public MascotaDTO(String nombre, String raza, Integer edad, Float peso, String enfermedad, String foto,
            Boolean estado, Long cedulaCliente) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.foto = foto;
        this.estado = estado;
        this.cedulaCliente = cedulaCliente;
    }
}

