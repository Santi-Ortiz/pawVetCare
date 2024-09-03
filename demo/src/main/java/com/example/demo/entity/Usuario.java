package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String tipoUsuario;

    public Usuario() {}

    public Usuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_usuario() {
        return tipoUsuario;
    }

    public void setTipo_usuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
     
}
