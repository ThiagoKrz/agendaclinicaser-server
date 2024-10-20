package com.nexcodelab.agendaclinicaser.application.user.persona.dto.request;

import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
public abstract class CadastrarPersonaRequest {

    @NotEmpty
    @Size(max = 90)
    String nome;

    @NotEmpty @Size(max = 90)
    String sobrenome;

    @NotNull
    LocalDate dataNascimento;

    @NotNull
    Sexo sexo;

    @Email @NotEmpty @Size(max = 90)
    String email;

    @NotEmpty @Size(max = 2)
    String ddd;

    @NotEmpty @Size(max = 11)
    String numeroTelefone;
}
