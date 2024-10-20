package com.nexcodelab.agendaclinicaser.application.user.usuario.dto.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class LoginRequest {
    @NotBlank
    String username;

    @NotBlank
    String password;
}
