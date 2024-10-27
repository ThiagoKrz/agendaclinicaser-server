package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.response;

import lombok.Value;

import java.time.LocalTime;

@Value
public class DisponibilidadeHorariaResponse {
    LocalTime horario;
}
