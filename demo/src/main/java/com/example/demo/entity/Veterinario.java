package com.example.demo.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
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

    public Veterinario (){
    }

    public Veterinario(Long cedula, String contrasena, String foto, String nombre, Boolean estado, Especialidad especialidad) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.foto = foto;
        this.nombre = nombre;
        this.estado = estado;
        this.especialidad = especialidad;
    }

    public Veterinario(Long id, Long cedula, String contrasena, String foto, String nombre, Boolean estado,
            Especialidad especialidad, List<Tratamiento> tratamientos) {
        this.id = id;
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.foto = foto;
        this.nombre = nombre;
        this.estado = estado;
        this.especialidad = especialidad;
        this.tratamientos = tratamientos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Veterinario orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}