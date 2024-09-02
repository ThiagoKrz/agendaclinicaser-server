package com.nexcodelab.agendaclinicaser.application.user.usuario.dto.response;

import lombok.Value;

@Value
public class JwtResponse {
    String accessToken;
    LoggedUserResponse user;
}
