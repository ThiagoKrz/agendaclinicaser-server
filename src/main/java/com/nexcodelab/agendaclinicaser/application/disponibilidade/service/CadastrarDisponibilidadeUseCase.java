package com.nexcodelab.agendaclinicaser.application.disponibilidade.service;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request.CadastrarDisponibilidadeRequest;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeDiaSemana;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeHoraria;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.repository.EstagiarioRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BusinessRuleException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.InvalidDateRangeException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import com.nexcodelab.agendaclinicaser.shared.utils.DateUtils;
import com.nexcodelab.agendaclinicaser.shared.utils.DiaDaSemanaUtils;
import com.nexcodelab.agendaclinicaser.shared.utils.StreamUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CadastrarDisponibilidadeUseCase {

    private final DisponibilidadeRepository disponibilidadeRepository;
    private final EstagiarioRepository estagiarioRepository;

    public void execute(CadastrarDisponibilidadeRequest request) {
        validar(request);

        DisponibilidadePersona disponibilidadePersona = toDisponibilidadePersona(request);

        disponibilidadeRepository.save(disponibilidadePersona);
    }

    private DisponibilidadePersona toDisponibilidadePersona(CadastrarDisponibilidadeRequest request) {
        Set<DisponibilidadeDiaSemana> disponibilidadeDiaSemanas = request.getDiasDaSemana().stream()
                .map(dia -> {
                    Set<DisponibilidadeHoraria> horarios = dia.getHorarios().stream()
                            .map(horario -> new DisponibilidadeHoraria(horario.getHoraInicio(), horario.getHoraFim()))
                            .collect(Collectors.toSet());

                    return new DisponibilidadeDiaSemana(DiaDaSemanaUtils.toDayOfWeek(dia.getDiaDaSemana()), horarios);
                }).collect(Collectors.toSet());

        return new DisponibilidadePersona( request.getDataInicio(), request.getDataFim(), request.getIdEstagiario(), disponibilidadeDiaSemanas);
    }

    private void validar(CadastrarDisponibilidadeRequest request) {
        validarDataInicioInvalida(request);
        validarHoraInicioInvalida(request);
        validarEstagiario(request);
        validarConflitoHorarios(request);
    }

    private void validarDataInicioInvalida(CadastrarDisponibilidadeRequest request) {
        Boolean isInvalido = DateUtils.isLocalDateGreaterOrEqual(request.getDataInicio(), request.getDataFim());

        if (isInvalido) {
            throw new InvalidDateRangeException("A data inicial é maior ou igual que a data final");
        }
    }

    private void validarHoraInicioInvalida(CadastrarDisponibilidadeRequest request) {
        Boolean isInvalido = request.getDiasDaSemana().stream()
                .flatMap(diaSemana -> diaSemana.getHorarios().stream())
                .anyMatch(StreamUtils.isLocalTimeGreaterOrEqual(dia -> dia.getHoraInicio(), dia -> dia.getHoraFim()));

        if (isInvalido) {
            throw new InvalidDateRangeException("A hora inicial é maior ou igual que a hora final");
        }
    }

    private void validarConflitoHorarios(CadastrarDisponibilidadeRequest request) {
        if (disponibilidadeRepository.existsDisponibilidadeConflitante(request.getDataInicio(), request.getDataFim(), request.getIdEstagiario())) {
            throw new BusinessRuleException("Existe conflito com uma disponibilidade existente");
        }
    }

    private void validarEstagiario(CadastrarDisponibilidadeRequest request) {
        if (!estagiarioRepository.existsById(request.getIdEstagiario())) {
            throw new ResourceNotFoundException("Estagiário não encontrado");
        }
    }
}
