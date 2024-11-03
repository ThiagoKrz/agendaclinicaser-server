package com.nexcodelab.agendaclinicaser.application.atendimento.dto.request;

import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.enums.ComparecimentoEnvolvido;
import lombok.Value;

@Value
public class StatusAtendimentoRequest {
    ComparecimentoEnvolvido statusComparecimentoEstagiario;
    ComparecimentoEnvolvido statusComparecimentoPaciente;
}
