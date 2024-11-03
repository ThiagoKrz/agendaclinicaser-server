package com.nexcodelab.agendaclinicaser.application.atendimento.service;

import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.OcupacaoHorario;
import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.repository.OcupacaoHorarioRepository;
import com.nexcodelab.agendaclinicaser.application.atendimento.dto.request.CadastrarAtendimentoRequest;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.Atendimento;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.EstagiarioEmServico;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.LocalDeTerapia;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.PacienteEmServico;
import com.nexcodelab.agendaclinicaser.application.atendimento.repository.AtendimentoRepository;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeDiaSemana;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadeHoraria;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.application.sala.repository.SalaRepository;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.repository.EstagiarioRepository;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.paciente.repository.PacienteRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.BusinessRuleException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CadastrarAtendimentoUseCase {

    private final DisponibilidadeRepository disponibilidadeRepository;
    private final AtendimentoRepository atendimentoRepository;
    private final OcupacaoHorarioRepository ocupacaoHorarioRepository;

    private final PacienteRepository pacienteRepository;
    private final EstagiarioRepository estagiarioRepository;
    private final SalaRepository salaRepository;

    public void execute(CadastrarAtendimentoRequest request) {
        validarDisponibilidade(request);

        Paciente paciente = pacienteRepository.findById(request.getIdPaciente())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        Estagiario estagiario = estagiarioRepository.findById(request.getIdEstagiario())
                .orElseThrow(() -> new ResourceNotFoundException("Estagiário não encontrado"));

        Sala sala = salaRepository.findById(request.getIdSala())
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrado"));

        PacienteEmServico pacienteEmServico = new PacienteEmServico(paciente);
        EstagiarioEmServico estagiarioEmServico = new EstagiarioEmServico(estagiario);
        LocalDeTerapia localDeTerapia = new LocalDeTerapia(sala);

        Atendimento atendimento = new Atendimento(request.getDataHora(), pacienteEmServico, localDeTerapia, estagiarioEmServico);

        List<OcupacaoHorario> ocupacoes = List.of(
                OcupacaoHorario.ofAcontecendoServico(request.getDataHora(), localDeTerapia),
                OcupacaoHorario.ofPrestandoServico(request.getDataHora(), estagiarioEmServico),
                OcupacaoHorario.ofRecebendoServico(request.getDataHora(), pacienteEmServico)
        );

        atendimentoRepository.save(atendimento);
        ocupacaoHorarioRepository.saveAll(ocupacoes);
    }

    private void validarDisponibilidade(CadastrarAtendimentoRequest request) {
        DisponibilidadePersona disponibilidade = disponibilidadeRepository.findByPersonaId(request.getIdEstagiario())
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidade não encontrada"));

        DisponibilidadeDiaSemana diaSemana = disponibilidade.getDiaDaSemana().stream()
                .filter(d -> d.getDiaDaSemana().equals(request.getDataHora().getDayOfWeek()))
                .findFirst().orElseThrow(() ->  new ResourceNotFoundException("Estagiário não tem disponibilidade no dia"));

        DisponibilidadeHoraria horario = diaSemana.getHorarios().stream().filter(h -> h.getHorario().equals(request.getDataHora().toLocalTime()))
                .findFirst().orElseThrow(() ->  new ResourceNotFoundException("Estagiário não tem disponibilidade no horario"));

        if(horario.getSala() == null || !horario.getSala().getId().equals(request.getIdSala())) {
            throw new BusinessRuleException("Estagiário não tem disponibilidade na sala selecionada");
        }
    }
}
