package com.example.proyIntegradorFinal.service;

import com.example.proyIntegradorFinal.dto.TurnoDto;
import com.example.proyIntegradorFinal.exceptions.BadRequestException;
import com.example.proyIntegradorFinal.exceptions.ResourceNotFoundException;
import com.example.proyIntegradorFinal.model.Paciente;
import com.example.proyIntegradorFinal.model.Turno;
import com.example.proyIntegradorFinal.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {
    private PacienteService pacienteService;
    private OdontologoService odontologoService;
    private TurnoRepository turnoRepository;

    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }

    public Turno buscarTurno(Integer id) throws ResourceNotFoundException {

        return turnoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Turno no encontrado"));
    }

    public Turno agregarDTO (TurnoDto turnoDto) throws ResourceNotFoundException {
        var odontologo = odontologoService.buscarOdontologo(turnoDto.getIdOdontologo());
        var paciente = pacienteService.buscarPaciente(turnoDto.getIdPaciente());
        var fecha = turnoDto.getFechaAlta();
        var turnoNew = new Turno();
        turnoNew.setOdontologo(odontologo);
        turnoNew.setPaciente(paciente);
        turnoNew.setFecha(fecha);
        turnoRepository.save(turnoNew);
        return turnoNew;
    }

    public void borrarTurno(Integer id) throws ResourceNotFoundException {
        if(buscarTurno(id)== null)throw new ResourceNotFoundException("Turno no encontrado");
        if (turnoRepository.findById(id).isPresent()) {
            turnoRepository.deleteById(id);
        }
    }

    public void actualizarTurno(Turno turno) throws ResourceNotFoundException {
        if(buscarTurno(turno.getId())== null)throw new ResourceNotFoundException("Turno no encontrado");
        turnoRepository.save(turno);
    }
}
