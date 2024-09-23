package com.nexcodelab.agendaclinicaser.application.disponibilidade.controller.query;

import com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.response.DisponibilidadeResponse;
import com.nexcodelab.agendaclinicaser.application.disponibilidade.service.ListarDisponibilidadeUseCase;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarDisponibilidadeController {

    private final ListarDisponibilidadeUseCase service;
    @RolesAllowed(accessLevel = AccessLevel.CLINICA)
    @GetMapping("/disponibilidade/estagiario/{id}")
    public ResponseEntity<List<DisponibilidadeResponse>> execute(@PathVariable String id){
        return new ResponseEntity(service.execute(id), HttpStatus.OK);
    }
}
