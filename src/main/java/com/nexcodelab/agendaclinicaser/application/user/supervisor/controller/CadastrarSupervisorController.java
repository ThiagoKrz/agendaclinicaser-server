//package com.nexcodelab.agendaclinicaser.application.user.supervisor.controller;
//
//import com.nexcodelab.agendaclinicaser.application.user.persona.service.CadastrarPersonaUseCase;
//import com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.request.CadastrarSupervisorRequest;
//import com.nexcodelab.agendaclinicaser.application.user.supervisor.model.Supervisor;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping
//@RequiredArgsConstructor
//public class CadastrarSupervisorController {
//    private final CadastrarPersonaUseCase<Supervisor> service;
//
//    @PostMapping("/supervisor")
//    public ResponseEntity<Void> execute(@Valid @RequestBody CadastrarSupervisorRequest request) {
//        service.execute(request);
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//}
