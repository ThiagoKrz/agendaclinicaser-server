package com.nexcodelab.agendaclinicaser.application.sala.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor @AllArgsConstructor
public class Sala {
    @Id
    private final String id = UUID.randomUUID().toString();

    private String nome;

    @Column(nullable = false)
    private boolean inativo = Boolean.FALSE;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Sala(String nome) {
        this.nome = nome;
    }

    public void ativarInativar(){
        this.inativo = !inativo;
    }
}
