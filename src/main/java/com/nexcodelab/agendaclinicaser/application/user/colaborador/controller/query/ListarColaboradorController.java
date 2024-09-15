package com.nexcodelab.agendaclinicaser.application.user.colaborador.controller.query;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.ListarColaboradorUseCase;
import com.nexcodelab.agendaclinicaser.application.user.persona.vo.IPersonaResumidaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarColaboradorController {

    private final ListarColaboradorUseCase service;

    @GetMapping("/colaborador")
    public ResponseEntity<List<IPersonaResumidaVO>> execute() {
         return ResponseEntity.ok(service.execute());
    }

}
