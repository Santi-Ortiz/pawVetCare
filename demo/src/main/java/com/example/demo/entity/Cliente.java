package com.example.demo.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cliente")

public class Cliente{
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long cedula;
    private String nombre;
    private String correo;
    private Long celular;

   
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas;


    public Cliente(Long cedula, String nombre, String correo, Long celular, List<Mascota> mascotas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.mascotas = mascotas;
    }
    
    public Cliente(Long cedula, String nombre, String correo, Long celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
    }

}