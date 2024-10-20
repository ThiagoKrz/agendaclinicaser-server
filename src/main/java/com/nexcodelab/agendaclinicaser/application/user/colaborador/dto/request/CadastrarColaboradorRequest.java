package com.nexcodelab.agendaclinicaser.application.user.colaborador.dto.request;

import com.nexcodelab.agendaclinicaser.application.user.persona.dto.request.CadastrarPersonaRequest;
import com.nexcodelab.agendaclinicaser.application.user.usuario.model.enums.Role;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class CadastrarColaboradorRequest extends CadastrarPersonaRequest {
    @NotNull
    @Size(max = 90)
    String username;

    @NotEmpty @Size(max = 90)
    String password;

    @NotNull
    Role role;
}
