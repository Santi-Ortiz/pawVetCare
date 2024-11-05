package com.example.demo.entity;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoDTO {
    private Long id;
    private Date fecha;
    private Long veterinarioId;
    private Long mascotaId;
    private List<MedicamentoDTO> medicamentos;
  
    public TratamientoDTO(Tratamiento tratamiento) {
        this.id = tratamiento.getId();
        this.fecha = tratamiento.getFecha();
        this.veterinarioId = tratamiento.getVeterinario() != null ? tratamiento.getVeterinario().getId() : null;
        this.mascotaId = tratamiento.getMascota() != null ? tratamiento.getMascota().getId() : null;
        this.medicamentos = tratamiento.getTratamientoMedicamentos().stream()
            .map(MedicamentoDTO::new)
            .collect(Collectors.toList());
    }
}
