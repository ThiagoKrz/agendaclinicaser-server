package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.response;

import lombok.Value;

import java.time.LocalDate;
import java.util.Set;

@Value
public class DisponibilidadeResponse {
    Long id;
    LocalDate dataInicio;
    LocalDate dataFim;
    Set<DisponibilidadeDiaSemanaResponse> diasDaSemana;
}
