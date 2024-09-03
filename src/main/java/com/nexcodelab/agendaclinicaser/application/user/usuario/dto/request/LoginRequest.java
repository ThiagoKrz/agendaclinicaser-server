package com.nexcodelab.agendaclinicaser.application.user.usuario.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class LoginRequest {
    @NotBlank
    String username;

    @NotBlank
    String password;
}
