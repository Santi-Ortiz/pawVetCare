package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medicamento")

public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio_venta;
    private Double precio_compra;
    private Integer unidades_disponibles;
    private Integer unidades_vendidas;

    @JsonIgnore
    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
    private List<TratamientoMedicamento> tratamientoMedicamentos = new ArrayList<>();

    public Medicamento(String nombre, Double precio_venta, Double precio_compra, Integer unidades_disponibles, Integer unidades_vendidas) {
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.unidades_disponibles = unidades_disponibles;
        this.unidades_vendidas = unidades_vendidas;
    }

}
