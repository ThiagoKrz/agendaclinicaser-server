package com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.controller.command;

import com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.dto.request.VincularOcupacaoPainelDeSalaRequest;
import com.nexcodelab.agendaclinicaser.application.gestaoocupacaosalas.service.VincularOcupacaoPainelDeSalaUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Painel de salas")
@RestController
@RequiredArgsConstructor
public class VincularOcupacaoPainelDeSalaController {

    private final VincularOcupacaoPainelDeSalaUseCase service;

    @Operation(summary = "Vincular sala ao estagiário")
    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @PostMapping("/painel-salas")
    public ResponseEntity<Void> execute(@RequestBody List<VincularOcupacaoPainelDeSalaRequest> request){

        service.execute(request);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
