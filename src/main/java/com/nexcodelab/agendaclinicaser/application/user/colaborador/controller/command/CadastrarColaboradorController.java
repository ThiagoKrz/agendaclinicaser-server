package com.nexcodelab.agendaclinicaser.application.user.colaborador.controller.command;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request.CadastrarColaboradorRequest;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.ColaboradorService;
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

@Tag(name = "Colaborador")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class CadastrarColaboradorController {

    private final ColaboradorService service;

    @Operation(summary = "Cadastrar colaborador")
    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @PostMapping("/colaborador")
    public ResponseEntity<Colaborador> execute(@Valid @RequestBody CadastrarColaboradorRequest request) {
        service.execute(request);

        return new ResponseEntity(service.execute(request), HttpStatus.CREATED);
    }

}
