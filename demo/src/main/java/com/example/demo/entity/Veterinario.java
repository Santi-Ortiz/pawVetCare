package com.example.demo.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="veterinario")

public class Veterinario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long cedula;

    @Column(nullable = false)
    private String contrasena;

    private String foto;


    private String nombre;

    private Boolean estado;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "especialidad_id")  
    private Especialidad especialidad;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Veterinario(Long cedula, String contrasena, String foto, String nombre, Boolean estado, Especialidad especialidad) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.foto = foto;
        this.nombre = nombre;
        this.estado = estado;
        this.especialidad = especialidad;
    }
}