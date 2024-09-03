package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.example.demo.entity.Medicamento;
import com.example.demo.repository.MedicamentoRepository;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Transactional
    public void agregarMedicamento(String nombre, String descripcion, Date fecha_vencimiento){
        medicamentoRepository.save(new Medicamento(nombre, descripcion, fecha_vencimiento));
    }

    @Transactional
    public void eliminarEspecialidad(String medicamento){
        medicamentoRepository.delete(medicamentoRepository.findByNombre(medicamento));
    }
}
