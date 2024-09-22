package com.nexcodelab.agendaclinicaser.application.user.supervisor.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.response.DetalhesPacienteResponse;
import com.nexcodelab.agendaclinicaser.application.user.paciente.service.BuscarPacienteUseCase;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.response.DetalhesSupervisorResponse;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.service.BuscarSupervisorUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BuscarSupervisorController {

    private final BuscarSupervisorUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/supervisor/{id}")
    public ResponseEntity<DetalhesSupervisorResponse> execute(@PathVariable String id) {
        return ResponseEntity.ok(service.execute(id));
    }
}
