package com.nexcodelab.uniforum.usuario.model;

import com.nexcodelab.uniforum.core.model.EntidadeBase;
import com.nexcodelab.uniforum.shared.enums.Sexo;
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
