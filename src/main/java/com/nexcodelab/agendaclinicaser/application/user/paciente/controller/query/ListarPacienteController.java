package com.nexcodelab.agendaclinicaser.application.user.paciente.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.paciente.service.ListarPacienteUseCase;
import com.nexcodelab.agendaclinicaser.application.user.paciente.vo.IPacienteParaListagemVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarPacienteController {

    private final ListarPacienteUseCase service;

    @GetMapping("/paciente")
    public ResponseEntity<List<IPacienteParaListagemVO>> execute() {
         return ResponseEntity.ok(service.execute());
    }

}
