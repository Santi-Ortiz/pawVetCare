package com.example.demo.entity;

public class VeterinarioDTO {
    private Long id;
    private Long cedula;
    private String nombre;
    private String contrasena;
    private String foto;
    private Boolean estado;
    private Long especialidad_id;
    private String nombreEspecialidad;

    public VeterinarioDTO(Veterinario veterinario) {
        this.id = veterinario.getId();
        this.cedula = veterinario.getCedula();
        this.nombre = veterinario.getNombre();
        this.contrasena = veterinario.getContrasena();
        this.foto = veterinario.getFoto();
        this.estado = veterinario.getEstado();
        this.nombreEspecialidad = veterinario.getEspecialidad().getNombre_especialidad();
        this.especialidad_id = veterinario.getEspecialidad().getId();
    }

    public VeterinarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public Long getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(Long especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    
}
