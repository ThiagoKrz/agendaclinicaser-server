package com.nexcodelab.agendaclinicaser.application.user.colaborador.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.ListarColaboradorUseCase;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarColaboradorController {

    private final ListarColaboradorUseCase service;

    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/colaborador")
    public ResponseEntity<List<IPersonaResumidaVO>> execute() {
         return ResponseEntity.ok(service.execute());
    }

}
