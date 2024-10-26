package com.nexcodelab.agendaclinicaser.application.disponibilidade.service;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.response.DisponibilidadeDiaSemanaResponse;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.response.DisponibilidadeHorariaResponse;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.response.DisponibilidadeResponse;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class ListarDisponibilidadeUseCase {

    private final DisponibilidadeRepository disponibilidadeRepository;

    public DisponibilidadeResponse execute(String id) {
        DisponibilidadePersona disponibilidade = disponibilidadeRepository.findByPersonaId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidade não encontrada"));

        return toDisponibilidadePersona(disponibilidade);
    }

    private DisponibilidadeResponse toDisponibilidadePersona(DisponibilidadePersona disponibilidade) {
        Set<DisponibilidadeDiaSemanaResponse> diasDaSemana = disponibilidade.getDiaDaSemana().stream()
                .map(dia  -> {
                    Set<DisponibilidadeHorariaResponse> horarios = dia.getHorarios().stream()
                            .map(horario -> new DisponibilidadeHorariaResponse(horario.getHoraInicio(), horario.getHoraFim()))
                            .collect(Collectors.toSet());

                    return new DisponibilidadeDiaSemanaResponse(
                            dia.getDiaDaSemana().getValue() == 7 ? 0 : dia.getDiaDaSemana().getValue(),
                            horarios
                    );

                }).collect(Collectors.toSet());

        return new DisponibilidadeResponse(disponibilidade.getId(), diasDaSemana);
    }


}
