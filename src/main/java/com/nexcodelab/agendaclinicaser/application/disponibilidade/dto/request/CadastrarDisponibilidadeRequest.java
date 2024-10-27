package com.nexcodelab.agendaclinicaser.application.disponibilidade.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;
import java.util.Set;

@Value
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class CadastrarDisponibilidadeRequest {

    @NotBlank
    String idEstagiario;

    @NotEmpty
    Set<CadastrarDisponibilidadeDiaSemanaRequest> diasDaSemana;
}
