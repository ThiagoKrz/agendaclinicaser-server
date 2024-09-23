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

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

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
