package com.nexcodelab.agendaclinicaser.application.disponibilidade.repository;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadePersona, Long> {

    @Query("SELECT COUNT(d) > 0 FROM DisponibilidadePersona d WHERE d.personaId = :personaId")
    boolean existsDisponibilidadeEstagiario(String personaId);

    @Query("SELECT d FROM DisponibilidadePersona d WHERE d.personaId = :id")
    Optional<DisponibilidadePersona> findByPersonaId(String id);

    @Query("SELECT d FROM DisponibilidadePersona d WHERE d.personaId IN :ids")
    List<DisponibilidadePersona> findByPersonasIds(List<String> ids);
}
