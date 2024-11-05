package com.example.demo.entity;

import java.util.*;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<TratamientoMedicamento> getTratamientoMedicamentos() {
        return tratamientoMedicamentos;
    }

    public void setTratamientoMedicamentos(List<TratamientoMedicamento> tratamientoMedicamentos) {
        this.tratamientoMedicamentos = tratamientoMedicamentos;
    }
}