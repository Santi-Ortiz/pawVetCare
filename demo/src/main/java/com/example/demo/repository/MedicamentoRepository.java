package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    public Medicamento findByNombre(String nombre);

    @Query("SELECT SUM(m.precio_venta * m.unidades_vendidas) FROM Medicamento m")
    Double obtenerVentasTotales();
    
    @Query("SELECT SUM(m.precio_compra * m.unidades_vendidas) FROM Medicamento m")
    Double obtenerCostosTotales();
}
