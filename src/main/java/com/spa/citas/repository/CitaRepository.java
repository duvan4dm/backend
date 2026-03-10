package com.spa.citas.repository;

import com.spa.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;


public interface CitaRepository extends JpaRepository<Cita, Integer> {

    boolean existsByFechaAndHora(LocalDate fecha, LocalTime hora);
}
