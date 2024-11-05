package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoRequestDTO {
    private Mascota mascota;
    private Veterinario veterinario;
    private Medicamento medicamento;
    private Integer cantidad;

}

