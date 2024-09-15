package com.nexcodelab.agendaclinicaser.application.user.paciente.controller.command;

import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.request.CadastrarPacienteRequest;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.paciente.service.CadastrarPacienteUseCase;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CadastrarPacienteController {

    private final CadastrarPacienteUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @PostMapping("/paciente")
    public ResponseEntity<Paciente> execute(@Valid @RequestBody CadastrarPacienteRequest request) {
        return new ResponseEntity(service.execute(request), HttpStatus.CREATED);
    }

}
