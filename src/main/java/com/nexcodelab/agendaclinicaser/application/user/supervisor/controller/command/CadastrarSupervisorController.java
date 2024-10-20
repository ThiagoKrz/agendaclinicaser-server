package com.nexcodelab.agendaclinicaser.application.user.supervisor.controller.command;

import com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.request.CadastrarSupervisorRequest;
import com.nexcodelab.agendaclinicaser.application.user.supervisor.service.SupervisorService;
import com.nexcodelab.agendaclinicaser.core.security.annotation.RolesAllowed;
import com.nexcodelab.agendaclinicaser.core.security.enums.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class CadastrarSupervisorController {

    private final SupervisorService service;

    @RolesAllowed(accessLevel = AccessLevel.ADMIN)
    @PostMapping("/supervisor")
    public ResponseEntity<Void> execute(@Valid @RequestBody CadastrarSupervisorRequest request) {
        return new ResponseEntity(service.execute(request), HttpStatus.CREATED);
    }
}
