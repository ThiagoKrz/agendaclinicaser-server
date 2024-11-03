package com.nexcodelab.agendaclinicaser.application.atendimento.service;

import com.nexcodelab.agendaclinicaser.application.atendimento.dto.request.StatusAtendimentoRequest;
import com.nexcodelab.agendaclinicaser.application.atendimento.model.Atendimento;
import com.nexcodelab.agendaclinicaser.application.atendimento.repository.AtendimentoRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AlterarStatusAtendimentoUseCase {

    private final AtendimentoRepository atendimentoRepository;

    public void execute(Long id, StatusAtendimentoRequest request) {
        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atendimento não encontrado"));


        atendimento.getPacienteEmServico().setComparecimentoEnvolvido(request.getStatusComparecimentoPaciente());
        atendimento.getEstagiarioEmServico().setComparecimentoEnvolvido(request.getStatusComparecimentoEstagiario());
    }
}
