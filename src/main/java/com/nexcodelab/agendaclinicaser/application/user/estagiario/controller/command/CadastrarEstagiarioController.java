package com.nexcodelab.agendaclinicaser.application.user.estagiario.controller.command;

import com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.request.CadastrarEstagiarioRequest;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.model.Estagiario;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.service.EstagiarioService;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Estagiario")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class CadastrarEstagiarioController {

    private final EstagiarioService service;

    @Operation(summary = "Cadastrar estagiário")
    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @PostMapping("/estagiario")
    public ResponseEntity<Estagiario> execute(@Valid @RequestBody CadastrarEstagiarioRequest request) {
        return new ResponseEntity(service.execute(request), HttpStatus.CREATED);
    }
}
