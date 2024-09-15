package com.nexcodelab.agendaclinicaser.application.sala.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Sala extends EntityBase {
    private String nome;
}
