package com.example.proyIntegradorFinal.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TurnoDto {
    private Integer idOdontologo;
    private Integer idPaciente;
    private LocalDate fechaAlta;

}
