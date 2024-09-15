package com.nexcodelab.agendaclinicaser.application.user.usuario.controller;

import com.nexcodelab.agendaclinicaser.application.user.usuario.dto.request.LoginRequest;
import com.nexcodelab.agendaclinicaser.application.user.usuario.dto.response.JwtResponse;
import com.nexcodelab.agendaclinicaser.application.user.usuario.service.LoginUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> execute(@Valid @RequestBody LoginRequest request) {
        JwtResponse jwtResponse = loginUseCase.execute(request);

        return ResponseEntity.ok(jwtResponse);
    }
}
