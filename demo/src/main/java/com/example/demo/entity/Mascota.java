package com.example.demo.entity;

/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/


public class Mascota{
    /* 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
    //private Long id;
    private String nombre;
    private String raza;
    private Integer edad;
    private Float peso;
    private String enfermedad;
    private String foto;
    private Boolean estado;

   public Mascota(String nombre, String raza, Integer edad, Float peso, String enfermedad, String foto, Boolean estado) {
        //this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.foto = foto;
        this.estado = estado;
    }

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
}