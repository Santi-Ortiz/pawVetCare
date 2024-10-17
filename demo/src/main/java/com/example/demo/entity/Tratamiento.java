package com.example.demo.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="tratamiento")

public class Tratamiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinario_id") 
    private Veterinario veterinario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
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

    public Tratamiento(Date fecha, Veterinario veterinario, Mascota mascota, List<TratamientoMedicamento> tratamientoMedicamentos) {
        this.fecha = fecha;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.tratamientoMedicamentos = tratamientoMedicamentos;
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

    public List<TratamientoMedicamento> getTratamientoMedicamentos() {
        return tratamientoMedicamentos;
    }

    public void setTratamientoMedicamentos(List<TratamientoMedicamento> tratamientoMedicamentos) {
        this.tratamientoMedicamentos = tratamientoMedicamentos;
    }
}