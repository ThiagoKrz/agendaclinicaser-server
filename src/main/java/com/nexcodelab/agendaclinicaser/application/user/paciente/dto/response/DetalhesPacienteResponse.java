package com.nexcodelab.agendaclinicaser.application.user.paciente.dto.response;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class DetalhesPacienteResponse {
    String id;
    String nome;
    String sobrenome;
    String email;
    String telefone;
}
