package com.example.demo.entity;

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
@Table(name = "tratamiento_medicamento")
public class TratamientoMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Clave primaria simple

    @ManyToOne
    @JoinColumn(name = "tratamiento_id", nullable = false)
    private Tratamiento tratamiento;

    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private Medicamento medicamento;

    private Integer cantidad;
    
    public TratamientoMedicamento(Tratamiento tratamiento, Medicamento medicamento) {
        this.tratamiento = tratamiento;
        this.medicamento = medicamento;
    }

    
    public TratamientoMedicamento(Tratamiento tratamiento, Medicamento medicamento, Integer cantidad) {
        this.tratamiento = tratamiento;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
    }
}
