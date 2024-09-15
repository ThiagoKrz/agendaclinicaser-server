package com.nexcodelab.agendaclinicaser.application.user.supervisor.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.paciente.service.ListarPacienteUseCase;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.service.ListarSupervisorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarSupervisorController {

    private final ListarSupervisorUseCase service;

    @GetMapping("/supervisor")
    public ResponseEntity<List<IPersonaResumidaVO>> execute() {
         return ResponseEntity.ok(service.execute());
    }

}
