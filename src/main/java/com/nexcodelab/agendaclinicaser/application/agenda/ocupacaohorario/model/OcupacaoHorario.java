package com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model;

import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.enums.TipoOcupacaoHorario;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.EstagiarioEmServico;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.LocalDeTerapia;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.PacienteEmServico;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class OcupacaoHorario extends EntityBase {
    private TipoOcupacaoHorario tipoOcupacao;

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    // ACONTECENDO_SERVICO
    @ManyToOne private LocalDeTerapia localDeTerapia;

    // PRESTANDO_SERVICO
    @ManyToOne private EstagiarioEmServico estagiarioEmServico;

    // RECEBENDO_SERVICO
    @ManyToOne private PacienteEmServico pacienteEmServico;
}
