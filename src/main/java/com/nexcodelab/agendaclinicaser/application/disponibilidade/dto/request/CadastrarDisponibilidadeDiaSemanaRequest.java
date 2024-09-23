package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class CadastrarDisponibilidadeDiaSemanaRequest {
    @NotNull
    Integer diaDaSemana;

    @NotNull
    List<CadastrarHorarioRequest> horarios;
}
