package com.example.demo.entity;

public class MedicamentoDTO {
    private Long id;
    private String nombre;
    private Integer cantidad;

    // Constructor
    public MedicamentoDTO(TratamientoMedicamento tm) {
        this.id = tm.getMedicamento().getId();
        this.nombre = tm.getMedicamento().getNombre();
        this.cantidad = tm.getCantidad();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
}