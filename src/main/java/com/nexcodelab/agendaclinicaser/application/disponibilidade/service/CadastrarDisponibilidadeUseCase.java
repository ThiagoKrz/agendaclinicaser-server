package com.nexcodelab.agendaclinicaser.application.disponibilidade.service;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request.CadastrarDisponibilidadeRequest;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeDiaSemana;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeHoraria;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.repository.EstagiarioRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BusinessRuleException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import com.nexcodelab.agendaclinicaser.shared.utils.DiaDaSemanaUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                            .map(horario -> new DisponibilidadeHoraria(horario.getHorario()))
                            .collect(Collectors.toSet());

                    return new DisponibilidadeDiaSemana(DiaDaSemanaUtils.toDayOfWeek(dia.getDiaDaSemana()), horarios);
                }).collect(Collectors.toSet());

        return new DisponibilidadePersona(request.getIdEstagiario(), disponibilidadeDiaSemanas);
    }

    private void validar(CadastrarDisponibilidadeRequest request) {
        validarEstagiario(request);
        validarSeJaExisteDisponibilidade(request);
    }

    private void validarSeJaExisteDisponibilidade(CadastrarDisponibilidadeRequest request) {
        if (disponibilidadeRepository.existsDisponibilidadeEstagiario(request.getIdEstagiario())) {
            throw new BusinessRuleException("Existe conflito com uma disponibilidade existente");
        }
    }

    private void validarEstagiario(CadastrarDisponibilidadeRequest request) {
        if (!estagiarioRepository.existsById(request.getIdEstagiario())) {
            throw new ResourceNotFoundException("Estagiário não encontrado");
        }
    }
}
