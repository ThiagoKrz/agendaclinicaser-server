package com.nexcodelab.agendaclinicaser.application.gestaodesalas.dto.response;

import java.time.LocalDate;
import java.util.List;

public class AgendaDiariaSalasResponse {
    LocalDate data;
    List<HorarioAgendaResponse> horarios;

}
