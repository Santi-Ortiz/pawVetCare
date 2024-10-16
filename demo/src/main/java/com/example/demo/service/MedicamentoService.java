package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Tratamiento;
import com.example.demo.repository.MedicamentoRepository;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Transactional
    public List<Medicamento> SearchAll() {
        return medicamentoRepository.findAll();
    }

    @Transactional
    public Medicamento SearchById(Long id) {
        Optional<Medicamento> auxMedicamento = medicamentoRepository.findById(id);
        return auxMedicamento.get();
    }

    @Transactional
    public void agregarMedicamento(String nombre, Double precio_venta, Double precio_compra,
            Integer unidades_disponibles, Integer unidades_vendidas) {
        medicamentoRepository
                .save(new Medicamento(nombre, precio_venta, precio_compra, unidades_disponibles, unidades_vendidas));
    }

    @Transactional
    public void eliminarEspecialidad(String medicamento) {
        medicamentoRepository.delete(medicamentoRepository.findByNombre(medicamento));
    }

    public double calcularVentasTotales() {
        return medicamentoRepository.obtenerVentasTotales();
    }

    public double calcularGananciasTotales() {
        Double costosTotales = medicamentoRepository.obtenerCostosTotales();
        Double ventasTotales = medicamentoRepository.obtenerVentasTotales();
        return ventasTotales - costosTotales;
    }

    public double calcularCostosTotales() {
        return medicamentoRepository.obtenerCostosTotales();
    }
}
