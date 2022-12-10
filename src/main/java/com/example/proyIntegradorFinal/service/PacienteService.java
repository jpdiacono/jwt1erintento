package com.example.proyIntegradorFinal.service;

import com.example.proyIntegradorFinal.exceptions.BadRequestException;
import com.example.proyIntegradorFinal.exceptions.ResourceNotFoundException;
import com.example.proyIntegradorFinal.model.Odontologo;
import com.example.proyIntegradorFinal.model.Paciente;
import com.example.proyIntegradorFinal.repository.OdontologoRepository;
import com.example.proyIntegradorFinal.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PacienteService{
        private final PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPaciente(Integer id) throws ResourceNotFoundException{

        return pacienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Paciente no encontrado"));
    }

    public void agregarPaciente(Paciente pacienteNuevo) throws BadRequestException {
        if(Objects.isNull(pacienteNuevo.getFechaAlta()))throw new BadRequestException("Faltan datos");

        pacienteRepository.save(pacienteNuevo);
    }

    public void borrarPaciente(Integer id) throws ResourceNotFoundException {
        if(buscarPaciente(id)== null)throw new ResourceNotFoundException("Paciente no encontrado");
        if (pacienteRepository.findById(id).isPresent()) {
            pacienteRepository.deleteById(id);
        }
    }

    public void actualizarPaciente(Paciente paciente) throws ResourceNotFoundException {
        if(buscarPaciente(paciente.getId())== null)throw new ResourceNotFoundException("Paciente no existente");
        pacienteRepository.save(paciente);
    }
}
