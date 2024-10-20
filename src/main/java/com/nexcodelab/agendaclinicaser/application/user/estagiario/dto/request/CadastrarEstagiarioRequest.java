package com.nexcodelab.agendaclinicaser.application.user.estagiario.dto.request;

import com.nexcodelab.agendaclinicaser.application.user.persona.dto.request.CadastrarPersonaRequest;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class CadastrarEstagiarioRequest extends CadastrarPersonaRequest {
    @NotNull
    @Size(max = 90)
    String username;

    @NotEmpty @Size(max = 90)
    String password;

    Integer horasRequeridas;

    @NotEmpty
    String idSupervisor;
}
