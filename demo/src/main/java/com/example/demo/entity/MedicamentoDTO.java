package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoDTO {
    private Long id;
    private String nombre;
    private Integer cantidad;

    public MedicamentoDTO(TratamientoMedicamento tm) {
        this.id = tm.getMedicamento().getId();
        this.nombre = tm.getMedicamento().getNombre();
        this.cantidad = tm.getCantidad();
    }
}