package com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.service;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeDiaSemana;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeHoraria;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.dto.request.VincularOcupacaoPainelDeSalaRequest;
import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.application.sala.repository.SalaRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VincularOcupacaoPainelDeSalaUseCase {

    private final DisponibilidadeRepository disponibilidadeRepository;
    private final SalaRepository salaRepository;

    public void execute(List<VincularOcupacaoPainelDeSalaRequest> request) {

        Map<String, List<VincularOcupacaoPainelDeSalaRequest>> requestByEstagiario = request.stream()
                .collect(Collectors.groupingBy(VincularOcupacaoPainelDeSalaRequest::getEstagiarioId));

        Map<String, DisponibilidadePersona> disponibilidadeMap = disponibilidadeRepository.findByPersonasIds(
                new ArrayList<>(requestByEstagiario.keySet())
        ).stream().collect(Collectors.toMap(DisponibilidadePersona::getPersonaId, d -> d));


        List<Sala> salas = salaRepository.findAllById(
                request.stream().map(VincularOcupacaoPainelDeSalaRequest::getSalaId).distinct().toList()
        );

        // Converte a lista de salas em um Map para acessos rápidos
        Map<String, Sala> salaMap = salas.stream().collect(Collectors.toMap(Sala::getId, s -> s));

        // Processa cada estagiário e vincula suas ocupações
        requestByEstagiario.forEach((estagiarioId, ocupacoes) -> {
            DisponibilidadePersona disponibilidade = disponibilidadeMap.get(estagiarioId);
            if (disponibilidade == null) {
                throw new ResourceNotFoundException("Disponibilidade não encontrada para o estagiário: " + estagiarioId);
            }

            // Vincula as ocupações com as disponibilidades
            vincularOcupacao(disponibilidade, ocupacoes, salaMap);
        });
    }

    private void vincularOcupacao(DisponibilidadePersona disponibilidade,
                                  List<VincularOcupacaoPainelDeSalaRequest> ocupacoes,
                                  Map<String, Sala> salaMap) {

        // Converte a lista de DisponibilidadeDiaSemana para um Map
        Map<DayOfWeek, DisponibilidadeDiaSemana> disponibilidadePorDiaMap = disponibilidade.getDiaDaSemana().stream()
                .collect(Collectors.toMap(DisponibilidadeDiaSemana::getDiaDaSemana, d -> d));

        ocupacoes.forEach(ocupacao -> {
            DisponibilidadeDiaSemana dia = disponibilidadePorDiaMap.get(ocupacao.getDiaDaSemana());
            if (dia == null) {
                throw new ResourceNotFoundException("Disponibilidade não encontrada para o dia: " + ocupacao.getDiaDaSemana());
            }

            // Converte os horários em um Map para acesso rápido
            Map<LocalTime, DisponibilidadeHoraria> horarioMap = dia.getHorarios().stream()
                    .collect(Collectors.toMap(DisponibilidadeHoraria::getHoraInicio, h -> h));

            DisponibilidadeHoraria disponibilidadeHoraria = horarioMap.get(ocupacao.getHorario());
            if (disponibilidadeHoraria == null) {
                throw new ResourceNotFoundException("Horário não encontrado: " + ocupacao.getHorario());
            }

            Sala sala = salaMap.get(ocupacao.getSalaId());
            if (sala == null) {
                throw new ResourceNotFoundException("Sala não encontrada com o ID: " + ocupacao.getSalaId());
            }

            // Atualiza a sala da disponibilidade horária
            disponibilidadeHoraria.atualizarSala(sala);
        });
    }
}
