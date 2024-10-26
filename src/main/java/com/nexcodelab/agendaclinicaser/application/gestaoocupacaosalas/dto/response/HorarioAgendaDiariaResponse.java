package com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.dto.response;

import java.time.LocalTime;
import java.util.List;

public class HorarioAgendaDiariaResponse {
    LocalTime horario;

    // Tipo do evento
    private String tipoEvento;

    // Estagiario
    private String idEstagiario;
    private String nomeCompletoEstagiario;

    // Supervisor
    private String idSupervisor;
    private String nomeCompletoSupervisor;

    // Atendimento
    private Long idServico;
    private String statusServico;
}
