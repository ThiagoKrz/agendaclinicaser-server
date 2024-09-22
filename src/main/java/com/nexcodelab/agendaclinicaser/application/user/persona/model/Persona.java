package com.nexcodelab.agendaclinicaser.application.user.persona.model;

import com.nexcodelab.agendaclinicaser.application.user.usuario.model.Usuario;
import com.nexcodelab.agendaclinicaser.shared.enums.Sexo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners(AuditingEntityListener.class)
//@SQLDelete(sql = "UPDATE persona SET inativo = true WHERE id=?")
@Getter
@NoArgsConstructor @RequiredArgsConstructor
public abstract class Persona{
    @Id @Getter
    private final String id = UUID.randomUUID().toString();

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

    @OneToOne
    private Usuario usuario;

    @Column(nullable = false)
    private boolean inativo = Boolean.FALSE;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Persona(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, Telefone telefone, Usuario usuario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.usuario = usuario;
        this.inativo = false;
    }

    public String getNomeCompleto(){
        return this.nome + "  " + this.sobrenome;
    }

    public String getSigla(){
        return nome.substring(0, 1).toUpperCase() + sobrenome.substring(0, 1).toUpperCase();
    }

    public void ativarInativar(){
        this.inativo = !this.inativo;
    }
}
