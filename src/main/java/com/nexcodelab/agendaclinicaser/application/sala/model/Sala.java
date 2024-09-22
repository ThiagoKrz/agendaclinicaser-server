package com.nexcodelab.agendaclinicaser.application.sala.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Sala extends EntityBase {
    private String nome;

    @Column(nullable = false)
    private boolean inativo = Boolean.FALSE;

    public void ativarInativar(){
        this.inativo = !inativo;
    }
}
