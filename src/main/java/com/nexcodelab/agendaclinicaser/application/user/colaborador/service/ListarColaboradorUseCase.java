package com.nexcodelab.agendaclinicaser.application.user.colaborador.service;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.persona.repository.PersonaRepository;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarColaboradorUseCase {
    private final PersonaRepository<Colaborador> personaRepository;

    public List<IPersonaResumidaVO> execute() {
        return personaRepository.findAllPersonaResumida().stream()
                .sorted(Comparator.comparing(IPersonaResumidaVO::getNomeCompleto))
                .collect(Collectors.toList());
    }
}
