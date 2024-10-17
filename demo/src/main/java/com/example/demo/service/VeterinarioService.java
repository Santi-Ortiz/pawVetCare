package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Especialidad;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.VeterinarioDTO;
import com.example.demo.repository.EspecialidadRepository;
import com.example.demo.repository.VeterinarioRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

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
        } else {
            return new Veterinario();
        }
    }

    @Transactional
    public void actualizarVet(VeterinarioDTO veterinarioDTO) {
        // Busca el veterinario existente por cédula
        Veterinario vetExistente = veterinarioRepository.findByCedula(veterinarioDTO.getCedula());

        // Verifica si el veterinario existe
        if (vetExistente == null) {
            throw new NoSuchElementException("El veterinario con la cédula " + veterinarioDTO.getCedula() + " no existe.");
        }

        // Actualiza los campos
        vetExistente.setNombre(veterinarioDTO.getNombre());
        vetExistente.setContrasena(veterinarioDTO.getContrasena());
        vetExistente.setFoto(veterinarioDTO.getFoto());
        vetExistente.setEstado(veterinarioDTO.getEstado());

        // Busca la especialidad existente en la base de datos
        Especialidad especialidad = especialidadRepository.findById((long) veterinarioDTO.getEspecialidad_id())
                .orElseThrow(() -> new NoSuchElementException("La especialidad con el ID " + veterinarioDTO.getEspecialidad_id() + " no existe."));
        
        vetExistente.setEspecialidad(especialidad);

        // Guarda los cambios
        veterinarioRepository.save(vetExistente);
    }

    @Transactional
    public VeterinarioDTO obtenerVeterinarioPorCedula(Long cedula) {
        Veterinario veterinario = veterinarioRepository.findByCedula(cedula);
        return convertirAVeterinarioDTO(veterinario);
    }

    // Método para convertir de Veterinario a VeterinarioDTO
    private VeterinarioDTO convertirAVeterinarioDTO(Veterinario veterinario) {
        String nombreEspecialidad = veterinario.getEspecialidad() != null ? veterinario.getEspecialidad().getNombre_especialidad() : null;
        return new VeterinarioDTO(
            veterinario
        );
    }

    public Collection<Veterinario> mostrarTodos() {
        return veterinarioRepository.findAll();
    }

    @Transactional
    public List<VeterinarioDTO> mostrarTodosConDTO() {
        List<Veterinario> veterinarios = veterinarioRepository.findAll();

        // Convertir la lista de entidades Veterinario a VeterinarioDTO
        return veterinarios.stream()
                .map(this::convertirAVeterinarioDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void eliminarVet(Long cedula) {
        Veterinario vetExistente = veterinarioRepository.findByCedula(cedula);
        List<Tratamiento> tratamientos = vetExistente.getTratamientos();
        for (Tratamiento tratamiento : tratamientos) {
            tratamiento.setVeterinario(null); 
        }
        veterinarioRepository.delete(vetExistente);
    }

    @Transactional
    public long contarVeterinariosActivos() {
        return veterinarioRepository.countByEstadoTrue();
    }

    @Transactional
    public long contarVeterinariosInactivos() {
        return veterinarioRepository.countByEstadoFalse();
    }

    @Transactional
    public long contarVeterinarios() {
        return veterinarioRepository.count();
    }
}
