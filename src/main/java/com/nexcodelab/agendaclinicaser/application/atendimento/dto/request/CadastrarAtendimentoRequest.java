package com.nexcodelab.agendaclinicaser.application.atendimento.dto.request;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CadastrarAtendimentoRequest {
    String idEstagiario;
    String idPaciente;
    String idSala;
    LocalDateTime dataHora;
}
