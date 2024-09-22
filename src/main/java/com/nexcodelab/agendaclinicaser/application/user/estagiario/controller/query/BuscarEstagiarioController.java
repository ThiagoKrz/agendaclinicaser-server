package com.nexcodelab.agendaclinicaser.application.user.estagiario.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.response.DetalhesColaboradorResponse;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.BuscarColaboradorUseCase;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.response.DetalhesEstagiarioResponse;
import com.nexcodelab.agendaclinicaser.application.user.estagiario.service.BuscarEstagiarioUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BuscarEstagiarioController {

    private final BuscarEstagiarioUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/estagiario/{id}")
    public ResponseEntity<DetalhesEstagiarioResponse> execute(@PathVariable String id) {
        return ResponseEntity.ok(service.execute(id));
    }
}
