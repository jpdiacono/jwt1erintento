package com.example.proyIntegradorFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nombre;
    private String apellido;
    private int matricula;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

}
