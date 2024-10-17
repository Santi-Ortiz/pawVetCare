package com.example.demo.entity;

import jakarta.persistence.*;

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

    public TratamientoMedicamento(){}
    
    public TratamientoMedicamento(Tratamiento tratamiento, Medicamento medicamento) {
        this.tratamiento = tratamiento;
        this.medicamento = medicamento;
    }

    
    public TratamientoMedicamento(Tratamiento tratamiento, Medicamento medicamento, Integer cantidad) {
        this.tratamiento = tratamiento;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
    public Integer getCantidad() {  // Asegúrate de tener este método
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
