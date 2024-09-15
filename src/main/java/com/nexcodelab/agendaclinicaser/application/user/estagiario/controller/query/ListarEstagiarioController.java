package com.nexcodelab.agendaclinicaser.application.user.estagiario.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.estagiario.service.ListarEstagiarioUseCase;
import com.nexcodelab.agendaclinicaser.application.user.paciente.service.ListarPacienteUseCase;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RolesAllowed(roles = {Role.ESTAGIARIO})
@RestController
@RequiredArgsConstructor
public class ListarEstagiarioController {

    private final ListarEstagiarioUseCase service;


    @GetMapping("/estagiario")
    public ResponseEntity<List<IPersonaResumidaVO>> execute() {
         return ResponseEntity.ok(service.execute());
    }

}
