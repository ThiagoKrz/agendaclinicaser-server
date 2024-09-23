package com.nexcodelab.agendaclinicaser.application.disponibilidade.service;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.model.DisponibilidadePersona;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.repository.DisponibilidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Transactional
@Service
@RequiredArgsConstructor
public class ExcluirDisponibilidadeUseCase {

    private final DisponibilidadeRepository disponibilidadeRepository;

    /**
     * TODO Validar se tem algum atendimento na disponibilidade antes de excluir
     */
    public void execute(Long id) {
        DisponibilidadePersona disponibilidadePersona = disponibilidadeRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Disponibilidade não encontrada"));

        disponibilidadeRepository.delete(disponibilidadePersona);
    }


}
