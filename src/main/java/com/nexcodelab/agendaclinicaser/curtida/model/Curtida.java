package com.nexcodelab.agendaclinicaser.curtida.model;

import com.nexcodelab.agendaclinicaser.core.model.EntidadeBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor @AllArgsConstructor
public abstract class Curtida extends EntidadeBase{
    @Column(nullable = false)
    private String titulo;

    private Long usuario_id;
}
