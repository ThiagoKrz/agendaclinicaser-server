package com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.response;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class DetalhesEstagiarioResponse{
    String id;
    String nome;
    String sobrenome;
    String email;
    String telefone;
    Integer periodo;
    Integer horasRequeridas;
    String nomeCompletoSupervisor;
}
