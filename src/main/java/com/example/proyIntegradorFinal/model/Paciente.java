package com.example.proyIntegradorFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String dni;
    private LocalDate fechaAlta;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();
}
