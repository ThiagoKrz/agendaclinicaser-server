package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Value
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class CadastrarDisponibilidadeDiaSemanaRequest {
    @NotNull
    Integer diaDaSemana;

    @NotNull
    List<CadastrarHorarioRequest> horarios;
}
