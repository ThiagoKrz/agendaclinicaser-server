package com.nexcodelab.agendaclinicaser.application.user.paciente.service;

import com.nexcodelab.agendaclinicaser.application.user.paciente.repository.PacienteRepository;
import com.nexcodelab.agendaclinicaser.application.user.paciente.vo.IPacienteParaListagemVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarPacienteUseCase {

    private final PacienteRepository pacienteRepository;

    public List<IPacienteParaListagemVO> execute() {
        return pacienteRepository.listarPacientes().stream()
                .sorted(Comparator.comparing(IPacienteParaListagemVO::getNomeCompleto))
                .collect(Collectors.toList());
    }
}
