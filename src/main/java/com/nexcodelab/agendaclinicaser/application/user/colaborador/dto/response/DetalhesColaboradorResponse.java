package com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.response;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class DetalhesColaboradorResponse {
    String id;
    String nome;
    String sobrenome;
    String email;
    String telefone;
}
