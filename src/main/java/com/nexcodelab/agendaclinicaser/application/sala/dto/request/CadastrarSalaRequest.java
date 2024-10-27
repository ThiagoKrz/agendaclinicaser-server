package com.nexcodelab.agendaclinicaser.application.sala.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class CadastrarSalaRequest {
    String nome;
}
