package com.nexcodelab.agendaclinicaser.application.sala.service;

import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.application.sala.repository.SalaRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequiredArgsConstructor
public class AtivarInativarSalaUseCase {

    private final SalaRepository repository;

    /**
     * Todo Adicionar validação para impossibilitar inativar se tiver atendimento marcado no dia ou posterior
     *
     */
    public void execute(String id){
        Sala sala = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));

        sala.ativarInativar();
    }
}
