package com.nexcodelab.agendaclinicaser.application.disponibilidade.repository;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeDiaSemana;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DisponibilidadeDiaSemanaRepository extends JpaRepository<DisponibilidadeDiaSemana, Long> {
}
