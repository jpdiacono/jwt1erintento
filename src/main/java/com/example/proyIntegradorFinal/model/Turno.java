package com.example.proyIntegradorFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"Turnos", "hibernateLazyInitializer"})
    private Odontologo odontologo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false,  referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"Turnos", "hibernateLazyInitializer"})
    private Paciente paciente;
    @Column
    private LocalDate fecha;

}
