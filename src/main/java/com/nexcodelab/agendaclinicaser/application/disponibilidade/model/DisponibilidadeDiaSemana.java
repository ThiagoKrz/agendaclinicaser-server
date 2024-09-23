package com.nexcodelab.agendaclinicaser.application.disponibilidade.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class DisponibilidadeDiaSemana extends EntityBase {

    @NotNull
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaDaSemana;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "disponibilidade_dia_semana_id")
    private Set<DisponibilidadeHoraria> horarios;

    public DisponibilidadeDiaSemana(DayOfWeek diaDaSemana, Set<DisponibilidadeHoraria> horarios) {
        this.diaDaSemana = diaDaSemana;
        this.horarios = horarios;
    }
}
