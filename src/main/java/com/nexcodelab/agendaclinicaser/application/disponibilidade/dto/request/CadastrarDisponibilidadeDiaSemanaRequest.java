package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.List;

@Value
public class CadastrarDisponibilidadeDiaSemanaRequest {
    @NotNull
    Integer diaDaSemana;

    @NotNull
    List<CadastrarHorarioRequest> horarios;
}
