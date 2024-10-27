package com.nexcodelab.agendaclinicaser.application.user.supervisor.controller.command;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.PersonaService;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.model.Supervisor;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Supervisor")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class AtivarInativarSupervisorController {

    private final PersonaService<Supervisor> service;

    @Operation(summary = "Ativar e inativar supervisor")
    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @PatchMapping("/supervisor/ativar-inativar/{id}")
    public ResponseEntity<Colaborador> execute(@PathVariable String  id) {
        service.ativarInativar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
