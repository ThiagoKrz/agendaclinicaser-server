package com.nexcodelab.agendaclinicaser.application.user.supervisor.dto.request;

import com.nexcodelab.agendaclinicaser.application.user.persona.dto.request.CadastrarPersonaRequest;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class CadastrarSupervisorRequest extends CadastrarPersonaRequest {
    @NotNull
    @Size(max = 90)
    String username;

    @NotEmpty @Size(max = 90)
    String password;
}
