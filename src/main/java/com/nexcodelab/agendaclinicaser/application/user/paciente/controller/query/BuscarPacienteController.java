package com.nexcodelab.agendaclinicaser.application.user.paciente.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.response.DetalhesEstagiarioResponse;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.service.BuscarEstagiarioUseCase;
import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.response.DetalhesPacienteResponse;
import com.nexcodelab.agendaclinicaser.application.user.paciente.service.BuscarPacienteUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BuscarPacienteController {

    private final BuscarPacienteUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/paciente/{id}")
    public ResponseEntity<DetalhesPacienteResponse> execute(@PathVariable String id) {
        return ResponseEntity.ok(service.execute(id));
    }
}