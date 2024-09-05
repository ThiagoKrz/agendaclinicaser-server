package com.nexcodelab.agendaclinicaser.application.user.persona.model;

import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SQLDelete(sql = "UPDATE persona SET inativo = true WHERE id=?")
@Getter
@NoArgsConstructor @RequiredArgsConstructor
public abstract class Persona extends EntityBase {
    @Column(length = 90, nullable = false)
    @NonNull private String nome;

    @Column(length = 90, nullable = false)
    @NonNull private String sobrenome;

    @Column(nullable = false)
    @NonNull private LocalDate dataNascimento;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    @NonNull private Sexo sexo;

    @Column(length = 90, nullable = false)
    @NonNull private String email;

    @Column(nullable = false)
    @NonNull @Embedded private Telefone telefone;

    @Column(nullable = false)
    private boolean inativo = Boolean.FALSE;
}
