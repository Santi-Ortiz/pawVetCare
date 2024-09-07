package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name="medicamento")

public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Date fecha_vencimiento;
    
    @ManyToOne
    @JoinColumn(name = "tratamiento_id", referencedColumnName = "id")
    private Tratamiento tratamiento;

    public Medicamento() {
    }

    public Medicamento(String nombre, String descripcion, Date fecha_vencimiento, Tratamiento tratamiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.tratamiento = tratamiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
    
}
