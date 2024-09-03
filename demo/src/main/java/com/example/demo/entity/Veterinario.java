package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.*;

import jakarta.persistence.*;


@Entity
@Table(name="veterinario")

public class Veterinario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Long cedula;

    @Column(nullable = false)
    private String contrasena;

    private String foto;

    private Integer numAtenciones;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "especialidad_id")  
    private Especialidad especialidad;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos;

    public Veterinario (){
    }

    public Veterinario(Long cedula, String contrasena, String foto, Integer numAtenciones, String nombre, Especialidad especialidad) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getNumAtenciones() {
        return numAtenciones;
    }

    public void setNumAtenciones(Integer numAtenciones) {
        this.numAtenciones = numAtenciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}