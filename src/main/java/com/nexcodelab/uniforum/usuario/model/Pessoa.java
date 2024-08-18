package com.nexcodelab.uniforum.usuario.model;

import com.nexcodelab.uniforum.core.model.EntidadeBase;
import com.nexcodelab.uniforum.shared.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public abstract class Pessoa extends EntidadeBase {
    @Column(length = 45, nullable = false)
    private String nome;

    @Column(length = 45, nullable = false)
    private String sobrenome;

    private LocalDate dataNascimento;

    private Sexo sexo;

    public Pessoa(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo) {
        super();

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }
}
