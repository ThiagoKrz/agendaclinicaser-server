package com.nexcodelab.agendaclinicaser.application.disponibilidade.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class DisponibilidadePersona extends EntityBase {

    @NotNull
    LocalDate dataInicio;

    LocalDate dataFim;

    @NotNull
    String personaId;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "disponibilidade_persona_id")
    private Set<DisponibilidadeDiaSemana> diaDaSemana;

    public DisponibilidadePersona(LocalDate dataInicio, LocalDate dataFim, String personaId, Set<DisponibilidadeDiaSemana> diaDaSemana) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.personaId = personaId;
        this.diaDaSemana = diaDaSemana;
    }
}
