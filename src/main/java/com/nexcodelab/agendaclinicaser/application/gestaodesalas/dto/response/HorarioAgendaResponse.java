package com.nexcodelab.agendaclinicaser.application.gestaodesalas.dto.response;

import java.time.LocalTime;
import java.util.List;

public class HorarioAgendaResponse {
    LocalTime horario;
    List<EventoSalaResponse> salas;
}
