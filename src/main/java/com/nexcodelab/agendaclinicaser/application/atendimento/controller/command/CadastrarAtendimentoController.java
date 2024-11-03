package com.nexcodelab.agendaclinicaser.application.atendimento.controller.command;

import com.nexcodelab.agendaclinicaser.application.atendimento.dto.request.CadastrarAtendimentoRequest;
import com.nexcodelab.agendaclinicaser.application.atendimento.service.CadastrarAtendimentoUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Atendimento")
@RestController
@RequiredArgsConstructor
public class CadastrarAtendimentoController {

    private final CadastrarAtendimentoUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @PostMapping("/atendimento")
    public ResponseEntity<Void> execute(@RequestBody @Valid CadastrarAtendimentoRequest request){
        service.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}