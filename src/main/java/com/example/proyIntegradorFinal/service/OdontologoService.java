package com.example.proyIntegradorFinal.service;

import com.example.proyIntegradorFinal.exceptions.BadRequestException;
import com.example.proyIntegradorFinal.exceptions.ResourceNotFoundException;
import com.example.proyIntegradorFinal.model.Odontologo;
import com.example.proyIntegradorFinal.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdontologoService {

    private final OdontologoRepository odontologoRepository;

    public List<Odontologo> listarOdontologos() {
        return odontologoRepository.findAll();
    }

    public Odontologo buscarOdontologo(Integer id) throws ResourceNotFoundException {
        return odontologoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Odontologo no encontrado"));
    }

    public void agregarOdontologo(Odontologo odontologoNuevo) throws BadRequestException {
        if(Objects.isNull(odontologoNuevo.getMatricula()))throw new BadRequestException("Faltan datos");
            odontologoRepository.save(odontologoNuevo);

    }

    public void borrarOdontologo(Integer id) throws ResourceNotFoundException{
        if(buscarOdontologo(id)== null)throw new ResourceNotFoundException("Odontologo no encontrado");
        if (odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
        }
    }

    public void actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException {
        if(buscarOdontologo(odontologo.getId())== null)throw new ResourceNotFoundException("Odontologo no existente");
        odontologoRepository.save(odontologo);
    }
}
