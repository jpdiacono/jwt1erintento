package com.example.proyIntegradorFinal.repository;

import com.example.proyIntegradorFinal.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno,Integer> {
}
