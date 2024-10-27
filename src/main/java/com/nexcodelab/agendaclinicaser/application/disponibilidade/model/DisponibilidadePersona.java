package com.nexcodelab.agendaclinicaser.application.disponibilidade.model;

import com.nexcodelab.agendaclinicaser.application.sala.model.Sala;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ResourceNotFoundException;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class DisponibilidadePersona extends EntityBase {
    @NotNull
    String personaId;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "disponibilidade_persona_id")
    private Set<DisponibilidadeDiaSemana> diaDaSemana;

    public DisponibilidadePersona(String personaId, Set<DisponibilidadeDiaSemana> diaDaSemana) {
        this.personaId = personaId;
        this.diaDaSemana = diaDaSemana;
    }

    public void atualizarOcupacaoHoraria(DayOfWeek diaDaSemana, LocalTime horario, Sala sala) {
        DisponibilidadeDiaSemana dia = getDiaDaSemana().stream().filter(d -> d.getDiaDaSemana().equals(diaDaSemana)).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidade não encontrada"));

        DisponibilidadeHoraria disponibilidadeHoraria = dia.getHorarios().stream().filter(h -> h.getHorario().equals(horario)).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Disponibilidade não encontrada"));

        disponibilidadeHoraria.atualizarSala(sala);
    }
}
