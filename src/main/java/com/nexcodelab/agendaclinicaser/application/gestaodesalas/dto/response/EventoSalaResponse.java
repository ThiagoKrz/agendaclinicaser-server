package com.nexcodelab.agendaclinicaser.application.gestaodesalas.dto.response;

public class EventoSalaResponse {
    // Sala
    private Long idSala;
    private String localAtendimento;

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
