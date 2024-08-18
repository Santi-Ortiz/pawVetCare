package com.example.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;



public class Cliente{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;
    private Integer cedula;
    private String nombre;
    private String correo;
    private Long celular;

    //@OneToMany(mappedBy = "cliente")
    private Map<Long, Mascota> mascotas = new HashMap<>();

    public Cliente(Integer cedula, String nombre, String correo, Long celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }
    
    public Map<Long, Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Map<Long, Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}