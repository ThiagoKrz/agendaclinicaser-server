package com.nexcodelab.agendaclinicaser.application.disponibilidade.repository;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.vo.DisponibilidadeParaPainelDeSalasVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadePersona, Long> {

    @Query("SELECT COUNT(d) > 0 FROM DisponibilidadePersona d WHERE d.personaId = :personaId")
    boolean existsDisponibilidadeEstagiario(String personaId);

    @Query("SELECT d FROM DisponibilidadePersona d WHERE d.personaId = :id")
    Optional<DisponibilidadePersona> findByPersonaId(String id);

    @Query("SELECT d FROM DisponibilidadePersona d WHERE d.personaId IN :ids")
    List<DisponibilidadePersona> findByPersonasIds(List<String> ids);

    @Query("SELECT new com.nexcodelab.agendaclinicaser.application.disponibilidade.vo.DisponibilidadeParaPainelDeSalasVO(" +
            "   d.personaId, " +
            "   CONCAT(p.nome, ' ', p.sobrenome), " +
            "   dd.diaDaSemana, " +
            "   h.horario, " +
            "   h.sala) " +
            "FROM DisponibilidadePersona d " +
            "JOIN Persona p ON d.personaId = p.id " +
            "JOIN d.diaDaSemana dd " +
            "JOIN dd.horarios h " +
            "WHERE h.sala IS NOT NULL ")
    List<DisponibilidadeParaPainelDeSalasVO> findDisponibilidadeParaPainelDeSalas();

}
