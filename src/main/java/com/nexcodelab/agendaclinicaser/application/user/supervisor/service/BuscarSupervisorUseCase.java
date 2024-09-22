package com.nexcodelab.agendaclinicaser.application.user.supervisor.service;

import com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.response.DetalhesSupervisorResponse;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.model.Supervisor;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.repository.SupervisorRepository;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarSupervisorUseCase {

    private final SupervisorRepository repository;

    public DetalhesSupervisorResponse execute(String id) {
        Supervisor supervisor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        return toDetalhesSupervisorResponse(supervisor);
    }
    public DetalhesSupervisorResponse toDetalhesSupervisorResponse(Supervisor paciente) {
        return DetalhesSupervisorResponse.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .sobrenome(paciente.getSobrenome())
                .email(paciente.getEmail())
                .telefone(paciente.getTelefone().getNumeroTelefone())
                .build();
    }

}
