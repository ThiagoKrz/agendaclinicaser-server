package com.nexcodelab.agendaclinicaser.application.atendimento.model;

import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Atendimento extends EntityBase {
    @NotNull
    private LocalDateTime dataHora;

    @Getter @OneToOne(cascade = CascadeType.ALL) private PacienteEmServico pacienteEmServico;

    @OneToOne(cascade = CascadeType.ALL) private LocalDeTerapia localDeTerapia;

    @OneToOne(cascade = CascadeType.ALL) private EstagiarioEmServico estagiarioEmServico;
}
