package com.nexcodelab.agendaclinicaser.application.user.colaborador.controller;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request.CadastrarColaboradorRequest;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
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
public class CadastrarColaboradorController {

    private final CadastrarPersonaUseCase<Colaborador> service;

    @PostMapping("/colaborador")
    public ResponseEntity<Void> execute(@Valid @RequestBody CadastrarColaboradorRequest request) {
        service.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
