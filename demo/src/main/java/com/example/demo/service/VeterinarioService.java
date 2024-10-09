package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Especialidad;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.VeterinarioRepository;

import java.util.*;
;



@Service
public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Transactional
    public Veterinario buscarVet(Long cedula){
      return veterinarioRepository.findByCedula(cedula);
    }

    @Transactional
    public void agregarVet(Long cedula, String contrasena, String foto, String nombre, Especialidad especialidad, List<Tratamiento> tratamientos){
      veterinarioRepository.save(new Veterinario(cedula, contrasena, foto, nombre, especialidad));
    }

    @Transactional
    public void eliminarEspecialidad(Long cedula){
      veterinarioRepository.delete(veterinarioRepository.findByCedula(cedula));
    }
}