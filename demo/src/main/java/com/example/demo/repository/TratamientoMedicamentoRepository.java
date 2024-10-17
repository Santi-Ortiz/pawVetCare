package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TratamientoMedicamento;

@Repository
public interface TratamientoMedicamentoRepository extends JpaRepository<TratamientoMedicamento, Long> {
  
}
