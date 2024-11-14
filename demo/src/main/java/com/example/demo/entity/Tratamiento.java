package com.example.demo.entity;

import java.util.*;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="tratamiento")

public class Tratamiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "veterinario_id") 
    private Veterinario veterinario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "mascota_id")  
    private Mascota mascota;

    @JsonIgnore
    @OneToMany(mappedBy = "tratamiento", cascade = CascadeType.ALL)
    private List<TratamientoMedicamento> tratamientoMedicamentos = new ArrayList<>();


    public Tratamiento(){}
    
    public Tratamiento(Date fecha, Veterinario veterinario, Mascota mascota) {
        this.fecha = fecha;
        this.veterinario = veterinario;
        this.mascota = mascota;
    }

    public Tratamiento(Long id, Date fecha, Veterinario veterinario, Mascota mascota,
            List<TratamientoMedicamento> tratamientoMedicamentos) {
        this.id = id;
        this.fecha = fecha;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.tratamientoMedicamentos = tratamientoMedicamentos;
    }

    public Tratamiento(Date fecha, Veterinario veterinario, Mascota mascota, List<TratamientoMedicamento> tratamientoMedicamentos) {
        this.fecha = fecha;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.tratamientoMedicamentos = tratamientoMedicamentos;
    }
}