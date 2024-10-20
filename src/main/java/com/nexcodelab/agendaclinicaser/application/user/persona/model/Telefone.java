package com.nexcodelab.agendaclinicaser.application.user.persona.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Telefone {

    @Column(nullable = false, length = 2)
    private String ddd;

    @Column(nullable = false, length = 11)
    private String numeroTelefone;

    public String getNumeroTelefone() {
        return ddd + numeroTelefone;
    }
}
