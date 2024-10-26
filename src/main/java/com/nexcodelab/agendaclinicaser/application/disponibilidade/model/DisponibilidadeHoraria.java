package com.nexcodelab.agendaclinicaser.application.disponibilidade.model;

import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public void atualizarSala(Sala sala) {
        this.sala = sala;
    }
}
