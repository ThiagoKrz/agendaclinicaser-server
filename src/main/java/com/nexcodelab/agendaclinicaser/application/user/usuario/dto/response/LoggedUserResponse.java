package com.nexcodelab.agendaclinicaser.application.user.usuario.dto.response;

import lombok.Value;

import java.util.List;

@Value
public class LoggedUserResponse {
    Long id;
    List<String> permissoes;
}
