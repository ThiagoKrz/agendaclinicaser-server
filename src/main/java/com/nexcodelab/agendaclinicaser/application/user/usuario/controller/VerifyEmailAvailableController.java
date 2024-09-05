package com.nexcodelab.agendaclinicaser.application.user.usuario.controller;

import com.nexcodelab.agendaclinicaser.application.user.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VerifyEmailAvailableController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping("/verify-email-available")
    public ResponseEntity<Boolean> execute(@RequestParam String email) {
        Boolean response = usuarioRepository.existsByUsername(email);

        return ResponseEntity.ok(response);
    }
}
