package com.example.demo.entity;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TratamientoDTO {
    private Long id;
    private Date fecha;
    private Long veterinarioId;
    private Long mascotaId;
    private List<MedicamentoDTO> medicamentos;
    
    public TratamientoDTO(Long id, Date fecha, Long veterinarioId, Long mascotaId,
            List<MedicamentoDTO> medicamentos) {
        this.id = id;
        this.fecha = fecha;
        this.veterinarioId = veterinarioId;
        this.mascotaId = mascotaId;
        this.medicamentos = medicamentos;
    }

    public TratamientoDTO(Tratamiento tratamiento) {
        this.id = tratamiento.getId();
        this.fecha = tratamiento.getFecha();
        this.veterinarioId = tratamiento.getVeterinario() != null ? tratamiento.getVeterinario().getId() : null;
        this.mascotaId = tratamiento.getMascota() != null ? tratamiento.getMascota().getId() : null;
        this.medicamentos = tratamiento.getTratamientoMedicamentos().stream()
            .map(MedicamentoDTO::new)
            .collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }

    public List<MedicamentoDTO> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentoDTO> medicamentos) {
        this.medicamentos = medicamentos;
    }

    
}
