package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Especialidad;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.VeterinarioRepository;

import java.util.*;

@Service
public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Transactional
    public Veterinario buscarVetPorCedula(Long cedula){
      return veterinarioRepository.findByCedula(cedula);
    }

    @Transactional
    public Veterinario buscarVet(Long id){
      return veterinarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public Veterinario agregarVet(Veterinario veterinario){
      if(veterinarioRepository.findByCedula(veterinario.getCedula()) == null){
        return veterinarioRepository.save(veterinario);
      } else{
        return new Veterinario();
      }
    }

    @Transactional
public void actualizarVet(Veterinario veterinario) {
    // Busca el veterinario existente en la base de datos por cédula
    Veterinario vetExistente = veterinarioRepository.findByCedula(veterinario.getCedula());
    
    // Verifica si el veterinario existe
    if (vetExistente == null) {
        throw new NoSuchElementException("El veterinario con la cédula " + veterinario.getCedula() + " no existe.");
    }

    // Actualiza los campos del veterinario existente
    vetExistente.setNombre(veterinario.getNombre());
    vetExistente.setContrasena(veterinario.getContrasena());
    vetExistente.setFoto(veterinario.getFoto());
    vetExistente.setEspecialidad(veterinario.getEspecialidad());
    vetExistente.setTratamientos(veterinario.getTratamientos());

    // Guarda los cambios en la base de datos
    veterinarioRepository.save(vetExistente);
}


    public Collection<Veterinario> mostrarTodos(){
      return veterinarioRepository.findAll();
    }

    @Transactional
    public void eliminarVet(Long cedula){
      veterinarioRepository.delete(veterinarioRepository.findByCedula(cedula));
    }
}