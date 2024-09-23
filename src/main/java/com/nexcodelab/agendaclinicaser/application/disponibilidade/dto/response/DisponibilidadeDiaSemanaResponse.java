package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.response;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeHoraria;
import lombok.Value;

import java.time.LocalDate;
import java.util.Set;

@Value
public class DisponibilidadeDiaSemanaResponse {
    Integer diaDaSemana;
    Set<DisponibilidadeHorariaResponse> horarios;
}
