package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Value
public class CadastrarHorarioRequest {
    @NotNull
    LocalTime horaInicio;

    @NotNull
    LocalTime horaFim;
}
