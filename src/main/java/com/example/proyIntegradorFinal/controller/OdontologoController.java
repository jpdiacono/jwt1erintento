package com.example.proyIntegradorFinal.controller;

import com.example.proyIntegradorFinal.exceptions.BadRequestException;
import com.example.proyIntegradorFinal.exceptions.ResourceNotFoundException;
import com.example.proyIntegradorFinal.model.Odontologo;
import com.example.proyIntegradorFinal.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class OdontologoController {
    private final OdontologoService odontologoService;

    @GetMapping("/odontologos")
    public List<Odontologo> listarOdontologos(){
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/odontologo/{id}")
    public Odontologo getById(@PathVariable Integer id) throws ResourceNotFoundException {
        return odontologoService.buscarOdontologo(id);
    }

    @PostMapping("/odontologo/agregar")
    public void agregarOdontologo(@RequestBody Odontologo odontologo) throws BadRequestException {
        odontologoService.agregarOdontologo(odontologo);
    }

    @DeleteMapping("/odontologo/borrar/{id}")
    public void eliminarOdontologo(@RequestBody Integer id) throws ResourceNotFoundException {
        odontologoService.borrarOdontologo(id);
    }

    @PutMapping("/odontologo/actualizar")
    public void actualizarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        odontologoService.actualizarOdontologo(odontologo);
    }

}
