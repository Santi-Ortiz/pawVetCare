package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {
    public Medicamento findByNombre(String nombre);
}
