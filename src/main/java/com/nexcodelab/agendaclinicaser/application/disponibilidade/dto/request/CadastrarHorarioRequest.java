package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Value
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class CadastrarHorarioRequest {
    @NotNull
    LocalTime horario;
}
