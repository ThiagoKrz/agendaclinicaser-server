package com.nexcodelab.agendaclinicaser.application.user.persona.model;

import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@NoArgsConstructor @AllArgsConstructor
public abstract class Persona extends EntityBase {
    @Column(length = 90, nullable = false)
    private String nome;

    @Column(length = 90, nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @Column(length = 90, nullable = false)
    private String email;

    @Column(nullable = false)
    @Embedded private Telefone telefone;
}
