package com.nexcodelab.agendaclinicaser.application.user.persona.dto.request;

import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDate;


@Getter
public abstract class CadastrarPersonaRequest {

    @NotEmpty @Size(max = 90)
    String nome;

    @NotEmpty @Size(max = 90)
    String sobrenome;

    @NotNull
    LocalDate dataNascimento;

    @NotNull
    Sexo sexo;

    @NotEmpty @Size(max = 90)
    String email;
}
