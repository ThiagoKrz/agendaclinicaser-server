package com.nexcodelab.agendaclinicaser.application.sala.model;

import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.interfaces.IAgendavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Sala implements IAgendavel {

    @Id
    @Getter
    private final String id = UUID.randomUUID().toString();

    private String nome;

    @Column(nullable = false)
    private boolean inativo = Boolean.FALSE;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void ativarInativar(){
        this.inativo = !inativo;
    }
}
