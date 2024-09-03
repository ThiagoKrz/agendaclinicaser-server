package com.nexcodelab.agendaclinicaser.application.user.persona.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Telefone {
    private String ddd;
    private String numeroTelefone;
}
