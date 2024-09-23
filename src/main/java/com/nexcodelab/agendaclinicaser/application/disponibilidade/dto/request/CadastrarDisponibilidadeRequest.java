package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

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
