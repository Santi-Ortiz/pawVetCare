package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeterinarioDTO {
    private Long id;
    private Long cedula;
    private String nombre;
    private String contrasena;
    private String foto;
    private Boolean estado;
    private Integer especialidad_id;
    private String nombreEspecialidad;

    public VeterinarioDTO(Veterinario veterinario) {
        this.id = veterinario.getId();
        this.cedula = veterinario.getCedula();
        this.nombre = veterinario.getNombre();
        this.contrasena = veterinario.getContrasena();
        this.foto = veterinario.getFoto();
        this.estado = veterinario.getEstado();
        this.nombreEspecialidad = veterinario.getEspecialidad().getNombreEspecialidad();
        this.especialidad_id = veterinario.getEspecialidad().getId();
    }

}
