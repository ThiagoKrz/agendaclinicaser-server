package com.nexcodelab.agendaclinicaser.application.disponibilidade.model;

import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class DisponibilidadeHoraria extends EntityBase {

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFim;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public DisponibilidadeHoraria(LocalTime horaInicio, LocalTime horaFim) {
        this(horaInicio, horaFim, null);
    }

    public DisponibilidadeHoraria(LocalTime horaInicio, LocalTime horaFim, Sala sala) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
    }
}
