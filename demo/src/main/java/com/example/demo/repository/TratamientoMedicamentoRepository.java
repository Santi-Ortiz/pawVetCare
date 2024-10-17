package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.TratamientoMedicamento;

@Repository
public class TratamientoMedicamentoRepository extends JpaRepository<TratamientoMedicamento, Long> {
  
}
