package com.nexcodelab.uniforum.authentication.controller;

import com.nexcodelab.uniforum.authentication.dto.request.LoginRequest;
import com.nexcodelab.uniforum.authentication.dto.request.SignUpRequest;
import com.nexcodelab.uniforum.authentication.dto.response.JwtResponse;
import com.nexcodelab.uniforum.authentication.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/verify-email-available")
    public ResponseEntity<Boolean> verifyEmailAvailable(@RequestParam String email) {
        Boolean response = authenticationService.verifyEmailAvailable(email);
        return ResponseEntity.ok(response);
    }
}
