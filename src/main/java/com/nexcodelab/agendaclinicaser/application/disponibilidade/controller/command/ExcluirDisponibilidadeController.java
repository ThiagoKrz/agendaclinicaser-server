package com.nexcodelab.agendaclinicaser.application.disponibilidade.controller.command;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.service.ExcluirDisponibilidadeUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Disponibilidade")
@RestController
@RequiredArgsConstructor
public class ExcluirDisponibilidadeController {

    private final ExcluirDisponibilidadeUseCase service;

    @Operation(summary = "Excluir disponibilidade")
    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @DeleteMapping("/disponibilidade/{id}")
    public ResponseEntity<Void> execute(@PathVariable Long id){
        service.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
