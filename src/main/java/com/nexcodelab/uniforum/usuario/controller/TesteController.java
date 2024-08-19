package com.nexcodelab.uniforum.usuario.controller;

import com.nexcodelab.uniforum.usuario.dto.request.SignUpRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TesteController {
    @GetMapping("/teste")
    public ResponseEntity<Void> teste() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
