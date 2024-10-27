package com.nexcodelab.agendaclinicaser.application.user.usuario.controller;

import com.nexcodelab.agendaclinicaser.application.user.usuario.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authenticação")
@RestController
@RequiredArgsConstructor
public class VerifyEmailAvailableController {

    private final UsuarioRepository usuarioRepository;

    @Operation(summary = "Verificar se email está disponível")
    @PostMapping("/verify-email-available")
    public ResponseEntity<Boolean> execute(@RequestParam String email) {
        Boolean response = usuarioRepository.existsByUsername(email);

        return ResponseEntity.ok(response);
    }
}
