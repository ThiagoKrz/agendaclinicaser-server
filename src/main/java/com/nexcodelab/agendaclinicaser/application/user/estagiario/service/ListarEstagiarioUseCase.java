package com.nexcodelab.agendaclinicaser.application.user.estagiario.service;

import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
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
public class ListarEstagiarioUseCase {
    private final PersonaRepository<Estagiario> personaRepository;

    public List<IPersonaResumidaVO> execute() {
        return personaRepository.findAllPersonaResumida().stream()
                .sorted(Comparator.comparing(IPersonaResumidaVO::getNomeCompleto))
                .collect(Collectors.toList());
    }
}
