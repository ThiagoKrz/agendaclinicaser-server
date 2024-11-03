package com.nexcodelab.agendaclinicaser.application.agenda.estagiario.service;

import com.nexcodelab.agendaclinicaser.application.agenda.estagiario.dto.response.AtendimentoAgendaEstagiarioResponse;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.Atendimento;
import com.nexcodelab.agendaclinicaser.application.atendimento.repository.AtendimentoRepository;
import com.nexcodelab.agendaclinicaser.shared.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaEstagiarioUseCase {

    private final AtendimentoRepository atendimentoRepository;

    public List<AtendimentoAgendaEstagiarioResponse> execute(String dataReferencia){

        LocalDateTime dataInicio = DateUtils.toLocalDate(dataReferencia).withDayOfMonth(1)
                .atStartOfDay();
        LocalDateTime dataFim = DateUtils.toLocalDate(dataReferencia).withDayOfMonth(dataInicio.toLocalDate().lengthOfMonth())
                .atTime(LocalTime.MAX);

        List<Atendimento> atendimentos = atendimentoRepository.findAtendimentosNoPeriodo(dataInicio, dataFim);

        return AtendimentoAgendaEstagiarioResponse.of(atendimentos);
    }
}
