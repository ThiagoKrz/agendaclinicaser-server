package com.nexcodelab.agendaclinicaser.application.atendimento.repository;

import com.nexcodelab.agendaclinicaser.application.atendimento.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {


    @Query("SELECT a FROM Atendimento a " +
            "WHERE a.dataHora BETWEEN :dataInicioInicioDoDia AND :dataFimFimDoDia")
    List<Atendimento> findAtendimentosNoPeriodo(@Param("dataInicioInicioDoDia") LocalDateTime dataInicioInicioDoDia,
                                                @Param("dataFimFimDoDia") LocalDateTime dataFimFimDoDia);
}
