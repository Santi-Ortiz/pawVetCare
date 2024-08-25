package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;


@Entity
@Table(name="cliente")

public class Cliente{

    @Id
    private Integer cedula;
    private String nombre;
    private String correo;
    private Long celular;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
    private List<Mascota> mascotas;

    public Cliente(){}

    public Cliente(Integer cedula, String nombre, String correo, Long celular, List<Mascota> mascotas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.mascotas = mascotas;
    }
    public Cliente(Integer cedula, String nombre, String correo, Long celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
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
    
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}