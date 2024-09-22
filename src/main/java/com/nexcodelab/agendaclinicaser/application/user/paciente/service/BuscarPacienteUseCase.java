package com.nexcodelab.agendaclinicaser.application.user.paciente.service;

import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.response.DetalhesPacienteResponse;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.paciente.repository.PacienteRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarPacienteUseCase {

    private final PacienteRepository repository;

    public DetalhesPacienteResponse execute(String id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        return toDetalhesPacienteResponse(paciente);
    }
    public DetalhesPacienteResponse toDetalhesPacienteResponse(Paciente paciente) {
        return DetalhesPacienteResponse.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .sobrenome(paciente.getSobrenome())
                .email(paciente.getEmail())
                .telefone(paciente.getTelefone().getNumeroTelefone())
                .build();
    }

}
