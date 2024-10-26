package com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Value
public class VincularOcupacaoPainelDeSalaRequest {
    @NotEmpty
    String estagiarioId;

    @NotEmpty
    DayOfWeek diaDaSemana;

    @NotNull
    LocalTime horario;

    @NotEmpty
    String salaId;
}
