package com.nexcodelab.agendaclinicaser.application.disponibilidade.repository;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadePersona, Long> {

    @Query("SELECT COUNT(d) > 0 FROM DisponibilidadePersona d  " +
           "WHERE d.personaId = :personaId " +
           "AND :inicio <= d.dataFim " +
           "AND  :fim >= d.dataInicio"
    )
    boolean existsDisponibilidadeConflitante(LocalDate inicio, LocalDate fim, String personaId);

    @Query("SELECT d FROM DisponibilidadePersona d WHERE d.personaId = :id")
    List<DisponibilidadePersona> findByPersonaId(String id);
}
