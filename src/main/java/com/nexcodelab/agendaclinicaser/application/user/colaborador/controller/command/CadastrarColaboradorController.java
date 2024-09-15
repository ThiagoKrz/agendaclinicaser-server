package com.nexcodelab.agendaclinicaser.application.user.colaborador.controller.command;

import com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request.CadastrarColaboradorRequest;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.model.Colaborador;
import com.nexcodelab.agendaclinicaser.application.user.colaborador.service.CadastrarColaboradorUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CadastrarColaboradorController {

    private final CadastrarColaboradorUseCase service;

    @PostMapping("/colaborador")
    public ResponseEntity<Colaborador> execute(@Valid @RequestBody CadastrarColaboradorRequest request) {
        service.execute(request);

        return new ResponseEntity(service.execute(request), HttpStatus.CREATED);
    }

}
