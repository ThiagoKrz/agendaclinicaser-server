package com.nexcodelab.agendaclinicaser.application.atendimento.controller.command;

import com.nexcodelab.agendaclinicaser.application.atendimento.dto.request.StatusAtendimentoRequest;
import com.nexcodelab.agendaclinicaser.application.atendimento.service.AlterarStatusAtendimentoUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Atendimento")
@RestController
@RequiredArgsConstructor
public class AlterarStatusAtendimentoController {

    private final AlterarStatusAtendimentoUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @PatchMapping("/atendimento/{id}/status")
    public ResponseEntity<Void> execute(@PathVariable Long id, @RequestBody StatusAtendimentoRequest request){
        service.execute(id, request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}