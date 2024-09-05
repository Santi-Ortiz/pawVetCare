package com.example.demo.entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name="tratamiento")

public class Tratamiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinario_id") 
    private Veterinario veterinario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mascota_id")  
    private Mascota mascota;

    public Tratamiento(Date fecha, Veterinario veterinario, Mascota mascota) {
    this.fecha = fecha;
    this.veterinario = veterinario;
    this.mascota = mascota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}