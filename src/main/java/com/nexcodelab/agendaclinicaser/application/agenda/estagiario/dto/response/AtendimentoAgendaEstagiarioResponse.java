package com.nexcodelab.agendaclinicaser.application.agenda.estagiario.dto.response;

import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.enums.ComparecimentoEnvolvido;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.Atendimento;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
@Builder
public class AtendimentoAgendaEstagiarioResponse {
    Long id;
    LocalDateTime dataHora;

    String idPaciente;
    String nomePaciente;
    String siglaPaciente;
    ComparecimentoEnvolvido comparecimentoEnvolvidoPaciente;

    String idEstagiario;
    String nomeEstagiario;
    String siglaEstagiario;
    ComparecimentoEnvolvido comparecimentoEnvolvidoEstagiario;

    String idSala;
    String nomeSala;


    public static List<AtendimentoAgendaEstagiarioResponse> of(List<Atendimento> atendimentos) {
        return atendimentos.stream().map(AtendimentoAgendaEstagiarioResponse::of).collect(Collectors.toList());
    }

    public static AtendimentoAgendaEstagiarioResponse of(Atendimento atendimento) {
        return AtendimentoAgendaEstagiarioResponse.builder()
                .id(atendimento.getId())
                .dataHora(atendimento.getDataHora())
                .idPaciente(atendimento.getPacienteEmServico().getPaciente().getId())
                .nomePaciente(atendimento.getPacienteEmServico().getPaciente().getNomeCompleto())
                .siglaPaciente(atendimento.getPacienteEmServico().getPaciente().getSigla())
                .comparecimentoEnvolvidoPaciente(atendimento.getPacienteEmServico().getComparecimentoEnvolvido())
                .idEstagiario(atendimento.getEstagiarioEmServico().getEstagiario().getId())
                .nomeEstagiario(atendimento.getEstagiarioEmServico().getEstagiario().getNomeCompleto())
                .siglaEstagiario(atendimento.getEstagiarioEmServico().getEstagiario().getSigla())
                .comparecimentoEnvolvidoEstagiario(atendimento.getEstagiarioEmServico().getComparecimentoEnvolvido())
                .idSala(atendimento.getLocalDeTerapia().getSala().getId())
                .nomeSala(atendimento.getLocalDeTerapia().getSala().getNome())
                .build();
    }
}
