package com.nexcodelab.agendaclinicaser.application.user.supervisor.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.response.DetalhesPacienteResponse;
import com.nexcodelab.agendaclinicaser.application.user.paciente.service.BuscarPacienteUseCase;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.response.DetalhesSupervisorResponse;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.service.BuscarSupervisorUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Supervisor")
@RestController
@RequiredArgsConstructor
public class BuscarSupervisorController {

    private final BuscarSupervisorUseCase service;

    @Operation(summary = "Detalhar supervisor")
    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/supervisor/{id}")
    public ResponseEntity<DetalhesSupervisorResponse> execute(@PathVariable String id) {
        return ResponseEntity.ok(service.execute(id));
    }
}
