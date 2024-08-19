package com.nexcodelab.uniforum.usuario.controller;

import com.nexcodelab.uniforum.usuario.dto.request.LoginRequest;
import com.nexcodelab.uniforum.usuario.dto.request.SignUpRequest;
import com.nexcodelab.uniforum.usuario.dto.response.JwtResponse;
import com.nexcodelab.uniforum.usuario.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody SignUpRequest request) throws Exception {
        authenticationService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticate(@Valid @RequestBody LoginRequest request) {
        JwtResponse jwtResponse = authenticationService.authenticate(request);

        return ResponseEntity.ok(jwtResponse);
    }
}
