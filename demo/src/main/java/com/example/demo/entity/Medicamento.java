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
    private Double precio_venta;
    private Double precio_compra;
    private Integer unidades_disponibles;
    private Integer unidades_vendidas;

    public Medicamento() {
    }

    public Medicamento(String nombre, Double precio_venta, Double precio_compra, Integer unidades_disponibles, Integer unidades_vendidas) {
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.unidades_disponibles = unidades_disponibles;
        this.unidades_vendidas = unidades_vendidas;
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

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Integer getUnidades_disponibles() {
        return unidades_disponibles;
    }

    public void setUnidades_disponibles(Integer unidades_disponibles) {
        this.unidades_disponibles = unidades_disponibles;
    }

    public Integer getUnidades_vendidas() {
        return unidades_vendidas;
    }

    public void setUnidades_vendidas(Integer unidades_vendidas) {
        this.unidades_vendidas = unidades_vendidas;
    } 
}
