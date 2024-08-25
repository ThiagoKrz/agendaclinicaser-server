package com.nexcodelab.agendaclinicaser.topico.controller.command;

import com.nexcodelab.agendaclinicaser.core.security.service.UserDetailsImpl;
import com.nexcodelab.agendaclinicaser.topico.dto.request.CreateTopicoRequest;
import com.nexcodelab.agendaclinicaser.topico.service.CreateTopicoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class CreateTopicoController {

    private final CreateTopicoUseCase service;
    @PostMapping
    public ResponseEntity<Void> execute(@AuthenticationPrincipal UserDetailsImpl userDetails, CreateTopicoRequest request) {
        this.service.execute(request, userDetails.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
