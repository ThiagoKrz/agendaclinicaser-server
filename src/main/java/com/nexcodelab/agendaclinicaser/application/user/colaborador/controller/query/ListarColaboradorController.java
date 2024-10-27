package com.nexcodelab.agendaclinicaser.application.user.colaborador.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.ListarColaboradorUseCase;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Colaborador")
@RestController
@RequiredArgsConstructor
public class ListarColaboradorController {

    private final ListarColaboradorUseCase service;

    @Operation(summary = "Listar colaborador")
    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/colaborador")
    public ResponseEntity<List<IPersonaResumidaVO>> execute() {
         return ResponseEntity.ok(service.execute());
    }

}
