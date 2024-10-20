package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Value
public class CadastrarDisponibilidadeRequest {

    @NotBlank
    String idEstagiario;

    @NotNull
    LocalDate dataInicio;

    @NotNull
    LocalDate dataFim;

    @NotEmpty
    Set<CadastrarDisponibilidadeDiaSemanaRequest> diasDaSemana;
}
