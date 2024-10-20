package com.nexcodelab.agendaclinicaser.application.atendimento.model;

import com.nexcodelab.agendaclinicaser.application.agenda.ocupacaohorario.model.enums.ComparecimentoEnvolvido;
import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class PacienteEmServico extends EntityBase {

    @ManyToOne
    @NotNull
    private Paciente paciente;

    @OneToOne(mappedBy = "pacienteEmServico") private Atendimento atendimento;

    @Enumerated(EnumType.STRING) @Setter
    private ComparecimentoEnvolvido comparecimentoEnvolvido;
}
