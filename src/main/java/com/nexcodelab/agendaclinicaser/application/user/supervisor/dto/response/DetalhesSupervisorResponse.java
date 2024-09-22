package com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.response;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class DetalhesSupervisorResponse {
    String id;
    String nome;
    String sobrenome;
    String email;
    String telefone;
}
