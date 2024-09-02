package com.nexcodelab.agendaclinicaser.application.user.paciente.controller;

import com.nexcodelab.agendaclinicaser.application.user.paciente.dto.request.CadastrarPacienteRequest;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
@RequiredArgsConstructor
public class CadastrarPacienteController {

    private final CadastrarPersonaUseCase<Paciente> service;

    @PostMapping("/paciente")
    public ResponseEntity<Void> execute(@Valid @RequestBody CadastrarPacienteRequest request) {
        service.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
