package com.example.proyIntegradorFinal.controller;

import com.example.proyIntegradorFinal.exceptions.BadRequestException;
import com.example.proyIntegradorFinal.exceptions.ResourceNotFoundException;
import com.example.proyIntegradorFinal.model.Odontologo;
import com.example.proyIntegradorFinal.model.Paciente;
import com.example.proyIntegradorFinal.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping("/pacientes")
    public List<Paciente> listarPacientes(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/paciente/{id}")
    public Paciente getById(@PathVariable Integer id) throws ResourceNotFoundException {
        return pacienteService.buscarPaciente(id);
    }

    @PostMapping("/paciente/agregar")
    public void agregarPaciente(@RequestBody Paciente paciente) throws BadRequestException {
        pacienteService.agregarPaciente(paciente);
    }

    @DeleteMapping("/paciente/borrar/{id}")
    public void eliminarPaciente(@RequestBody Integer id) throws ResourceNotFoundException {
        pacienteService.borrarPaciente(id);
    }

    @PutMapping("/paciente/actualizar")
    public void actualizarPaciente(@RequestBody Paciente paciente) throws ResourceNotFoundException {
        pacienteService.actualizarPaciente(paciente);
    }
}
