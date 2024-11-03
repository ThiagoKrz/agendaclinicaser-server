package com.nexcodelab.agendaclinicaser.application.atendimento.model;

import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class LocalDeTerapia extends EntityBase {

    @ManyToOne
    @NotNull
    private Sala sala;

    @OneToOne(mappedBy = "localDeTerapia") private Atendimento atendimento;

    public LocalDeTerapia(Sala sala) {
        this.sala = sala;
    }
}
