package com.nexcodelab.agendaclinicaser.application.user.estagiario.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.response.DetalhesColaboradorResponse;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.BuscarColaboradorUseCase;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.response.DetalhesEstagiarioResponse;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.service.BuscarEstagiarioUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Estagiario")
@RestController
@RequiredArgsConstructor
public class BuscarEstagiarioController {

    private final BuscarEstagiarioUseCase service;

    @Operation(summary = "Detalhar estagiário")
    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/estagiario/{id}")
    public ResponseEntity<DetalhesEstagiarioResponse> execute(@PathVariable String id) {
        return ResponseEntity.ok(service.execute(id));
    }
}
