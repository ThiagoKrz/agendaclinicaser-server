//package com.nexcodelab.agendaclinicaser.application.agenda.atendimento.model;
//
//import com.nexcodelab.agendaclinicaser.application.agenda.servico.model.ServicoIndividual;
//import com.nexcodelab.agendaclinicaser.application.user.paciente.model.Paciente;
//import com.nexcodelab.agendaclinicaser.shared.model.EntityBase;
//import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@NoArgsConstructor
//public class PacienteEmServico extends EntityBase {
//
//    @ManyToOne @NotNull private Paciente paciente;
//
//    @OneToOne(mappedBy = "pacienteEmServico") private ServicoIndividual servicoIndividual;
//
//    @Enumerated(EnumType.STRING) @Setter
//    private ComparecimentoEnvolvido comparecimentoEnvolvido;
//}
