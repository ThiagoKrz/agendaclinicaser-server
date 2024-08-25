package com.nexcodelab.agendaclinicaser.usuario.model;

import com.nexcodelab.agendaclinicaser.core.model.EntidadeBase;
import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class DadosPessoais extends EntidadeBase {
    @Column(length = 45, nullable = false)
    private String nome;

    @Column(length = 45, nullable = false)
    private String sobrenome;

    private LocalDate dataNascimento;

    private Sexo sexo;
}
