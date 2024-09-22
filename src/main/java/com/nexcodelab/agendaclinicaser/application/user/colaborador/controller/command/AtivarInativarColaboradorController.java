package com.nexcodelab.agendaclinicaser.application.user.colaborador.controller.command;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request.CadastrarColaboradorRequest;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.ColaboradorService;
import com.nexcodelab.agendaclinicaser.application.user.persona.service.PersonaService;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AtivarInativarColaboradorController {

    private final PersonaService<Colaborador> service;

    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @PatchMapping("/colaborador/ativar-inativar/{id}")
    public ResponseEntity<Colaborador> execute(@PathVariable String  id) {
        service.ativarInativar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
