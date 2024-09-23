package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Value
public class CadastrarHorarioRequest {
    @NotNull
    LocalTime horaInicio;

    @NotNull
    LocalTime horaFim;
}
