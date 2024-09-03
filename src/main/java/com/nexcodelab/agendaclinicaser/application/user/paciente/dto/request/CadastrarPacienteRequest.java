package com.nexcodelab.agendaclinicaser.application.user.paciente.dto.request;

import com.nexcodelab.agendaclinicaser.application.user.persona.dto.request.CadastrarPersonaRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CadastrarPacienteRequest extends CadastrarPersonaRequest { }
